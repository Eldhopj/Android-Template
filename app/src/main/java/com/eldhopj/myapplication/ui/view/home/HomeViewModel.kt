package com.eldhopj.myapplication.ui.view.home

import androidx.lifecycle.ViewModel
import com.eldhopj.myapplication.data.repositories.ApiRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Home view model
 *
 * @property repo
 * @constructor Create empty Home view model
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: ApiRepo,
) : ViewModel() {
    //
}
