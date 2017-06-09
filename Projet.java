import java.io.*;
import java.util.ArrayList;

public class Projet {
	public static void main(String[] args)  throws Exception, RobotCoule {
		
		char mode, mode2;
		AfficheRobot AF = new ITRobot ();
		
		try {
			System.out.print("\nMode texte (t) ou graphique (g)? : \n");
			mode = Terminal.lireChar();
			if (mode=='g'){
			  IGRobot IGR = new IGRobot();
			   AF=IGR;
			} else {
			  AF = new ITRobot();
			}
			Robot R = new Robot(args[1]);
			Terrain ter  = new Terrain(args[0], R, AF);
			System.out.print("\nMode Interactif (o/n) ? : \n");
			mode2 = Terminal.lireChar();
			
			AF.afficher();
			
			for (int i = 0; i < R.thisProg.tabInstruction.length; i++) {
				if (mode2=='o')
					temporise();
				else
					temporise2(1000);
				ter.deplacerRobot(R.thisProg.executeProg(R.thisProg.tabInstruction[i]));
				AF.afficher();
			}
									
			R.afficherScore();
			temporise();			
			AF.terminer();
					
		} catch (FileNotFoundException e) {
			System.out.println("\nLe fichier n'existe pas");
		} catch (IOException e) {
			System.out.println("\nIOException");
		} catch (RobotCoule e) {
			System.out.println("\nVotre robot coule\nGame Over !!");
			AF.terminer();
		}
		catch (TimeOut e) {
			System.out.println("\nTime out\nGame Over !!");
			AF.terminer();
		}
	}
		
	/*
	temporiser
	*/
	
	static void temporise(){ //mode interactif
		Terminal.ecrireStringln("\nAppuyer sur la touche \"entree\"\n");
		Terminal.lireString();
	}
	
	static void temporise2 (int t) { //mode non-interactif
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
}
