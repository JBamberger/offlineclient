package de.jbamberger.offlineclient.ui.main

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import de.jbamberger.api.backend.BackendPost
import de.jbamberger.api.model.StreamContent
import de.jbamberger.offlineclient.R
import java.util.*

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

internal class CombinedStreamAdapter
private constructor(private val backendHandler: BackendStreamHandler) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private var items: List<StreamContent> = ArrayList()

    fun setItems(items: List<StreamContent>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.stream_post -> backendHandler.createHolder(parent, viewType)
            else -> TODO()
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item: StreamContent = items[position]
        return when (item) {
            is BackendPost -> backendHandler.getViewType(item)
            else -> TODO()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder == null) return
        val item: StreamContent = items[position]
        return when (item) {
            is BackendPost -> backendHandler.bindViewHolder(item, holder as BackendStreamHandler.Holder)
            else -> TODO()
        }
    }

    interface StreamHandler<in ItemType: StreamContent, HolderType: RecyclerView.ViewHolder> {
        fun bindViewHolder(item: ItemType, holder: HolderType)

        fun getViewType(item: ItemType): Int

        fun createHolder(parent: ViewGroup?, viewType: Int): HolderType
    }
}
