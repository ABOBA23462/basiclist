package com.example.basiclist.viewmodel

import androidx.lifecycle.ViewModel
import com.example.basiclist.model.HomeModel

class HomeViewModel : ViewModel() {

    private var homeModelArrayList: ArrayList<HomeModel> = ArrayList()

    fun getListOfCatHTP(): ArrayList<HomeModel> {
        homeModelArrayList.clear()
        homeModelArrayList.add(
            HomeModel(
                "https://static.detmir.st/media_out/494/929/4929494/450/0.jpg?1662437224508",
                " lost World"
            )
        )
        homeModelArrayList.add(
            HomeModel(
                "https://www.mann-ivanov-ferber.ru/assets/images/covers/37/21737/1.00x-thumb.png",
                "Дети капитана Гранта"
            )
        )
        homeModelArrayList.add(
            HomeModel(
                "https://www.storytel.com/images/640x640/0001156746.jpg",
                "самурай без меча"
            )
        )
        homeModelArrayList.add(
            HomeModel(
                "https://img4.labirint.ru/rc/fba9dddb9b67ef95831c7174b4c2eb8c/363x561q80/books16/150746/cover.jpg?1280394613",
                "Гарри Поттер и дары смерти"
            )
        )
        homeModelArrayList.add(
            HomeModel(
                "https://img4.labirint.ru/rc/c5593938783bcf5a3a3617ea89dbf73b/363x561q80/books46/459698/cover.jpg?1566211871",
                "Макс Фрай: чужак"
            )
        )
        homeModelArrayList.add(
            HomeModel(
                "https://cv9.litres.ru/pub/c/cover_200/48428994.jpg",
                "Ведьмин котел"
            )
        )
        return homeModelArrayList
    }
}
