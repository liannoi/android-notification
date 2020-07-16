package org.itstep.liannoi.notifications.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.itstep.liannoi.notifications.R
import org.itstep.liannoi.notifications.application.common.notifications.channels.DefaultNotificationChannelFactory
import org.itstep.liannoi.notifications.application.common.notifications.core.DefaultNotificationFactory
import org.itstep.liannoi.notifications.infrastructure.notifications.NotificationService

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        stopIfRequest(intent)
    }

    private fun stopIfRequest(intent: Intent?) {
        val shouldStop: Boolean =
            intent?.action?.toLowerCase() == DefaultNotificationFactory.Defaults.THIRD_REPLY_KEYCODE.toLowerCase()

        if (!shouldStop) return

        val notificationService = NotificationService(this, DefaultNotificationChannelFactory())
        notificationService.cancel(DefaultNotificationFactory.Defaults.THIRD_ID)
    }
}
