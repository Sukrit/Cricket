package cricket;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class YamlTesting {
	
	private static boolean writeToFile = true;
	private static int MATCH = 0;
	private static int NO_MATCH =0;
	
    public static void main(String[] args) {
        //ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
       try {
    	   
    	   List<Result> results = new ArrayList<Result>();
    	   List<File> files = new ArrayList<File>();
     	   
    	   readFromDir(files);
    	   //readFromFile(files);
    	   
    	   
    	   //File[] directoryListing = dir.listFiles();
    	   //if (directoryListing != null) {
    	     for (File child : files) {
    	       // Do something with child
    	    	 ObjectMapper xmlMapper = new XmlMapper();
    	        	
    	        	cricsheet match = xmlMapper.readValue(child, cricsheet.class); // deserializing
    	        	
    	        	if(!match.getInfo().getMatch_type().equals("ODI")) {
    	        		continue;
    	        	}
    	        	
    	        	 Map<String, Double> players = calculateScores(match);
    	             
    	             if(match.getInfo().getMatch_type().equals("ODI")) {
    	          		Result result  = new Result();
    	          		result.setPlayers(players);
    	          		result.setCity(match.getInfo().getCity());
    	          		result.setDate(match.getInfo().getDates().get(0));
    	          		result.setWinner(match.getInfo().getOutcome().getWinner());
    	          		result.setTeams(match.getInfo().getTeams());
    	          		results.add(result);
    	          		
    	          		printPlayers(players);
    	          		System.out.println("Matching:"+MATCH+" Not Matching:"+NO_MATCH);
    	          		}
    	     }
    	     
    	     try {
    	    	 if(writeToFile) {
    	    		 File newFile = new File("C:\\Users\\Sukrit\\Desktop\\Cricket\\Cricket.json");
    	    	     
    	    		 ObjectMapper mapper = new ObjectMapper();

    	            // Serialize Java object info JSON file.
    	            mapper.writeValue(newFile, results);
    	    	 }
    	        } catch (IOException e) {
    	            e.printStackTrace();
    	        }

    	     
    	   //} 
        	//InputStream file = new FileInputStream("C:\\Users\\Sukrit\\workspace\\cricket\\src\\main\\resources\\518959.xml");
        	
        	
        	//ObjectMapper xmlMapper = new XmlMapper();
        	
        	//cricsheet match = xmlMapper.readValue(file, cricsheet.class); // deserializing
            
        	
            
          
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    private static void readFromFile(List<File> files) {
    	File dir = new File("C:\\Users\\Sukrit\\Desktop\\Cricket\\cricsheet-xml-master\\cricsheet-xml-master\\data\\5\\589309.xml");
  	   files.add(dir);
    }
    
    private static void readFromDir(List<File> files) {
		String dir = "C:\\Users\\Sukrit\\Desktop\\Cricket\\cricsheet-xml-master\\cricsheet-xml-master\\data\\";
 	   
 	   listf(dir, files);
		
	}

	private static void listf(String directoryName, List<File> files) {
        File directory = new File(directoryName);

        // Get all the files from a directory.
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                files.add(file);
            } else if (file.isDirectory()) {
                listf(file.getAbsolutePath(), files);
            }
        }
    }

	private static Map<String, Double> calculateScores(cricsheet match) {
	
	int target = getTarget(match);
	int toWin = target;
	int runs = 0;
	double firstScores = 0.0;
	double secondScores = 0.0;
	System.out.println("Target is "+target);
	Map<String, Double> players = new HashMap<String, Double>();
	
	for(Inning inning : match.getInnings()) {
		if(inning.getInningsNumber()==2) {
			populatePlayers(players, inning);
		}
	}
	
	for(Inning inning : match.getInnings()) {
		
		if(inning.getInningsNumber()==1)
			continue;
		else {
			
			int lastOver = 0;
			int lastBall = 0;
	for (Delivery delivery : inning.getDeliveries()) {
			
			
				/*
				double score = calculateFirstScore(delivery, runs, delivery.getOver(), delivery.getBall());
				players.put(delivery.getBatsman(), players.get(delivery.getBatsman()) + score);			
				runs = runs + delivery.getRuns().getTotal();
				firstScores = firstScores+ score;*/
				
			
				double points = calculateScore(delivery, toWin, delivery.getOver(), delivery.getBall());
				players.put(delivery.getBatsman(), players.get(delivery.getBatsman()) + points);			
				toWin = toWin - delivery.getRuns().getTotal();
				secondScores = secondScores + points;
				lastOver = delivery.getOver();
				lastBall = delivery.getBall();
		
	}
	
	if(inning.getDeliveries().size()<300 && toWin>0) { //penalty for not playing out full quota
		
		double dummyToWin = toWin;
		double RR = dummyToWin/(50.17 - convertOver(lastOver, lastBall));
		double RR_b = RR/6.0;
		Double negativeSum = 0.0;
		while(lastOver!=50) {
			lastBall++;
			if(lastBall>6) {
				lastBall=1;
				lastOver++;
			}
		if(lastOver==50)
			break;
		Delivery dummy = new Delivery();
		Runs dummyRuns = new Runs();
		dummyRuns.setBatsman(-1);
		dummy.setRuns(dummyRuns);
		double negScore = calculateScore(dummy,dummyToWin, lastOver, lastBall);
		negativeSum = negativeSum + negScore;
		dummyToWin = dummyToWin - RR_b;
		}
		secondScores = secondScores+negativeSum;
		
		
		for(String playerS:players.keySet()) {
			players.put(playerS, players.get(playerS) + negativeSum/10.0);
		}
	}
	if(toWin>0) {
		if(secondScores > 200) {
			NO_MATCH++;
			System.out.println("NO MATCH score is:"+secondScores);
		}
		else {
			System.out.println("MATCH score is:"+secondScores);
			MATCH++;
		}
	}
	else {
		if(secondScores > 200) 
		{
			System.out.println("MATCH score is:"+secondScores);
			MATCH++;
		}
		else
		{
			System.out.println("NO MATCH score is:"+secondScores);
			NO_MATCH++;
		}
	}
	toWin = target;
	runs = 0;
	}
	
	}
	System.out.println("First inning score is "+firstScores + " Second inning score is "+secondScores);
	
	
	return players;
	
	}
	
	private static Double calculateFirstScore(Delivery delivery, int runs, Integer overNum, Integer ball) {
		if (ball>6)
			ball = 6;
		double over = convertOver(overNum, ball);
		double RR = 0.0;
		if(runs==0)
			RR=6.0;
		else
			RR = runs/over;
		
		double RR_b = RR/6;
		double score=0.0;
		
		double factor = Math.pow(over, 0.5)/3;
		
		score = factor * (delivery.getRuns().getBatsman() + 0.5  - RR_b);
		
		return score;
	}
	
	public static Double calculateScore(Delivery delivery, double ToWin, Integer overNum, Integer ball) {
		if (ball>6)
			ball = 6;
		double over = convertOver(overNum, ball);
		double remaining = 50.17 - over;
		double RR = ToWin/remaining;
		double RR_b = RR/6;
		double score=0.0;
		
		double factor = Math.sqrt((over/14.0)+0.5);
		
		score = factor * (delivery.getRuns().getBatsman() +1 - RR_b);
		
		/*
		if(delivery.getBatsman().equals("MS Dhoni")) {
			System.out.println("Score given at "+over+" is "+score + ": RR_b is "+RR_b+" :factor is "+factor);
		}
		*/
		return score;
	}

	private static void printPlayers(Map<String, Double> players) {
		System.out.println(Arrays.asList(players)); 
	}

	private static double convertOver(Integer over, Integer ball) {
		return (over + ball/6.0);
	}

	private static void populatePlayers(Map<String, Double> players, Inning inning) {
		
		for (Delivery delivery : inning.getDeliveries()) {
			if(!players.containsKey(delivery.getBatsman())) {
				players.put(delivery.getBatsman(), new Double(0.0));
			}
		}
	}

	private static int getTarget(cricsheet match) {
		/*String tossWin = match.getInfo().getToss().getWinner();
		String decision = match.getInfo().getToss().getDecision();
		String teamSecond = match.getInfo().getTeams().get(0);
		String teamFirst = match.getInfo().getTeams().get(1);
		
		if(decision=="field") {
			if(teamSecond != tossWin) { //exchange teams;
				String temp = teamSecond;
				teamSecond = teamFirst;
				teamFirst = temp;
			}
		} else {
			if(teamFirst != tossWin) { //exchange teams;
				String temp = teamSecond;
				teamSecond = teamFirst;
				teamFirst = temp;
			}
		}*/
		
		int total = 0;
		for(Inning inning :match.getInnings()) {
			if(inning.getInningsNumber()==1) {
				for(Delivery delivery :inning.getDeliveries()) {
					total = total + delivery.getRuns().getTotal();
				}
			}
		}
	
		return total;
	}

}
