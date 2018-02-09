package de.jbamberger.offlineclient.ui.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import de.jbamberger.offlineclient.di.AppInjector
import javax.inject.Inject

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

abstract class BaseFragment<T : ViewModel> : Fragment(), AppInjector.Injectable {

    @Inject
    internal lateinit var context: Context

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory

    internal lateinit var viewModel: T
    abstract var viewModelClass: Class<T>


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders
                .of(this, viewModelFactory)
                .get(viewModelClass)
    }
}
