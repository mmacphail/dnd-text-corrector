package eu.macphail

data class Text(val originalText: String, val tokens: List<Token>) {
    fun buildFromTokens(): String {
        return tokens
            .map(Token::string)
            .joinToString(separator = "")
    }

    fun replaceToken(index: Int, newTokenValue: String): Text {
        return Text(originalText,
            tokens.take(index) + listOf(Token(index, newTokenValue)) + tokens.drop(index + 1)
            )
    }

    fun insertTokenAfter(index: Int, token: String): Text {
        return Text(originalText,
            tokens.take(index + 1) + listOf(Token(index, token)) + tokens.drop(index + 1)
        )
    }
}

data class Token(val index: Int, val string: String)

fun parseText(text: String): Text {
    val regex = Regex("([^A-Za-zÀ-ÖØ-öø-ÿ\\-]*)([A-Za-zÀ-ÖØ-öø-ÿ\\-]+)([^A-Za-zÀ-ÖØ-öø-ÿ\\-]*)(\\s*)")
    val tokens = regex
        .findAll(text)
        .flatMap { match ->
            match.groupValues
                .drop(1)
                .filter { it.isNotEmpty() }
                .asSequence()
        }
        .mapIndexed { index, string -> Token(index, string) }
        .toList()
    return Text(text, tokens)
}