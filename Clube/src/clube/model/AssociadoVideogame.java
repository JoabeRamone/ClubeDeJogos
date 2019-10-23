package clube.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class AssociadoVideogame implements IBaseEntity {

	private static final long serialVersionUID = -2081967611462916697L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "associado_id")
	private Associado associado;
	
	@ManyToOne
	@JoinColumn(name = "videogame_id")
	private Videogame videogame;
	
	@OneToMany(mappedBy = "associadoVideogame", cascade = CascadeType.ALL)
    private Set<AssociadoVideogameJogo> jogos;

	
	
	public AssociadoVideogame() {
	
	}
	
	public AssociadoVideogame(Associado associado, Videogame videogame) {
		super();
		this.associado = associado;
		this.videogame = videogame;
		this.jogos = new HashSet<AssociadoVideogameJogo>();
	}

	
	public void addJogo(String nomeJogo) {
		this.jogos.add(new AssociadoVideogameJogo(this, nomeJogo));
	}
	
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}

	public Videogame getVideogame() {
		return videogame;
	}

	public void setVideogame(Videogame videogame) {
		this.videogame = videogame;
	}

	public Set<AssociadoVideogameJogo> getJogos() {
		return jogos;
	}

	public void setJogos(Set<AssociadoVideogameJogo> jogos) {
		this.jogos = jogos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		AssociadoVideogame other = (AssociadoVideogame) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
