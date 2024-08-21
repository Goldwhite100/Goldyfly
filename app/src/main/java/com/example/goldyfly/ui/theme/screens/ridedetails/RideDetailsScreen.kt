package com.example.goldyfly.ui.theme.screens.ridedetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.goldyfly.R

@Composable
fun RideDetailsScreen(navController: NavController){
    Column (modifier = Modifier
        .fillMaxSize()
        .paint(painterResource(R.drawable.background3), contentScale = ContentScale.FillBounds)

        ,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

    }


}
@Composable
@Preview(showBackground = true)
fun RideDetailsScreenPreview(){
    RideDetailsScreen(rememberNavController())

}