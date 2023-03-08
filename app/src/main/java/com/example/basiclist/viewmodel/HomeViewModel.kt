package com.example.basiclist.viewmodel

import androidx.lifecycle.ViewModel
import com.example.basiclist.model.HomeModel

class HomeViewModel : ViewModel() {

    private var homeModelArrayList: ArrayList<HomeModel> = ArrayList()

    fun getListOfCatHTP(): ArrayList<HomeModel> {
        homeModelArrayList.clear()
        homeModelArrayList.add(HomeModel("https://http.cat/100", "Continue"))
        homeModelArrayList.add(HomeModel("https://http.cat/101", "Switching Protocols"))
        homeModelArrayList.add(HomeModel("https://http.cat/102", "Processing"))

        return homeModelArrayList
    }
}