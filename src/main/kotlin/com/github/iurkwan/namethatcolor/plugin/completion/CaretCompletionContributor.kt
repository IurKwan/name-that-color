package com.github.iurkwan.namethatcolor.plugin.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.completion.CompletionUtilCore.DUMMY_IDENTIFIER_TRIMMED
import com.intellij.util.ProcessingContext
import com.github.iurkwan.namethatcolor.core.manager.ColorNameFinder
import com.github.iurkwan.namethatcolor.plugin.util.NAME_THAT_COLOR
import com.github.iurkwan.namethatcolor.plugin.util.NAME_THAT_MATERIAL_COLOR
import com.github.iurkwan.namethatcolor.plugin.util.PLACE
import com.github.iurkwan.namethatcolor.plugin.util.addElement

/**
 * Completes the color on the caret after the color was written
 * (For some reason this shows up in the IDE only for lowercase entered colors)
 */
class CaretCompletionContributor : CompletionContributor() {

    init {
        extend(CompletionType.BASIC, PLACE, object : CompletionProvider<CompletionParameters>() {

            override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, resultSet: CompletionResultSet) {

                val text = parameters.position.text.replace(DUMMY_IDENTIFIER_TRIMMED, "")

                resultSet.addElement(NAME_THAT_COLOR, text, ColorNameFinder::findColor)
                resultSet.addElement(NAME_THAT_MATERIAL_COLOR, text, ColorNameFinder::findMaterialColor)
            }
        })
    }
}
