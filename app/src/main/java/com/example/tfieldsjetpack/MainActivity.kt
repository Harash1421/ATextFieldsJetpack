package com.example.tfieldsjetpack

import android.content.Context
import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tfieldsjetpack.ui.theme.TFieldsJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TFieldsJetpackTheme {
                // A surface container using the 'background' color from the theme
                Column(modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                    Greeting()
                }
            }
        }
    }
}

//Text Fields Function
@Composable
fun Greeting() {
    var context = LocalContext.current
    var text by remember {
        mutableStateOf("")
    }
    TextField(modifier = Modifier.padding(44.dp), value = text, onValueChange = { newText ->
        text = newText
    },
        label = {
            Text(text = "Name")
        },
        singleLine = true,
        leadingIcon ={
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Email,
                    contentDescription = "Email Icon")
            }
        },
        trailingIcon = {
            IconButton(onClick = {
                Toast.makeText(context, "Hello $text", Toast.LENGTH_SHORT).show()
            }) {
                Icon(imageVector = Icons.Filled.Check,
                    contentDescription = "Check")
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Go
        )
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TFieldsJetpackTheme {
        Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
            Greeting()
        }
    }
}