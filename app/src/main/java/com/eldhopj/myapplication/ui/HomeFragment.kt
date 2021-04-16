package com.eldhopj.myapplication.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.eldhopj.myapplication.databinding.FragmentHomeBinding
import com.eldhopj.myapplication.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Home fragment
 *
 * @constructor Create empty Home fragment
 */
@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun setBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentHomeBinding =
        FragmentHomeBinding.inflate(inflater, container, false)

}
