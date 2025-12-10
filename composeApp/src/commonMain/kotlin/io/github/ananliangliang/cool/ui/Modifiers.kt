package io.github.ananliangliang.cool.ui

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color

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


    this.then(
        Modifier.fillMaxSize()
            .drawWithContent {
                drawContent()

                // 在格子中心绘制圆点
                val centerX = size.width / 2
                val centerY = size.height / 2
                val baseRadius = minOf(size.width, size.height) * 0.15f
                val radius = baseRadius * scale

                drawCircle(
                    color = Color.White,
                    radius = radius,
                    center = androidx.compose.ui.geometry.Offset(centerX, centerY),
                    alpha = 0.6F
                )
            }
    )
}
