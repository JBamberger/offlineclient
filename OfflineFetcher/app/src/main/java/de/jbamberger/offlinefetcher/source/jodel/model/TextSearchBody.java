package de.jbamberger.offlinefetcher.source.jodel.model;

public class TextSearchBody {
    public final String message;
    public final boolean suggested;

    public TextSearchBody(String str, boolean z) {
        this.message = str;
        this.suggested = z;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isSuggested() {
        return this.suggested;
    }
}
