package com.gentalha.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.gentalha.aluvery.R
import java.math.BigDecimal
import java.text.DecimalFormat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductFormScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Criando um Produto",
            fontSize = 28.sp
        )
        var imgUrl by remember { mutableStateOf("") }

        if (imgUrl.isNotBlank()) {
            AsyncImage(
                model = imgUrl,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                placeholder = painterResource(R.drawable.ic_launcher_background),
                error = painterResource(R.drawable.ic_launcher_background),
                contentScale = ContentScale.Crop
            )
        }

        TextField(
            value = imgUrl,
            onValueChange = { newValue -> imgUrl = newValue },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(
                    text = "Url da Imagem"
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )

        var name by remember { mutableStateOf("") }
        TextField(
            value = name,
            onValueChange = { newValue -> name = newValue },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(
                    text = "Nome"
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Sentences
            )
        )

        var price by remember { mutableStateOf("") }
        val formatterPrice = remember {
            DecimalFormat("#.##")
        }
        TextField(
            value = price,
            onValueChange = { newValue ->
                try {
                    price = formatterPrice.format(BigDecimal(newValue))
                } catch (e: IllegalArgumentException) {
                    if (newValue.isBlank()) {
                        price = newValue
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(
                    text = "Preco"
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            )
        )

        var description by remember { mutableStateOf("") }
        TextField(
            value = description,
            onValueChange = { newValue -> description = newValue },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp),
            label = {
                Text(
                    text = "Descricao"
                )
            }
        )

        Button(modifier = Modifier.fillMaxWidth(), onClick = { /*TODO*/ }) {
            Text(text = "Salvar")
        }
    }
}

@Preview
@Composable
private fun ProductFormScreenPreview() {
    ProductFormScreen()
}