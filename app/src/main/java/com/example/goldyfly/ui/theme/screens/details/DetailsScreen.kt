package com.example.goldyfly.ui.theme.screens.details


import android.annotation.SuppressLint
import android.content.Intent
import android.provider.MediaStore
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.goldyfly.ui.theme.newGreen
import com.example.goldyfly.R
import com.example.goldyfly.navigation.ADD_ACCOUNT
import com.example.goldyfly.navigation.ADD_CONTACT
import com.example.goldyfly.navigation.BOOKING_URL
import com.example.goldyfly.navigation.VIEW_ACCOUNT
import com.example.goldyfly.navigation.VIEW_BOOKING_URL
import com.example.goldyfly.navigation.VIEW_CONTACT
import com.example.goldyfly.ui.theme.screens.book.BottomNavItem
import com.example.goldyfly.ui.theme.screens.book.bottomNavItems

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailsScreen(navController: NavController){

    Column (modifier = Modifier.fillMaxSize()){
        var selected by remember { mutableIntStateOf(0) }
        //signup and login not need scaffold
        Scaffold(

            topBar = {
                TopAppBar(
                    title = { Text(text = "Goldyfly", color = newGreen) },
                    navigationIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "", tint = newGreen)
                        }
                    },
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.Info, contentDescription = "", tint = newGreen)
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.Notifications, contentDescription = "", tint = newGreen)
                        }
                    }

                    )
            },



            floatingActionButton = {
                FloatingActionButton(onClick = { navController.navigate(BOOKING_URL) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 60.dp, end = 40.dp),
                    containerColor = newGreen) {
                   Row {

                         IconButton(onClick = { navController.navigate(BOOKING_URL) }) {
                             Icon(imageVector = Icons.Default.Add,
                                 contentDescription = "menu", tint = Color.White)
                         }

                       Text(text = "Book a ride", modifier = Modifier.padding(top = 13.dp), fontSize = 16.sp, color = Color.White)
                   }
                }
            },
            //Content Section
            content = @Composable {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 70.dp, start = 30.dp)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally,

                )

                {

                    Spacer(modifier = Modifier.height(30.dp))


                    Card (modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .padding(end = 10.dp)){
                        Image(
                            painter = painterResource(id = R.drawable.img_6) ,
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop

                        )

                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Ways to plan with Goldyfly",
                        fontSize = 20.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.ExtraBold

                    )



                    Row(modifier = Modifier.horizontalScroll(rememberScrollState())){



                        Column{
                            Card (modifier = Modifier
                                .width(230.dp)
                                .height(150.dp)
                                .padding(end = 10.dp)
                                .clickable { navController.navigate(BOOKING_URL) }){
                                Image(
                                    painter = painterResource(id = R.drawable.img_1) ,
                                    contentDescription = "",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop

                                )

                            }
                            Spacer(modifier = Modifier.height(10.dp))

                            Row {
                                Text(
                                    text = "Reserve a ride!",
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily.SansSerif,
                                    fontWeight = FontWeight.Bold

                                )
                                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "")
                            }
                            Spacer(modifier = Modifier.height(5.dp))

                            Text(
                                text = "Proceed to booking",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.SansSerif
                            )






                        }

                        Spacer(modifier = Modifier.width(20.dp))

                        Column{
                            Card (modifier = Modifier
                                .width(230.dp)
                                .height(150.dp)
                                .padding(end = 10.dp)
                                .clickable { navController.navigate(VIEW_BOOKING_URL) }){
                                Image(
                                    painter = painterResource(id = R.drawable.img_2) ,
                                    contentDescription = "",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop

                                )

                            }
                            Spacer(modifier = Modifier.height(10.dp))

                            Row {
                                Text(
                                    text = "Travel with Us",
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily.SansSerif,
                                    fontWeight = FontWeight.Bold

                                )
                                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "")
                            }
                            Spacer(modifier = Modifier.height(5.dp))

                            Text(
                                text = "View my bookings",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.SansSerif
                            )


                        }

                        Spacer(modifier = Modifier.width(20.dp))


                        Column{
                            Card (modifier = Modifier
                                .width(230.dp)
                                .height(150.dp)
                                .padding(end = 10.dp)
                                .clickable { navController.navigate(VIEW_ACCOUNT) }){
                                Image(
                                    painter = painterResource(id = R.drawable.img_1) ,
                                    contentDescription = "",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop

                                )

                            }
                            Spacer(modifier = Modifier.height(10.dp))

                            Row {
                                Text(
                                    text = "Registered Drivers!",
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily.SansSerif,
                                    fontWeight = FontWeight.Bold

                                )
                                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "")
                            }
                            Spacer(modifier = Modifier.height(5.dp))

                            Text(
                                text = "Proceed to booking",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.SansSerif
                            )






                        }
                    }


                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "More ways to use Goldyfly",
                        fontSize = 20.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.ExtraBold

                    )


                    Spacer(modifier = Modifier.height(10.dp))


                    Row(modifier = Modifier.horizontalScroll(rememberScrollState())){



                        Column{
                            Card (modifier = Modifier
                                .width(230.dp)
                                .height(150.dp)
                                .padding(end = 10.dp)
                                .clickable { navController.navigate(ADD_ACCOUNT) }){
                                Image(
                                    painter = painterResource(id = R.drawable.home) ,
                                    contentDescription = "",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop

                                )

                            }
                            Spacer(modifier = Modifier.height(10.dp))

                            Row {
                                Text(
                                    text = "Register yourself as a driver",
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily.SansSerif,
                                    fontWeight = FontWeight.Bold

                                )
                            }
                            Spacer(modifier = Modifier.height(5.dp))

                            Text(
                                text = "Upload the required information",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.SansSerif
                            )






                        }

                        Column{
                            Card (modifier = Modifier
                                .width(230.dp)
                                .height(150.dp)
                                .padding(end = 10.dp)
                                .clickable { navController.navigate(ADD_CONTACT) }){
                                Image(
                                    painter = painterResource(id = R.drawable.img_3) ,
                                    contentDescription = "",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop

                                )

                            }
                            Spacer(modifier = Modifier.height(10.dp))

                            Row {
                                Text(
                                    text = "Contact Us",
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily.SansSerif,
                                    fontWeight = FontWeight.Bold

                                )
                                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "")
                            }
                            Spacer(modifier = Modifier.height(5.dp))

                            Text(
                                text = "You call or chat",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.SansSerif
                            )


                        }
                    }






                    Spacer(modifier = Modifier.height(120.dp))





                }
            }

        )

    }


}
val bottomNavItems1 = listOf(
    BottomNavItem(
        title = "Home",
        route="home",
        selectedIcon=Icons.Filled.Home,
        unselectedIcon=Icons.Outlined.Home,
        hasNews = false,
        badges=0
    ),


)



data class BottomNavItem(
    val title :String,
    val route :String,
    val selectedIcon: ImageVector,
    val unselectedIcon : ImageVector,
    val hasNews :Boolean,
    val badges :Int
)


@Composable
@Preview(showBackground = true)
fun DetailsScreenPreview() {
    DetailsScreen(rememberNavController())

}

