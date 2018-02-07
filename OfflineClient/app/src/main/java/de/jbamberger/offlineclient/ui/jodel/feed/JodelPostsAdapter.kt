package de.jbamberger.offlineclient.ui.jodel.feed

import de.jbamberger.offlineclient.R
import de.jbamberger.offlineclient.source.jodel.model.Post
import de.jbamberger.offlineclient.ui.components.DataBindingBaseAdapter
import java.util.*

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

class JodelPostsAdapter : DataBindingBaseAdapter() {


    private var items: List<Post> = ArrayList()

    internal fun setItems(items: List<Post>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun getListenerForPosition(position: Int): Any? {
        return null
    }

    override fun getObjForPosition(position: Int): Any? {
        return items[position]
    }

    override fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.post
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
