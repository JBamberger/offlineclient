package de.jbamberger.api.model

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */
abstract class StreamContent constructor(
        val provider: StreamProvider,
        val content: String,
        val contentUrl: String,
        val orderDate: Long,
        val imageUrl: String?
)