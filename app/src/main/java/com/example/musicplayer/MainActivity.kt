package com.example.musicplayer

import android.media.MediaPlayer
import android.media.MediaPlayer.OnPreparedListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.SeekBar

import android.widget.SeekBar.OnSeekBarChangeListener




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val mediaPlayer = MediaPlayer.create(this,R.raw.missindia)
        val mediaPlayer = MediaPlayer()
        play.setOnClickListener{
            mediaPlayer.start()
        }
        pause.setOnClickListener{
           mediaPlayer.pause()
        }

        //Remote source

        mediaPlayer.setDataSource("http://penguinradio.dominican.edu/Sound%20FX%20Collection/Cartoon%20Sound%20Effects%20from%20StockMusic.com.mp3")

        mediaPlayer.setOnPreparedListener(OnPreparedListener { mediaPlayer ->
            Toast.makeText(this,"Ready to Play",Toast.LENGTH_SHORT).show()
            mediaPlayer.start()
            seekBar.setMax(mediaPlayer.duration)
            seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
                override fun onStopTrackingTouch(seekBar: SeekBar) {
                    // TODO Auto-generated method stub
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {
                    // TODO Auto-generated method stub
                }

                override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                    // TODO Auto-generated method stub
                    if(fromUser){
                        mediaPlayer.seekTo(progress)
                    }
                }
            })
        })

        mediaPlayer.prepareAsync()
        //mp.start()

    }
}