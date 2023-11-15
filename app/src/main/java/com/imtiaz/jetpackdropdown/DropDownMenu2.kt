package com.imtiaz.jetpackdropdown


import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun DropDownMenu2() {
//    val countryName = arrayOf("USA", "BD", "In", "GR", "ARG", "BR")
//    val selectedText = remember { mutableStateOf("") }
//    val expandedState = remember { mutableStateOf(false) }
//    val snackbarHostState = remember { SnackbarHostState() }
//    val coroutineScope = rememberCoroutineScope()
//
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(32.dp)
//    ) {
//        ExposedDropdownMenuBox(expanded = expandedState.value, onExpandedChange = {
//            expandedState.value = !expandedState.value
//        }) {
//            TextField(
//                value = if (selectedText.value.isEmpty()) "Select a country" else selectedText.value,
//                onValueChange = {},
//                readOnly = true,
//                trailingIcon = {
//                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedState.value)
//                },
//                modifier = Modifier.menuAnchor()
//            )
//            ExposedDropdownMenu(expanded = expandedState.value,
//                onDismissRequest = { expandedState.value = false }) {
//                countryName.forEach {
//                    DropdownMenuItem(text = { Text(text = it) }, onClick = {
//                        selectedText.value = it
//                        expandedState.value = false
//
//                        coroutineScope.launch{
//                            snackbarHostState.showSnackbar("Selected: $it")
//                        }
//
//                    })
//                }
//            }
//        }
//    }
//}


//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun DropDownMenu2() {
//    val countryName = arrayOf("USA", "BD", "In", "GR", "ARG", "BR")
//    val selectedText = remember { mutableStateOf("") }
//    val expandedState = remember { mutableStateOf(false) }
//    val snackBarHostState = remember { SnackbarHostState() }
////    snackBarHostState.currentSnackbarData?.dismissOnTimeout(2000)
//
//    val coroutineScope = rememberCoroutineScope()
//
//    Scaffold(
//        snackbarHost = {
//            SnackbarHost(
//                hostState = snackBarHostState,
//                modifier = Modifier.padding(16.dp)
//            )
//        }
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(32.dp)
//        ) {
//            ExposedDropdownMenuBox(expanded = expandedState.value, onExpandedChange = {
//                expandedState.value = !expandedState.value
//            }) {
//                TextField(
//                    value = if (selectedText.value.isEmpty()) "Select a country" else selectedText.value,
//                    onValueChange = {},
//                    readOnly = true,
//                    trailingIcon = {
//                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedState.value)
//                    },
//                    modifier = Modifier.menuAnchor()
//                )
//                ExposedDropdownMenu(expanded = expandedState.value,
//                    onDismissRequest = { expandedState.value = false }) {
//                    countryName.forEach {
//                        DropdownMenuItem(text = { Text(text = it) }, onClick = {
//                            selectedText.value = it
//                            expandedState.value = false
//
//                            coroutineScope.launch {
//                                snackBarHostState.showSnackbar("Selected: $it")
//                            }
//                        })
//                    }
//                }
//            }
//        }
//    }
//}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenu2() {
    val countryName = arrayOf("USA", "BD", "In", "GR", "ARG", "BR")
    val selectedText = remember { mutableStateOf("") }
    val expandedState = remember { mutableStateOf(false) }
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        ExposedDropdownMenuBox(expanded = expandedState.value, onExpandedChange = {
            expandedState.value = !expandedState.value
        }) {
            TextField(
                value = if (selectedText.value.isEmpty()) "Select a country" else selectedText.value,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedState.value)
                },
                modifier = Modifier.menuAnchor()
            )
            ExposedDropdownMenu(expanded = expandedState.value,
                onDismissRequest = { expandedState.value = false }) {
                countryName.forEach {
                    DropdownMenuItem(text = { Text(text = it) }, onClick = {
                        selectedText.value = it
                        expandedState.value = false

                        coroutineScope.launch {
                            snackbarHostState.showSnackbar("Selected: $it")
                        }

                    })
                }
            }
        }
    }
}

