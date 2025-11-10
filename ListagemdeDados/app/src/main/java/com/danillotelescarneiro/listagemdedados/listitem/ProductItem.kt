package com.danillotelescarneiro.listagemdedados.listitem

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danillotelescarneiro.listagemdedados.R
import com.danillotelescarneiro.listagemdedados.model.Product
import com.danillotelescarneiro.listagemdedados.ui.theme.Red
import com.danillotelescarneiro.listagemdedados.ui.theme.White

@Composable
fun ProductItem(
    product: Product
) {

    val context = LocalContext.current

    Spacer(modifier = Modifier.padding(8.dp))

    Column(
        modifier = Modifier.fillMaxWidth().background(
            color = White,
            shape = RoundedCornerShape(15.dp)
        ).padding(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().background(color = White).padding(10.dp)
        ) {

            Image(
                painter = painterResource(product.img),
                contentDescription = null,
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = product.name,
                fontSize = 14.sp,
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            )

        }

        Text(
            text = product.price,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Red,
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            textAlign = TextAlign.Center
        )

        Text(
            text = "Á vista no PIX",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            textAlign = TextAlign.Center
        )

        OutlinedButton(
            onClick = {
                Toast.makeText(
                    context,
                    product.name,
                    Toast.LENGTH_LONG
                ).show()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Red
            ),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Comprar",
                fontSize = 16.sp,
                color = White,
                fontWeight = FontWeight.Bold
            )
        }
    }

}

@Preview
@Composable
private fun ProductItemPreview(){
    ProductItem(
        Product(
            name = "Teste",
            img = R.drawable.img4,
            price = "R$ 1500,00"
        )
    )
}