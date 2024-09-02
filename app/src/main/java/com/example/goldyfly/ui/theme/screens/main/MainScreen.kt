package com.example.goldyfly.ui.theme.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.goldyfly.R
import com.example.goldyfly.navigation.ROUT_LOGIN
import com.example.goldyfly.navigation.ROUT_MAIN
import com.example.goldyfly.ui.theme.newGreen

@Composable
fun MainScreen(navController: NavController) {



    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally)


//MAIN
    {


        Image(
            painter = painterResource(id = R.drawable.img_5) ,
            contentDescription = "",
            modifier = Modifier
                .size(400.dp),
            contentScale = ContentScale.Crop

        )
        Spacer(modifier = Modifier.height(80.dp))

        Text(
            text = "CALL A TAXI",
            fontSize = 25.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Open the app and enter your destination in the “Where to?” box. Once you confirm that your pickup and destination addresses are correct, select Taxi.",
            fontSize = 15.sp,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )


        Spacer(modifier = Modifier.height(20.dp))


        Button(
            onClick = { navController.navigate(ROUT_LOGIN) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 20.dp, end = 20.dp),
            colors = ButtonDefaults.buttonColors(newGreen),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "Get Started")
        }



    }





}

@Composable
@Preview(showBackground = true)
fun MainScreenPreview(){
    MainScreen(rememberNavController())

}