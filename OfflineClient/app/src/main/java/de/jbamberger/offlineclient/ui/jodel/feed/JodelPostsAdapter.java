package de.jbamberger.offlineclient.ui.jodel.feed;

import java.util.ArrayList;
import java.util.List;

import de.jbamberger.offlineclient.R;
import de.jbamberger.offlineclient.source.jodel.model.Post;
import de.jbamberger.offlineclient.ui.components.DataBindingBaseAdapter;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

public class JodelPostsAdapter extends DataBindingBaseAdapter {


    private List<Post> items = new ArrayList<>();

    public void setItems(List<Post> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    protected Object getListenerForPosition(int position) {
        return null;
    }

    @Override
    protected Object getObjForPosition(int position) {
        return items.get(position);
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return R.layout.post;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
