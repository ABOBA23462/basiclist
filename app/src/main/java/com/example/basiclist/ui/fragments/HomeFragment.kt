package com.example.basiclist.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.basiclist.R
import com.example.basiclist.databinding.FragmentHomeBinding
import com.example.basiclist.model.HomeModel
import com.example.basiclist.ui.adapter.HomeAdapter
import com.example.basiclist.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    private var viewModel: HomeViewModel? = null
    private val listBook = mutableListOf<HomeModel>()
    private lateinit var binding: FragmentHomeBinding
    private var adapterBook = HomeAdapter(listBook,this::onItemClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        setUpListeners()
        clear()
        initialization()
    }

    private fun setUpListeners() {
        binding.btnShow.setOnClickListener{
            binding.btnShow.isInvisible = true
            binding.rvList.isInvisible = false
        }
    }

    private fun clear() {
        listBook.clear()
    }

    private fun initialization() {
        viewModel?.let { listBook.addAll(it.getListOfCatHTP())}
        binding.rvList.adapter = adapterBook
    }
    
    private fun onItemClick(modelBook:HomeModel) {
        val action:NavDirections =
            HomeFragmentDirections.actionHomeFragmentToDetailFragment(
            modelBook.name,
            modelBook.img
        )
        findNavController().navigate(action)
    }
}
