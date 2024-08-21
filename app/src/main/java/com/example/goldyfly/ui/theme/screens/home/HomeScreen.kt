package com.example.goldyfly.ui.theme.screens.home



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontFamily

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.goldyfly.R
import com.example.goldyfly.navigation.ROUT_HOME

import com.example.goldyfly.ui.theme.newGreen


@Composable
fun HomeScreen(navController: NavController){
    val pickupLocation = remember { mutableStateOf("") }
    val dropoffLocation = remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(newGreen),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {

        //Lottie Animation......shuold replace image in splash screen
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.property))
        val progress by animateLottieCompositionAsState(composition)
        LottieAnimation(composition, progress,
            modifier = Modifier.size(300.dp)
        )




        Text(
            text = "Goldyfly",
            fontSize = 60.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Magenta
        )
        Spacer(modifier = Modifier.height(10.dp))
        
        Text(
            text = "Book Ride",
            fontSize = 20.sp


        )
        
        Spacer(modifier = Modifier.height(140.dp))

        Text("Book a Ride" )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = pickupLocation.value,
            onValueChange = { pickupLocation.value = it },
            label = { Text("Pickup Location") },
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = dropoffLocation.value,
            onValueChange = { dropoffLocation.value = it },
            label = { Text("Dropoff Location") }
        )
        Button(onClick = {
            // Handle booking logic and navigate to ride details
            navController.navigate("rideDetails/12345")
        }) {
            Text("Book Ride")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("profile")
        }) {
            Text("Profile")


            Button(
                onClick = { navController.navigate(ROUT_HOME) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(start = 20.dp, end = 20.dp),
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Get Started")
            }
        }


    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}
