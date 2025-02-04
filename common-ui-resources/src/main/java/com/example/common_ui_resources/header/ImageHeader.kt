package com.example.common_ui_resources.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.common_ui_resources.theme.Gray_300
import com.example.common_ui_resources.theme.Gray_500

@Composable
fun ImageHeader(modifier: Modifier, image: Int, title: String, description: String) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Image(
            modifier = modifier.size(100.dp),
            painter = painterResource(image),
            contentDescription = "Pocket"
        )
        Text(title, fontSize = 16.sp, color = Gray_300, fontWeight = FontWeight.Bold)
        Text(description, fontSize = 16.sp, color = Gray_500)
    }
}