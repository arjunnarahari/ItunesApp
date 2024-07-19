package app.itunes.play.presentation.activity

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import app.itunes.play.R
import app.itunes.play.data.model.Entry
import app.itunes.play.data.utils.isNetworkAvailable
import app.itunes.play.databinding.ActivitySongsDetailsBinding
import com.bumptech.glide.Glide
import com.google.gson.Gson

class SongsDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySongsDetailsBinding
    private lateinit var entryItem: Entry
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_songs_details)
        binding.lifecycleOwner = this
        if (intent.extras?.containsKey("entryItem")!! &&
            !intent.extras?.getString("entryItem").isNullOrEmpty()
        ) {
            entryItem = Gson().fromJson(
                intent.extras?.getString("entryItem"),
                Entry::class.java
            )
            binding.item = entryItem

            if (!entryItem.imageUrl.isNullOrEmpty()) {
                Glide.with(binding.imvIcon.context)
                    .load(entryItem.imageUrl)
                    .into(binding.imvIcon)
            }
        }

        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.btnPlay.setOnClickListener {
            if (isNetworkAvailable(this)) {
                playAudio()
            } else {
                displayToast(getString(R.string.no_internet_msg))
            }
        }

        binding.btnPause.setOnClickListener {
            if (isNetworkAvailable(this)) {
                pauseAudio()
            } else {
                displayToast(getString(R.string.no_internet_msg))
            }
        }
    }

    private fun playAudio() {
        mediaPlayer = MediaPlayer().apply {
            setDataSource(entryItem.link.audioLink)
            prepare()
            start()
        }
    }

    private fun pauseAudio() {
        mediaPlayer?.let {
            if (it.isPlaying) {
                it.stop()
                it.reset()
                it.release()
            }
        }
    }

    private fun displayToast(msg: String) {
        Toast.makeText(
            this,
            msg,
            Toast.LENGTH_LONG
        ).show()
    }

}