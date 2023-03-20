package com.eldhopj.myapplication.presentation.view.home

import com.eldhopj.myapplication.data.repositories.ApiRepoImpl
import com.eldhopj.myapplication.utils.bases.BaseViewModel
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
    private val repo: ApiRepoImpl,
) : BaseViewModel() {
    //
}
