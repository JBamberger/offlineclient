package de.jbamberger.offlineclient.source.jodel.model;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

import de.jbamberger.offlineclient.source.jodel.Consts;

public class Post implements Parcelable {
    public static final Creator<Post> CREATOR = new Creator<Post>() {
        public Post createFromParcel(Parcel parcel) {
            return new Post(parcel);
        }

        public Post[] newArray(int i) {
            return new Post[i];
        }
    };
    int childCount;
    List<Post> children;
    String color;
    DateTime createdAt;
    float distance;
    boolean fromHome;
    boolean gotThanks;
    List<PostHighlight> highlight;
    String imageUrl;
    boolean isFlagged;
    boolean isOffline;
    boolean isReply;
    Location location;
    LocationTag locationTag;
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
    String replyTimestamp;
    int shareCount;
    int thanksCount;
    String thumbnailUrl;
    String userHandle;
    int voteCount;
    String voted;

    public Post(String str, String str2, Location location) {
        this.message = str;
        this.color = str2;
        this.location = location;
    }

    public Post(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.createdAt = new DateTime(parcel.readLong());
        this.voteCount = parcel.readInt();
        this.childCount = parcel.readInt();
        this.pinCount = parcel.readInt();
        this.voted = parcel.readString();
        this.distance = parcel.readFloat();
        if (parcel.readInt() != 0) {
            this.children = new ArrayList<>();
            parcel.readTypedList(this.children, CREATOR);
        } else {
            this.children = null;
        }
        this.postId = parcel.readString();
        this.parentId = parcel.readString();
        this.message = parcel.readString();
        this.postOwn = parcel.readString();
        this.imageUrl = parcel.readString();
        this.thumbnailUrl = parcel.readString();
        this.color = parcel.readString();
        this.location = parcel.readParcelable(getClass().getClassLoader());
        this.userHandle = parcel.readString();
        this.replierMark = parcel.readString();
        this.notificationsEnabled = parcel.readByte() != (byte) 0;
        this.pinned = parcel.readByte() != (byte) 0;
        this.fromHome = parcel.readByte() != (byte) 0;
        this.gotThanks = parcel.readByte() != (byte) 0;
        this.removed = parcel.readByte() != (byte) 0;
        this.removedReason = parcel.readInt();
        this.thanksCount = parcel.readInt();
        this.replier = parcel.readInt();
        this.isReply = parcel.readByte() != (byte) 0;
        this.isFlagged = parcel.readByte() != (byte) 0;
        if (parcel.readByte() == (byte) 0) {
            z2 = false;
        }
        this.readonly = z2;
        this.replyTimestamp = parcel.readString();
        this.locationTag = parcel.readParcelable(getClass().getClassLoader());
    }

    public DateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(DateTime dateTime) {
        this.createdAt = dateTime;
    }

    public int getVoteCount() {
        return this.voteCount;
    }

    public void setVoteCount(int i) {
        this.voteCount = i;
    }

    public int getChildCount() {
        return this.childCount;
    }

    public void setChildCount(int i) {
        this.childCount = i;
    }

    public String getVoted() {
        return this.voted;
    }

    public void setVoted(String str) {
        this.voted = str;
    }

    public float getDistance() {
        return this.distance;
    }

    public void setDistance(float f) {
        this.distance = f;
    }

    public List<Post> getChildren() {
        return this.children;
    }

    public void setChildren(List<Post> list) {
        this.children = list;
    }

    public String getPostId() {
        return this.postId;
    }

