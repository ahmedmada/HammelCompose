package com.qader.hammelcompose.search.item

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    modalBottomSheetState: SheetState = rememberModalBottomSheetState(),
    onDismiss: () -> Unit = {},
    content: @Composable () -> Unit,
) {
    ModalBottomSheet(scrimColor= Color.Black.copy(alpha = 0.4f),
        containerColor = Color.White,
        contentColor = Color.White,
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = {   },
    ) {
        content()
    }
}
