package org.itstep.liannoi.notifications.application.common.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import org.itstep.liannoi.notifications.application.ApplicationDefaults
import org.itstep.liannoi.notifications.application.common.interfaces.NotificationChannelFactory

class DefaultNotificationChannelFactory : NotificationChannelFactory {

    override fun create(): NotificationChannel =
        NotificationChannel(
            ApplicationDefaults.CHANNEL_DEFAULT_ID,
            ApplicationDefaults.CHANNEL_DEFAULT_NAME,
            NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            enableVibration(true)
            vibrationPattern = longArrayOf(100, 200, 100, 200)
            description = ApplicationDefaults.CHANNEL_DEFAULT_DESCRIPTION
        }
}
