package com.ShumanVO.ega.ui.fragments.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class SettingsView
{
    companion object
    {
        @Composable
        //почему View, почему не Fragment
        //это чисто интерфейс, который уже можно применить и для Activity
        fun View(
            isChecked: Boolean,
            onCheckedChange: (Boolean) -> Unit
        )
        {
            Box(// контейнер, что позволяет размещать элементы друг на друге
                modifier = Modifier //модификатор, что опеределяет свойства Box
                    .fillMaxSize()//занять всё доступное место родительского элемента
                    .background(Color.White), // цвет фона
                contentAlignment = Alignment.Center// расположение элементов в Box
            ) {
                SettingsView.Setting(
                    name = "name",
                    isChecked = isChecked,
                    onCheckedChange = onCheckedChange,
                    modifier = Modifier.align(Alignment.TopCenter)
                )
                Text(//для примера у меня здесь текст, свойства кот понятны
                    text = "SETTINGS",
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }

        //настройка вкл/выкл
        @Composable
        fun Setting(
            name: String = "Default",
            isChecked: Boolean = true,
            onCheckedChange: (Boolean)->Unit,
            modifier: Modifier = Modifier)
        {
            //var checked by remember { mutableStateOf(false) }
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = name, style = MaterialTheme.typography.bodyLarge)
                Switch(
                    checked = isChecked,
                    onCheckedChange = onCheckedChange
                )
            }
        }
    }
}



//@Composable
//@Preview //позволяет сделать предосмотр без запуска
//fun TestSettingsView()//функция для проверки
//{
//    SettingsView.View()
//}