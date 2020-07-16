package org.itstep.liannoi.notifications.infrastructure.player

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import org.itstep.liannoi.notifications.R

class PlayerService : Service() {

    object Defaults {
        const val ACTION_PLAY: String = "Play"
        const val ACTION_PLAY_CODE: Int = 1
        const val ACTION_STOP: String = "Stop"
        const val ACTION_STOP_CODE: Int = -1
    }

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this, R.raw.music_intro)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaPlayer.start()
        stopIfRequest(intent)

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
    }

    ///////////////////////////////////////////////////////////////////////////
    // Helpers
    ///////////////////////////////////////////////////////////////////////////

    private fun stopIfRequest(intent: Intent?) {
        val shouldStop: Boolean =
            intent?.action?.toLowerCase() == Defaults.ACTION_STOP.toLowerCase()

        if (shouldStop) stopSelf()
    }
}
