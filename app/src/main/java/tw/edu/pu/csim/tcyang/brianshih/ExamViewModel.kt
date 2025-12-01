package tw.edu.pu.csim.tcyang.brianshih

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class ExamViewModel : ViewModel() {
    private val imageList = listOf(
        R.drawable.service0,
        R.drawable.service1,
        R.drawable.service2,
        R.drawable.service3
    )
    var circleX by mutableStateOf(0f)
    var circleY by mutableStateOf(0f)
    var screenWidth by mutableStateOf(0.0f)
        private set
    var screenHeight by mutableStateOf(0.0f)
        private set

    var selectedImageId by mutableStateOf(R.drawable.service0)
        private set


    fun SetGameSize(width: Float, height: Float) {
        screenWidth = width
        screenHeight = height

        circleX = 130f
        circleY = 0f

        pickRandomImage()
        viewModelScope.launch {
            startFalling()
        }
    }

    fun MoveCircle(dx: Float) {
        circleX += dx

    }

    fun pickRandomImage() {
        selectedImageId = imageList[Random.nextInt(imageList.size)]
    }
    private val DROP_DISTANCE_DP = 20f
    private val DROP_INTERVAL_MS = 100L
    private fun resetImagePosition() {
        circleX = 130f
        circleY = 0f
    }

    suspend fun startFalling() {
        while (true) {
            delay(DROP_INTERVAL_MS)

            circleY += DROP_DISTANCE_DP

            if (circleY >= screenWidth - 300) {
                resetImagePosition()
                pickRandomImage()
            }
        }
    }
}