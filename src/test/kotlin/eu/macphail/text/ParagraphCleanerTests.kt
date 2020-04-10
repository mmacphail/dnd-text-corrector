package eu.macphail.text

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ParagraphCleanerTests {
    @Test
    fun shouldBeSingeLine() {
        assertEquals(expectedCleanedText, cleanParagraphs(exampleText))
        assertEquals(expectedCleanedText2, cleanParagraphs(exampleText2))
    }

    @Test
    fun isAllCaps() {
        assertTrue("LA MAGIE DU KI".isAllCaps())
    }

    val exampleText = """Ses poings semblables à un tourbillon tandis qu'elle détourne
la pluie de flèches qui s'abat sur elle, une demi-elfe bondit par-
dessus une barricade et se jette dans les rangs des hobgobelins
massés derrière. Elle tournoie parmi eux, déviant leurs coups,
et les envoie à terre un par un, jusqu'à ce qu'il ne reste plus
qu'elle debout.
Un humain couvert de tatouages inspire profondément et
prend une pose de combat. Alors que les premiers orcs de
la charge l'atteignent, il souffle : une boule de feu jaillit de sa
bouche et enveloppe ses adversaires.
Une halfeline vêtue de noir se déplace aussi silencieusement
qu'une ombre. Elle pénètre dans l'obscurité qui s'étend sous
une arche et ressort d'une autre ombre d'un noir d'encre, sur
un balcon, à un jet de pierre. Elle tire sa lame de son fourreau
enveloppé d'un tissu et observe le prince tyrannique à travers la
fenêtre ouverte. Il est si vulnérable en plein sommeil.
Quelle soit leur discipline de prédilection, tous les moines
partagent une même capacité à rassembler par magie les
énergies qui coulent dans leur corps. Qu'ils les canalisent
pour exécuter des prouesses martiales époustouflantes ou les
concentrent plus discrètement au profit de leur défense et de
leur vitesse, elles imprègnent tous leurs mouvements."""

    val expectedCleanedText = """Ses poings semblables à un tourbillon tandis qu'elle détourne la pluie de flèches qui s'abat sur elle, une demi-elfe bondit par-dessus une barricade et se jette dans les rangs des hobgobelins massés derrière. Elle tournoie parmi eux, déviant leurs coups, et les envoie à terre un par un, jusqu'à ce qu'il ne reste plus qu'elle debout.
Un humain couvert de tatouages inspire profondément et prend une pose de combat. Alors que les premiers orcs de la charge l'atteignent, il souffle : une boule de feu jaillit de sa bouche et enveloppe ses adversaires.
Une halfeline vêtue de noir se déplace aussi silencieusement qu'une ombre. Elle pénètre dans l'obscurité qui s'étend sous une arche et ressort d'une autre ombre d'un noir d'encre, sur un balcon, à un jet de pierre. Elle tire sa lame de son fourreau enveloppé d'un tissu et observe le prince tyrannique à travers la fenêtre ouverte. Il est si vulnérable en plein sommeil. Quelle soit leur discipline de prédilection, tous les moines partagent une même capacité à rassembler par magie les énergies qui coulent dans leur corps. Qu'ils les canalisent pour exécuter des prouesses martiales époustouflantes ou les concentrent plus discrètement au profit de leur défense et de leur vitesse, elles imprègnent tous leurs mouvements."""

    val exampleText2 = """Quelle soit leur discipline de prédilection, tous les moines
partagent une même capacité à rassembler par magie les
énergies qui coulent dans leur corps. Qu'ils les canalisent
pour exécuter des prouesses martiales époustouflantes ou les
concentrent plus discrètement au profit de leur défense et de
leur vitesse, elles imprègnent tous leurs mouvements.
LA MAGIE DU KI
Les moines étudient assidûment une énergie magique que la
plupart des traditions monacales appellent le ki. Cette énergie
est un élément de la magie qui imprègne le multivers, à savoir
celui qui coule au travers des corps vivants. Les moines puisent
dans ce pouvoir interne pour créer des effets magiques et
dépasser les limites physiques de leur corps. Une partie de
leurs attaques spéciales sont capables d'arrêter le flux du
ki chez leurs adversaires. Grâce à cette énergie, les moines
dotent leurs attaques à mains nues d'une vitesse et d'une
force surnaturelle. Plus ils gagnent en expérience, plus leur
entraînement martial et leur maîtrise du ki leur permettent de
maîtriser leur corps et celui de leurs ennemis."""

    val expectedCleanedText2 = """Quelle soit leur discipline de prédilection, tous les moines partagent une même capacité à rassembler par magie les énergies qui coulent dans leur corps. Qu'ils les canalisent pour exécuter des prouesses martiales époustouflantes ou les concentrent plus discrètement au profit de leur défense et de leur vitesse, elles imprègnent tous leurs mouvements. 
LA MAGIE DU KI
Les moines étudient assidûment une énergie magique que la plupart des traditions monacales appellent le ki. Cette énergie est un élément de la magie qui imprègne le multivers, à savoir celui qui coule au travers des corps vivants. Les moines puisent dans ce pouvoir interne pour créer des effets magiques et dépasser les limites physiques de leur corps. Une partie de leurs attaques spéciales sont capables d'arrêter le flux du ki chez leurs adversaires. Grâce à cette énergie, les moines dotent leurs attaques à mains nues d'une vitesse et d'une force surnaturelle. Plus ils gagnent en expérience, plus leur entraînement martial et leur maîtrise du ki leur permettent de maîtriser leur corps et celui de leurs ennemis."""
}