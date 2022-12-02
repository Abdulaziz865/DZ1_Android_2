package com.example.dz1_android_2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.dz1_android_2.databinding.FragmentDetailImageBinding

class DetailImageFragment : Fragment() {

    private var binding: FragmentDetailImageBinding? = null
    private val argsNavigation by navArgs<DetailImageFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailImageBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    private fun getData() {
        binding?.tvImage?.let {
            Glide.with(it).load(argsNavigation.image).into(it)
        }
    }
}
