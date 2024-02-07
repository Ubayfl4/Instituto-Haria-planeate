package com.example.institutoharia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Column(horizontalAlignment = Alignment.CenterHorizontally,
           modifier = modifier
               .fillMaxSize()
               .border(BorderStroke(2.dp, Color.Red))) {
        Contenido()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Contenido() {
    var estadoSheets by rememberSaveable { mutableStateOf(false) }

    Column(modifier = Modifier
        .padding(top = 80.dp)
        .padding(10.dp)
        .verticalScroll(rememberScrollState()),
           horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "PROYECTO/ACTIVIDADES", fontWeight = FontWeight.Bold, fontSize = 25.sp)
        Text(text = "Proyectos y actividades que se eleboran en estos cursos", fontSize = 17.sp, textAlign = TextAlign.Center)
        Row(modifier = Modifier.padding(vertical = 10.dp)) {
            ElevatedCard (modifier = Modifier
                .clickable {/*TODO*/ }
                .padding(10.dp)
                .weight(1f)){
                Image(painter = painterResource(id = R.drawable.cable), contentDescription = "hola")
                Text(text = "Cableado estructurado",fontWeight = FontWeight.Bold, modifier = Modifier.padding(10.dp))
            }
            ElevatedCard (modifier = Modifier
                .clickable {/*TODO*/ }
                .padding(10.dp)
                .weight(1f)){
                Image(painter = painterResource(id = R.drawable.codigohtml), contentDescription = "hola")
                Text(text = "Diseño de páginas web", fontWeight = FontWeight.Bold, modifier = Modifier.padding(10.dp))
            }
        }
        Row(modifier = Modifier.padding(vertical = 10.dp)) {
            ElevatedCard (modifier = Modifier
                .clickable { /*TODO*/}
                .padding(10.dp)
                .weight(1f)){
                Image(painter = painterResource(id = R.drawable.juegofinal), contentDescription = "hola")
                Text(text = "Elaboración de juegos",fontWeight = FontWeight.Bold, modifier = Modifier.padding(10.dp))
            }
            ElevatedCard (modifier = Modifier
                .clickable {/*TODO*/ }
                .padding(10.dp)
                .weight(1f)){
                Image(painter = painterResource(id = R.drawable.montajefinal), contentDescription = "hola")
                Text(text = "Montaje de equipo", fontWeight = FontWeight.Bold, modifier = Modifier.padding(10.dp))
            }
        }
        Row(modifier = Modifier.padding(vertical = 10.dp)) {
            ElevatedCard (modifier = Modifier
                .clickable {/*TODO*/ }
                .padding(10.dp)
                .weight(1f)){
                Image(painter = painterResource(id = R.drawable.red), contentDescription = "hola")
                Text(text = "Diseño de red",fontWeight = FontWeight.Bold, modifier = Modifier.padding(10.dp))
            }
            ElevatedCard (modifier = Modifier
                .clickable { Sheets() }
                .padding(10.dp)
                .weight(1f)){
                Image(painter = painterResource(id = R.drawable.fol), contentDescription = "hola")
                Text(text = "Formación en centros de trabajo", fontWeight = FontWeight.Bold, modifier = Modifier.padding(10.dp))
            }
        }
    }
    Sheets()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Sheets(estadoSheets){

    if (estadoSheets){
        ModalBottomSheet(
            onDismissRequest = { estadoSheets = false },

        ) {

        }
    }
}



