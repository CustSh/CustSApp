package com.ShumanVO.ega.view.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview


class ProfileView
{
    companion object
    {
        @Composable
    //почему View, почему не Fragment
    //это чисто интерфейс, который уже можно применить и для Activity
        fun View()
        {
            Box(// контейнер, что позволяет размещать элементы друг на друге
                modifier = Modifier //модификатор, что опеределяет свойства Box
                    .fillMaxSize()//занять всё доступное место родительского элемента
                    .background(Color.Blue),// цвет фона
                contentAlignment = Alignment.Center// расположение элементов в Box
            ){
                Text(//для примера у меня здесь текст, свойства кот понятны
                    text = "PROFILE",
                    fontSize = MaterialTheme.typography.labelLarge.fontSize,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
            }
        }

    }
}


@Preview //позволяет сделать предосмотр без запуска
@Composable
fun TestProfileView() //функция для проверки
{
    ProfileView.View()
}