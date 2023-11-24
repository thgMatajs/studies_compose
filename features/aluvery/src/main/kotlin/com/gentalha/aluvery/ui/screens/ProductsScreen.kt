package com.gentalha.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gentalha.aluvery.model.ProductsSectionModel
import com.gentalha.aluvery.ui.components.ProductsSection

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsScreen() {
    Column {
        var searchValue by remember { mutableStateOf("") }
        OutlinedTextField(
            value = "",
            onValueChange = { newValue -> searchValue = newValue },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    top = 16.dp,
                    end = 16.dp
                ),
            shape = RoundedCornerShape(100),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search icon"
                )
            },
            label = {
                Text(text = "Produto")
            },
            placeholder = {
                Text("O que voce procura?")
            }
        )
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
}