package clube.dao;

import clube.model.Videogame;
import util.dao.GenericDAO;

public class VideogameDAO extends GenericDAO<Videogame, Long> {

	public VideogameDAO() {
		super(Videogame.class);
	}
	
	
}
