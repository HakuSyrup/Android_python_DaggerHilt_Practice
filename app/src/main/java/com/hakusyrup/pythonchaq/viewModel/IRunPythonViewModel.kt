package com.hakusyrup.pythonchaq.viewModel

import kotlinx.coroutines.flow.StateFlow

interface IRunPythonViewModel {
    val uiState: StateFlow<IRunPythonUIState>
    fun runPython()
}