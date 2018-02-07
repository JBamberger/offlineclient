package de.jbamberger.offlineclient.ui.components

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

import de.jbamberger.offlineclient.BR

/**
 * Base class for RecyclerView Adapters. The adapter utilizes the android data binding library and
 * requires a "obj" and a "listener" field in the item layout.
 *
 *
 * The adapter provides multi-select capabilities.
 *
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */
abstract class DataBindingBaseAdapter : RecyclerView.Adapter<DataBindingBaseAdapter.DataBindingViewHolder>() {

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
        return DataBindingViewHolder(binding)
    }

    /**
     * Binds the data item at position to the View of holder
     *
     * @param holder   View to bind to
     * @param position index of the data item
     */
    override fun onBindViewHolder(holder: DataBindingViewHolder,
                                  position: Int) {
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


    /**
     * Returns the data item at a given position.
     *
     * @param position index of the data item
     * @return data item at position
     */
    protected abstract fun getObjForPosition(position: Int): Any?

    /**
     * Returns the event listener for the given position.
     *
     * @param position index of the data item
     * @return event handler at position
     */
    protected abstract fun getListenerForPosition(position: Int): Any?

    /**
     * Returns the layout id for the View at position
     *
     * @param position position of the View
     * @return layout resource id of the View
     */
    protected abstract fun getLayoutIdForPosition(position: Int): Int


    /**
     * ViewHolder class containing a reference to the ViewDataBinding of the associated view.
     */
    class DataBindingViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        /**
         * Binds the data object and event listener to the View.
         *
         * @param obj      data obj
         * @param listener event listener
         */
        fun bind(obj: Any?, listener: Any?) {
            binding.setVariable(BR.obj, obj)
            binding.setVariable(BR.listener, listener)
            binding.executePendingBindings()
        }
    }
}