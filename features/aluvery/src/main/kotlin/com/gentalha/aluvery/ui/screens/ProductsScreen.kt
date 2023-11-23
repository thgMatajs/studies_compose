package com.gentalha.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gentalha.aluvery.model.ProductsSectionModel
import com.gentalha.aluvery.ui.components.ProductsSection

@Composable
fun ProductsScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ProductsSection(ProductsSectionModel("Promotions", emptyList()))
        ProductsSection(ProductsSectionModel("Promotions", emptyList()))
        ProductsSection(ProductsSectionModel("Promotions", emptyList()))
    }
}