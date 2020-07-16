package org.itstep.liannoi.notifications.infrastructure.player

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import org.itstep.liannoi.notifications.R
import org.itstep.liannoi.notifications.infrastructure.InfrastructureDefaults

class PlayerService : Service() {

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
        val shouldStop: Boolean = intent?.action?.toLowerCase() ==
                InfrastructureDefaults.SERVICE_PLAYER_KEYCODE_STOP.toLowerCase()

        if (shouldStop) stopSelf()
    }
}
