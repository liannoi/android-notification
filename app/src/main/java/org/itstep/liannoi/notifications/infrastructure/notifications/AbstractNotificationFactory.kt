package org.itstep.liannoi.notifications.infrastructure.notifications

import android.content.Context
import org.itstep.liannoi.notifications.application.common.interfaces.NotificationFactory

abstract class AbstractNotificationFactory(protected val context: Context) : NotificationFactory
