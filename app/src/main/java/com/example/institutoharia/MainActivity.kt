package com.example.institutoharia

import android.os.Bundle
import android.util.Log
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
import androidx.compose.foundation.layout.RowScope
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
import androidx.compose.material3.SheetState
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
import org.w3c.dom.Text

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
    var contenidoSheets by rememberSaveable {
        mutableStateOf("")
    }

    val listaCotenidoInicio = listOf(
        Data(textoCard = "Cableado estructurado", textoModal = "Hola 1", textoImagen = "hola", imagen = painterResource(id = R.drawable.cable)),
        Data(textoCard = "Diseño de páginas web", textoModal = "Hola 2", textoImagen = "hola", imagen = painterResource(id = R.drawable.codigohtml)),
        Data(textoCard = "Elaboración de juegos", textoModal = "Hola 3", textoImagen = "hola", imagen = painterResource(id = R.drawable.juegofinal)),
        Data(textoCard = "Montaje de equipos", textoModal = "Hola 4", textoImagen = "hola", imagen = painterResource(id = R.drawable.montajefinal)),
        Data(textoCard = "Diseño de redes", textoModal = "Hola 5", textoImagen = "hola", imagen = painterResource(id = R.drawable.red)),
        Data(textoCard = "Formación en centros de trabajo", textoModal = "Hola 6", textoImagen = "hola", imagen = painterResource(id = R.drawable.fol)),
    )

    Column(modifier = Modifier
        .padding(top = 80.dp)
        .padding(10.dp)
        .verticalScroll(rememberScrollState()),
           horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "PROYECTO/ACTIVIDADES", fontWeight = FontWeight.Bold, fontSize = 25.sp)
        Text(text = "Proyectos y actividades que se eleboran en estos cursos", fontSize = 17.sp, textAlign = TextAlign.Center)
        for (index in listaCotenidoInicio.indices step 2) {
            Row (modifier = Modifier.padding(vertical = 10.dp)) {
                var maxIndex = index + 1
                if (maxIndex >= listaCotenidoInicio.size) {
                    maxIndex -= 1
                }
                for (currentIndex in index .. maxIndex) {
                    val data = listaCotenidoInicio[currentIndex]
                    ElevatedCard (modifier = Modifier
                        .clickable {
                            estadoSheets = true
                            contenidoSheets = data.textoModal
                        }
                        .padding(10.dp)
                        .weight(1f)) {
                        Image(painter = data.imagen, contentDescription = data.textoImagen)
                        Text(text = data.textoCard, fontWeight = FontWeight.Bold, modifier = Modifier.padding(10.dp))
                    }
                }
            }
        }
        Sheets({ estadoSheets = false; contenidoSheets = "" }, estadoSheets, contenidoSheets)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Sheets(onDismissModalBottomSheet: () -> Unit, estadoSheets: Boolean, contenidoSheets: String) {
    val sheetState = rememberModalBottomSheetState()
    if (estadoSheets){
        ModalBottomSheet(
            onDismissRequest = { onDismissModalBottomSheet() },
            sheetState = sheetState
        ) {
            Row(modifier = Modifier.padding(60.dp)) {
                Text(text = contenidoSheets)
            }
        }
    }
}



