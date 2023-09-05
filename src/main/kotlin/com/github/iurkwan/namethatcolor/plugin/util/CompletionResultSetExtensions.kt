package com.github.iurkwan.namethatcolor.plugin.util

import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.github.iurkwan.namethatcolor.core.exception.ColorNotFoundException
import com.github.iurkwan.namethatcolor.core.model.Color
import il.co.galex.namethatcolor.core.model.HexColor
import com.github.iurkwan.namethatcolor.core.util.toXmlName

inline fun CompletionResultSet.addElement(message: String, clipboard: String, find: (color: HexColor) -> Pair<HexColor, Color>) {

    try {
        val (hexColor, color) = find(HexColor(clipboard))
        val name = color.name.toXmlName(hexColor.percentAlpha)
        val insert = xmlOutput(name, hexColor.toString())
        addElement(LookupElementBuilder.create(insert).withPresentableText(message))

    } catch (e: ColorNotFoundException) {
        println(e.localizedMessage)
    } catch (e: IllegalArgumentException) {
        println(e.localizedMessage)
    }
}