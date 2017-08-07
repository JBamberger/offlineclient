package de.jbamberger.offlinefetcher.ui.components;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import de.jbamberger.offlinefetcher.BR;

/**
 * Base class for RecyclerView Adapters. The adapter utilizes the android data binding library and
 * requires a "obj" and a "listener" field in the item layout.
 * <p>
 * The adapter provides multi-select capabilities.
 *
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */
public abstract class DataBindingBaseAdapter
        extends RecyclerView.Adapter<DataBindingBaseAdapter.DataBindingViewHolder> {

    /**
     * Creates a new View of the given type and binds it to a ViewHolder
     *
     * @param parent   parent of the newly created View
     * @param viewType integer used to distinguish the different View types
     * @return ViewHolder of the newly created View
     */
    public DataBindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);
        return new DataBindingViewHolder(binding);
    }

    /**
     * Binds the data item at position to the View of holder
     *
     * @param holder   View to bind to
     * @param position index of the data item
     */
    public void onBindViewHolder(DataBindingViewHolder holder,
                                 int position) {
        Object obj = getObjForPosition(position);
        Object listener = getListenerForPosition(position);
        holder.bind(obj, listener);
    }

    /**
     * Returns the view type of the data item at the given position
     *
     * @param position index of the data item
     * @return view type required for the data item at the given position
     */
    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }


    /**
     * Returns the data item at a given position.
     *
     * @param position index of the data item
     * @return data item at position
     */
    protected abstract Object getObjForPosition(int position);

    /**
     * Returns the event listener for the given position.
     *
     * @param position index of the data item
     * @return event handler at position
     */
    protected abstract Object getListenerForPosition(int position);

    /**
     * Returns the layout id for the View at position
     *
     * @param position position of the View
     * @return layout resource id of the View
     */
    protected abstract int getLayoutIdForPosition(int position);


    /**
     * ViewHolder class containing a reference to the ViewDataBinding of the associated view.
     */
    public static class DataBindingViewHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding binding;

        public DataBindingViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        /**
         * Binds the data object and event listener to the View.
         *
         * @param obj      data object
         * @param listener event listener
         */
        public void bind(Object obj, Object listener) {
            binding.setVariable(BR.obj, obj);
            binding.setVariable(BR.listener, listener);
            binding.executePendingBindings();
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }
}