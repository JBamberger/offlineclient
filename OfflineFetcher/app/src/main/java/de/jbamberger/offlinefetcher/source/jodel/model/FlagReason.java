package de.jbamberger.offlinefetcher.source.jodel.model;

public class FlagReason {
    public final transient String reasonDesc;
    public final int reasonId;
    public final transient String reasonText;
    public final int subreasonId;

    public FlagReason(int i, int i2, String str) {
        this(i, i2, str, "");
    }

    public FlagReason(int i, int i2, String str, String str2) {
        this.reasonId = i;
        this.subreasonId = i2;
        this.reasonText = str;
        this.reasonDesc = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FlagReason flagReason = (FlagReason) obj;
        if (this.reasonId != flagReason.reasonId) {
            return false;
        }
        if (this.subreasonId != flagReason.subreasonId) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.reasonId * 31) + this.subreasonId;
    }
}
