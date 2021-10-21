package com.example.androiddevchallenge.petstore.home

import android.content.Context
import android.icu.util.Currency
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import com.example.androiddevchallenge.R
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

class PetStoreHomeRepository(val context : Context, val gson: Gson) {

    fun getPets() : PetsList? {
        val jsonString = context.assets.open("petslist.json").bufferedReader().use {
            it.readText()
        }
        return gson.fromJson(jsonString, PetsList::class.java)

    }

    data class Pet(@SerializedName("petname") val petName: String, val category: String,@SerializedName("petpicture") val petPicture: String, val price: Int, val currency: String, val distance: String){
        fun getCategory(): PetCategory{
            return PetCategory.valueOf(category)
        }
    }

    data class PetsList(val petslist : ArrayList<Pet>)

    enum class PetCategory(){
            DOGS{
                override fun getPetCategoryImageURL() = "https://post.medicalnewstoday.com/wp-content/uploads/sites/3/2020/02/322868_1100-800x825.jpg"
            },
            CATS{
                override fun getPetCategoryImageURL() = "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/cat-quotes-1543599392.jpg?crop=1.00xw:0.759xh;0,0&resize=980:*"
            },
            BIRDS{
                override fun getPetCategoryImageURL() =
                    "https://cdn.birdwatchingdaily.com/2020/06/Mountain-Bluebird-nr-Millarville-29-May-2020.jpg"
            };
       abstract fun getPetCategoryImageURL() : String
    }
}



