package cl.vs.versus2.repository;

import java.awt.print.Book;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.vs.versus2.entity.Tournament;

@Repository("torunamentRepository")
public interface TournamentRepository extends JpaRepository<Tournament, Long> {
	Tournament findById(int id);

	Tournament findByName(String name);

	@SuppressWarnings("unchecked")
	Tournament save(Tournament entity);

	@Transactional
	void deleteById(int id);
	
//	@Query("select u.owned from User u where u.id like ?1")
//	Set<Book> findTournamentParticipantByTournamentId(long id);
}
