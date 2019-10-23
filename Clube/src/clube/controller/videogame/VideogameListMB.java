package clube.controller.videogame;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import clube.model.Videogame;
import clube.service.ClubeService;
import clube.service.IClubeService;

@ManagedBean
@ViewScoped
public class VideogameListMB implements Serializable {

	private static final long serialVersionUID = 8953220697722151516L;

	private IClubeService service = ClubeService.getInstance();

	private Videogame selectedVideogame;
	
	private List<Videogame> videogames;
	
	

	/**
	 * Em um managed bean, @PostConstruct é chamado após o construtor.
	 * 
	 * @PostConstruct é um contrato que garante que o método será invocado apenas
	 *                uma vez no ciclo de vida do MB. Pode acontecer (embora
	 *                improvável) que um MB seja instanciado várias vezes pelo pelo
	 *                contêiner em seu funcionamento interno, mas garante
	 *                que @PostConstruct será invocado apenas uma vez.
	 */
	@PostConstruct
	public void init() {
		videogames = service.listarVideogames();
	}

	public String editar(Videogame selectedVideogame) {
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("videogame", selectedVideogame);
		// modo alternativo
		//FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("videogame", selectedVideogame);
		return "form";
	}

	public String excluir(Videogame selectedVideogame) {
		
		service.removerVideogame(selectedVideogame.getId());
		videogames = service.listarVideogames();
		
		FacesMessage fm = new FacesMessage("Videogame excluído com sucesso!");
		FacesContext.getCurrentInstance().addMessage("Sucesso", fm);
		
		return null;
	}
	
	
	public String novo() {
		return "form";
	}


	// get and set
	public Videogame getSelectedVideogame() {
		return selectedVideogame;
	}

	public void setSelectedVideogame(Videogame selectedVideogame) {
		this.selectedVideogame = selectedVideogame;
	}



	public List<Videogame> getVideogames() {
		return videogames;
	}

	public void setVideogames(List<Videogame> videogames) {
		this.videogames = videogames;
	}
	
	
}
