package com.unip.flex.ads.dm.roteiro5

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

// 1. A classe MainActivity herda de ComponentActivity
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 2. setContent define o que será desenhado na tela
        setContent {
            // O MaterialTheme garante que os botões e textos sigam o padrão visual do Android
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // 3. Chamamos a tela do nosso aplicativo aqui
                    TelaPesquisaTecnologias()
                }
            }
        }
    }
}

// 4. A função @Composable fica FORA da classe MainActivity
@Composable
fun TelaPesquisaTecnologias() {
    val context = LocalContext.current

    var java by remember { mutableStateOf(false) }
    var kotlin by remember { mutableStateOf(false) }
    var flutter by remember { mutableStateOf(false) }
    var python by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Quais tecnologias você conhece?",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = java, onCheckedChange = { java = it })
            Text(text = "Java")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = kotlin, onCheckedChange = { kotlin = it })
            Text(text = "Kotlin")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = flutter, onCheckedChange = { flutter = it })
            Text(text = "Flutter")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = python, onCheckedChange = { python = it })
            Text(text = "Python")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            val selecionadas = mutableListOf<String>()
            if (java) selecionadas.add("Java")
            if (kotlin) selecionadas.add("Kotlin")
            if (flutter) selecionadas.add("Flutter")
            if (python) selecionadas.add("Python")

            val mensagem = if (selecionadas.isEmpty()) {
                "Nenhuma tecnologia selecionada."
            } else {
                "Você conhece: ${selecionadas.joinToString(", ")}"
            }

            Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Verificar Resposta")
        }
    }
}