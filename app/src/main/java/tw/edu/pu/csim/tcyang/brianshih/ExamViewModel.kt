package tw.edu.pu.csim.tcyang.brianshih

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Rect
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

    var scoretext by mutableStateOf("")

    var score by mutableStateOf(0)

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

    val role0 = Rect(82f, 810f, 382f, 1110f)
    val role1 = Rect(698f, 810f, 998f, 1110f)
    val role2 = Rect(0f, 1620f, 300f, 1920f)
    val role3 = Rect(780f, 1620f, 1080f, 1920f)
    suspend fun startFalling() {
        while (true) {
            delay(DROP_INTERVAL_MS)

            circleY += DROP_DISTANCE_DP

            if (circleY >= screenWidth - 300) {
                resetImagePosition()
                pickRandomImage()
                score+=1
                scoretext = "fell to the bottom"
            }

            if (circleX >= 100 && circleX){

            }
        }
    }


}