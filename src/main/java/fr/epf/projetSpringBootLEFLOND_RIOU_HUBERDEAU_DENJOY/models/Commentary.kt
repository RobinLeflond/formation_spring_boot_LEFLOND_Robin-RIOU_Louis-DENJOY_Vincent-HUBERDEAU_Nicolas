package fr.epf.projetSpringBootLEFLOND_RIOU_HUBERDEAU_DENJOY.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Commentary(@Id @GeneratedValue var id: Int? = null, var comment: String? = null, var author: String? = null, var escape_game: String? = null, var note: Double? = null) {

}
