package com.example.componentfactory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.componentfactory.components.FavouriteIcon
import com.example.componentfactory.components.utils.Style
import com.example.componentfactory.ui.theme.ComponentFactoryTheme
import com.example.componentfactory.ui.theme.lemon

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComponentFactoryTheme {

                val isSelectedRounded = remember {
                    mutableStateOf(false)
                }

                val isSelectedFilledCorner = remember {
                    mutableStateOf(false)
                }
                val isSelectedStokeCorner = remember {
                    mutableStateOf(false)
                }

                val isSelectedBig = remember {
                    mutableStateOf(false)
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = lemon
                ) {

                    Column(
                        modifier = Modifier
                            .width(100.dp)
                            .height(300.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        FavouriteIcon(
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp),
                            isSelected = isSelectedRounded.value,
                            style = Style.Fill,
                            selectedColor = Color.Green,
                            unSelectedColor = Color.Red
                        ) {
                            isSelectedRounded.value = !isSelectedRounded.value
                        }

                        FavouriteIcon(
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp),
                            isSelected = isSelectedFilledCorner.value,
                            style = Style.Fill,
                            selectedColor = Color.Green,
                            unSelectedColor = Color.Red,
                            shape = RoundedCornerShape(20.dp)
                        ) {
                            isSelectedFilledCorner.value = !isSelectedFilledCorner.value
                        }
                        FavouriteIcon(
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp),
                            isSelected = isSelectedStokeCorner.value,
                            style = Style.Stroke,
                            selectedColor = Color.Green,
                            unSelectedColor = Color.Red
                        ) {
                            isSelectedStokeCorner.value = !isSelectedStokeCorner.value
                        }

                        FavouriteIcon(
                            modifier = Modifier
                                .width(200.dp)
                                .height(200.dp),
                            isSelected = isSelectedBig.value,
                            style = Style.Stroke,
                            stokeWidth = 10f,
                            selectedColor = Color.Green,
                            unSelectedColor = Color.Red,
                            shape = RoundedCornerShape(20.dp)
                        ) {
                            isSelectedBig.value = !isSelectedBig.value
                        }
                    }

                }
            }
        }
    }
}

/*
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
    FavouriteIcon()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComponentFactoryTheme {
        Greeting("Android")
    }
}*/
