package cl.vs.versus2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.vs.versus2.entity.User;
import cl.vs.versus2.repository.UserRepository;

@Service
public class RankingServiceImpl implements RankingService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	public void increaseElo(String email) {
		User winner = userRepository.findByEmail(email);
		winner.setWins(winner.getWins() + 1);
		winner.setEloRating(changeElo(winner));
		userService.updateUser(winner);
	}

	public void decreaseElo(String email) {
		User defeated = userRepository.findByEmail(email);
		defeated.setLoses(defeated.getLoses() + 1);
		defeated.setEloRating(changeElo(defeated));
		userService.updateUser(defeated);
	}

	public int changeElo(User user) {
		return user.getEloRating() 
				+ ((400 * (user.getWins() - user.getLoses())) / (user.getWins() + user.getLoses()));
	}

}
