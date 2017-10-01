package de.jbamberger.offlineclient.source.jodel.model;

public class ModerationPost extends Post {
    public int flagReason;
    public String taskId;

    //TODO: added
    public ModerationPost(String str, String str2, Location location) {
        super(str, str2, location);
    }

    public String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }

    public int getFlagReason() {
        return this.flagReason;
    }

    public void setFlagReason(int i) {
        this.flagReason = i;
    }
}
