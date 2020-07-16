package org.itstep.liannoi.notifications.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.itstep.liannoi.notifications.R
import org.itstep.liannoi.notifications.application.common.notifications.channels.DefaultNotificationChannelFactory
import org.itstep.liannoi.notifications.application.common.notifications.core.DefaultNotificationFactory
import org.itstep.liannoi.notifications.application.common.notifications.core.DefaultNotificationFactory.Defaults
import org.itstep.liannoi.notifications.application.common.notifications.core.actions.ServiceNotificationFactory
import org.itstep.liannoi.notifications.application.common.notifications.core.replies.ActivityNotificationFactory
import org.itstep.liannoi.notifications.infrastructure.notifications.NotificationService
import org.itstep.liannoi.notifications.infrastructure.player.PlayerService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val notificationService = NotificationService(this, DefaultNotificationChannelFactory())
        notifyDefault(notificationService)
        Thread.sleep(1400)
        notifyPlayer(notificationService)
        Thread.sleep(1400)
        notifyInput(notificationService)
    }

    ///////////////////////////////////////////////////////////////////////////
    // Helpers
    ///////////////////////////////////////////////////////////////////////////

    private fun notifyDefault(notificationService: NotificationService) {
        notificationService.notify(
            Defaults.FIRST_ID,
            DefaultNotificationFactory(
                this,
                DefaultNotificationFactory.Details("Default Title", "Default Text")
            )
        )
    }

    private fun notifyPlayer(notificationService: NotificationService) {
        notificationService.notify(
            Defaults.SECOND_ID,
            ServiceNotificationFactory(
                this,
                DefaultNotificationFactory.Details("Player", "Play control"),
                prepareAction(
                    android.R.drawable.ic_media_play,
                    PlayerService.Defaults.ACTION_PLAY_CODE,
                    PlayerService.Defaults.ACTION_PLAY
                ),
                prepareAction(
                    android.R.drawable.ic_media_pause,
                    PlayerService.Defaults.ACTION_STOP_CODE,
                    PlayerService.Defaults.ACTION_STOP
                )
            )
        )
    }

    private fun prepareAction(
        icon: Int,
        requestCode: Int,
        action: String
    ): ServiceNotificationFactory.Action<PlayerService> =
        ServiceNotificationFactory.Action(requestCode, PlayerService::class.java, action, icon)

    private fun notifyInput(notificationService: NotificationService) {
        notificationService.notify(
            Defaults.THIRD_ID,
            ActivityNotificationFactory(
                this,
                DefaultNotificationFactory.Details("Default Title", "Default Text"),
                ActivityNotificationFactory.Action(
                    SecondActivity::class.java,
                    Defaults.THIRD_REPLY_EXTRA,
                    Defaults.THIRD_REPLY_KEYCODE,
                    Defaults.THIRD_REPLY_CODE,
                    Defaults.THIRD_REPLY
                )
            )
        )
    }
}
