package fr.epf.demoseptembre.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * Cette classe utilise Kotlin (parce qu'on est grave des Hipsters).
 * La "data class" représente un "POJO" (plain-old java object), c'est à dire un objet qui n'est destiné qu'à "représenter" une entité.
 * Ici, en l'occurence, un utilisateur.
 * @author Loïc Ortola on 10/09/2018
 */
@Entity
data class EscapeGame(@Id @GeneratedValue var id: Int? =  null, var createur: String? = null, var nom: String? = null, var description: String?= null, var note: Double? = null, var theme: String? = null, var nombreNotes: Int? = 0, var date_ouverture: String?= null) {

}