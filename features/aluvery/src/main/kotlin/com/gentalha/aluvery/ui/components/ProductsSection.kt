package com.gentalha.aluvery.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gentalha.aluvery.model.ProductsSectionModel

@Composable
fun ProductsSection(section: ProductsSectionModel) {
    Column {
        Text(
            section.title,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            fontWeight = FontWeight(400),
            fontSize = 20.sp
        )
        Row(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            section.products.forEach { productModel ->
                ProductCard(productModel)
            }
        }
    }
}