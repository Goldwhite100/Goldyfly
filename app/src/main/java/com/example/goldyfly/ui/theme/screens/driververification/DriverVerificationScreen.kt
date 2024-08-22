package com.example.goldyfly.ui.theme.screens.driververification

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun DriverVerificationScreen(navController: NavController) {
    var driverName by remember { mutableStateOf(TextFieldValue()) }
    var driverLicense by remember { mutableStateOf(TextFieldValue()) }
    var verificationStatus by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Driver Verification",
            fontSize = 60.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Cyan

        )

        TextField(
            value = driverName,
            onValueChange = { driverName = it },
            label = { Text("Driver Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = driverLicense,
            onValueChange = { driverLicense = it },
            label = { Text("Driver License Number") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { verificationStatus = verifyDriver(driverName.text, driverLicense.text) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Verify Driver")
        }

        Spacer(modifier = Modifier.height(16.dp))


    }
}

fun verifyDriver(name: String, license: String): String {

    return if (name.isNotBlank() && license.isNotBlank()) {
        "Driver Verified: $name"
    } else {
        "Verification Failed: Please enter all required fields."
    }
}

@Preview(showBackground = true)
@Composable
fun DriverVerificationScreenPreview() {
    DriverVerificationScreen(rememberNavController())
}