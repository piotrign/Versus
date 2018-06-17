package cl.vs.versus2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import cl.vs.versus2.entity.User;
import cl.vs.versus2.service.RankingServiceImpl;

public class EloMethodTest {

	private RankingServiceImpl rankingService;
	
	@Before
	public void setupRankingService() {
		rankingService = new RankingServiceImpl(); 
	}
	
	@Test
	public void shouldCorrectlyAdjustElo() {
		//given
		User testUser = new User();
		testUser.setId(9000);
		testUser.setEmail("test1@test.pl");
		testUser.setEloRating(1200);
		testUser.setWins(40);
		testUser.setLoses(30);
		//when
		int expectedChange = rankingService.changeElo(testUser);
		//then
		assertEquals(1257, expectedChange);		
	}
	
	@Test
	public void shouldCorrectlyAdjustEloScenario2() {
		//given
		User testUser2 = new User();
		testUser2.setId(1337);
		testUser2.setEmail("test2@test.pl");
		testUser2.setEloRating(1200);
		testUser2.setWins(60);
		testUser2.setLoses(50);
		//when
		int expectedChange = rankingService.changeElo(testUser2);
		//given
		assertEquals(1236, expectedChange);
	}
	
}
