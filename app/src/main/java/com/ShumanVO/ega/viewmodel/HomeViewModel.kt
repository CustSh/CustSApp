package com.ShumanVO.ega.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ShumanVO.ega.view.elements.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel()
{
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val prodicts: StateFlow<List<Product>> get() = _products

    init{
        loadProducts()
    }
    private fun loadProducts(){
        viewModelScope.launch {
            _products.value = listOf(
                Product(1, "Product 1", 29.99, "https://example.com/image1.jpg", 4.5f),
                Product(2, "Product 2", 49.99, "https://example.com/image2.jpg", 3.8f),
                Product(3, "Product 3", 19.99, "https://example.com/image3.jpg", 4.2f),
                Product(4, "Product 4", 39.99, "https://example.com/image4.jpg", 3.9f),
                Product(5, "Product 5", 24.99, "https://example.com/image5.jpg", 4.7f),
                Product(6, "Product 6", 59.99, "https://example.com/image6.jpg", 4.0f),
                Product(7, "Product 7", 49.99, "https://example.com/image7.jpg", 4.3f),
                Product(8, "Product 8", 34.99, "https://example.com/image8.jpg", 4.1f),
                Product(9, "Product 9", 44.99, "https://example.com/image9.jpg", 3.6f),
                Product(10, "Product 10", 54.99, "https://example.com/image10.jpg", 4.4f),
                Product(11, "Product 11", 64.99, "https://example.com/image11.jpg", 4.5f),
                Product(12, "Product 12", 29.99, "https://example.com/image12.jpg", 4.2f),
                Product(13, "Product 13", 22.99, "https://example.com/image13.jpg", 3.8f),
                Product(14, "Product 14", 19.99, "https://example.com/image14.jpg", 4.0f),
                Product(15, "Product 15", 32.99, "https://example.com/image15.jpg", 4.6f),
                Product(16, "Product 16", 27.99, "https://example.com/image16.jpg", 4.1f),
                Product(17, "Product 17", 38.99, "https://example.com/image17.jpg", 4.3f),
                Product(18, "Product 18", 49.99, "https://example.com/image18.jpg", 3.9f)
            )

        }
    }

}