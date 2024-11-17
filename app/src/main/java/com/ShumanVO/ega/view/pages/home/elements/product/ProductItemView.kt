package com.ShumanVO.ega.view.pages.home.elements.product

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.background
import androidx.compose.material.Icon
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun ProductItem(
    product: ProductItem,
    onClick: (ProductItem) -> Unit
)
{
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onClick(product) },
        elevation = 4.dp,
        backgroundColor = Color.Blue
    ) {
        Row (verticalAlignment = Alignment.CenterVertically){
//            Image(
//                painter = rememberImagePainter(data = product.image),
//                contentDescription = null,
//                modifier = Modifier.size(64.dp)
//            )
            Box( modifier = Modifier.size(64.dp).background(Color.Blue.copy(alpha = 1f)))
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = product.name, fontWeight = FontWeight.Bold, color = Color.Black)
                Text(text = "${product.price}$", color = Color.Gray)
                RatingBar(rating = product.rating)
            }
        }
    }
}

@Composable
fun RatingBar(rating: Float) {
    Row {
        repeat(5) { index ->
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = if (index < rating) Color.Yellow else Color.Gray
            )
        }
    }
}

@Composable
fun ProductList(
    products: List<ProductItem>,
    onProductClick: (ProductItem) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn (
        modifier = modifier
    ){
        items(products) { product ->
            ProductItem(product = product, onClick = onProductClick)
        }
    }
}

@Composable
fun ShopScreen(products: List<ProductItem>, onProductClick: (ProductItem) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Shop") })
        },
        content = {
                paddingValues ->
            ProductList(
                products = products,
                onProductClick = onProductClick,
                modifier = Modifier.padding(paddingValues)
            )
        }
    )
}