package com.ShumanVO.ega.ui.fragments

import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.FragmentContainerView

@Composable
/*
эту функцию я создал для создания контейнера
для фрагментов, при чём создаётся для использования
Jetpack Compose
 */
fun FragmentContainer(
    containerId: Int
)
{
    //ф-я из Jet.Comp., для интеграции традиционных Android View-компонентов
    //в нашем случае речь о Fragment-ах
    AndroidView(
        factory = {//для созданя экземпляра FragmentContainerView
            context ->
            FragmentContainerView(context).apply {
                id = containerId//и для этого экземляра устанавливаем его Id
            }
        },
        update = {}//исп в случае обновления состояния существующего View
    )
}
