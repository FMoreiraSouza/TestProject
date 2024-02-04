package org.example.testproject.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.isExporting
import com.varabyte.kobweb.core.rememberPageContext
import org.example.testproject.components.MenuBar
import org.example.testproject.sections.BeginSection

@Page
@Composable
fun HomePage() {
    var menuOpened by remember {
        mutableStateOf(false)
    }
    if (!rememberPageContext().isExporting) {
        Box(
            Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BeginSection { menuOpened = true }
            }
//            if (menuOpened) MenuBar { menuOpened = false }
        }
    }
}
