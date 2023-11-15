package com.imtiaz.jetpackdropdown


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned

import androidx.compose.ui.platform.LocalDensity

import androidx.compose.ui.unit.dp

import androidx.compose.ui.unit.toSize


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenu(){
//    val parentOptions = listOf("Animals","Birds","Flowers") // to provide options
//    var expandedState by remember { mutableStateOf(false) } //to handle down or up
//    var selectedOption by remember { mutableStateOf(parentOptions[0]) }  // by default 0 index
//    var mContext = LocalContext.current // to display toast

    var expandedState by remember { mutableStateOf(false) } //to handle down or up

    val list = listOf("Animals","Birds","Flowers") // to provide options

    var selectedItem by remember { mutableStateOf("") }

     var textFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if(expandedState){
        Icons.Filled.KeyboardArrowUp
    }else{
        Icons.Filled.KeyboardArrowDown
    }


    Column(modifier = Modifier.padding(20.dp)) {

        OutlinedTextField(
            value = selectedItem,
            onValueChange = { selectedItem = it},
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { cordinates ->
                    textFieldSize = cordinates.size.toSize()
                },
            label = { Text(text = "Select Item")},
            trailingIcon = {

                Icon(icon,"",Modifier.clickable { expandedState = !expandedState })
            }
        )

        DropdownMenu(
            expanded = expandedState,
            onDismissRequest = { expandedState = false },
            modifier = Modifier.width(with(LocalDensity.current){
                textFieldSize.width.toDp() })
        ) {

            list.forEach { label ->
                DropdownMenuItem(text = { Text(text = label) },
                    onClick = {
                    selectedItem = label
                    expandedState = false
                })
            }

        }

    }

}


