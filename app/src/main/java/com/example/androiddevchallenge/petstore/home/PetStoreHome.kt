package com.example.androiddevchallenge.petstore.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.size.OriginalSize
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.android.material.tabs.TabLayout
import java.time.format.TextStyle

@ExperimentalFoundationApi
@Composable
fun PetStoreHomeUI(
    petCategories: Array<PetStoreHomeRepository.PetCategory>,
    petsList: ArrayList<PetStoreHomeRepository.Pet>?
) {
    rememberSystemUiController().setSystemBarsColor(
        color = grey50,
    )
    MyTheme{
    Row {

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(grey50)
                .padding(32.dp, 20.dp, 32.dp, 0.dp)
        ) {
            PetStoreAppBar()
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
            )
            PetStoreSearchBlock()
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
            )
            PetStoreCategoriesBlock(petCategories)
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(15.dp)
            )
            PetsListBlock(petsList)
        }
    }
    }
}


@SuppressLint("RestrictedApi")
@Composable
fun PetStoreAppBar() {

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconButton(onClick = { } ,
            modifier = Modifier
                .background(Color.White, shape = shapes.small)
                .size(48.dp)) {
            Icon(
                contentDescription = "menu is",
                painter = painterResource(id = R.drawable.ic_home_black),
                modifier = Modifier.size(30.dp),
                tint = purple700
            )
        }

        Row {
            Icon(
                painter = painterResource(id = R.drawable.ic_location),
                contentDescription = "current location is",
                modifier = Modifier
                    .align(Alignment.Bottom),
                tint = purple700
            
            )
            Text(
                text = "Zurich,CH",
                modifier = Modifier
                    .align(Alignment.Bottom),
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Image(
                painter = painterResource(id = R.drawable.ic_down_arrow),
                contentDescription = "current location is",
                modifier = Modifier
                        .align(Alignment.Bottom)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.ic_action_name),
            contentDescription = "current location is",
            modifier = Modifier
                .alignByBaseline()
                .size(60.dp),
            alignment = Alignment.BottomEnd
        )

    }




}


@Composable
fun PetStoreSearchBlock() {
    Column(
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = stringResource(id = R.string.label_home_tv_find_your_new_pet),
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(15.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier
                .height(48.dp)
                .weight(1f)){
            TextField(
                value = "",
                modifier = Modifier.fillMaxHeight(),
                onValueChange = {},
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = android.R.drawable.ic_menu_search),
                        contentDescription = "search",
                        tint = Color.Black
                    )
                },
                placeholder = {
                    Text(text = stringResource(id = R.string.label_home_tf_hint_search),
                        color = Color.LightGray,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Light
                    )
                },
                shape = shapes.small,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    textColor = Color.LightGray,
                    focusedIndicatorColor = Color.Transparent
                )
            )
            }
            Spacer(modifier = Modifier
                .width(20.dp))
            IconButton(
                onClick = { },
                modifier = Modifier
                    .padding(0.dp)
                    .background(color = orange, shape = shapes.small)
                    .size(48.dp),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu),
                    contentDescription = "filter",
                    modifier = Modifier
                        .size(30.dp)
                        .padding(0.dp),
                    tint = Color.White
                )

            }
        }
    }

}

@Composable
fun PetStoreCategoriesBlock(petCategories: Array<PetStoreHomeRepository.PetCategory>) {
    Column {
        Text(text = stringResource(id = R.string.label_home_tv_categories),
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold)
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(15.dp))
        TabRow(selectedTabIndex = 1,
            indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        color = Color.Yellow
                    )
                

            }) {
            Tab(selected = true, onClick = {}) {
                Text(text = "Dogs")
            }

            Tab(selected = false, onClick = {}) {
                Text(text = "Cats")
            }

            Tab(selected = false, onClick = {}) {
                Text(text = "Birds")
            }

        }
        LazyRow() {
            items(petCategories) { it ->
                Column {
                    Image(
                        painter = rememberImagePainter(it.getPetCategoryImageURL(),
                            builder = {
                                size(OriginalSize)
                            }),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(150.dp),

                        )
                    Log.d("DDD", "Pet >> ${it.toString()}")
                    Text(text = it.name)


                }


            }
        }
    }
}
@ExperimentalFoundationApi
@Composable
fun PetsListBlock(petsList: ArrayList<PetStoreHomeRepository.Pet>?) {

    petsList?.let {
        LazyVerticalGrid(cells = GridCells.Fixed(2),
        modifier = Modifier.padding(10.dp)) {
            items(petsList) { it ->
                Column {
                    Image(
                        painter = rememberImagePainter(it.petPicture,
                            builder = {
                                size(OriginalSize)
                            }),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(150.dp),

                        )
                    Log.d("DDD", "Pet >> ${it.toString()}")
                    Text(text = it.petName)
                    Text(text = it.price.toString().plus(it.currency))
                    Text(text = it.distance)
                }
            }
        }
    }


}


@Preview
@Composable
fun ComposablePreview() {
    MyTheme() {


        PetStoreSearchBlock()

    }

}





