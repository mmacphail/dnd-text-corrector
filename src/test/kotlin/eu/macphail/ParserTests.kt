package eu.macphail

import org.junit.Assert.assertEquals
import org.junit.Test

class ParserTests {
    val exampleText = """Ce Traumatisant Docteur! Il était vraiment éprouvant!
Il faut dire que je ne l'avais que peu connu.
J'habitais à New-York.
J'étais comme ça."""

    @Test
    fun canParseText() {
        val t2 = """Hello there!
            |I love?
        """.trimMargin()

        assertEquals(exampleText, parseText(exampleText).buildFromTokens())
        assertEquals(t2, parseText(t2).buildFromTokens())
    }

    @Test
    fun canReplaceToken() {
        val updatedText = """Ce Traumatisant Babouin! Il était vraiment éprouvant!
Il faut dire que je ne l'avais que peu connu.
J'habitais à New-York.
J'étais comme ça."""

        assertEquals(updatedText, parseText(exampleText).replaceToken(4, "Babouin").buildFromTokens())
    }

    @Test
    fun canInsertToken() {
        val updatedText = """Ce Traumatisant Docteur Babouin! Il était vraiment éprouvant!
Il faut dire que je ne l'avais que peu connu.
J'habitais à New-York.
J'étais comme ça."""

        assertEquals(updatedText, parseText(exampleText)
            .insertTokenAfter(4, " ")
            .insertTokenAfter(5, "Babouin")
            .buildFromTokens())
    }

}

