package com.eldhopj.myapplication.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.eldhopj.myapplication.ui.view.main.MainActivity
import com.eldhopj.myapplication.utils.extensions.unblockInput

/**
 * Base fragment with view binding ,and other common stuffs
 *
 * @param T
 * @constructor Create empty Base fragment view binding
 */
abstract class BaseFragment<T : ViewBinding>(private val bindingInflater: (inflater: LayoutInflater) -> T) :
    Fragment() {

    // Bindings
    private var _binding: T? = null

    /**
     * Binding
     */
    protected val binding get() = _binding

    /**
     * getting Activity
     */
    protected val hostActivity by lazy { requireActivity() as? MainActivity }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater)
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        hostActivity?.unblockInput()
        _binding = null
    }
}
