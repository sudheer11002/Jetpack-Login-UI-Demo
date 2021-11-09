package com.demo.logindemo

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.demo.logindemo.view.Login
import com.demo.logindemo.view.Signup
import com.demo.logindemo.ui.theme.LoginApplicationTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        setContent {
            LoginApplicationTheme {
                LoginApplication()
            }
        }
    }

    @Composable
    fun LoginApplication(){
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "login", builder = {
            composable("login", content = { Login(navController = navController) })
            composable("signup", content = { Signup(navController = navController) })
        })
    }
}

