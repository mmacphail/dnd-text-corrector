package eu.macphail

import org.junit.Assert.*
import org.junit.Test
import java.lang.Exception

class DictionaryTests {
    val dictionary = Dictionary()

    @Test
    fun isInDictionary() {
        assertTrue(dictionary.isWord("chaise"))
        assertTrue(dictionary.isWord("bateau"))
        assertTrue(dictionary.isWord("élévation"))
        assertTrue(dictionary.isWord("grâce"))
        assertTrue(dictionary.isWord("traumatisant"))
        assertTrue(dictionary.isWord("docteur"))
        assertTrue(dictionary.isWord("Docteur"))
        assertFalse(dictionary.isWord("câvition"))
        assertFalse(dictionary.isWord("cigarquillon"))
    }

    @Test
    fun autoSpaceWords() {
        assertEquals("bien que", dictionary.autoSpace("bienque").firstResult())
        assertEquals("traumatisant docteur", dictionary.autoSpace("traumatisantdocteur").firstResult())
        //assertEquals("alors que", dictionary.autoSpace("alorsque"))
    }
}

private fun List<Pair<String, String>>.firstResult(): String {
    if(isEmpty() || size < 1) throw Exception(if(isEmpty()) "more than one result" else "no results")
    return first().let { "${it.first} ${it.second}" }
}
