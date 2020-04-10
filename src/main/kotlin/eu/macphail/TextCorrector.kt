package eu.macphail

class TextCorrector {
    val dictionary = Dictionary()

    fun autoCorrect(text: String): String {
        val words = text.split(" ")
        return words.map { autoCorrectWord(it) }.joinToString(separator = " ")
    }

    private fun autoCorrectWord(word: String): String? {
        val wordBase = word.withoutPunctuation()
        if(!dictionary.isWord(wordBase)) {
            val autoSpaceResult = dictionary.autoSpace(wordBase)
            return if(autoSpaceResult.size == 1)
                autoSpaceResult.first().addSpaceBetweenWords().restorePunctuation(word)
            else word
        }
        return word
    }
}

private fun Pair<String, String>.addSpaceBetweenWords(): String {
    return "$first $second"
}
