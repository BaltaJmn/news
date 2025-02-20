package com.baltajmn.features.article.presentation.screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.baltajmn.template.core.design.components.LoadingView
import com.baltajmn.template.core.design.theme.SubBody
import com.baltajmn.template.core.design.theme.Title
import org.koin.androidx.compose.koinViewModel

@Composable
fun ArticleScreen(
    viewModel: ArticleViewModel = koinViewModel(),
    listState: LazyListState
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    AnimatedContent(
        targetState = state.isLoading,
        label = ""
    ) {
        when (it) {
            true -> LoadingView()
            false -> Content(
                state = state,
                listState = listState
            )
        }
    }
}

@Composable
private fun Content(
    state: State,
    listState: LazyListState
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        state = listState,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item {
            Text(
                text = state.article?.title.orEmpty(),
                style = Title
            )
        }
        item { Spacer(modifier = Modifier.height(16.dp)) }
        item {
            AsyncImage(
                model = state.article?.urlToImage,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = 200.dp)
                    .clip(shape = RectangleShape)
            )
        }
        item { Spacer(modifier = Modifier.height(16.dp)) }
        item {
            Text(
                text = state.article?.content.orEmpty(),
                style = SubBody
            )
        }

    }
}