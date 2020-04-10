package eu.macphail

import org.junit.Assert.assertEquals
import org.junit.Test

class WordTests {
    @Test
    fun canExtractBaseWord() {
        assertEquals("joli", "joli!".withoutPunctuation())
        assertEquals("joli", "-joli?".withoutPunctuation())
        assertEquals("joli", ",joli...".withoutPunctuation())
        assertEquals("joli", ",...joli".withoutPunctuation())
    }

    @Test
    fun canRestorePunctuation() {
        assertEquals("joli!", "joli".restorePunctuation("joli!"))
        assertEquals("!!hello!", "hello".restorePunctuation("!!joli!"))
    }
}

