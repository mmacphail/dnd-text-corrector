package eu.macphail

val wordRegex = "([^A-Za-zÀ-ÖØ-öø-ÿ]*)([A-Za-zÀ-ÖØ-öø-ÿ]+)([^A-Za-zÀ-ÖØ-öø-ÿ]*)".toRegex()
fun String.withoutPunctuation(): String {
    return if(wordRegex.matches(this)) {
        wordRegex.find(this)!!.groupValues[2]
    } else {
        this
    }
}

fun String.restorePunctuation(originalWord: String): String {
    val captures = wordRegex.find(originalWord)!!.groupValues
    val before = captures[1]
    val after = captures[3]
    return "$before$this$after"
}