package com.godzuche.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
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
                    color = MaterialTheme.colors.background) {
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
    Column(modifier = modifier
        .fillMaxSize()
        .background(AndroidDarkGreen)
        .padding(16.dp)
    ) {
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
                .size(72.dp)
        )
        Text(
            text = "God'swill U. Jonathan",
            fontSize = 36.sp,
            fontWeight = FontWeight.Light,
            color = Color.White,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Native Android Developer",
            fontSize = 16.sp,
            color = Color.White,
        )

    }
}

@Composable
fun ContactInfo(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        ContactInfoItem(contactIcon = Icons.Default.Call, contactText = "08059062965")
        ContactInfoItem(contactIcon = Icons.Default.Email, contactText = "godxuche@gmail.com")
    }
}

@Composable
fun ContactInfoItem(
    contactIcon: ImageVector,
    contactText: String,
) {
    Row(
        modifier = Modifier
            .padding(start = 24.dp)
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