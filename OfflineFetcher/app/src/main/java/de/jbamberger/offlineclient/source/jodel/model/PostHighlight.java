package de.jbamberger.offlineclient.source.jodel.model;

public class PostHighlight {
    private int index;
    private int length;

    public PostHighlight(int i, int i2) {
        this.index = i;
        this.length = i2;
    }

    public int getStartIndex() {
        return this.index;
    }

    public int getLength() {
        return this.length;
    }

    public int getEndIndex() {
        return getStartIndex() + getLength();
    }
}
