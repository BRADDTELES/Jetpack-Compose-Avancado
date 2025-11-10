package com.danillotelescarneiro.listagemdedados.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danillotelescarneiro.listagemdedados.R
import com.danillotelescarneiro.listagemdedados.listitem.ProductItem
import com.danillotelescarneiro.listagemdedados.model.Product
import com.danillotelescarneiro.listagemdedados.ui.theme.Blue
import com.danillotelescarneiro.listagemdedados.ui.theme.Red

@Composable
fun Home() {

    val productList: MutableList<Product> = mutableListOf(
        Product(
            name = "SSD 1 TB Kingston NV2, M.2 2280 PCIe, NVMe, Leitura: 3500 Mb/s e Gravação: 2100 MB/s",
            img = R.drawable.img1,
            price = "R$ 369,99"
        ),
        Product(
            name = "Cooler Fan Rise Mode, 120mm, Preto - RM-BK-01-FB",
            img = R.drawable.img2,
            price = "R$ 6,99"
        ),
        Product(
            name = "Placa de Vídeo RTX 4060 Ventus 2x Black OC MSI NVIDIA GeForce, 8GB GDDR6, DLSS, Ray Tracing",
            img = R.drawable.img3,
            price = "R$ 2100,99"
        ),
        Product(
            name = "Processador Intel Core i5-14400, 10-Core, 16-Threads, 3.5GHz (4.7GHz Turbo), Cache 20MB",
            img = R.drawable.img4,
            price = "R$ 1457,00"
        ),
        Product(
            name = "Processador AMD Ryzen 5 5600G, 3.9GHZ, Cache 16MB, Hexa Core, 12 Threads, AM4",
            img = R.drawable.img5,
            price = "R$ 953,82"
        ),
        Product(
            name = "Gabinete NZXT H5 Flow Compact, Mid Tower, ATX, Lateral e Frontal em Vidro Temperado",
            img = R.drawable.img6,
            price = "R$ 549,99"
        ),
    )

    Column(
        modifier = Modifier.fillMaxSize().background(
            brush = Brush.linearGradient(
                colors = listOf(
                    Blue,
                    Red
                )
            )
        ).padding(WindowInsets.systemBars.asPaddingValues())
    ) {

        LazyColumn(
            modifier = Modifier.padding(10.dp)
        ) {
            itemsIndexed(productList){ _, product ->
                ProductItem(product = product)
            }
        }
    }

}

@Preview
@Composable
private fun HomePreview(){
    Home()
}
