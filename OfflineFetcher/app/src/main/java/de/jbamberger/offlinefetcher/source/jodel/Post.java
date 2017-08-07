package de.jbamberger.offlinefetcher.source.jodel;

import android.graphics.Color;
import android.location.Location;

import java.util.List;

public class Post {
    int childCount;
    List<Post> children;
    String color;
    String createdAt;
    float distance;
    boolean fromHome;
    boolean gotThanks;
    String imageUrl;
    boolean isFlagged;
    boolean isOffline;
    boolean isReply;
    Location location;
    String message;
    boolean notificationsEnabled;
    String parentId;
    int pinCount;
    boolean pinned;
    String postId;
    String postOwn;
    boolean readonly;
    boolean removed;
    int removedReason;
    int replier = -1;
    String replierMark;
    int shareCount;
    int thanksCount;
    String thumbnailUrl;
    String userHandle;
    int voteCount;
    String voted;


    public int getChildCount() {
        return childCount;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }

    public List<Post> getChildren() {
        return children;
    }

    public void setChildren(List<Post> children) {
        this.children = children;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public boolean isFromHome() {
        return fromHome;
    }

    public void setFromHome(boolean fromHome) {
        this.fromHome = fromHome;
    }

    public boolean isGotThanks() {
        return gotThanks;
    }

    public void setGotThanks(boolean gotThanks) {
        this.gotThanks = gotThanks;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }

    public boolean isOffline() {
        return isOffline;
    }

    public void setOffline(boolean offline) {
        isOffline = offline;
    }

    public boolean isReply() {
        return isReply;
    }

    public void setReply(boolean reply) {
        isReply = reply;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isNotificationsEnabled() {
        return notificationsEnabled;
    }

    public void setNotificationsEnabled(boolean notificationsEnabled) {
        this.notificationsEnabled = notificationsEnabled;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public int getPinCount() {
        return pinCount;
    }

    public void setPinCount(int pinCount) {
        this.pinCount = pinCount;
    }

    public boolean isPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostOwn() {
        return postOwn;
    }

    public void setPostOwn(String postOwn) {
        this.postOwn = postOwn;
    }

    public boolean isReadonly() {
        return readonly;
    }

    public void setReadonly(boolean readonly) {
        this.readonly = readonly;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    public int getRemovedReason() {
        return removedReason;
    }

    public void setRemovedReason(int removedReason) {
        this.removedReason = removedReason;
    }

    public int getReplier() {
        return replier;
    }

    public void setReplier(int replier) {
        this.replier = replier;
    }

    public String getReplierMark() {
        return replierMark;
    }

    public void setReplierMark(String replierMark) {
        this.replierMark = replierMark;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public int getThanksCount() {
        return thanksCount;
    }

    public void setThanksCount(int thanksCount) {
        this.thanksCount = thanksCount;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getUserHandle() {
        return userHandle;
    }

    public void setUserHandle(String userHandle) {
        this.userHandle = userHandle;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String getVoted() {
        return voted;
    }

    public void setVoted(String voted) {
        this.voted = voted;
    }

    public int getColorInt() {
        try {
            return Color.parseColor("#" + color);

        } catch (IllegalArgumentException e) {
            return Color.WHITE;
        }
    }
}
