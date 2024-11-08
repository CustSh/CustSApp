package com.ShumanVO.ega.ui.fragments.home

import android.view.View
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
import com.ShumanVO.ega.ui.bottombar.BottomBar


class HomeView{
    companion object
    {
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
        }

    }
}


@Preview//позволяет сделать предосмотр без запуска
@Composable
fun TestHomeView()//функция для проверки
{
    HomeView.View()
}
