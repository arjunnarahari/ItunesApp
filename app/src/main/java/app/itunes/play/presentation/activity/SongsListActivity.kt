package app.itunes.play.presentation.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import app.itunes.play.R
import app.itunes.play.data.utils.MessageConstants
import app.itunes.play.databinding.ActivitySongsListBinding
import app.itunes.play.presentation.viewmodel.SongsListViewModel
import app.itunes.play.presentation.viewmodel.events.EventObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SongsListActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySongsListBinding
    private val viewModel by lazy { ViewModelProvider(this)[SongsListViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_songs_list)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.getSongsList()

        viewModel.eventMessage.observe(this,EventObserver {
            val message = it as MessageConstants
            if (message == (MessageConstants.NO_NETWORK)) {
                Toast.makeText(
                    this,
                    getString(R.string.no_internet_msg),
                    Toast.LENGTH_LONG
                ).show()
            }
        })
    }
}