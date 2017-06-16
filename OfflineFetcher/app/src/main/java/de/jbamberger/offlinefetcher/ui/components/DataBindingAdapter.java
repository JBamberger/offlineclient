package de.jbamberger.offlinefetcher.ui.components;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import de.jbamberger.offlinefetcher.BR;


/**
 * RecyclerView adapter that uses ListItems to bind data to views. The Adapter does not support
 * multi-selection. The Items can have unique layouts, but the data types returned by getObject and
 * getListener must match the layout.
 *
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

public class DataBindingAdapter extends RecyclerView.Adapter<DataBindingAdapter.DataBindingViewHolder> {

    private List<ListItem> items = new ArrayList<>();


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
        return new DataBindingViewHolder(binding, viewType);
    }

    /**
     * Binds the data item at position to the View of holder
     *
     * @param holder   View to bind to
     * @param position index of the data item
     */
    @Override
    public void onBindViewHolder(DataBindingViewHolder holder, int position) {
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


    public void setItems(List<ListItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    protected Object getObjForPosition(int position) {
        return items.get(position).getObject();
    }

    protected Object getListenerForPosition(int position) {
        return items.get(position).getListener();
    }

    protected int getLayoutIdForPosition(int position) {
        return items.get(position).getLayoutRes();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    /**
     * ViewHolder class containing a reference to the ViewDataBinding of the associated view.
     */
    public static class DataBindingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @LayoutRes
        private final int viewType;
        private final ViewDataBinding binding;
        private boolean expanded = false;

        public DataBindingViewHolder(ViewDataBinding binding, @LayoutRes int viewType) {
            super(binding.getRoot());
            this.binding = binding;
            this.viewType = viewType;
        }

        /**
         * Binds the data object and event listener to the View.
         *
         * @param obj      data object
         * @param listener event listener
         */
        public void bind(Object obj, Object listener) {
            binding.setVariable(BR.obj, obj);
            switch (viewType) {
                /*case R.layout.list_two_line_item_expandable:
                case R.layout.list_upload_status:
                    expanded = false;
                    ((TwoLineItemExpandable) obj).setExpanded(expanded);
                    binding.setVariable(BR.listener, this);
                    break;*/
                default:
                    binding.setVariable(BR.listener, listener);
                    break;
            }
            binding.executePendingBindings();
        }

        public ViewDataBinding getBinding() {
            return binding;
        }

        @Override
        public void onClick(View v) {
            expanded = !expanded;
            switch (viewType) {
                /*case R.layout.list_two_line_item_expandable:
                    ((ListTwoLineItemExpandableBinding) binding).getObj().setExpanded(expanded);
                    break;
                case R.layout.list_upload_status:
                    ((ListUploadStatusBinding) binding).getObj().setExpanded(expanded);
                    break;*/
                default:
            }
        }
    }
}
