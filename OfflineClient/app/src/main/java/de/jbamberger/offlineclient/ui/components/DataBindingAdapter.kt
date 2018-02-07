package de.jbamberger.offlineclient.ui.components

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.jbamberger.offlineclient.BR
import java.util.*


/**
 * RecyclerView adapter that uses ListItems to bind data to views. The Adapter does not support
 * multi-selection. The Items can have unique layouts, but the data types returned by getObj and
 * getListener must match the layout.
 *
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

class DataBindingAdapter : RecyclerView.Adapter<DataBindingAdapter.DataBindingViewHolder>() {

    private var items: List<ListItem> = ArrayList()


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
        val obj = getObjForPosition(position)
        val listener = getListenerForPosition(position)
        holder.bind(obj, listener)
    }

    /**
     * Returns the view type of the data item at the given position
     *
     * @param position index of the data item
     * @return view type required for the data item at the given position
     */
    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }


    fun setItems(items: List<ListItem>) {
        this.items = items
        notifyDataSetChanged()
    }

    protected fun getObjForPosition(position: Int): Any? {
        return items[position].obj
    }

    protected fun getListenerForPosition(position: Int): Any? {
        return items[position].listener
    }

    protected fun getLayoutIdForPosition(position: Int): Int {
        return items[position].layoutRes
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
