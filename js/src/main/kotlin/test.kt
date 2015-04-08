package test

import html4k.*
import html4k.dom.buildAndAppendChild
import html4k.dom.buildHTML
import html4k.stream.appendHTML
import kotlin.js.dom.html.HTMLElement
import kotlin.js.dom.html.document
import kotlin.js.dom.html.window

fun onReady() {
    val div = document.buildHTML().div {
        div("bold") {
            div {
                a("http://kotlinlang.org") {
                    target = Target.blank
                    +"Kotlin site"
                    div {
                    }
                }
                p {
                    +"content"
                }
            }
        }
    }

    document.body.appendChild(div)

    window.setInterval({
        div.buildAndAppendChild {
            div {
                +"added it"
            }
            div {
            }
        }
    }, 10000L)
}

fun main(args: Array<String>) {
    window.onload = ::onReady
}
