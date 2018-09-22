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
    	          		results.add(result);
    	          		
    	          		printPlayers(players);
    	          		}
    	     }
    	     
    	     try {
    	    	 if(writeToFile) {
    	    		 File newFile = new File("C:\\Users\\Sukrit\\Desktop\\Cricket.json");
    	    	     
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
		
	
	for (Delivery delivery : inning.getDeliveries()) {
			if(inning.getInningsNumber()==1)
			{
				/*
				double score = calculateFirstScore(delivery, runs, delivery.getOver(), delivery.getBall());
				players.put(delivery.getBatsman(), players.get(delivery.getBatsman()) + score);			
				runs = runs + delivery.getRuns().getTotal();
				firstScores = firstScores+ score;*/
			}
				else	
			{
				double points = calculateScore(delivery, toWin, delivery.getOver(), delivery.getBall());
				players.put(delivery.getBatsman(), players.get(delivery.getBatsman()) + points);			
				toWin = toWin - delivery.getRuns().getTotal();
				secondScores = secondScores + points;
			}	
		
	}
	
	toWin = target;
	runs = 0;
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
	
	private static Double calculateScore(Delivery delivery, int target, Integer overNum, Integer ball) {
		if (ball>6)
			ball = 6;
		double over = convertOver(overNum, ball);
		double remaining = 50.17 - over;
		double RR = target/remaining;
		double RR_b = RR/6;
		double score=0.0;
		
		double factor = Math.sqrt((over/14.0)+0.5);
		
		score = factor * (delivery.getRuns().getBatsman() + 1 - RR_b);
		
		
		if(delivery.getBatsman().equals("MS Dhoni")) {
			System.out.println("Score given at "+over+" is "+score + ": RR_b is "+RR_b+" :factor is "+factor);
		}
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
