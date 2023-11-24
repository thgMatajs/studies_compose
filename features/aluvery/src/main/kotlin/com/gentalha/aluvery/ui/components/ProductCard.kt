package com.gentalha.aluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.gentalha.aluvery.R
import com.gentalha.aluvery.model.ProductModel
import com.gentalha.aluvery.ui.theme.Purple40
import com.gentalha.aluvery.ui.theme.Purple80

@Composable
fun ProductCard(product: ProductModel = ProductModel("", "", "")) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 4.dp
    ) {
        Column(
            Modifier
                .width(200.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Purple40,
                                Purple80
                            )
                        )
                    )
            ) {
                AsyncImage(
                    model = product.imgUrl,
                    contentDescription = "",
                    modifier = Modifier
                        .size(100.dp)
                        .offset(y = 50.dp)
                        .clip(CircleShape)
                        .align(BottomCenter),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.ic_launcher_background)
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = product.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = product.price,
                    modifier = Modifier.padding(top = 8.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
            }
        }

    }
}

@Composable
fun ChallengeComposable() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .width(100.dp)
                .wrapContentHeight()
                .background(Color.Blue)
        )
        Column(Modifier.background(Color.LightGray)) {
            Text(
                modifier = Modifier
                    .background(Color.Gray)
                    .padding(16.dp)
                    .fillMaxWidth(),
                text = "Test 1"
            )
            Text(
                modifier = Modifier
                    .background(Color.LightGray)
                    .padding(16.dp)
                    .fillMaxWidth(),
                text = "Test 2"
            )

        }
    }
}