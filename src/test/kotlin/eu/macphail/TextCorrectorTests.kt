package eu.macphail

import org.junit.Assert.assertEquals
import org.junit.Test

class TextCorrectorTests {
    val textCorrector = TextCorrector()

    @Test
    fun canAutoCorrectText() {
        val phrase = "Ce traumatisantdocteur était vraiment éprouvant!"
        val correction = "Ce traumatisant docteur était vraiment éprouvant!"
        assertEquals(correction, textCorrector.autoCorrect(phrase))
    }

    @Test
    fun canAutoCorrectTextWithPunctuation() {
        val phrase = "Ce traumatisantdocteur! Il était vraiment éprouvant!"
        val correction = "Ce traumatisant docteur! Il était vraiment éprouvant!"
        assertEquals(correction, textCorrector.autoCorrect(phrase))
    }

    @Test
    fun canAutoCorrectTextWithPunctuationAndCase() {
        val phrase = "Ce TraumatisantDocteur! Il était vraiment éprouvant!"
        val correction = "Ce Traumatisant Docteur! Il était vraiment éprouvant!"
        assertEquals(correction, textCorrector.autoCorrect(phrase))
    }
}