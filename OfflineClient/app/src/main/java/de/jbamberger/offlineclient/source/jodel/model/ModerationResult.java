package de.jbamberger.offlineclient.source.jodel.model;

public class ModerationResult {
    public static final int ACCEPT = 0;
    public static final int DISCARD = 2;
    public static final int SKIP = 1;
    public final int decision;
    public final String taskId;

    public ModerationResult(String str, int i) {
        this.taskId = str;
        this.decision = i;
    }
}
