package cl.vs.versus2.service;

import cl.vs.versus2.entity.User;

public interface RankingService {

	public void increaseElo(String email);

	public void decreaseElo(String email);

	public int changeElo(User user);
}
