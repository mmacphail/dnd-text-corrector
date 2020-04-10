package eu.macphail

val wordRegex = "[^A-Za-zÀ-ÖØ-öø-ÿ]*([A-Za-zÀ-ÖØ-öø-ÿ]+)[^A-Za-zÀ-ÖØ-öø-ÿ]*".toRegex()
fun String.withoutPunctuation(): String {
    return if(wordRegex.matches(this)) {
        wordRegex.find(this)!!.groupValues[1]
    } else {
        this
    }
}