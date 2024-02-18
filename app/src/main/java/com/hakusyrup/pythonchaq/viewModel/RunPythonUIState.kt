package com.hakusyrup.pythonchaq.viewModel

data class RunPythonUIState(
    override val btnText: String = "",
    override val outputText: String = ""
): IRunPythonUIState