package com.example.ui_auth_screen.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.common_ui_resources.btn.OutlinedButtonWithIcon
import com.example.common_ui_resources.theme.Gray_300
import com.example.common_ui_resources.theme.Gray_500
import com.example.common_ui_resources.theme.Gray_700
import com.example.common_ui_resources.theme.Gray_800
import com.example.common_ui_resources.theme.Gray_900
import com.example.common_ui_resources.theme.Primary
import com.example.common_ui_resources.theme.White
import com.example.common_ui_resources.R
@Composable
fun BottomActionBar(
    modifier: Modifier = Modifier,
    enable: Boolean,
    onSignInClick: () -> Unit,
    onGoogleClick: () -> Unit
) {
    Column(
        modifier = modifier.padding(bottom = 100.dp, start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedButtonWithIcon(
            modifier = modifier
                .fillMaxWidth()
                .height(45.dp),
            textColor = if (enable) {
                Gray_300

            } else Gray_900,
            enabled = enable,
            fontWeight = FontWeight.Bold,
            text = "GET STARTED",
        ) {
            onSignInClick()
        }
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Box(
                modifier = modifier
                    .weight(5f)
                    .height(1.dp)
                    .background(Gray_700)
            )
            Text(
                modifier = modifier
                    .weight(1f), text = "Or",
                textAlign = TextAlign.Center,
                color = Gray_700
            )
            Box(
                modifier = modifier
                    .weight(5f)
                    .height(1.dp)
                    .background(Gray_700)
            )
        }
        OutlinedButtonWithIcon(
            modifier = modifier
                .fillMaxWidth()
                .height(45.dp),
            textColor = White,
            leftIcon = R.drawable.google_symbol_svg,
            enabled = enable,
           buttonColors =  ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
            ),
            fontWeight = FontWeight.Bold,
            text = "SIGN IN WITH GOOGLE",
        ) {
            onGoogleClick()
        }
    }
}