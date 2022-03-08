package com.escalondev.deeplink_nav.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.escalondev.deeplink_nav.databinding.FragmentWebViewBinding

class WebViewFragment : Fragment() {

    lateinit var binding: FragmentWebViewBinding
    private val args: WebViewFragmentArgs by navArgs()

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
        binding.webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                url?.let { view?.loadUrl(it) }
                return true
            }
        }

        binding.webView.apply {
            settings.userAgentString = System.getProperty(AGENT)

            // getting url param obtained from deeplink
            args.url?.let { url ->
                loadUrl(url)
            } ?: run {
                loadUrl(DEFAULT_WEB_URL)
            }
        }
    }

    companion object {
        const val DEFAULT_WEB_URL = "https://developer.android.com/docs"
        const val AGENT = "https.agent"
    }
}