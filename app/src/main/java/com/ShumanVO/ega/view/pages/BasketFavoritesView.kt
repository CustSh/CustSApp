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
class BasketFavoritesView
{
    companion object
    {
        @Composable
        fun View()
        {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.DarkGray),
                contentAlignment = Alignment.Center
            )
            {
                Text(
                    text = "Basket and Favorites",
                    fontSize = MaterialTheme.typography.labelLarge.fontSize,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview
@Composable
fun TestBasketFavoritesView()
{
    BasketFavoritesView.View()
}