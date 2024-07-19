package app.itunes.play.presentation.bindingadapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import app.itunes.play.data.model.Entry
import app.itunes.play.data.model.Feed
import app.itunes.play.presentation.adapter.SongsListRecyclerviewAdapter
import app.itunes.play.presentation.viewmodel.SongsListViewModel

@BindingAdapter("setSongsList", "viewModel")
fun setSongsList(
    view: RecyclerView,
    list: List<Entry>?,
    viewModel: SongsListViewModel
) {
    view.adapter?.run {
        //notify
        if (this is SongsListRecyclerviewAdapter) {
            this.list = list
            this.viewModel = viewModel
            this.notifyDataSetChanged()
        }
    } ?: run {
        view.adapter = SongsListRecyclerviewAdapter(list, viewModel)
    }

}