    public void setPostId(String str) {
        this.postId = str;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String str) {
        this.parentId = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getPostOwn() {
        return this.postOwn;
    }

    public void setPostOwn(String str) {
        this.postOwn = str;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnailUrl = str;
    }

    public String getColor() {
        if (TextUtils.isEmpty(this.color)) {
            return "#FFFF9908";
        }
        return this.color.contains(Consts.HASHTAG_SYMBOL) ? this.color : Consts.HASHTAG_SYMBOL + this.color;
    }

    public void setColor(String str) {
        this.color = str;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getUserHandle() {
        return this.userHandle;
    }

    public void setUserHandle(String str) {
        this.userHandle = str;
    }

    public String getReplierMark() {
        return this.replierMark;
    }

    public void setReplierMark(String str) {
        this.replierMark = str;
    }

    public boolean isNotificationsEnabled() {
        return this.notificationsEnabled;
    }

    public void setNotificationsEnabled(boolean z) {
        this.notificationsEnabled = z;
    }

    public boolean isRemoved() {
        return this.removed;
    }

    public void setRemoved(boolean z) {
        this.removed = z;
    }

    public int getRemovedReason() {
        return this.removedReason;
    }

    public void setRemovedReason(int i) {
        this.removedReason = i;
    }

    public int getThanksCount() {
        return this.thanksCount;
    }

    public void setThanksCount(int i) {
        this.thanksCount = i;
    }

    public boolean isReply() {
        return this.isReply;
    }

    public void setReply(boolean z) {
        this.isReply = z;
    }

    public boolean isFlagged() {
        return this.isFlagged;
    }

    public void setFlagged(boolean z) {
        this.isFlagged = z;
    }

    public boolean isReadonly() {
        return this.readonly;
    }

    public int getParsedColor() {
        int i = 0;
        try {
            i = Color.parseColor(getColor());
        } catch (Exception e) {
            try {
                i = Color.parseColor(Consts.HASHTAG_SYMBOL + getColor());
            } catch (Exception e2) {
            }
        }
        return i;
    }

    public boolean hasImageUrl() {
        return this.imageUrl != null && this.imageUrl.trim().length() > 0;
    }

    public boolean wasUpvoted() {
        return Consts.VOTE_TYPE_UP.equals(this.voted);
    }

    public boolean wasDownvoted() {
        return Consts.VOTE_TYPE_DOWN.equals(this.voted);
    }

    public boolean isOwn() {
        return Consts.POST_OWNERSHIP_TYPE_OWN.equals(this.postOwn);
    }

    public boolean isPinned() {
        return this.pinned;
    }

    public void setPinned(boolean z) {
        this.pinned = z;
    }

    public boolean isPTP() {
        return Consts.POST_OWNERSHIP_TYPE_TEAM.equals(getPostOwn());
    }

    public int getShareCount() {
        return this.shareCount;
    }

    public void setShareCount(int i) {
        this.shareCount = i;
    }

    public int getPinCount() {
        return this.pinCount;
    }

    public void setPinCount(int i) {
        this.pinCount = i;
    }

    public void setDownVoted() {
        setVoted(Consts.VOTE_TYPE_DOWN);
    }

    public void setUpVoted() {
        setVoted(Consts.VOTE_TYPE_UP);
    }

    public boolean isFromHome() {
        return this.fromHome;
    }

    public boolean isGotThanks() {
        return this.gotThanks;
    }

    public void setGotThanks(boolean z) {
        this.gotThanks = z;
    }

    public int getReplier() {
        return this.replier;
    }

    public void setReplier(int i) {
        this.replier = i;
    }

    public boolean isOffline() {
        return this.isOffline;
    }

    public void setOffline() {
        this.isOffline = true;
    }

    public List<PostHighlight> getHighlight() {
        return this.highlight;
    }

    public LocationTag getLocationTag() {
        return this.locationTag;
    }

    public void setLocationTag(LocationTag locationTag) {
        this.locationTag = locationTag;
    }

    public String getReplyTimestamp() {
        return this.replyTimestamp;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        if (this.createdAt != null) {
            parcel.writeLong(this.createdAt.getMillis());
        }
        parcel.writeInt(this.voteCount);
        parcel.writeInt(this.childCount);
        parcel.writeInt(this.pinCount);
        parcel.writeString(this.voted);
        parcel.writeFloat(this.distance);
        if (this.children != null) {
            parcel.writeInt(1);
            parcel.writeTypedList(this.children);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.postId);
        parcel.writeString(this.parentId);
        parcel.writeString(this.message);
        parcel.writeString(this.postOwn);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.thumbnailUrl);
        parcel.writeString(this.color);
        parcel.writeParcelable(this.location, 0);
        parcel.writeString(this.userHandle);
        parcel.writeString(this.replierMark);
        parcel.writeByte((byte) (this.notificationsEnabled ? 1 : 0));
        if (this.pinned) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (this.fromHome) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (this.gotThanks) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (this.removed) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeInt(this.removedReason);
        parcel.writeInt(this.thanksCount);
        parcel.writeInt(this.replier);
        if (this.isReply) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (this.isFlagged) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.readonly) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeString(this.replyTimestamp);
        parcel.writeParcelable(this.locationTag, 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Post)) {
            return false;
        }
        Post post = (Post) obj;
        if (post.postId != null) {
            return post.postId.equals(this.postId);
        }
        return false;
    }

    public int hashCode() {
        return this.postId.hashCode();
    }
}
