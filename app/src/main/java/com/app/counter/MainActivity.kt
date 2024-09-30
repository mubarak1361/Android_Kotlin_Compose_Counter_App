package com.app.counter

import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.app.counter.ui.theme.ComposeCounterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeCounterAppTheme {
                CounterScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CounterScreen() {

    val counter = remember { mutableIntStateOf(0) }

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { Text(text = stringResource(id = R.string.app_name)) },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer)) },
        floatingActionButton = { FloatingActionButton(
        onClick = { counter.intValue ++ }) {
        Icon(Icons.Default.Add, contentDescription = null)
    } }) { innerPadding ->

    Column(modifier = Modifier
        .padding(innerPadding)
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)) {

            Text(modifier = Modifier.align(Alignment.CenterHorizontally),
                text = stringResource(id = R.string.counter_description))

            Text(modifier = Modifier.align(Alignment.CenterHorizontally),
                text = counter.intValue.toString(),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold)

    }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterScreenPreview() {
    ComposeCounterAppTheme {
        CounterScreen()
    }
}