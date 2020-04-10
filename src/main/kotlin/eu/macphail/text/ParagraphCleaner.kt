package eu.macphail.text

import java.lang.StringBuilder

fun cleanParagraphs(text: String): String {
    val lines = text.lines()
    val result = lines.fold(StringBuilder("")) { builder, line ->
        println("line: $line, isAllCaps? ${line.isAllCaps()}")
        if(line.isAllCaps()) {
            if(!builder.toString().endsWith("\n")) {
                builder.append("\n")
            }
            builder.append(line)
            builder.append("\n")
        } else {
            builder.append(line)
            val endOfLineParagraph = 40
            if (line.length < endOfLineParagraph) {
                builder.append("\n")
            } else {
                if (!builder.toString().endsWith("-")) {
                    builder.append(" ")
                }
            }
        }
        builder
    }.toString()

    return result.trim()
}

private val charRegex = Regex("[A-Za-zÀ-ÖØ-öø-ÿ]")
fun String.isAllCaps(): Boolean {
    return this.chars()
        .filter{ v -> charRegex.matches(v.toChar().toString()) }
        .allMatch { v -> v.toChar().isUpperCase() }
}
