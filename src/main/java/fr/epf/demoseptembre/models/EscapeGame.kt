package fr.epf.demoseptembre.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class EscapeGame(@Id @GeneratedValue var id: Int? =  null, var nom: String? = null, var theme: String?= null, var createur: Int? =  null,var note: Int? =  null) {

}