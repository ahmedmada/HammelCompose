package com.qader.hammelcompose.search.item

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.qader.hammelcompose.R
import com.qader.hammelcompose.ui.theme.HammelComposeTheme
import com.qader.hammelcompose.ui.theme.dinFontBold
import com.qader.hammelcompose.ui.theme.dinFontMedium


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun CustomBottomSheet(
    onCloseClick: () -> Unit = {},
) {
    HammelComposeTheme {

        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            BottomSheet(
                onDismiss = {
                    onCloseClick()
                },
            ) {
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFF12121A), shape = RoundedCornerShape(16.dp))
                        .border(1.dp, Color.Gray, shape = RoundedCornerShape(16.dp))
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    // خط صغير في الأعلى
                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(0.3f)
                            .height(5.dp)
                            .clip(RoundedCornerShape(5.dp))
                            .background(Color.White)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Row الأول
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(R.string.all_shared_links),
                            color = Color.White,
                            modifier = Modifier.weight(1f),
                            style = MaterialTheme.typography.subtitle1.copy(
                                color = MaterialTheme.colors.onBackground,
                                fontSize = 16.sp,
                                fontFamily = dinFontBold,
                            )

                        )
                        Text(
                            text = stringResource(R.string.delete_all),
                            color = Color(0xFFF96969),
                            modifier = Modifier.padding(end = 8.dp),
                            style = MaterialTheme.typography.subtitle2.copy(
                                fontSize = 14.sp,
                                fontFamily = dinFontMedium,
                            )
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.search_trash),
                            contentDescription = "Delete",
                            tint = Color(0xFFF96969)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    RepeatRow(
                        icon = Icons.Default.AccountCircle,
                        url = "https://www.instagram.com/some_url"
                    )
                    RepeatRow(
                        icon = Icons.Default.AccountCircle,
                        url = "https://www.facebook.com/some_url"
                    )
                    RepeatRow(
                        icon = Icons.Default.AccountCircle,
                        url = "https://www.youtube.com/some_url"
                    )
                }
            }
        }
    }
}


@Composable
fun RepeatRow(icon: ImageVector, url: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(1.dp, Color(0x35383F26), RoundedCornerShape(8.dp))
            .background(Color(0x35383F26))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Close",
            modifier = Modifier
                .size(18.dp)
                .background(Color.Gray, shape = CircleShape)
                .padding(4.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Icon(
            imageVector = icon,
            contentDescription = "Icon",
            modifier = Modifier.size(32.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = url,
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(1f),
            style = androidx.compose.material.MaterialTheme.typography.subtitle2.copy(
                color = MaterialTheme.colors.onBackground,
                fontFamily = dinFontMedium,
            )
        )
        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = stringResource(R.string.past),
            style = MaterialTheme.typography.caption.copy(
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xffffffff),
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .height(32.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xff579594))
                .padding(horizontal = 16.dp, vertical = 4.dp)
                .clickable { },
        )
    }
}
