package com.godzuche.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.godzuche.businesscard.ui.theme.AndroidDarkGreen
import com.godzuche.businesscard.ui.theme.AndroidGreen
import com.godzuche.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    BusinessCard()
}

@Composable
fun BusinessCard(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AndroidDarkGreen)
            .padding(16.dp),
    ) {
        Spacer(modifier = Modifier.height(120.dp))
        MyDetails(
            iconPainter = painterResource(R.drawable.android_logo),
            modifier = Modifier.weight(1f))
        ContactInfo(modifier = Modifier.weight(1f))
    }
}

@Composable
fun MyDetails(
    iconPainter: Painter,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        Icon(
            painter = iconPainter,
            contentDescription = null,
            tint = AndroidGreen,
            modifier = Modifier
                .size(88.dp)
        )
        Text(
            text = "God'swill Jonathan",
            fontSize = 36.sp,
            fontWeight = FontWeight.ExtraLight,
            color = Color.White,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Native Android Developer",
            fontSize = 16.sp,
            color = AndroidGreen,
            fontWeight = FontWeight.SemiBold
        )

    }
}

@Composable
fun ContactInfo(
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier
            .fillMaxSize()
    ) {
        ContactInfoItem(contactIcon = Icons.Default.Call, contactText = "+234 805 9062 965")
        ContactInfoItem(contactIcon = Icons.Default.Share, contactText = "@Godxuche")
        ContactInfoItem(contactIcon = Icons.Default.Email, contactText = "godxuche@gmail.com")
    }
}

@Composable
fun ContactInfoItem(
    contactIcon: ImageVector,
    contactText: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 24.dp, top = 12.dp, bottom = 12.dp, end = 24.dp)
    ) {
        Icon(
            imageVector = contactIcon,
            contentDescription = null,
            tint = AndroidGreen
        )
        Text(
            text = contactText,
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier.padding(start = 24.dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}