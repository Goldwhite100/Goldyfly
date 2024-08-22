package com.example.goldyfly.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.goldyfly.ui.theme.screens.about.AboutScreen
import com.example.goldyfly.ui.theme.screens.driververification.DriverVerificationScreen
import com.example.goldyfly.ui.theme.screens.home.HomeScreen
import com.example.goldyfly.ui.theme.screens.login.LoginScreen
import com.example.goldyfly.ui.theme.screens.profile.ProfileScreen
import com.example.goldyfly.ui.theme.screens.registration.RegistrationScreen
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

        composable(ROUT_REGISTRATION) {
            RegistrationScreen(navController = navController)
        }


        composable(ROUT_DRIVERVERIFICATION) {
                DriverVerificationScreen(navController = navController)

        }

        }

    }


