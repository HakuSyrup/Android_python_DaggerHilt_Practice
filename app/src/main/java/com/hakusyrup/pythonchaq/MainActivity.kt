package com.hakusyrup.pythonchaq

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import com.hakusyrup.pythonchaq.ui.theme.PythonChaqTheme
import com.hakusyrup.pythonchaq.viewModel.RunPythonViewModel
import dagger.hilt.android.AndroidEntryPoint
import com.hakusyrup.pythonchaq.ui.view.SimpleButtonAndTxt

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!Python.isStarted()) {
            Python.start(AndroidPlatform(this))
        }
        setContent {
            PythonChaqTheme {
                val viewModelModel = hiltViewModel<RunPythonViewModel>()
                SimpleButtonAndTxt(viewModel = viewModelModel)
            }
        }
    }
}


@Preview
@Composable
fun DefaultPreview() {
    PythonChaqTheme {
        SimpleButtonAndTxt()
    }
}
