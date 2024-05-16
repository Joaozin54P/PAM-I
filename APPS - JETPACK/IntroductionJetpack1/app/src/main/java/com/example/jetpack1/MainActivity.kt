package com.example.jetpack1

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack1.ui.theme.DebugButtonColors
import com.example.jetpack1.ui.theme.ErrorButtonColors
import com.example.jetpack1.ui.theme.InfoButtonColors
import com.example.jetpack1.ui.theme.JetPack1Theme
import com.example.jetpack1.ui.theme.WarninButtonColors

const val Tag = "TestAndroid"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPack1Theme {
                // A surface container using the 'background' color from the theme
                   App()
            }
        }
    }
}
@Composable
fun App(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally) {

        Greeting("Android")
        ActionButton(
            text = "Debug",
            buttonColors = DebugButtonColors(),
            modifier = Modifier.fillMaxWidth(0.7f)
        ) {
          Log.d(TAG,"App: clicou em debug")
        }
            ActionButton(
                text = "Info",
                buttonColors = InfoButtonColors(),
                modifier = Modifier.fillMaxWidth(0.7f)
            ) {
                Log.i(TAG,"App: clicou em Info")
            }
            ActionButton(
                text = "Warning",
                buttonColors = WarninButtonColors(),
                modifier = Modifier.fillMaxWidth(0.7f)
            ) {
                Log.w(TAG,"App: clicou em warning")
            }
            ActionButton(
                text = "Erro",
                buttonColors = ErrorButtonColors(),
                modifier = Modifier.fillMaxWidth(0.7f)
            ) {
                Log.e(TAG,"App: clicou em erro")
            }
        }
    }
}


@Preview(showBackground = true, widthDp = 150, heightDp = 200)
@Composable
fun AppPreview(){
    JetPack1Theme {
        App()
    }
}

@Composable
fun ActionButton(
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
){
   ElevatedButton(
       onClick = block,
       shape = RoundedCornerShape(5.dp),
       colors = buttonColors,
       modifier = modifier
   ) {
       Text(text = text)
   }
}
@Preview(showBackground = true)
@Composable
fun ActionButtonPreview(){
    ActionButton(text = "Será?") {

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Olá $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPack1Theme {
        Greeting("Android")
    }
}