package tw.edu.pu.csim.tcyang.brianshih

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ExamViewModel : ViewModel() {
    var screenWidth by mutableStateOf(0.0f)
        private set

    var screenHeight by mutableStateOf(0.0f)
        private set

    fun SetGameSize(width: Float, height: Float) {
        screenWidth = width
        screenHeight = height
    }


}