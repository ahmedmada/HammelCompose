package com.qader.hammelcompose.search.item

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun SearchBottomSheet() {
    val showBottomSheet = remember {
        mutableStateOf(false)
    }

    MaterialTheme {

        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(8.dp))
                    .border(1.dp, Color(0x35383F26), RoundedCornerShape(8.dp, 8.dp, 0.dp, 0.dp))
//                    .background(Color(0x35383F26))
                    .background(Color(0xFF12121A))
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                Spacer(modifier = Modifier.padding(top = 16.dp))
                Box(
                    modifier = Modifier
                        .height(5.dp)
                        .fillMaxWidth(.3f)
                        .background(Color.White)
                        .clip(RoundedCornerShape(8.dp)),
                )
                if (showBottomSheet.value) {
                    BottomSheet(
                        onDismiss = {
                            showBottomSheet.value = false
                        },
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(),
                            contentAlignment = Alignment.Center,
                        ) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Color(0x35383F26))
                                    .padding(8.dp),
                            ) {
                                Text(
                                    text = "التصفح",
                                    color = Color.White,
                                    fontSize = 16.sp,
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Icon(
                                    imageVector = Icons.Default.Place,
                                    contentDescription = "أيقونة الكرة الأرضية",
                                    tint = Color.White,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
