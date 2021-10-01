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
fun PetStoreAppBar() {
    TopAppBar(backgroundColor = Color(Color.White.value)) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(50.dp,0.dp,50.dp,0.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_menu),
                contentDescription = "menu is",
                alignment = Alignment.Center
            )

            Row(modifier = Modifier.wrapContentSize(),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_location),
                    contentDescription = "current location is",
                    modifier = Modifier
                        .align(Alignment.Bottom)
                )
                Text(
                    text = "Zurich,CH",
                    modifier = Modifier
                        .align(Alignment.Bottom),
                    color = Color.Black
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_down_arrow),
                    contentDescription = "current location is"
                )
            }
            Image(
                painter = painterResource(id = R.drawable.ic_action_name),
                contentDescription = "current location is",
                modifier = Modifier
                    .alignByBaseline()
                    .size(30.dp),
                alignment = Alignment.BottomEnd
            )

        }

    }


}


@Preview
@Composable
fun ComposablePreview() {
    PetStoreAppBar()
}


