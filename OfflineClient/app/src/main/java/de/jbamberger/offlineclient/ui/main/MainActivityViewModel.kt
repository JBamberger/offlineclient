package de.jbamberger.offlineclient.ui.main

import android.arch.lifecycle.ViewModel
import de.jbamberger.api.provider.Repository
import javax.inject.Inject

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

class MainActivityViewModel @Inject constructor(private val repo: Repository) : ViewModel()
