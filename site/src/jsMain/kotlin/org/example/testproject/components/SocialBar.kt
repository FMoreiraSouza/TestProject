package org.example.testproject.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.components.icons.fa.FaLinkedin
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text

@Composable
fun SocialBar(breakpoint: Breakpoint) {
    Column(
        modifier = Modifier
//            .animation(
//                ShowKeyFrames
//                    .toAnimation(
//                        duration = 1.s,
//                        timingFunction = AnimationTimingFunction.EaseInOut
//                    )
//            )
            .borderRadius(r = 20.px),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (breakpoint >= Breakpoint.SM) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SocialLinks(breakpoint)
                SpeakOnEmail(breakpoint)
            }
        }
        else {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SpeakOnEmail(breakpoint)
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    SocialLinks(breakpoint)
                }
            }
        }
    }
}

@Composable
fun SocialLinks(breakpoint: Breakpoint) {
    Link(
        modifier = Modifier.margin(
            right = 10.px,
            bottom = if (breakpoint >= Breakpoint.SM) 20.px else 5.px
        ),
        path = "https://www.linkedin.com/in/felipe-moreira-b16147200/",
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        FaLinkedin(
            modifier = Modifier,
            size = IconSize.XXL
        )
    }
    Link(
        modifier = Modifier.margin(
            right = 10.px,
            bottom = if (breakpoint >= Breakpoint.SM) 20.px else 5.px
        ),
        path = "https://github.com/FMoreiraSouza",
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        FaGithub(
            modifier = Modifier,
            size = IconSize.XXL
        )
    }
}

@Composable
fun SpeakOnEmail(breakpoint: Breakpoint) {
    Link(
        modifier = Modifier
            .margin(
                bottom = if (breakpoint >= Breakpoint.SM) 20.px else 35.px,
                left = if (breakpoint >= Breakpoint.SM) 20.px else 0.px
            )
            .height(50.px)
            .width(100.px),
        path = "mailto:fmoreirasouza701@gmail.com"
    ) {
        Button(
            attrs = Modifier
                .backgroundColor(Colors.Gray)
                .color(Colors.White)
                .fillMaxSize()
                .fontSize(14.px)
                .fontWeight(FontWeight.Bold)
                .color(Colors.White)
                .border(width = 0.px)
                .borderRadius(r = 5.px)
                .cursor(Cursor.Pointer)
                .toAttrs()
        ) {
            Text("E-mail")
        }
    }
}