package com.example.goldyfly.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.goldyfly.ui.theme.screens.about.AboutScreen
import com.example.goldyfly.ui.theme.screens.account.ViewAccountScreen
import com.example.goldyfly.ui.theme.screens.book.BookScreen
import com.example.goldyfly.ui.theme.screens.book.ViewBookScreen
import com.example.goldyfly.ui.theme.screens.contact.AddContactScreen
import com.example.goldyfly.ui.theme.screens.contact.ViewContactScreen
import com.example.goldyfly.ui.theme.screens.details.DetailsScreen
import com.example.goldyfly.ui.theme.screens.driververification.AddAccountScreen
import com.example.goldyfly.ui.theme.screens.home.HomeScreen
import com.example.goldyfly.ui.theme.screens.login.LoginScreen
import com.example.goldyfly.ui.theme.screens.main.MainScreen
import com.example.goldyfly.ui.theme.screens.profile.ProfileScreen
import com.example.goldyfly.ui.theme.screens.signup.SignupScreen
import com.example.goldyfly.ui.theme.screens.splash.SplashScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination:String = ROUT_SPLASH
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        composable(ROUT_HOME) {
            HomeScreen(navController = navController)


        }

        composable(ROUT_ABOUT) {
            AboutScreen(navController = navController)

        }
        composable(ROUT_SPLASH) {
            SplashScreen(navController = navController)

        }


        composable(ROUT_SIGNUP) {
            SignupScreen(navController = navController)

        }
        composable(ROUT_LOGIN) {
            LoginScreen(navController = navController)

        }
        composable(ROUT_PROFILE) {
            ProfileScreen(navController = navController)

        }

        composable(ROUT_MAIN) {
            MainScreen(navController = navController)
        }
        composable(ROUT_DETAILS) {
            DetailsScreen(navController = navController)
        }



        composable(BOOKING_URL) {
            BookScreen(navController = navController)

        }
        composable(VIEW_BOOKING_URL) {
            ViewBookScreen(navController = navController)

        }


        composable(ADD_ACCOUNT){
            AddAccountScreen(navController = navController)
        }
        composable(VIEW_ACCOUNT){
            ViewAccountScreen(navController = navController)
        }

        composable(ADD_CONTACT){
            AddContactScreen(navController = navController)
        }

        composable(VIEW_CONTACT){
            ViewContactScreen(navController = navController)
        }


    }

    }


