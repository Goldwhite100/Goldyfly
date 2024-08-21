package com.example.goldyfly.ui.theme.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.R
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.goldyfly.data.AuthViewModel
import com.example.goldyfly.navigation.ROUT_SIGNUP
import com.example.goldyfly.ui.theme.Pink40
import com.example.goldyfly.ui.theme.Purple80
import com.example.goldyfly.ui.theme.newGreen


@Composable
fun LoginScreen(navController: NavController){
    Column (modifier = Modifier
        .fillMaxSize()
        .paint(painterResource(com.example.goldyfly.R.drawable.background), contentScale = ContentScale.FillBounds)

        ,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(id = com.example.goldyfly.R.drawable.background) ,
            contentDescription = "property",
            modifier = Modifier
                .size(200.dp),

            contentScale = ContentScale.Crop

        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Welcome back",
            fontSize = 60.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Magenta
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Already have an account.Please enter your credantials",
            fontSize = 20.sp,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value =email,
            onValueChange = {email = it},
            label = { Text(text = "email address")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            //ledingicon or
            trailingIcon ={ Icon(imageVector = Icons.Default.Email, contentDescription = "", tint = Purple80) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value =password,
            onValueChange = {password = it},
            label = { Text(text = "password")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            //ledingicon or
            trailingIcon ={ Icon(imageVector = Icons.Default.Lock, contentDescription = "", tint = newGreen)},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(10.dp))

        val context = LocalContext.current
        val authViewModel = AuthViewModel(navController, context)
        Button(
            onClick = {
                authViewModel.login(email, password)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 20.dp, end = 20.dp),
            colors = ButtonDefaults.buttonColors(Pink40),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "LOGIN")
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Do not have an account ?Register",
            fontSize = 20.sp,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate(ROUT_SIGNUP)
                },
            textAlign = TextAlign.Center
        )




    }


}
@Composable
@Preview(showBackground = true)
fun LoginScreenPreview(){
    LoginScreen(rememberNavController())

}