package de.jbamberger.offlineclient.ui.main

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.jbamberger.api.model.StreamContent
import de.jbamberger.offlineclient.BR
import de.jbamberger.offlineclient.R
import timber.log.Timber
import java.util.*


/**
 * RecyclerView adapter that uses ListItems to bind data to views. The Adapter does not support
 * multi-selection. The Items can have unique layouts, but the data types returned by getObj and
 * getListener must match the layout.
 *
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

class StreamAdapter : RecyclerView.Adapter<StreamAdapter.DataBindingViewHolder>() {

    private var items: List<StreamContent> = ArrayList()


    /**
     * Creates a new View of the given type and binds it to a ViewHolder
     *
     * @param parent   parent of the newly created View
     * @param viewType integer used to distinguish the different View types
     * @return ViewHolder of the newly created View
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, viewType, parent, false)
        return DataBindingViewHolder(binding, viewType)
    }

    /**
     * Binds the data item at position to the View of holder
     *
     * @param holder   View to bind to
     * @param position index of the data item
     */
    override fun onBindViewHolder(holder: DataBindingViewHolder, position: Int) {
        val obj = items[position]
        Timber.d("%s Provider: %s", obj.javaClass, obj.provider?.name)
        val listener = null
        holder.bind(obj, listener)
    }

    /**
     * Returns the view type of the data item at the given position
     *
     * @param position index of the data item
     * @return view type required for the data item at the given position
     */
    override fun getItemViewType(position: Int): Int {
        return R.layout.stream_post
    }


    fun setItems(items: List<StreamContent>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    /**
     * ViewHolder class containing a reference to the ViewDataBinding of the associated view.
     */
    class DataBindingViewHolder(val binding: ViewDataBinding, @param:LayoutRes @field:LayoutRes
    private val viewType: Int) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        private var expanded = false

        /**
         * Binds the data obj and event listener to the View.
         *
         * @param obj      data obj
         * @param listener event listener
         */
        fun bind(obj: Any?, listener: Any?) {
            binding.setVariable(BR.obj, obj)
            binding.setVariable(BR.listener, listener)
            binding.executePendingBindings()
        }

        override fun onClick(v: View) {
            expanded = !expanded
            when (viewType) {

            }
        }
    }
}
