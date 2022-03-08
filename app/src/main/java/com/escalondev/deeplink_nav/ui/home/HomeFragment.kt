package com.escalondev.deeplink_nav.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.escalondev.deeplink_nav.R
import com.escalondev.deeplink_nav.databinding.FragmentHomeBinding
import com.escalondev.deeplink_nav.util.navigateThroughDeepLink

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() {
        binding.tvNavToDetails.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionFragmentHomeToDetailsGraph())
        }

        // simple navigation
        binding.tvNavToWebsite.setOnClickListener {
            findNavController().navigateThroughDeepLink(getString(R.string.nav_to_web_view_fragment))
        }

        // use this to pass a parameter through URI
        binding.tvNavToWebsiteByParam.setOnClickListener {
            findNavController().navigateThroughDeepLink("android-app://webViewFragment/$NEW_URL")
        }
    }

    companion object {
        const val NEW_URL = "www.google.com"
    }
}
