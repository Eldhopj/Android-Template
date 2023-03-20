package com.eldhopj.myapplication.utils.bases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 * Base fragment with data binding ,and other common stuffs
 *
 * @param T
 * @constructor Create empty Base fragment view binding
 */
abstract class BaseFragment<T : ViewDataBinding>(private val bindingInflater: (inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean) -> T) :
    Fragment() {

    // Bindings
    private var _binding: T? = null

    /**
     * Binding
     */
    protected val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.let { viewCreated(it) }
    }

    /**
     * It is same as onViewCreated, so no need to override onViewCreated again on fragment
     */
    abstract fun viewCreated(binding: T)

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
