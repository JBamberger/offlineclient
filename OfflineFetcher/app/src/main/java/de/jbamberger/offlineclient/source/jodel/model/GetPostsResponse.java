package de.jbamberger.offlineclient.source.jodel.model;

import java.util.List;

public class GetPostsResponse {
    private ErrorType errorType;
    private int max;
    private List<Post> posts;
    private String requestTag;

    public enum ErrorType {
        NO_ERROR,
        CONNECTION_ERROR,
        UPDATE_ACCESS_TOKEN,
        OTHERS
    }

    public GetPostsResponse(String str, ErrorType errorType) {
        this.requestTag = str;
        this.errorType = errorType;
    }

    public GetPostsResponse(List<Post> list, int i) {
        this.posts = list;
        this.max = i;
    }

    public List<Post> getPosts() {
        return this.posts;
    }

    public int getMax() {
        return this.max;
    }

    public String getRequestTag() {
        return this.requestTag;
    }

    public ErrorType getErrorType() {
        return this.errorType;
    }

    public void setRequestTag(String str) {
        this.requestTag = str;
    }

    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }
}
