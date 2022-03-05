package com.escalondev.deeplink_nav.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.escalondev.deeplink_nav.databinding.FragmentWebViewBinding

class WebViewFragment : Fragment() {

    lateinit var binding: FragmentWebViewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWebViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupWebView()
    }

    private fun setupWebView() {
        binding.webView.loadUrl(WEB_URL)
    }

    companion object {
        const val WEB_URL = "https://developer.android.com/docs"
    }
}