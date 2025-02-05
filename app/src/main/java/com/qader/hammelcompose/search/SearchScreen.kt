package com.qader.hammelcompose.search

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.qader.hammelcompose.R
import com.qader.hammelcompose.search.item.CustomBottomSheet
import com.qader.hammelcompose.search.item.SearchResult
import com.qader.hammelcompose.ui.theme.HammelComposeTheme
import com.qader.hammelcompose.ui.theme.dinFontBold
import com.qader.hammelcompose.ui.theme.dinFontNormal

@Composable
fun SearchScreen() {
    val showBottomSheet = remember {
        mutableStateOf(false)
    }
    val openSearchResult = remember {
        mutableStateOf(false)
    }

    HammelComposeTheme {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background),
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                ) {
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = stringResource(R.string.search),
                        modifier = Modifier.align(Alignment.Start),
                        style = MaterialTheme.typography.h5.copy(
                            fontSize = 34.sp,
                            color = MaterialTheme.colors.onSurface,
                            fontFamily = dinFontBold
                        )

                    )
                    Spacer(modifier = Modifier.height(16.dp))


                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .clickable { showBottomSheet.value = true },
                    ) {
                        Spacer(modifier = Modifier.weight(1f))
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp, 8.dp, 0.dp, 0.dp))
                                .background(Color(0xFF283E42))
                                .padding(horizontal = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                        ) {
                            Text(
                                text = stringResource(R.string.shared_links),
                                style = MaterialTheme.typography.body2.copy(
                                    color = MaterialTheme.colors.onSurface,
                                    fontFamily = dinFontNormal
                                )
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(
                                painter = painterResource(id = R.drawable.share),
                                contentDescription = "",
                                tint = MaterialTheme.colors.onSurface,
                                modifier = Modifier.size(9.dp),
                            )
                        }
                        Spacer(modifier = Modifier.width(49.dp))
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0x35383F26))
                            .border(1.dp, Color(0x35383F26), RoundedCornerShape(8.dp)),

                        ) {
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .clip(RoundedCornerShape(8.dp, 0.dp, 0.dp, 8.dp))
                                .background(MaterialTheme.colors.primary)
                                .clickable {
                                    openSearchResult.value = true
                                },
                            contentAlignment = Alignment.Center,
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.arrow_search),
                                contentDescription = "",
                                tint = MaterialTheme.colors.onSurface,
                            )
                        }

                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            label = {
                                Text(
                                    stringResource(R.string.links_download),
                                    fontSize = 16.sp,
                                )
                            },
                            modifier = Modifier
                                .weight(1f)
                                .background(Color.Unspecified),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                backgroundColor = Color.Transparent, // Background color for the container
                                focusedBorderColor = Color.Transparent, // Border color when focused
                                unfocusedBorderColor = Color.Transparent // Border color when not focused
                            ),
                            textStyle = MaterialTheme.typography.body1.copy(
                                color = MaterialTheme.colors.onSurface, // Text color
                                fontSize = 16.sp, // Optional: set font size if needed
                                fontWeight = FontWeight.Normal // Optional: set font weight
                            )
                        )


                        Box(
                            modifier = Modifier
                                .padding(vertical = 10.dp)
                                .fillMaxHeight()
                                .width(1.dp)
                                .background(Color(0x35383F26)),
                        )
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .clip(RoundedCornerShape(0.dp, 0.dp, 8.dp, 8.dp)),
                            contentAlignment = Alignment.Center,
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.link_svgrepo_com),
                                contentDescription = "",
                                tint = MaterialTheme.colors.onSurface,
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(32.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center,
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .clip(RoundedCornerShape(24.dp))
//                                .padding(vertical = 8.dp, horizontal = 16.dp)
                                .border(1.dp, Color(0x35383F26), RoundedCornerShape(8.dp))
                                .background(Color(0x35383F26))
                                .padding(8.dp),

                        ) {
                            Text(
                                text = stringResource(R.string.browse),
                                color = MaterialTheme.colors.onSurface,
                                fontSize = 16.sp,
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(
                                painter = painterResource(id = R.drawable.boxes),
                                contentDescription = "",
                                tint = MaterialTheme.colors.onSurface,
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    if (openSearchResult.value)
                        SearchResult(){
                            openSearchResult.value = true
                        }
                    else
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp))
                                .border(1.dp, Color(0x35383F26), RoundedCornerShape(8.dp))
                                .background(Color(0x35383F26))
                                .padding(16.dp),
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.fillMaxWidth(),
                            ) {
                                Text(
                                    text = stringResource(R.string.feature_download_hammel),
                                    style = MaterialTheme.typography.h6.copy(
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Medium,
                                        color = MaterialTheme.colors.onSurface,
                                    ),
                                )
                                Spacer(modifier = Modifier.height(12.dp))
                                Text(
                                    text = stringResource(R.string.search_desc_1),
                                    color = MaterialTheme.colors.onSurface,
                                    fontSize = 14.sp,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier.fillMaxWidth(),
                                    style = MaterialTheme.typography.body2.copy(
                                        color = MaterialTheme.colors.onSurface,
                                        fontFamily = dinFontNormal
                                    )
                                )
                                Text(
                                    text = stringResource(R.string.search_desc_2),
                                    color = MaterialTheme.colors.onSurface,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier.fillMaxWidth(),
                                    style = MaterialTheme.typography.body2.copy(
                                        color = MaterialTheme.colors.onSurface,
                                        fontFamily = dinFontNormal
                                    )
                                )
                                Text(
                                    text = stringResource(R.string.search_desc_3),
                                    color = MaterialTheme.colors.onSurface,
                                    style = MaterialTheme.typography.body2.copy(
                                        color = MaterialTheme.colors.onSurface,
                                        fontFamily = dinFontNormal
                                    ),
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier.fillMaxWidth(),
                                )
                                Text(
                                    text = buildAnnotatedString {
                                        withStyle(
                                            style = SpanStyle(
                                                fontSize = 14.sp,
                                                color = MaterialTheme.colors.onSurface,
                                                fontFamily = dinFontNormal
                                            ),
                                        ) {
                                            append(stringResource(R.string.search_desc_4_1))
                                        }
                                        withStyle(
                                            style = SpanStyle(
                                                fontSize = 14.sp,
                                                color = Color(0xFFE1BD73),
                                                fontFamily = dinFontNormal
                                            ),
                                        ) {
                                            append(stringResource(R.string.search_desc_4_2))
                                        }
                                        withStyle(
                                            style = SpanStyle(
                                                fontSize = 14.sp,
                                                color = MaterialTheme.colors.onSurface,
                                                fontFamily = dinFontNormal
                                            ),
                                        ) {
                                            append(stringResource(R.string.search_desc_4_3))
                                        }
                                    },
                                    fontSize = 14.sp,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier.fillMaxWidth(),
                                )
                                Text(
                                    text = stringResource(R.string.search_desc_5),
                                    color = MaterialTheme.colors.onSurface,
                                    style = MaterialTheme.typography.body2.copy(
                                        color = MaterialTheme.colors.onSurface,
                                        fontFamily = dinFontNormal
                                    ),
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier.fillMaxWidth(),
                                )

                                Spacer(modifier = Modifier.height(16.dp))

                                Text(
                                    text = stringResource(R.string.open_now),
                                    style = MaterialTheme.typography.body2.copy(
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colors.onSurface,
                                    ),
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .height(35.dp)
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(16.dp))
                                        .background(
                                            Color(
                                                0xFF35383F,
                                            ),
                                        )
                                        .clickable { },
                                )


                            }
                        }

                    if (showBottomSheet.value)
                        CustomBottomSheet(){
                            showBottomSheet.value = false
                        }
                }

            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun PreviewSearchScreen() {
    SearchScreen()
}
