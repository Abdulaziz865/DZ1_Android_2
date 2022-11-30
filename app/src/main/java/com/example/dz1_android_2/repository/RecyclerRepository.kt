package com.example.dz1_android_2.repository

import com.example.dz1_android_2.model.RecyclerModel

class RecyclerRepository {

    private val list = arrayListOf<RecyclerModel>()

    fun getListData(): ArrayList<RecyclerModel> {
        list.add(
            RecyclerModel(
                "https://softech.kg/image/catalog/Products/Phones/Apple/14%20Pro%20Max/1%D1%84.jpg",
                "Iphone"
            )
        )
        list.add(
            RecyclerModel(
                "https://login.kg/image/cache/catalog/new/Phones/Xiaomi/Mi%2011T/xiaomi-11t-1-500x500.jpg",
                "Xiaomi"
            )
        )
        list.add(
            RecyclerModel(
                "https://samsungstore.kg/files/media/8/8738.png",
                "Samsung"
            )
        )
        list.add(
            RecyclerModel(
                "https://www.notebookcheck.net/fileadmin/Notebooks/News/_nc3/twocloursredminote12pro.jpg",
                "Redmi"
            )
        )
        list.add(
            RecyclerModel(
                "https://login.kg/image/cache/catalog/new/Phones/Nokia/G50/nokia-g50-1-500x500.jpg",
                "Nokia"
            )
        )
        list.add(
            RecyclerModel(
                "https://www.ixbt.com/img/r30/00/02/47/62/honor50imgcolorchangeru1.jpg",
                "Honor"
            )
        )
        list.add(
            RecyclerModel(
                "https://24.kg/files/media/242/242701.jpg",
                "Huawei"
            )
        )
        list.add(
            RecyclerModel(
                "https://cdn.britannica.com/02/155502-004-B94B05A0.jpg",
                "Telephons"
            )
        )
        return list
    }
}