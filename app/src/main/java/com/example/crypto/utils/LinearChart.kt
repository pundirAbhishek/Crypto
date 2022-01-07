package com.example.crypto.utils

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import kotlin.math.min


fun getBounds(list: List<Float>): Pair<Float, Float> {
    var min = Float.MAX_VALUE
    var max = -Float.MAX_VALUE
    list.forEach {
        min = min.coerceAtMost(it)
        max = max.coerceAtLeast(it)
    }
    return Pair(min, max)
}

@Composable
fun LineChart(
    modifier: Modifier = Modifier,
    lineColors: List<Color> = listOf(
        androidx.compose.material.MaterialTheme.colors.primary,
        androidx.compose.material.MaterialTheme.colors.primary
    ),
    lineColor : Color = Color.White,
    lineWidth: Float = 4f,
    yAxisValues: List<Float>,
    shouldAnimate: Boolean = true,
    shouldDrawLiveDot: Boolean = false,
    shouldDrawMiddleLine : Boolean = true,
    animationKey: Any? = Unit,
    customXTarget: Int = 0,
) {
    val yValues = yAxisValues
    val x = remember { Animatable(0f) }
    val xTarget = if (customXTarget > 0) customXTarget.toFloat() else (yValues.size - 1).toFloat()
    LaunchedEffect(animationKey) {
        x.animateTo(
            targetValue = xTarget,
            animationSpec = tween(
                durationMillis = if (shouldAnimate) 500 else 0,
                easing = LinearEasing
            ),
        )
    }
    val infiniteTransition = rememberInfiniteTransition()
    val radius by infiniteTransition.animateFloat(
        initialValue = 7f,
        targetValue = 15f,
        animationSpec = infiniteRepeatable(
            animation = tween(500, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    val opacity by infiniteTransition.animateFloat(
        initialValue = 0.7f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(500, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Canvas(modifier = modifier.padding(8.dp)) {
        val path = Path()
        val xBounds = Pair(0f, xTarget)
        val yBounds = getBounds(yValues)
        val scaleX = size.width / (xBounds.second - xBounds.first)
        val scaleY = size.height / (yBounds.second - yBounds.first)
        val yMove = yBounds.first * scaleY
        val interval = (0..min(yValues.size - 1, x.value.toInt()))
        val last = interval.last()
        interval.forEach { value ->
            val xPoint = value * scaleX
            val yPoint = size.height - (yValues[value] * scaleY) + yMove
            if (value == 0) {
                path.moveTo(0f, yPoint)
                return@forEach
            }
            path.lineTo(xPoint, yPoint)
        }

        val pathEffect = PathEffect.dashPathEffect(floatArrayOf(20f, 20f), 0f)
        val yMin = size.height - (yBounds.first * scaleY) + yMove
        val yMax = size.height - (yBounds.second * scaleY) + yMove
        val yCoordinate = yMax.plus(yMin).div(2)

        drawPath(
            path = path,
            brush = Brush.linearGradient(lineColors),
            style = Stroke(width = lineWidth)
        )

        if(shouldDrawMiddleLine){
            drawLine(
                color = lineColor,
                start = Offset(0f, yCoordinate),
                end = Offset(size.width, yCoordinate),
                pathEffect = pathEffect,
                strokeWidth = lineWidth/2,
                alpha = 0.5f
            )
        }

        if (shouldDrawLiveDot) {
            drawCircle(
                lineColors.first(), radius, Offset(
                    last * scaleX, size.height - (yValues[last] *
                            scaleY)
                            + yMove
                ), opacity
            )
        }
    }
}