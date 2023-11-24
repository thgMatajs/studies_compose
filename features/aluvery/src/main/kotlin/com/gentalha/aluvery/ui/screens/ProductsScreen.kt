package com.gentalha.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gentalha.aluvery.model.ProductsSectionModel
import com.gentalha.aluvery.ui.components.ProductsSection

@Composable
fun ProductsScreen() {
    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        items(
            listOf(
                ProductsSectionModel("Promotions", emptyList()),
                ProductsSectionModel("Promotions", emptyList()),
                ProductsSectionModel("Promotions", emptyList())
            )
        ) {
            ProductsSection(section = it)
        }

    }
}