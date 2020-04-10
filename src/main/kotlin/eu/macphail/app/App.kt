package eu.macphail.app

import eu.macphail.text.Dictionary
import eu.macphail.text.Text
import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.*
import tornadofx.*
import java.io.File
import java.nio.file.Paths

class MyController : Controller() {
    var dictionary: Dictionary? = null
    var text: Text? = null
    fun pickDictionary(file: File): Boolean {
        return if(file.exists() && file.isDirectory) {
            dictionary = Dictionary(file.canonicalPath)
            true
        } else {
            false
        }
    }

    private fun parseText(originText: String) {
        text = eu.macphail.text.parseText(originText)
    }

    fun autoCorrect(originText: String): String {
        parseText(originText)
        text = eu.macphail.text.autoCorrect(text!!, dictionary!!)
        return text!!.buildFromTokens()
    }

    fun cleanParagraphs(originText: String): String {
        return eu.macphail.text.cleanParagraphs(originText)
    }

    fun correctAndClean(originText: String): String {
        val correctedText = autoCorrect(originText)
        return cleanParagraphs(correctedText)
    }

}

class MasterView : View() {
    val controller: MyController by inject()
    var dictionaryPath = SimpleStringProperty()
    var textToFormat: TextArea by singleAssign()
    var resultText: TextArea by singleAssign()

    val defaultPath = "C:\\temp\\French-Dictionary\\dictionary"

    val exampleText = """Ce TraumatisantDocteur! Il était vraiment éprouvant!
Il faut dire que je ne l'avaisque peu connu.
J'habitais à New-York.
J'étaiscomme ça."""

    override val root = form {
        button("Choose Dictionary") {
            action {
                val file = chooseDirectory(initialDirectory = Paths.get(defaultPath).toFile())
                dictionaryPath.value = file!!.canonicalPath
                if(!controller.pickDictionary(file)) {
                    alert(Alert.AlertType.ERROR, "The selected directory does not exist")
                }
            }
        }
        fieldset {
            field("Selected dictionary path") {
                textfield(dictionaryPath)
            }
        }
        fieldset {
            field("Text") {
                textToFormat = textarea(exampleText)
            }
        }
        button("Autocorrect") {
            action {
                val result = controller.correctAndClean(textToFormat.text)
                resultText.text = result
            }
        }
        fieldset {
            field("Corrected Text") {
                resultText = textarea("")
            }
        }
    }
}

class MyApp : App(MasterView::class)

fun main(args: Array<String>) {
    launch<MyApp>(args)
}