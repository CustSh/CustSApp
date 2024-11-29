package com.ShumanVO.ega.view.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ShumanVO.ega.view.elements.ProductList
import com.ShumanVO.ega.view.elements.ProductPage
import com.ShumanVO.ega.viewmodel.HomeViewModel
import org.koin.androidx.compose.getViewModel

class HomeView{

    companion object
    {
        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        //почему View, почему не Fragment
        //это чисто интерфейс, который уже можно применить и для Activity
        fun View()
        {
            val navController = rememberNavController() // собственный контролер навигации
            val homeViewModel : HomeViewModel = getViewModel() //это от Koin
            val products = homeViewModel.prodicts.collectAsState().value

            NavHost(navController = navController, startDestination = "home" )
            {
                composable("home")
                {
                    Scaffold(
                        topBar =
                        {
                            TopAppBar(title = { Text("Shop") })
                        },
                        content =
                        {
                                paddingValues ->
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color.Red)
                                    .padding(paddingValues),
                                contentAlignment = Alignment.Center
                            )
                            {
                                ProductList(
                                    products = products,
                                    onProductClick = {
                                            product ->
                                        navController.navigate("product/${product.id}")
                                        //println("Привет, вы кликнули на ${product.name}!")
                                    }
                                )
                            }
                        }
                    )
                }

                composable(
                    route = "product/{productId}",
                    arguments = listOf(navArgument("productId"){type = NavType.IntType})
                ){ backStackEntry ->
                    val productId = backStackEntry.arguments?.getInt("productId") ?: 0
                    ProductPage(productId = productId)
                }
            }


        }

    }
}


@Preview//позволяет сделать предосмотр без запуска
@Composable
fun TestHomeView()//функция для проверки
{
    HomeView.View()
}
