package com.hakusyrup.pythonchaq.viewModel

import androidx.lifecycle.ViewModel
import com.chaquo.python.Python
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class RunPythonViewModel @Inject constructor(@Named("InjectionTest") private val txt : String )
    :IRunPythonViewModel , ViewModel(){
    private val _uiState : MutableStateFlow<RunPythonUIState> = MutableStateFlow(RunPythonUIState() )

    override val uiState : StateFlow<RunPythonUIState> = _uiState.asStateFlow()

    override fun runPython() {
        val py = Python.getInstance()
        val pyf = py.getModule("hello_world")
        val result = pyf.callAttr("say_hello_world","Python").toString()
        _uiState.update{ it.copy(btnText = "Run Python Again", outputText = result)}
    }

    private fun resetUiState(){
        _uiState.update { it.copy(btnText = "Run Python" ,  outputText = txt) }

    }
    init {
        resetUiState()
    }
}