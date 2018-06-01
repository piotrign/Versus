package cl.vs.versus2.service;

public interface RankingService {

	public void increaseElo(String email);

	public void decreaseElo(String email);

}
