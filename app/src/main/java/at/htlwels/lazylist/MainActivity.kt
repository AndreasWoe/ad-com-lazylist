package at.htlwels.lazylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import at.htlwels.lazylist.ui.theme.LazyListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyListTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //SimpleList(modifier = Modifier.padding(innerPadding))
                    //LazyListScreen(modifier = Modifier.padding(innerPadding))
                    PaymentScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun LazyListScreen(modifier: Modifier = Modifier, vm: MainViewModel = viewModel()) {
    Column(modifier.height(150.dp)) {
        Button(onClick = { vm.addItem("Another Item") }) {
            Text("Add Item")
        }
        LazyList(modifier, vm.items)
    }
}

//lazy list for large data sets
@Composable
fun LazyList(modifier: Modifier = Modifier, items: List<String>) {

    var sliderPosition by remember { mutableStateOf(20f) }

    LazyColumn (modifier = Modifier) {
        items(items = items) {
            Text(text = it)
            Button(onClick = { /*TODO*/ }) {
                Text("Choose me!")
            }
        }
    }
}

@Preview
@Composable
fun PreviewLazyColumn() {
    LazyListTheme {
        LazyList(items = listOf("Eins", "Zwo"))
    }
}

//easy way to build a list
@Composable
fun SimpleList(modifier: Modifier = Modifier, items: List<String> = listOf("One", "Two", "Three", "Four", "Five", "Six")) {
    Column(modifier = modifier) {
        for (item in items) {
            Text(item)
            HorizontalDivider(color = Color.Black)
        }
    }
}