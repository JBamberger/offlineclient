package de.jbamberger.offlinefetcher.ui.components;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

public abstract class DataBindingBaseAdapter
        extends RecyclerView.Adapter<DataBindingBaseAdapter.DataBindingViewHolder> {
    public DataBindingViewHolder onCreateViewHolder(ViewGroup parent,
                                                    int viewType) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(
                layoutInflater, viewType, parent, false);
        return new DataBindingViewHolder(binding);
    }

    public void onBindViewHolder(DataBindingViewHolder holder,
                                 int position) {
        Object obj = getObjForPosition(position);
        holder.bind(obj);
    }
    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }

    protected abstract Object getObjForPosition(int position);

    protected abstract int getLayoutIdForPosition(int position);

    public class DataBindingViewHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding binding;

        public DataBindingViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Object obj) {
            binding.setVariable(BR.obj, obj);
            binding.executePendingBindings();
        }
    }
}