package clube.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
		@NamedQuery(name = "Associado.encontrarPorId_fullList", query = "SELECT a from Associado a LEFT JOIN FETCH a.videogames v LEFT JOIN FETCH v.jogos j  where a.id= :id") })
// 
public class Associado implements IBaseEntity {

	private static final long serialVersionUID = -2664894933372487877L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String telefone;

	@Column(nullable = false)
	private String endereco;

	@OneToMany(mappedBy = "associado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<AssociadoVideogame> videogames;

	public Associado() {
		this.videogames = new HashSet<AssociadoVideogame>();
	}

	public Associado(String nome, String telefone, String endereco) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public Associado(String nome, String telefone, String endereco, Videogame videogame) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.videogames = new HashSet<AssociadoVideogame>();

		AssociadoVideogame avg = new AssociadoVideogame(this, videogame);
		this.videogames.add(avg);
	}

	public AssociadoVideogame addVideogame(Videogame videogame) {
		AssociadoVideogame avg = new AssociadoVideogame(this, videogame);
		this.videogames.add(avg);
		
		return avg;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Set<AssociadoVideogame> getVideogames() {
		return videogames;
	}

	public void setVideogames(Set<AssociadoVideogame> videogames) {
		this.videogames = videogames;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Associado other = (Associado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
		

}
