package cricket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileReplace {

	List<String> lines = new ArrayList<String>();
    String line = null;

    public void  doIt(File f1) {
        try {
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
            	for(int i=0;i<=52; i++) {
            		for(int j=1;j<=6;j++) {
            			if (line.contains(i+"."+j+":"))
                            line = line.replace(i+"."+j+":", "over"+":"+i+"."+j);
            		}
            	}
                
                lines.add(line);
            }
            fr.close();
            br.close();

            FileWriter fw = new FileWriter(f1);
            BufferedWriter out = new BufferedWriter(fw);
            for(String s : lines)
                 out.write(s);
            out.flush();
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
