package de.jbamberger.offlinefetcher.ui.components;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import de.jbamberger.offlinefetcher.BR;
import de.jbamberger.offlinefetcher.R;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

public class TwoLineItem extends BaseObservable implements ListItem {

    private String title;
    private String content;
    private View.OnClickListener actionListener;

    public TwoLineItem(String title, String content) {
        this.title = title;
        this.content = content;
        notifyPropertyChanged(BR.title);
        notifyPropertyChanged(BR.content);
    }

    public TwoLineItem(String title, String content, View.OnClickListener actionListener) {
        this(title, content);
        this.actionListener = actionListener;
        notifyPropertyChanged(BR.actionListener);
    }

    @Override
    public Object getListener() {
        return actionListener;
    }

    @Override
    public Object getObject() {
        return this;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_two_line_item;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        notifyPropertyChanged(BR.content);
    }

    @Bindable
    public View.OnClickListener getActionListener() {
        return actionListener;
    }

    public void setActionListener(View.OnClickListener actionListener) {
        this.actionListener = actionListener;
        notifyPropertyChanged(BR.actionListener);
    }

}
