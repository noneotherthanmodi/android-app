package com.example.birthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birthday.ui.theme.BirthdayTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(

                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(message = stringResource(R.string.welcome_to_the_app_text), from = stringResource(
                        R.string.signature_text
                    ))
                }
            }
        }
    }
}

@Composable
fun EnterText(message: String,from: String, modifier: Modifier = Modifier){
    Column (verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(8.dp)) {
        Text(
            text = message,
            fontSize = 50.sp,
            lineHeight = 50.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(8.dp)
                .align(alignment = Alignment.CenterHorizontally)

        )
    }
}

@Composable
fun GreetingImage(message: String, from: String,modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.androidparty)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop, //fits the image to the screen
            alpha = 0.7F //controls opacity
        )
        EnterText(message = message, from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true,
//    showSystemUi = true, //changes to phone view
    name = "My preview")
@Composable
fun BirthdayCardPreview() {
    BirthdayTheme {
        GreetingImage(message = stringResource(R.string.welcome_to_the_app_text), from = stringResource(
            R.string.signature_text
        ))
    }
}