package com.example.dz1_android_2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.example.dz1_android_2.adapters.FirstAdapter
import com.example.dz1_android_2.adapters.SecondAdapter
import com.example.dz1_android_2.databinding.FragmentFirstBinding
import com.example.dz1_android_2.model.RecyclerModel
import com.example.dz1_android_2.repository.RecyclerRepository

class FirstFragment : Fragment() {

    private var binding: FragmentFirstBinding? = null
    private val repository = RecyclerRepository()
    private var imageAdapter: FirstAdapter? = null
    private var nameAdapter: SecondAdapter? = null
    private lateinit var modelArrayList: ArrayList<RecyclerModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        modelArrayList = repository.getListData()
        imageAdapter = FirstAdapter(modelArrayList, this::onClickListener)
        nameAdapter = SecondAdapter(modelArrayList, this::onClickListenerImage)
        val concatAdapter = ConcatAdapter(nameAdapter, imageAdapter)
        binding?.rvListOfName?.adapter = concatAdapter
    }

    private fun onClickListenerImage(model: RecyclerModel) {
        findNavController().navigate(
            FirstFragmentDirections.actionFirstFragmentToDetailImageFragment(
                model.image
            )
        )
    }

    private fun onClickListener(model: RecyclerModel) {
        findNavController().navigate(
            FirstFragmentDirections.actionMainFragmentToDetailFragment(
                model.name
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        modelArrayList.clear()
        binding = null
    }
}