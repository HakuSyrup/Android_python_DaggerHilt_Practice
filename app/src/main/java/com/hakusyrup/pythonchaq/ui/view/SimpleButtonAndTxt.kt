package com.hakusyrup.pythonchaq.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hakusyrup.pythonchaq.viewModel.IRunPythonViewModel

@Composable
fun SimpleButtonAndTxt ( viewModel: IRunPythonViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    Surface (modifier = Modifier.fillMaxSize()){
        Column (modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center){
            Button(onClick = { viewModel.runPython() }) {
                Text(uiState.btnText)
            }
            Text(uiState.outputText)
        }
    }
}