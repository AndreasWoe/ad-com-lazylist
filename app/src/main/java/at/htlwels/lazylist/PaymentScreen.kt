package at.htlwels.lazylist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun PaymentScreen(modifier: Modifier = Modifier, viewModel: MainViewModel = viewModel()) {
    val paymentOptions = listOf("Rechnung", "PayPal", "Kreditkarte", "Apple Pay", "Google Pay")

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Wählen Sie eine Bezahlmethode:", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(paymentOptions) { option ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .clickable { viewModel.selectPayment(option) },
                    colors = CardDefaults.cardColors(
                        containerColor = if (viewModel.selectedPayment == option) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
                    )
                ) {
                    Text(
                        text = option,
                        modifier = Modifier.padding(16.dp),
                        color = if (viewModel.selectedPayment == option) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Text(viewModel.selectedPayment)
    }
}
