package de.jbamberger.offlineclient.di.jodel;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface JodelActivityScope {
}
