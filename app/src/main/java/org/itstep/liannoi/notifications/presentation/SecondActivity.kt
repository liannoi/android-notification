package org.itstep.liannoi.notifications.presentation

import android.app.RemoteInput
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*
import org.itstep.liannoi.notifications.R
import org.itstep.liannoi.notifications.application.common.notifications.channels.DefaultNotificationChannelFactory
import org.itstep.liannoi.notifications.application.common.notifications.core.DefaultNotificationFactory.Defaults
import org.itstep.liannoi.notifications.infrastructure.notifications.NotificationService

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        stopIfRequest(intent)
    }

    ///////////////////////////////////////////////////////////////////////////
    // Helpers
    ///////////////////////////////////////////////////////////////////////////

    private fun stopIfRequest(intent: Intent?) {
        val shouldStop: Boolean =
            intent?.action?.toLowerCase() == Defaults.THIRD_REPLY_KEYCODE.toLowerCase()

        if (!shouldStop) return

        updateMessage()
        NotificationService(this, DefaultNotificationChannelFactory()).cancel(Defaults.THIRD_ID)
    }

    private fun updateMessage() {
        val result = RemoteInput.getResultsFromIntent(intent)
            .getCharSequence(Defaults.THIRD_REPLY_EXTRA)
            .toString()

        message_text.text = "Second Activity: $result"
    }
}
