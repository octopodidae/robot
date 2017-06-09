import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
public class LectureFichier{
  
  LectureFichier() {
	  
  }
   
  public static ArrayList<String> litFichier(String nom) 
    throws FileNotFoundException, IOException{
    BufferedReader br = new BufferedReader(new FileReader(nom));
    ArrayList<String> res = new ArrayList<String>();
    String lig;
    do{
      lig = br.readLine();
      if (lig != null){
        res.add(lig);
      }
    }while(lig != null);
    br.close();
    return res;
  }
}


