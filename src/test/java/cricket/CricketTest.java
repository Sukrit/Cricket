package cricket;

import org.junit.Assert;
import org.testng.annotations.Test;

public class CricketTest {
	
	@Test
	public void testScore() {
		YamlTesting obj = new YamlTesting();
		Delivery delivery  = new Delivery();
		Runs runs = new Runs();
		runs.setTotal(1);
		delivery.setRuns(runs);
		Double score = obj.calculateScore(delivery, 300, 1, 1);
		System.out.println("Score is " + score);
		Assert.assertTrue(score > 0);
	}

}
