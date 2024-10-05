package com.jxji.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jxji.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    var currentStep by remember { mutableIntStateOf(1) }

    fun setCurrentStep(step: Int) {
        currentStep = step
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (currentStep) {
            1 -> {
                Screen(
                    rTapText = R.string.tap_lemon_tree,
                    rImageCenter = R.drawable.lemon_tree,
                    rImageDesc = R.string.lemon_tree_content_desc,
                    setStep = { setCurrentStep(2) }
                )
            }

            2 -> {
                Screen(
                    rTapText = R.string.keep_tapping,
                    rImageCenter = R.drawable.lemon_squeeze,
                    rImageDesc = R.string.lemon_content_desc,
                    setStep = { setCurrentStep(3) }
                )
            }

            3 -> {
                Screen(
                    rTapText = R.string.tap_lemonade,
                    rImageCenter = R.drawable.lemon_drink,
                    rImageDesc = R.string.glass_of_lemonade_content_desc,
                    setStep = { setCurrentStep(4) }
                )
            }

            else -> {
                Screen(
                    rTapText = R.string.tap_empty_glass,
                    rImageCenter = R.drawable.lemon_restart,
                    rImageDesc = R.string.empty_glass_content_desc,
                    setStep = { setCurrentStep(1) }
                )
            }
        }
    }

}

@Composable
fun Screen(
    rTapText: Int,
    rImageCenter: Int,
    rImageDesc: Int,
    setStep: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        Text(
            text = stringResource(R.string.app_name),
            textAlign = TextAlign.Center,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                // Set background before wrapContentHeight()
//                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .background(color = Color(0xFFfff063))
                .wrapContentHeight(align = Alignment.CenterVertically)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = stringResource(rTapText))
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = setStep,
                shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
            ) {
                Image(
                    painter = painterResource(rImageCenter),
                    contentDescription = stringResource(rImageDesc),
                    modifier = Modifier
                        .wrapContentSize()
//                        .clickable {
//                            setStep()
//                        }
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}