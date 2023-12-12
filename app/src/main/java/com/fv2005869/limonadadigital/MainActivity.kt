package com.fv2005869.limonadadigital

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FazendoLimonada()
        }
    }
}

@Preview
@Composable
fun LimonadaDigital(){
    FazendoLimonada()
}

@Composable
fun FazendoLimonada(modifier:Modifier = Modifier
    .background(Color.LightGray)
    .fillMaxSize()
    .wrapContentSize()){
    var etapa by remember { mutableStateOf(1) }
    var imageId = 1
    var textId = 1

    when(etapa){
        1 -> {
            imageId = R.drawable.lemon_tree
            textId = R.string.frase01
        }
        2 -> {
            imageId = R.drawable.lemon_squeeze
            textId = R.string.frase02
        }
        3 -> {
            imageId = R.drawable.lemon_drink
            textId = R.string.frase03
        }
        else -> {
            imageId = R.drawable.lemon_restart
            textId = R.string.frase04
        }
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(

            onClick = {
                if(etapa < 4){etapa += 1}
                else{etapa = 1}
            }

        ){

            Image(
                painter = painterResource(id = imageId),
                contentDescription = etapa.toString()
            )

        }
        Spacer(Modifier.height(16.dp))
        Text(
            text = stringResource(id = textId),
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(20.dp)
        )

    }

}
