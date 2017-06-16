package de.jbamberger.offlinefetcher.source.jodel;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */


import java.util.List;

public class PostDetailsResponse {
    Post details;
    String next;
    boolean readonly;
    int remaining;
    List<Post> replies;
    boolean shareable;
}
