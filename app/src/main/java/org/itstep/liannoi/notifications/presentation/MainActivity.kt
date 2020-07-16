package org.itstep.liannoi.notifications.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.itstep.liannoi.notifications.R
import org.itstep.liannoi.notifications.application.ApplicationDefaults
import org.itstep.liannoi.notifications.application.common.notifications.DefaultNotificationChannelFactory
import org.itstep.liannoi.notifications.application.common.notifications.DefaultNotificationFactory
import org.itstep.liannoi.notifications.infrastructure.notifications.NotificationService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val notificationService = NotificationService(this, DefaultNotificationChannelFactory())

        notificationService.notify(
            ApplicationDefaults.CHANNEL_DEFAULT_NOTIFICATION_FIRST_ID,
            DefaultNotificationFactory(
                this,
                DefaultNotificationFactory.Details("Title Lorem", "Text Ipsum")
            )
        )
    }
}
