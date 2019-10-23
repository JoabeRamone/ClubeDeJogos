package clube.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AssociadoVideogameJogo implements IBaseEntity{

	
	private static final long serialVersionUID = 7028818992520258225L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
		
	@ManyToOne
	@JoinColumn(name = "associado_videogame_id")
	private AssociadoVideogame associadoVideogame;
	
	@Column 
	private String nomeJogo;
	
	@Enumerated(EnumType.STRING)
	@Column
	private Enum<JogoStatus> status = JogoStatus.DISPONIVEL;


	
	public AssociadoVideogameJogo() {
		
	}
	
	
	
	
	public AssociadoVideogameJogo(AssociadoVideogame associadoVideogame, String nomeJogo) {
		super();
		this.associadoVideogame = associadoVideogame;
		this.nomeJogo = nomeJogo;
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public AssociadoVideogame getAssociadoVideogame() {
		return associadoVideogame;
	}


	public void setAssociadoVideogame(AssociadoVideogame associadoVideogame) {
		this.associadoVideogame = associadoVideogame;
	}


	public String getNomeJogo() {
		return nomeJogo;
	}


	public void setNomeJogo(String nomeJogo) {
		this.nomeJogo = nomeJogo;
	}


	public Enum<JogoStatus> getStatus() {
		return status;
	}


	public void setStatus(Enum<JogoStatus> status) {
		this.status = status;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomeJogo == null) ? 0 : nomeJogo.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssociadoVideogameJogo other = (AssociadoVideogameJogo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomeJogo == null) {
			if (other.nomeJogo != null)
				return false;
		} else if (!nomeJogo.equals(other.nomeJogo))
			return false;
		return true;
	}
	
	
	
	
}
