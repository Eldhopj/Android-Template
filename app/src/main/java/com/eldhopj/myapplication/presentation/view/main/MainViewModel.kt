package com.eldhopj.myapplication.presentation.view.main

import androidx.lifecycle.ViewModel
import com.eldhopj.myapplication.data.repositories.ApiRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Main view model
 *
 * @property repo
 * @constructor Create empty Main view model
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: ApiRepo,
) : ViewModel() {
    //
}
