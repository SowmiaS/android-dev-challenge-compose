package com.example.androiddevchallenge.petstore.home

import android.content.Context
import android.icu.util.Currency
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import com.example.androiddevchallenge.R
import com.google.gson.Gson

class PetStoreHomeRepository(val context : Context, val gson: Gson) {

    fun getPets() : PetsList? {
        val jsonString = context.assets.open("petslist.json").bufferedReader().use {
            it.readText()
        }
        return gson.fromJson(jsonString, PetsList::class.java)

    }

    data class Pet(val petName: String,val category: PetCategory, val petPicture: String, val price: Int, val currency: Currency, val distance: Int)

    data class PetsList(val petslist : ArrayList<Pet>)

    enum class PetCategory(val petname : String){
            DOGS("DOGS"){
                override fun getPetCategoryImageURL() = "https://media.hswstatic.com/eyJidWNrZXQiOiJjb250ZW50Lmhzd3N0YXRpYy5jb20iLCJrZXkiOiJnaWZcL3B1Zy5qcGciLCJlZGl0cyI6eyJyZXNpemUiOnsid2lkdGgiOjQwMH0sInRvRm9ybWF0IjoiYXZpZiJ9fQ=="
            },
            CATS("CATS"){
                override fun getPetCategoryImageURL() = "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/cat-quotes-1543599392.jpg?crop=1.00xw:0.759xh;0,0&resize=980:*"
            },
            BIRDS("BIRDS") {
                override fun getPetCategoryImageURL() =
                    "https://cdn.birdwatchingdaily.com/2020/06/Mountain-Bluebird-nr-Millarville-29-May-2020.jpg"
            };
       abstract fun getPetCategoryImageURL() : String
    }
}



