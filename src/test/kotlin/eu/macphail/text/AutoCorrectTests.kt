package eu.macphail.text

import eu.macphail.text.Dictionary
import eu.macphail.text.Text
import eu.macphail.text.Token
import eu.macphail.text.autoCorrect
import org.junit.Assert.assertEquals
import org.junit.Test

class AutoCorrectTests {
    val dictionary = Dictionary()

    val exampleText = Text(
        "Ceci est unexemple",
        listOf(
            Token(0, "Ceci"),
            Token(1, " "),
            Token(2, "est"),
            Token(3, " "),
            Token(4, "unexemple")
        )
    )

    @Test
    fun canAutoCorrect() {
        val result = autoCorrect(exampleText, dictionary)
        assertEquals(
            Text(
                "Ceci est unexemple",
                listOf(
                    Token(0, "Ceci"),
                    Token(1, " "),
                    Token(2, "est"),
                    Token(3, " "),
                    Token(4, "un"),
                    Token(5, " "),
                    Token(6, "exemple")
                )
            ), result)
    }
}