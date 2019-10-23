package clube.controller.videogame;

import java.io.Serializable;

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
public class VideogameMB implements Serializable{

	private static final long serialVersionUID = 7376834516863092920L;

	private IClubeService service = ClubeService.getInstance();
	
	private Videogame videogame;
	

	@PostConstruct
	public void init() {
		videogame = (Videogame) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("videogame");
		// modo alternativo
		//videogame = (Videogame) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("videogame");
		
		if(videogame == null)
			videogame = new Videogame();
	}
	
	public String salvar() {
		
		service.salvarVideogame(videogame);
		
		FacesMessage fm = new FacesMessage("Videogame salvo com sucesso!");
		FacesContext.getCurrentInstance().addMessage("Sucesso", fm);
		
		return null;
	}

	public Videogame getVideogame() {
		return videogame;
	}

	public void setVideogame(Videogame videogame) {
		this.videogame = videogame;
	}

}
