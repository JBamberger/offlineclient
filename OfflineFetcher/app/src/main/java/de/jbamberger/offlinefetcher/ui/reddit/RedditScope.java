package de.jbamberger.offlinefetcher.ui.reddit;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Scope
public @interface RedditScope {
}