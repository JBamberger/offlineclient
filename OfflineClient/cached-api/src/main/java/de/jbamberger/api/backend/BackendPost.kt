package de.jbamberger.api.backend

import de.jbamberger.api.model.StreamContent
import de.jbamberger.api.model.StreamProvider

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */
class BackendPost(content: String, contentUrl: String, orderDate: Long, imageUrl: String?) :
        StreamContent(StreamProvider.BACKEND, content, contentUrl, orderDate, imageUrl) {
}