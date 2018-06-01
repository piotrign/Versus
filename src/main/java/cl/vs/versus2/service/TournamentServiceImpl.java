package cl.vs.versus2.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import cl.vs.versus2.entity.User;

@Service("tournamentService")
public class TournamentServiceImpl {

	@PersistenceContext
	EntityManager entityManager;
	
	public List<User> getAllTournaments() {
		Query query = entityManager.createQuery("SELECT t FROM Tournament t");
		@SuppressWarnings("unchecked")
		List<User> allTournaments = query.getResultList();
		System.out.println(allTournaments.toString());
		return allTournaments;
	}
	
}
