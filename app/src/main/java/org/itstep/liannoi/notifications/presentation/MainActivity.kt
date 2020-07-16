package org.itstep.liannoi.notifications.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.itstep.liannoi.notifications.R
import org.itstep.liannoi.notifications.application.ApplicationDefaults
import org.itstep.liannoi.notifications.application.common.notifications.DefaultNotificationChannelFactory
import org.itstep.liannoi.notifications.application.common.notifications.DefaultNotificationFactory
import org.itstep.liannoi.notifications.application.common.notifications.ServiceNotificationFactory
import org.itstep.liannoi.notifications.infrastructure.InfrastructureDefaults
import org.itstep.liannoi.notifications.infrastructure.notifications.NotificationService
import org.itstep.liannoi.notifications.infrastructure.player.PlayerService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val notificationService = NotificationService(this, DefaultNotificationChannelFactory())
        notifyDefault(notificationService)
        notifyPlayer(notificationService)
    }

    ///////////////////////////////////////////////////////////////////////////
    // Helpers
    ///////////////////////////////////////////////////////////////////////////

    private fun notifyDefault(notificationService: NotificationService) {
        notificationService.notify(
            ApplicationDefaults.CHANNEL_DEFAULT_NOTIFICATION_FIRST_ID,
            DefaultNotificationFactory(
                this,
                DefaultNotificationFactory.Details("Title Lorem", "Text Ipsum")
            )
        )
    }

    private fun notifyPlayer(notificationService: NotificationService) {
        notificationService.notify(
            ApplicationDefaults.CHANNEL_DEFAULT_NOTIFICATION_SECOND_ID,
            ServiceNotificationFactory(
                this,
                DefaultNotificationFactory.Details("Single Action Title", "Single Action Text"),
                prepareAction(
                    android.R.drawable.ic_media_play,
                    InfrastructureDefaults.SERVICE_PLAYER_REQUEST_CODE_PLAY,
                    "Play"
                ),
                prepareAction(
                    android.R.drawable.ic_media_pause,
                    InfrastructureDefaults.SERVICE_PLAYER_REQUEST_CODE_STOP,
                    "Stop"
                )
            )
        )
    }

    private fun prepareAction(
        icon: Int,
        requestCode: Int,
        action: String
    ): ServiceNotificationFactory.Action<PlayerService> =
        ServiceNotificationFactory.Action(icon, requestCode, PlayerService::class.java, action)
}
