package io.github.ananliangliang.cool.ui

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer

fun Modifier.legalMoveTo(enable: Boolean = true) = composed {
    if (!enable) return@composed this

    val infiniteTransition = rememberInfiniteTransition(label = "legalMoveAnimation")

    val scale by infiniteTransition.animateFloat(
        initialValue = 0.8f,
        targetValue = 0.6f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 600,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scaleAnimation"
    )


    val color = MaterialTheme.colorScheme.onBackground
    this.then(
        Modifier.fillMaxSize()
            .drawWithContent {
                drawContent()

                // 在格子中心绘制圆点
                val centerX = size.width / 2
                val centerY = size.height / 2
                val baseRadius = minOf(size.width, size.height) * 0.15f
                val radius = baseRadius * scale

                drawCircle(color, radius, Offset(centerX, centerY), 0.3F)
            }
    )
}


fun Modifier.swing(
    enable: Boolean = true,
    duration: Int = 200, // 晃动周期（毫秒）
    angle: Float = 5f // 最大晃动角度
): Modifier = composed {
    if (!enable) return@composed this

    val infiniteTransition = rememberInfiniteTransition(label = "swing")

    val rotation by infiniteTransition.animateFloat(
        initialValue = -angle,
        targetValue = angle,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = duration,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = "rotation"
    )

    this.graphicsLayer {
        rotationZ = rotation
        transformOrigin = TransformOrigin.Center
    }
}