package com.example.cursodefinitivojetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cursodefinitivojetpackcompose.ui.CheckInfo
import com.example.cursodefinitivojetpackcompose.ui.theme.CursoDefinitivoJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CursoDefinitivoJetpackComposeTheme {
                var myText by remember {
                    mutableStateOf("")
                }
                // A surface container using the 'background' color from the theme
                var selected by remember {
                    mutableStateOf("Aris")
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var status by rememberSaveable { mutableStateOf(false) }

                    val myOptions = getOptions(titles = listOf("Aris", "Ejemplo", "Pikachu"))
                    Column {
                       // MyRadioButton()
                        //MyTriStatusCheckBox()
                       // myOptions.forEach() {
                       //     MyCheckBoxCompleted(it)
                       // }
                        MyRadioButtonList(name = selected) { selected = it }

                    }
                }
            }
        }
    }
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable {
            mutableStateOf(false)
        }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { myNewStatus -> status = myNewStatus }
        )

    }
}

@Composable
fun MyStateExample() {

    var counter by rememberSaveable {
        mutableStateOf(0)
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter += 1 }) {
            Text(text = "Pulsar")
        }
        Text(text = "Ha sido pulsado ${counter} veces", color = Color.Black)

    }

}

@Composable
fun MySpacer(size: Int) {
    Spacer(modifier = Modifier.height(size.dp))

}

@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .background(Color.Cyan), contentAlignment = Alignment.Center
        ) {
            Text(text = "Ejemplo 1", color = Color.Black)

        }
        MySpacer(size = 30)
        Row(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color.Red), contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 2", color = Color.Black)
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color.Green), contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 3", color = Color.Black)
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .background(Color.Magenta), contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Ejemplo 4", color = Color.Black)

        }

    }
}


@Composable
fun MyRow() {
    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Ejemplo 1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 2", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 3", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 3", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 3", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 3", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 3", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 3", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 3", modifier = Modifier.width(100.dp))


    }

}

@Composable
fun MyColumn() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Ejemplo 1", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo 1", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo 1", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )

    }


}

@Composable
fun MyBox(name: String, modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .background(Color.Cyan)
                .verticalScroll(rememberScrollState()), contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Esto es un Ejemplo jajajaja", color = Color.Black)
        }
    }
}

@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo")
        Text(text = "Esto es un ejemplo", color = Color.Blue)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.Light)
        Text(text = "Esto es un ejemplo", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )

        Text(
            text = "Esto es un ejemplo", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.Underline)
                )
            )
        )
        Text(text = "Esto es un ejemplo", fontSize = 30.sp)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(name: String, onValueChanged: (String) -> Unit) {
    TextField(value = name, onValueChange = { onValueChanged(it) })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldAdvance() {
    var myText by remember {
        mutableStateOf("")
    }
    TextField(
        value = myText,
        onValueChange = {
            myText =
                if (it.contains("a")) {
                    it.replace("a", "")
                } else {
                    ""
                }
        },
        label = { Text(text = "Introduce tu nombre") })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldOutlined() {
    var myText by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = myText,
        onValueChange = { myText = it },
        modifier = Modifier.padding(24.dp),
        label = {
            Text(
                text = "Holita"
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Blue
        )
    )

}

@Composable
fun MyButtonExample() {
    var enabled by rememberSaveable { mutableStateOf(true) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = { enabled = false },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Magenta,
                containerColor = Color.Blue
            ),
            border = BorderStroke(5.dp, Color.Green)
        ) {
            Text(text = "Hola")

        }

        OutlinedButton(
            onClick = { enabled = false },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Magenta,
                containerColor = Color.Blue,
                disabledContentColor = Color.Blue,
                disabledContainerColor = Color.Black
            ),
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(text = "Hola")

        }
        TextButton(onClick = {}) {
            Text(text = "Hola")

        }
    }
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo 1",
        alpha = 0.5f
    )

}

