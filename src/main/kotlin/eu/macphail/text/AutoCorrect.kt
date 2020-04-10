package eu.macphail.text

fun autoCorrect(text: Text, dictionary: Dictionary): Text {
    return text.tokens.fold(Text(text.originalText, listOf())) { t, token ->
        if(token.isWord()) {
            if(dictionary.isWord(token.string)) {
                t.appendToken(token.string)
            } else {
                val subWordsResults = dictionary.autoSpace(token.string)
                if(subWordsResults.size == 1) {
                    val subWord = subWordsResults.first()
                    t.appendTokens(subWord.first, " ", subWord.second)
                } else {
                    t.appendToken(token.string)
                }
            }
        } else {
            t.appendToken(token.string)
        }
    }
}