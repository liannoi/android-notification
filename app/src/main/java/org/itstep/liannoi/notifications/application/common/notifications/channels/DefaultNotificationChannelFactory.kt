package org.itstep.liannoi.notifications.application.common.notifications.channels

import android.app.NotificationChannel
import android.app.NotificationManager
import org.itstep.liannoi.notifications.application.common.interfaces.NotificationChannelFactory

class DefaultNotificationChannelFactory : NotificationChannelFactory {

    object Defaults {
        const val ID: String = "channel_default"
        const val NAME: String = "Default Channel"
        const val DESCRIPTION: String = "Test channel for custom notifications."
    }

    override fun create(): NotificationChannel =
        NotificationChannel(
            Defaults.ID,
            Defaults.NAME,
            NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            enableVibration(true)
            vibrationPattern = longArrayOf(100, 200, 100, 200)
            description = Defaults.DESCRIPTION
        }
}
