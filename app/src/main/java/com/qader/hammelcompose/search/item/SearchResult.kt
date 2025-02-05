package com.qader.hammelcompose.search.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.qader.hammelcompose.R
import com.qader.hammelcompose.ui.theme.HammelComposeTheme
import com.qader.hammelcompose.ui.theme.dinFontBold
import kotlinx.coroutines.launch

@Composable
fun SearchResult(
    onCloseClick: () -> Unit = {},
) {
    var expanded by remember { mutableStateOf(false) }
    val items = remember { List(10) { "Item $it" } }
    val visibleItems = if (expanded) items else items.take(4)
    val scope = rememberCoroutineScope()
    HammelComposeTheme {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .border(1.dp, Color(0x35383F26), RoundedCornerShape(8.dp))
                .background(Color(0x35383F26))
                .padding(16.dp),

                    horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            // Header Box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.medium)
                    .padding(8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(onClick = {onCloseClick() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.video_actions),
                            contentDescription = "Close",
                            tint = Color.White,
                            modifier = Modifier
                                .width(26.dp)
                                .height(38.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "Survive 100 Days Trapped, Win \$500,000",
                        style = MaterialTheme.typography.subtitle1.copy(
                            color = MaterialTheme.colors.onBackground,
                            fontFamily = dinFontBold,
                        ),
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.fillMaxWidth()) {
                items(visibleItems) { item ->
                    GridItem(item)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Load More Button
            if (!expanded) {
                Button(
                    onClick = { scope.launch { expanded = true } },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF579594)),
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text(stringResource(R.string.show_more), color = Color.White)
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_down),
                        contentDescription = "Show More",
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun GridItem(title: String) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .clip(MaterialTheme.shapes.medium)
            .border(1.dp, Color.Gray, MaterialTheme.shapes.medium)
            .background(Color.DarkGray)
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .border(1.dp, Color(0x35383F26), RoundedCornerShape(8.dp))
                    .background(Color(0x35383F26))
                ,
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.image_result_test),
                    contentDescription = "Image",
                    contentScale = ContentScale.Fit,
                )
//                Icon(
//                    painter = painterResource(id = R.drawable.vector_play),
//                    contentDescription = "Icon",
//                    tint = Color.White
//                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "1080P فيديو",
                style = MaterialTheme.typography.subtitle2.copy(
                    color = MaterialTheme.colors.onBackground,
                    fontFamily = dinFontBold,
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text("(16.35 MB)",
                style = MaterialTheme.typography.subtitle2.copy(
                    color = Color.Gray,
                    fontFamily = dinFontBold,
                    fontSize = 14.sp
                )
                )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                LabelBox(stringResource(R.string.plus), Color(0xFFE2BB6B), R.drawable.ic_crown)
                LabelBox(stringResource(R.string.fast), Color(0xFF5C9557), R.drawable.vector_fast)
                LabelBox(stringResource(R.string.new_), Color(0xFF5C5AC3), R.drawable.ic_crown)
            }
        }
    }
}

@Composable
fun LabelBox(text: String, color: Color, icon: Int? = null) {
    Box(
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
            .background(color.copy(alpha = 0.2f))
            .padding(horizontal = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (icon != null) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = text,
                    tint = color,
                    modifier = Modifier.size(10.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
            }
            Text(text, fontSize = 10.sp, fontWeight = FontWeight.W500, color = color)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomPage() {
    MaterialTheme {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            SearchResult()
        }
    }
}