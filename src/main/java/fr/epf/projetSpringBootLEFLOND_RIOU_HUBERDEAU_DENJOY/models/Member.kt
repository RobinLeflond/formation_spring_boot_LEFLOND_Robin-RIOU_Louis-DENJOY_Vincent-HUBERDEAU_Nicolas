package fr.epf.projetSpringBootLEFLOND_RIOU_HUBERDEAU_DENJOY.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Member(@Id @GeneratedValue var id: Int? = null, var password: String? = null, var pseudo: String? = null) {

}

