package com.example.componentfactory.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.componentfactory.components.utils.Style
import com.example.componentfactory.ui.theme.ComponentFactoryTheme

@ExperimentalMaterialApi
@Composable
fun FavouriteIcon(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    style: Style = Style.Fill,
    selectedColor: Color = MaterialTheme.colors.primary,
    unSelectedColor: Color = MaterialTheme.colors.onBackground,
    stokeWidth: Float = 5f,
    shape: Shape = CircleShape,
    padding: Dp = 4.dp,
    onClick: () -> Unit
) {

    Card(onClick = onClick, modifier = Modifier.padding(padding), shape = shape) {

        Box(modifier = modifier) {

            Canvas(
                modifier = Modifier.matchParentSize(),
            ) {


                val halfWidth = size.width / 2
                val halfHeight = size.height / 2
                val quarterWidth = size.width / 4
                val quarterHeight = size.height / 4
                val octHeight = size.height / 8


                val path = Path()
                path.moveTo(halfWidth, halfHeight + quarterHeight)
                path.cubicTo(
                    -quarterWidth, halfHeight,
                    quarterWidth, 0f,
                    halfWidth, halfHeight - octHeight
                )
                path.cubicTo(
                    quarterWidth + halfWidth, 0f,
                    size.width + quarterWidth, halfHeight,
                    halfWidth, halfHeight + quarterHeight
                )
                path.close()
                when (style) {
                    is Style.Fill -> {
                        drawPath(
                            path = path,
                            color = if (isSelected) selectedColor else unSelectedColor,
                            style = Fill
                        )
                    }
                    is Style.Stroke -> {
                        drawPath(
                            path = path,
                            color = if (isSelected) selectedColor else unSelectedColor,
                            style = Stroke(width = stokeWidth)
                        )
                    }

                }
                clipPath(path = path, clipOp = ClipOp.Difference) {

                }

            }
        }
    }


}


@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComponentFactoryTheme {
        FavouriteIcon {

        }
    }
}