package com.eldhopj.myapplication.presentation.view.home

import com.eldhopj.myapplication.domain.repoInterface.ApiRepo
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
    private val repo: ApiRepo,
) : BaseViewModel() {
    //
}
