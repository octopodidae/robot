import java.util.ArrayList;
import java.io.*;
public class Programme  {
	
	Instruction []tabInstruction; 
			
	public Programme(String fichierProgramme) throws FileNotFoundException, IOException {
		
		LectureFichier lf = new LectureFichier();
		ArrayList<String> programme;
		programme = lf.litFichier(fichierProgramme);
		String [] tabLigne = new String [programme.size()];
		tabInstruction = new Instruction [programme.size()];
		for (int i=0; i<tabInstruction.length; i++){
			tabLigne[i] = programme.get(i);
			tabInstruction[i] = new Instruction(tabLigne[i]);
		}	
	}
	
	public int executeProg(Instruction instruction){
		return instruction.splitInstruction();
	}
}


