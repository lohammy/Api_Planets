package com.example.api_planets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.api_planets.presentation.Screen
import com.example.api_planets.presentation.list.DetailScreen
import com.example.api_planets.presentation.list.ListScreen
import com.example.api_planets.ui.theme.Api_PlanetsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Api_PlanetsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.List,
                    ) {
                        composable<Screen.List> {
                            ListScreen { id ->
                                navController.navigate(Screen.Detail(id))
                            }
                        }
                        composable<Screen.Detail> {
                            DetailScreen {
                                navController.popBackStack()
                            }
                        }
                    }
                }
            }
        }
    }
}
