package cricket;

import org.junit.Assert;
import org.testng.annotations.Test;

public class CricketTest {
	
	@Test
	public void testScore() {
		YamlTesting obj = new YamlTesting();
		Double total = 0.0;
		Integer toWin = 300;
		int perBall = 1;
		for(int over = 0; over<50;over++) {
			for(int ball=1; ball<7;ball++) {
				Delivery delivery  = new Delivery();
				Runs runs = new Runs();
				//runs.setTotal(1);
				runs.setBatsman(perBall);
				delivery.setRuns(runs);
				Double score = obj.calculateScore(delivery, toWin, over, ball);
				score= score/4.4114;
				total = total +score;
				toWin = toWin-perBall;
				System.out.println("Score for "+ over+":"+ball+" target:"+toWin+" is " + score);
			}
		}
		System.out.println("Total is "+total);
		//Assert.assertTrue(score > 0);
	}

}
