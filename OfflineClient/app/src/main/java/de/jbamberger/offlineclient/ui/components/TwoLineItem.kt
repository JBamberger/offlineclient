package de.jbamberger.offlineclient.ui.components

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.view.View

import de.jbamberger.offlineclient.BR
import de.jbamberger.offlineclient.R

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

class TwoLineItem(private var title: String?, private var content: String?) : BaseObservable(), ListItem {
    private var actionListener: View.OnClickListener? = null

    override val listener: Any?
        get() = actionListener

    override val obj: Any
        get() = this

    override val layoutRes: Int
        get() = R.layout.list_two_line_item

    init {
        notifyPropertyChanged(BR.title)
        notifyPropertyChanged(BR.content)
    }

    constructor(title: String, content: String, actionListener: View.OnClickListener) : this(title, content) {
        this.actionListener = actionListener
        notifyPropertyChanged(BR.actionListener)
    }

    @Bindable
    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
        notifyPropertyChanged(BR.title)
    }

    @Bindable
    fun getContent(): String? {
        return content
    }

    fun setContent(content: String) {
        this.content = content
        notifyPropertyChanged(BR.content)
    }

    @Bindable
    fun getActionListener(): View.OnClickListener? {
        return actionListener
    }

    fun setActionListener(actionListener: View.OnClickListener) {
        this.actionListener = actionListener
        notifyPropertyChanged(BR.actionListener)
    }

}
