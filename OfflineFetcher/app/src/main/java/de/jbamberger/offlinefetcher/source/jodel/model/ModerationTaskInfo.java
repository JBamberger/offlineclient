package de.jbamberger.offlinefetcher.source.jodel.model;

public class ModerationTaskInfo {
    private boolean hasTasks;

    public ModerationTaskInfo(boolean z) {
        this.hasTasks = z;
    }

    public boolean hasTasks() {
        return this.hasTasks;
    }
}
