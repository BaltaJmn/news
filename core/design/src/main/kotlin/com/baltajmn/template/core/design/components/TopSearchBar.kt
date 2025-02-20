package com.baltajmn.template.core.design.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun TopSearchBar(
    modifier: Modifier = Modifier,
    onTextSearch: (String) -> Unit,
    shouldShow: () -> Boolean
) {
    var text by rememberSaveable {
        mutableStateOf("")
    }

    var firstVisibility by rememberSaveable {
        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {
        delay(600)
        firstVisibility = true
    }

    AnimatedVisibility(
        modifier = modifier
            .navigationBarsPadding()
            .padding(top = 24.dp),
        visible = shouldShow() && firstVisibility,
        enter = slideInHorizontally(
            initialOffsetX = { 1000 },
            animationSpec = tween(
                durationMillis = 400,
                easing = LinearEasing
            )
        ),
        exit = slideOutHorizontally(
            targetOffsetX = { 1000 },
            animationSpec = tween(
                durationMillis = 400,
                easing = LinearEasing
            )
        )
    ) {
        TopBarSurface(
            modifier = modifier
                .height(IntrinsicSize.Min)
        ) {
            TextField(
                value = text,
                onValueChange = {
                    text = it
                    onTextSearch.invoke(it)
                },
                label = { Text("Search") }
            )
        }
    }
}

@Composable
fun TopBarSurface(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Surface(
            shadowElevation = 0.dp,
            color = MaterialTheme.colorScheme.surface,
            modifier = modifier
                .shadow(
                    elevation = 5.dp,
                    shape = RoundedCornerShape(20)
                )
                .align(Alignment.Center)
        ) {
            Row(
                modifier = Modifier
                    .padding(10.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                content()
            }
        }
    }
}