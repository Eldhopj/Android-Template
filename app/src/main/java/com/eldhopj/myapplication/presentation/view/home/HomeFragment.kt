package com.eldhopj.myapplication.presentation.view.home

import androidx.fragment.app.viewModels
import com.eldhopj.myapplication.databinding.FragmentHomeBinding
import com.eldhopj.myapplication.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Home fragment
 *
 * @constructor Create empty Home fragment
 */
@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel by viewModels<HomeViewModel>()
}
