package eu.macphail

import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.streams.asSequence

class Dictionary() {

    private val words: Set<String>

    init {
        val path: String? = System.getenv("DICTIONARY_PATH")
        if (path == null) throwSetupException()
        val files = Files.list(Paths.get(path!!)).asSequence()
        this.words = files
            .map(Path::toFile)
            .filter { it.isFile }
            .flatMap(this::readDictionaryFile)
            .map(this::keepWordOnly)
            .toSet()
    }

    private fun readDictionaryFile(file: File): Sequence<String> {
        val lines = file.inputStream().bufferedReader().use { it.readLines() }
        return lines.asSequence()
    }

    private fun keepWordOnly(it: String): String {
        val parts = it.split(";")
        return parts[0]
    }

    fun isWord(word: String): Boolean = words.contains(word.toLowerCase())

    private fun throwSetupException() {
        throw RuntimeException(
            "Environment variable 'DICTIONARY_PATH' must be initialized. " +
                    "Clone this dictionary: https://github.com/hbenbel/French-Dictionary and use " +
                    "the /dictionary path"
        )
    }

    fun autoSpace(words: String): List<Pair<String, String>> = words.possibleSubWords(this)
}

private fun String.possibleSubWords(dictionary: Dictionary): List<Pair<String, String>> {
    if (isBlank() || length == 1) return listOf()
    return (1..length)
        .map { substring(0, it) to substring(it, length) }
        .filter { dictionary.isWord(it.first) and dictionary.isWord(it.second) }
}
