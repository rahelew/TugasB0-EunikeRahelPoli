package com.example.applicationlifecycle

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.applicationlifecycle.ui.theme.ApplicationLifeCycleTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("onCreate()")

        setContent {
            ApplicationLifeCycleTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Main()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        println("onStart()")
    }

    override fun onResume() {
        super.onResume()
        println("onResume()")
    }

    override fun onPause() {
        super.onPause()
        println("onPause()")
    }

    override fun onStop() {
        super.onStop()
        println("onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        println("onRestart")
    }
}

@Composable
fun Main() {
    var isDialogVisible by remember { mutableStateOf(true) } // Tampilkan dialog saat pertama kali masuk

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isDialogVisible) {
            AlertDialog(
                onDismissRequest = {
                    isDialogVisible = false // Tutup dialog saat pengguna menutupnya
                },
                title = {
                    Text("uy")
                },
                text = {
                    Text("HALLO, Klik OK untuk melanjutkan")
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            isDialogVisible = false // Tutup dialog saat tombol OK diklik
                        }
                    ) {
                        Text(text = "OK")
                    }
                }
            )
        }

        Text("Hello!", fontStyle = FontStyle.Italic, fontFamily = FontFamily.Serif)
        Text("Welcome to the App", fontStyle = FontStyle.Italic, fontFamily = FontFamily.Serif)
            Text("Dalam dunia yang semakin terhubung, ")
            Text("sangat penting untuk ")
            Text("tetap berakhlak dan bertanggung jawab ")
            Text("dalam penggunaan teknologi.")
            Text("-unknown")
        Text("God Bless You", fontStyle = FontStyle.Italic, fontFamily = FontFamily.Serif)
    }
}
