package com.example.androiddevchallenge.petstore.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment

@Composable
fun PetStoreHomeUI() {
    PetStoreAppBar()
}

@SuppressLint("RestrictedApi")
@Composable
fun PetStoreAppBar(){
    TopAppBar(backgroundColor = Color(Color.White.value)) {
        Spacer(modifier = Modifier.width(50.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Image(painter = painterResource(id = R.drawable.ic_menu),
                contentDescription = "menu is",
                modifier = Modifier.alignByBaseline(),
                alignment = Alignment.Center)

            Row(modifier = Modifier.wrapContentSize()){
            Image(painter = painterResource(id = R.drawable.ic_location),
                contentDescription = "current location is",
                modifier = Modifier.alignByBaseline())
            Text(text = "Zurich,CH",
                modifier = Modifier
                    .alignByBaseline()
                    .align(Alignment.Bottom),
                color = Color.Black)
            Image(painter = painterResource(id = R.drawable.ic_down_arrow),
                contentDescription = "current location is",
                modifier = Modifier.alignByBaseline())
            }
            Image(painter = painterResource(id = R.drawable.ic_action_name),
                contentDescription = "current location is",
                modifier = Modifier
                    .alignByBaseline()
                    .size(30.dp),
                alignment = Alignment.BottomEnd)
        }
        Spacer(modifier = Modifier.width(50.dp))

    }

//     Image(
//        painter = painterResource(id = R.drawable.ic_launcher_background),
//        contentDescription = "menu",
//        modifier = Modifier.height(height = 10.dp),
//        alignment = Alignment.Center,
//        contentScale  = ContentScale.Fit,
//        alpha = DefaultAlpha,
//        colorFilter = null
//    )
//
//
//    Image(
//        painter = painterResource(id = R.drawable.ic_launcher_background),
//        contentDescription = "menu",
//        modifier = Modifier.height(height = 10.dp),
//        alignment = Alignment.Center,
//        contentScale  = ContentScale.Fit,
//        alpha = DefaultAlpha,
//        colorFilter = null
//    )
//
//    Text(text = "Zurich,CH",
//    color = Color.Black)
//
//    Image(painter = painterResource(id = R.id.dragDown), contentDescription = "")
//
//    Image(
//        painter = painterResource(id = R.drawable.ic_launcher_background),
//        contentDescription = "menu",
//        modifier = Modifier.height(height = 10.dp),
//        alignment = Alignment.Center,
//        contentScale  = ContentScale.Fit,
//        alpha = DefaultAlpha,
//        colorFilter = null
//    )

}


@Preview
@Composable
fun ComposablePreview() {
    PetStoreAppBar()
}


