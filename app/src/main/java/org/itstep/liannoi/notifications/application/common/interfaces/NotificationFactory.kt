package org.itstep.liannoi.notifications.application.common.interfaces

import android.app.Notification

interface NotificationFactory {
    fun create(): Notification
}
