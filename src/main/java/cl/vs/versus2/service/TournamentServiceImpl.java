package cl.vs.versus2.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cl.vs.versus2.entity.Tournament;
import cl.vs.versus2.entity.User;
import cl.vs.versus2.repository.TournamentRepository;
import cl.vs.versus2.repository.UserRepository;

@Service("tournamentService")
public class TournamentServiceImpl implements TournamentService {

	@Autowired
	TournamentRepository tournamentRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Value("${spring.queries.users-query}")
	private String usersQuery;
	
	@PersistenceContext
	EntityManager entityManager;

	public List<User> getAllTournament() {
		Query query = entityManager.createQuery("SELECT t FROM Tournament t");
		@SuppressWarnings("unchecked")
		List<User> allTournaments = query.getResultList();
		System.out.println(allTournaments.toString());
		return allTournaments;
	}
	
	public void addUserToTournament(Tournament tournament, User user){
		user = userRepository.findById(user.getId());
		
		Set<User> tournamentParticipants = new HashSet<User>();
		tournament.setParticipant(tournamentParticipants);
		
	}

}
