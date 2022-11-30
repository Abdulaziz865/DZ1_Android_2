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
    private var firstAdapter: FirstAdapter? = null
    private var secondAdapter: SecondAdapter? = null
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
        firstAdapter = FirstAdapter(modelArrayList, this::onClickListener)
        secondAdapter = SecondAdapter(modelArrayList, this::onClickListener)
        val concatAdapter = ConcatAdapter(firstAdapter, secondAdapter)
        binding?.rvListOfName?.adapter = concatAdapter
    }

    private fun onClickListener(model: RecyclerModel) {
        findNavController().navigate(
            FirstFragmentDirections.actionMainFragmentToDetailFragment(
                model.name
            )
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        modelArrayList.clear()
    }
}