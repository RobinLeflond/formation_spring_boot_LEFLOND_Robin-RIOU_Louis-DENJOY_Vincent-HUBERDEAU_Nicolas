package fr.epf.projetSpringBootLEFLOND_RIOU_HUBERDEAU_DENJOY.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class EscapeGame(@Id @GeneratedValue var id: Int? = null, var creator: String? = null, var name: String? = null, var description: String? = null, var note: Double? = null, var theme: String? = null, var nb_Notes: Int? = 0, var opening_date: String? = null, var address: String? = null) {

}