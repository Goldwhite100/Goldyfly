package com.example.goldyfly.ui.theme.screens.ridesharing


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.telephony.SmsManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RideSharingApp()
        }
    }
}

@Composable
fun RideSharingApp() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            RideSharingScreen()
        }
    }
}

@Composable
fun RideSharingScreen() {
    var phoneNumber by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("I am on my way to [Destination]. My estimated arrival time is [ETA].") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Safety Notes",
            fontSize = 60.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Cyan
        )

        TextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Recipient Phone Number") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = message,
            onValueChange = { message = it },
            label = { Text("Message") },
            modifier = Modifier.fillMaxWidth(),
            maxLines = 3
        )
        Spacer(modifier = Modifier.height(16.dp))


        val mContext = LocalContext.current

        Button(
            onClick = {
                val smsIntent = Intent(Intent.ACTION_SENDTO)
                smsIntent.data = "smsto:0700658322".toUri()
                smsIntent.putExtra("sms_body", "Hello am not safe!!")
                mContext.startActivity(smsIntent)

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Share Ride")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewRideSharingScreen() {
    RideSharingApp()
}