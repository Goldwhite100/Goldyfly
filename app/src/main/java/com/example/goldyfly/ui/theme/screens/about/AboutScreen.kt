package com.example.goldyfly.ui.theme.screens.about

import android.app.DatePickerDialog
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.goldyfly.ui.theme.Pink40
import com.example.goldyfly.ui.theme.Pink80
import com.example.goldyfly.ui.theme.newGreen
import java.util.Calendar


@Composable
fun AboutScreen(navController: NavController){

    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){



        //DateField
        var selectedDate by remember { mutableStateOf<String?>(null) }
        var showDatePicker by remember { mutableStateOf(false) }



        Row(modifier = Modifier.padding(start = 20.dp, end = 20.dp)){

            Button(onClick = {
                val calendar = Calendar.getInstance()
                val year = calendar.get(Calendar.YEAR)
                val month = calendar.get(Calendar.MONTH)
                val day = calendar.get(Calendar.DAY_OF_MONTH)

                DatePickerDialog(
                    //Don't forget to create the context variable located just below
                    //the aboutscreen function
                    context,
                    { _, selectedYear, selectedMonth, selectedDay ->
                        selectedDate = "${selectedDay}/${selectedMonth + 1}/${selectedYear}"
                    },
                    year,
                    month,
                    day
                ).show()
            },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(newGreen),
                modifier = Modifier
                    .height(65.dp)
                    .padding(top = 10.dp)) {
                Text(text = "Start Date")
            }
            Spacer(modifier = Modifier.width(20.dp))

            OutlinedTextField(
                value = selectedDate ?: "",
                onValueChange = { /* No-op, as we handle value through date picker */ },
                label = { Text("Select Date") },
                readOnly = true,  // Makes the text field non-editable
                modifier = Modifier
                    .padding(bottom = 18.dp)
                    .width(250.dp),
                trailingIcon = {
                    Text(text = "📅")  // Icon to indicate date picker
                },
                singleLine = true
            )


        }

        //End of a datefield





        //Start of radiobutton
        val selectedOption = remember { mutableStateOf("Male") }

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Choose gender",
                fontSize = 40.sp
            )
            listOf("Male", "Female", "Bigender").forEach { option ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 5.dp)
                ) {
                    RadioButton(
                        selected = selectedOption.value == option,
                        onClick = { selectedOption.value = option },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Pink40,
                            unselectedColor = Pink80
                        )
                    )
                    Text(
                        text = option,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }

        //End of radiobutton









    }


}


@Composable
@Preview(showBackground = true)
fun AboutScreenPreview(){
    AboutScreen(rememberNavController())
}