package app.itunes.play.presentation.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import app.itunes.play.data.model.Entry
import app.itunes.play.data.model.Feed
import app.itunes.play.data.utils.MessageConstants
import app.itunes.play.data.utils.isNetworkAvailable
import app.itunes.play.domain.mappers.mapToEntryItemList
import app.itunes.play.domain.mappers.mapToSongsItemList
import app.itunes.play.domain.usecases.LocalDbUseCase
import app.itunes.play.domain.usecases.SongsListUseCase
import app.itunes.play.presentation.viewmodel.events.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SongsListViewModel @Inject constructor(
    private val songsListUseCase: SongsListUseCase,
    private val localDbUseCase: LocalDbUseCase,
    @ApplicationContext private val context: Context
) :
    ViewModel() {

    val showMessage = MutableLiveData<Event<MessageConstants>>()
    val eventMessage: LiveData<Event<MessageConstants>> get() = showMessage

    private val songsListMutableLiveData = MutableLiveData<List<Entry?>>()
    val songsListLivedata: LiveData<List<Entry?>> get() = songsListMutableLiveData

    /**
     * This function is used to fetch the list of songs
     * If the list is already present in local database then fetch from local DB
     * else check internet connection and fetch from API
     * Show no results found text if the list is empty
     * Show no internet toast if there is no internet connectivity
     * **/
    fun getSongsList() {
        viewModelScope.launch(Dispatchers.IO) {
            if (localDbUseCase.getSongsCount() > 0) {
                val entryList = localDbUseCase.getSongsList()
                songsListMutableLiveData.postValue(mapToEntryItemList(entryList))
            } else {
                if (isNetworkAvailable(context)) {
                    try {
                        songsListUseCase.getItunesSongsList()?.let {
                            if (!it.entryList.isNullOrEmpty()) {
                                songsListMutableLiveData.postValue(it.entryList)
                                localDbUseCase.insertSongs(mapToSongsItemList(it.entryList))
                            } else {
                                showMessage.postValue(Event(MessageConstants.EMPTY_RESULTS))
                            }
                        }
                    } catch (ex: Exception) {
                        Log.i("exception ::::", "" + ex.toString())
                        showMessage.postValue(Event(MessageConstants.EMPTY_RESULTS))
                    }

                } else showMessage.postValue(Event(MessageConstants.NO_NETWORK))
            }
        }


    }
}