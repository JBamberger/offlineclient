package de.jbamberger.offlineclient.ui.main

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import de.jbamberger.api.provider.backend.BackendPost

class BackendStreamHandler : CombinedStreamAdapter.StreamHandler<BackendPost, BackendStreamHandler.Holder> {

    override fun bindViewHolder(item: BackendPost, holder: Holder) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getViewType(item: BackendPost): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createHolder(parent: ViewGroup?, viewType: Int): Holder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {

    }
}