package eu.macphail.text

data class Text(val originalText: String, val tokens: List<Token>) {
    fun buildFromTokens(): String {
        return tokens
            .map(Token::string)
            .joinToString(separator = "")
    }

    fun replaceToken(index: Int, newTokenValue: String): Text {
        return Text(
            originalText,
            tokens.take(index) + listOf(Token(index, newTokenValue)) + tokens.drop(
                index + 1
            )
        )
    }

    fun insertTokenAfter(index: Int, token: String): Text {
        return Text(
            originalText,
            tokens.take(index + 1) + listOf(
                Token(
                    index,
                    token
                )
            ) + tokens.drop(index + 1)
        )
    }

    fun appendToken(token: String): Text {
        return Text(
            originalText,
            tokens + listOf(Token(tokens.size, token))
        )
    }

    fun appendTokens(vararg tokens: String): Text {
        return tokens.fold(this) { t, token ->
            t.appendToken(token)
        }
    }
}

data class Token(val index: Int, val string: String) {

    private val regex = Regex("[A-Za-zÀ-ÖØ-öø-ÿ\\-]+")
    fun isWord(): Boolean = regex.matches(string)
}

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