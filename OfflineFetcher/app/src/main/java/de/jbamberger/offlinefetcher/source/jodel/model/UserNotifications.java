package de.jbamberger.offlinefetcher.source.jodel.model;

import java.util.List;

public final class UserNotifications {
    public final List<UserNotification> notifications;

    public UserNotifications(List<UserNotification> list) {
        this.notifications = list;
    }
}
