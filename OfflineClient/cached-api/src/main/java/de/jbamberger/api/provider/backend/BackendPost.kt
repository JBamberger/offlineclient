package de.jbamberger.api.provider.backend

import com.squareup.moshi.Json
import de.jbamberger.api.model.StreamContent

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */
class BackendPost(
        @Json(name="content") content: String,
        @Json(name="content_url")contentUrl: String,
        @Json(name="order_date")orderDate: Long,
        @Json(name="image_url")imageUrl: String?) :
        StreamContent(content, contentUrl, orderDate, imageUrl)