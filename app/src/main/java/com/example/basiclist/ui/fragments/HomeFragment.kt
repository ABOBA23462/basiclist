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
import com.example.basiclist.databinding.FragmentHomeBinding
import com.example.basiclist.model.HomeModel
import com.example.basiclist.ui.adapter.HomeAdapter

class HomeFragment : Fragment() {

    private var viewModel: HomeViewModel? = null
    private lateinit var binding: FragmentHomeBinding
    private var adapterBook = HomeAdapter(this::onItemClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        init()
        setupListeners()
        setupObserves()

    }

    private fun init() {
        binding.rvList.adapter = adapterBook
    }

    private fun setupListeners() {
        binding.btnShow.setOnClickListener {
            binding.btnShow.isInvisible = true
            binding.rvList.isInvisible = false
        }
    }

    private fun setupObserves() {
        viewModel?.getListOfCatHTP()?.observe(viewLifecycleOwner) {
            adapterBook.setList(it)
        }
    }

    private fun onItemClick(modelBook: HomeModel) {
        val action: NavDirections =
            HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                modelBook.name,
                modelBook.img
            )
        findNavController().navigate(action)
    }
}
