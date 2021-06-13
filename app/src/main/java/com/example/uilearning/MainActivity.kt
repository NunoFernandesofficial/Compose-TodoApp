package com.example.uilearning

import android.icu.util.TimeUnit.values
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.ui.res.vectorResource
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uilearning.ui.theme.UiLearningTheme
import kotlinx.coroutines.launch
import java.time.chrono.JapaneseEra.values

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {MainContent()
        TextFieldDemo()
        }

    }
     
    @Composable
    private fun MainContent(){
        val fabShape = CircleShape
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()

        Scaffold(
            scaffoldState = scaffoldState,
            drawerContent = {},
            topBar = { TopAppBar(title = {Text("TodoApp",
                textAlign = TextAlign.Center,
                color = Color.Black,              //mudar cor do texto
                modifier = Modifier.fillMaxWidth(),
                fontFamily = magicowlFamily,    //mudar fonte do texto
                fontSize =50.sp                 //mudar tamanho do texto

            )},
                backgroundColor = Color.Cyan) // Mudar a cor da top bar
                     },
                bottomBar = {
                BottomAppBar(cutoutShape = fabShape,backgroundColor = Color.Cyan //mudar a cor da bottom bar
                ) {
                    IconButton(
                        onClick = {
                            scope.launch { scaffoldState.drawerState.open() }     //abrir o drawerState

                        }
                    ) {

                    }

                }

            },
            floatingActionButtonPosition = FabPosition.Center,
            isFloatingActionButtonDocked = true,
            floatingActionButton = {
                FloatingActionButton(
                    shape = fabShape,
                    onClick = {},
                    backgroundColor= Color.Green,    //mudar a cor do fab
                ) {

                    Icon(Icons.Filled.Add,"",) //icon de adicionar

                }
            }, content = {
                //bodyContent()
            })

}   }

    @Composable
fun TextFieldDemo() {
        Column(
            Modifier
                .padding(50.dp, 600.dp, 0.dp, 0.dp)
                .fillMaxHeight()) {
            val textState = remember { mutableStateOf(TextFieldValue()) }
            TextField(
                value = textState.value,
                onValueChange = { textState.value = it },
                label = {Text(text = "What you need Todo?")}
            )

        }
    }