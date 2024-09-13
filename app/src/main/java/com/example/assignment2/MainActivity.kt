package com.example.assignment2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignment2.ui.theme.Assignment2Theme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import java.time.LocalTime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val funFacts = arrayOf(
                        "Australia is wider than the moon.",
                        "Venus is the only planet to spin clockwise.",
                        "Allodoxaphobia is the fear of other people’s opinions.",
                        "Human teeth are the only part of the body that cannot heal themselves.",
                        "Competitive art used to be an Olympic sport.",
                        "The first person processed at Ellis Island was a 15-year-old girl from Ireland.",
                        "Google Images was created after Jennifer Lopez wore the green dress at the 2000 Grammys.",
                        "Lemons float, but limes sink.",
                        "The Eiffel Tower was originally made for Barcelona.",
                        "It would take 19 minutes to fall to the center of the Earth."
                    )
                    var clicked by remember { mutableIntStateOf(funFacts.indices.random()) }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(16.dp) // I heard dp is the best use of
                        // pixel measurement in Android Studio
                    ) {
                        Button(onClick = {
                            clicked += 1
                        }) {
                            Text("Next Fact!")
                        }
                        if (clicked >= funFacts.size) {
                            clicked = 0
                        }
                        Greeting(
                            greeting = funFacts[clicked]
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(greeting: String, modifier: Modifier = Modifier) {
    Text(
        text = greeting,
        modifier = modifier,
        color = Color.Blue,
        fontStyle = FontStyle.Italic
    )
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assignment2Theme {
        Greeting("Android")
    }
}