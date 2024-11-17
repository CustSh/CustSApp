package com.ShumanVO.ega.view.pages.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.ShumanVO.ega.view.pages.home.elements.product.ProductItem
import com.ShumanVO.ega.view.pages.home.elements.product.ProductList


class HomeView{

    companion object
    {
        val products = listOf(
            ProductItem(1, "Product 1", 29.99, "https://example.com/image1.jpg", 4.5f),
            ProductItem(2, "Product 2", 49.99, "https://example.com/image2.jpg", 3.5f),
            ProductItem(2, "Product 2", 49.99, "https://example.com/image2.jpg", 3.5f),
            ProductItem(2, "Product 2", 49.99, "https://example.com/image2.jpg", 3.5f),
            ProductItem(2, "Product 2", 49.99, "https://example.com/image2.jpg", 3.5f),
            ProductItem(2, "Product 2", 49.99, "https://example.com/image2.jpg", 3.5f),
            ProductItem(2, "Product 2", 49.99, "https://example.com/image2.jpg", 3.5f),
            ProductItem(2, "Product 2", 49.99, "https://example.com/image2.jpg", 3.5f),
            ProductItem(2, "Product 2", 49.99, "https://example.com/image2.jpg", 3.5f),
            ProductItem(2, "Product 2", 49.99, "https://example.com/image2.jpg", 3.5f),
            ProductItem(2, "Product 2", 49.99, "https://example.com/image2.jpg", 3.5f),
            ProductItem(2, "Product 2", 49.99, "https://example.com/image2.jpg", 3.5f),
            ProductItem(2, "Product 2", 49.99, "https://example.com/image2.jpg", 3.5f),
            ProductItem(2, "Product 2", 49.99, "https://example.com/image2.jpg", 3.5f),
            ProductItem(2, "Product 2", 49.99, "https://example.com/image2.jpg", 3.5f),
            ProductItem(2, "Product 2", 49.99, "https://example.com/image2.jpg", 3.5f),
            ProductItem(2, "Product 2", 49.99, "https://example.com/image2.jpg", 3.5f),
        )
        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        //почему View, почему не Fragment
        //это чисто интерфейс, который уже можно применить и для Activity
        fun View()
        {
            Box( // контейнер, что позволяет размещать элементы друг на друге
                modifier = Modifier //модификатор, что опеределяет свойства Box
                    .fillMaxSize() //занять всё доступное место родительского элемента
                    .background(Color.Red),// цвет фона
                contentAlignment = Alignment.Center // расположение элементов в Box
            ) {
                Text(//для примера у меня здесь текст, свойства кот понятны
                    text = "Home",
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )
            }
            Scaffold(
                topBar = {
                    TopAppBar(title = {Text("Shop")} )
                },
                content = {
                    paddingValues ->
                    ProductList(
                        products = products,
                        onProductClick = { product -> println("Привет, вы кликнули на ${product.name}!") },
                        modifier = Modifier.padding(paddingValues)
                    )
                }
            )

        }

    }
}


@Preview//позволяет сделать предосмотр без запуска
@Composable
fun TestHomeView()//функция для проверки
{
    HomeView.View()
}
