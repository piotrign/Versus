package cl.vs.versus2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.vs.versus2.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);

	@Query("select u from User u ORDER BY eloRating DESC")
	User findAllOrderByEloRating();

}
