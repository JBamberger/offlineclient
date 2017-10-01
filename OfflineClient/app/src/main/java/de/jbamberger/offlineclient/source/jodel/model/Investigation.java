package de.jbamberger.offlineclient.source.jodel.model;

public class Investigation {
    public final String ancestor_post_id;
    public final String post_id;

    public Investigation(String str, String str2) {
        this.post_id = str;
        this.ancestor_post_id = str2;
    }
}
