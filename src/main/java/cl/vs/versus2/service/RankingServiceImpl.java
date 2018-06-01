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

	@Override
	public void increaseElo(String email) {

		User winner = userRepository.findByEmail(email);

		winner.setWins(winner.getWins() + 1);
		// idea for change - increasedElo could be written once outside function
		int increasedElo = ((winner.getEloRating() + 400 * (winner.getWins() - winner.getLoses()))
				/ (winner.getWins() + winner.getLoses()));

		winner.setEloRating(increasedElo);
		userService.updateUser(winner);
	}

	@Override
	public void decreaseElo(String email) {
		User defeated = userRepository.findByEmail(email);
		defeated.setLoses(defeated.getLoses() + 1);

		int decreasedElo = ((defeated.getEloRating() + 400 * (defeated.getWins() - defeated.getLoses()))
				/ (defeated.getWins() + defeated.getLoses()));

		defeated.setEloRating(decreasedElo);

		userService.updateUser(defeated);
	}

}
