package cl.vs.versus2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.vs.versus2.entity.Tournament;

@Repository("torunamentRepository")
public interface TournamentRepository extends JpaRepository<Tournament, Long> {
	Tournament findById(int id);

	Tournament findByName(String name);

	@SuppressWarnings("unchecked")
	Tournament save(Tournament entity);

	void deleteById(int id);
}
