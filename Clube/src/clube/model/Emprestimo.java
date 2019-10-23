package clube.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Emprestimo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
		
	@ManyToOne
	@JoinColumn(name = "associado_locatario_id")
	private Associado locatario;
	
	/** quem cede o jogo para o emprestimo */
 	@ManyToOne
	@JoinColumn(name = "associado_locador_id")
	private Associado locador;
	
 	@Temporal(TemporalType.DATE)
 	private Date data;
 	
 	
	@OneToMany(mappedBy = "emprestimo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<EmprestimoItem> jogos;
	
}