@Composable
fun MyImageAdvanced() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo 1",
        modifier = Modifier
            .clip(CircleShape)
            .border(5.dp, Color.Red, CircleShape)

    )

}

@Composable
fun MyIcon() {
    Icon(imageVector = Icons.Rounded.Star, contentDescription = "icono", tint = Color.Red)
}

@Composable
fun MyProgress() {
    var showLoading by rememberSaveable {
        mutableStateOf(false)

    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(color = Color.Red, strokeWidth = 8.dp)
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 32.dp),
                color = Color.Red,
                trackColor = Color.Green
            )

        }
        Button(onClick = { showLoading = !showLoading }) {
            Text(text = "Cargar Perfil")
        }


    }
}

@Composable
fun MyProgressAdvance() {
    var estado by rememberSaveable {
        mutableStateOf(0f)

    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(progress = estado)
        Row(Modifier.fillMaxWidth()) {
            Button(onClick = { estado += 0.1f }) {
                Text(text = "incrementar")
            }
            Button(onClick = { estado -= 0.1f }) {
                Text(text = "Reducir")


            }

        }

    }
}

@Composable
fun mySwitch() {
    var state by rememberSaveable {
        mutableStateOf(false)
    }
    Switch(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.Green,
            checkedTrackColor = Color.Cyan,
            uncheckedTrackColor = Color.Magenta,
            uncheckedThumbColor = Color.Red,

            disabledCheckedTrackColor = Color.Yellow,
            disabledCheckedThumbColor = Color.Yellow,

            disabledUncheckedThumbColor = Color.Yellow,
            disabledUncheckedTrackColor = Color.Yellow


        )
    )
}

@Composable
fun MyCheckBox() {
    var state by rememberSaveable {
        mutableStateOf(false)
    }
    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Yellow,
            checkmarkColor = Color.Blue
        )
    )
}


@Composable
fun MyCheckBoxWithText() {
    var state by rememberSaveable {
        mutableStateOf(false)
    }
    Row(Modifier.padding(8.dp)) {
        Checkbox(
            checked = state,
            onCheckedChange = { state = !state },
            enabled = true,

            )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Ejemplo 1")
    }
}

@Composable
fun MyCheckBoxCompleted(checkInfo: CheckInfo) {

    Row(Modifier.padding(8.dp)) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) },
            enabled = true,

            )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title)
    }
}

@Composable
fun MyTriStatusCheckBox() {
    var status by rememberSaveable {
        mutableStateOf(ToggleableState.Off)


    }
    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.On -> {
                ToggleableState.Off
            }

            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On

        }
    })
}

@Composable
fun MyRadioButton() {
    Row(Modifier.fillMaxWidth()) {
        RadioButton(
            selected = false,
            onClick = { },
            enabled = false,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                disabledSelectedColor = Color.Green
            )
        )
        Text(text = "Ejemplo 1")

    }

}

@Composable
fun MyRadioButtonList(name: String, onItemSelected: (String)->Unit) {

    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.fillMaxWidth()) {
            RadioButton(
                selected = name== "Aris",
                onClick = {onItemSelected(name)},
            )
            Text(text = "Aris")

        }
        Row(Modifier.fillMaxWidth()) {
            RadioButton(
                selected = name== "David",
                onClick = {onItemSelected(name)},
            )
            Text(text = "David")

        }
        Row(Modifier.fillMaxWidth()) {
            RadioButton(
                selected = name== "Fulanito",
                onClick = {onItemSelected(name)},
            )
            Text(text = "Fulanito")

        }
        Row(Modifier.fillMaxWidth()) {
            RadioButton(
                selected = name== "Pepe",
                onClick = { onItemSelected(name)},
            )
            Text(text = "Pepe")

        }


    }
}

@Preview(showBackground = true)
@Composable
fun MyBox() {
    CursoDefinitivoJetpackComposeTheme {
        MyIcon()
    }
}