package com.example.institutoharia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.institutoharia.ui.theme.InstitutoHariaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstitutoHariaTheme {
                // A surface container using the 'background' color from the theme
                BotonesAbajo()
            }
        }
    }
}

@Composable
fun BotonesAbajo(){
    Scaffold(
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(painterResource(id = R.drawable.inicio), contentDescription = "Inicio")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(painterResource(id = R.drawable.fpb_basica), contentDescription = "FP Basica")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(painterResource(id = R.drawable.meidop), contentDescription = "FP Medio")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(painterResource(id = R.drawable.superior), contentDescription = "FP Superior")
                    }
                }
            )
        }
    ) { it: PaddingValues ->
        MyApp(modifier = Modifier.padding(it))
    }
}

@Composable
fun MyApp(modifier: Modifier){
    Column(modifier = modifier
        .fillMaxWidth()
        .border(BorderStroke(2.dp, Color.Red))) {
        Contenido()
    }
}

@Composable
fun Contenido() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("Songs", "Artists", "Playlists", "hola")
    Text(text = "hola")
    NavigationBar() {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(Icons.Filled.Favorite, contentDescription = item) },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}




