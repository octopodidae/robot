import java.util.ArrayList;
import java.io.*;
public class Terrain {

	Robot monRobot;
	Case [][] tabCase;
	AfficheRobot af;
	int temps = 0;
	static int tempsMax = 200;
	
	// Constructeur
	public Terrain(String fichierTerrain, Robot r, AfficheRobot iaf)  throws FileNotFoundException, IOException {
		
		// On stocke le contenu du fichier terrain.txt dans un ArrayList<String>
		// Utilisation du constructeur et de la méthode litFichier(String nom) de la classe LectureFichier 
		LectureFichier lf = new LectureFichier();
		ArrayList<String> terrain;
		terrain = lf.litFichier(fichierTerrain);
		
		// A partir de l'ArrayList<String>, on initialise un tableau de char à  deux dimensions
		char [][] tabChar;
		tabChar=new char[terrain.size()][];
		for (int i=0; i<tabChar.length; i++){
			tabChar[i]=terrain.get(i).toCharArray();
		}
				
		// Initialise l'objet du type AfficheRobot
		af = iaf;
		af.initialiser(tabChar);
		
		// A partir du tableau de char à  deux dimensions, on initialise un tableau à  deux dimensions de type Case
		tabCase = new Case [tabChar.length][tabChar[0].length];
		for (int i = 0; i<tabChar.length; i++){
			for (int j=0; j<tabChar[0].length; j++){
				if (tabChar[i][j] == ' '){
					tabCase[i][j] = new Case(' ', r);
				}
				else if (tabChar[i][j] == '*'){
					tabCase[i][j] = new Case('*', r);
				}
				else if (tabChar[i][j] == '$'){
					tabCase[i][j] = new Case('$', r);
				}
				else if (tabChar[i][j] == '#'){
					tabCase[i][j] = new Case('#', r);
				}
				else if (tabChar[i][j] == 'A'){
					monRobot = r;
					tabCase[i][j] = new Case('A', monRobot);
					monRobot.setPositionX(j);
					monRobot.setPositionY(i);
					monRobot.totalMinerai = 0;
				}
			}
		}
	}
	
	// Detect
	public void detect(){
		int xDest, yDest; // Coordonnées destination
		for (int i = 0; i < 4; i++) { // i=0 pour nord, i=1 pour est, i=2 pour sud, i=3 pour ouest 
			xDest = monRobot.calculerCoordX(i);
			yDest = monRobot.calculerCoordY(i);
			if (tabCase[yDest][xDest].estLibre() && i == 0)
				System.out.println("La case au nord est libre");
			else if (tabCase[yDest][xDest].estEau() && i == 0)
				System.out.println("La case au nord contient de l'eau");
			else if (tabCase[yDest][xDest].estMinerai() && i == 0)
				System.out.println("La case au nord contient du minerai");
			else if (tabCase[yDest][xDest].estRoche() && i == 0)
				System.out.println("La case au nord contient de la roche");
			else if (tabCase[yDest][xDest].estLibre() && i == 1)
				System.out.println("La case a l'est est libre");
			else if (tabCase[yDest][xDest].estEau() && i == 1)
				System.out.println("La case a l'est contient de l'eau");
			else if (tabCase[yDest][xDest].estMinerai() && i == 1)
				System.out.println("La case a l'est contient du minerai");
			else if (tabCase[yDest][xDest].estRoche() && i == 1)
				System.out.println("La case a l'est contient de la roche");
			else if (tabCase[yDest][xDest].estLibre() && i == 2)
				System.out.println("La case au sud est libre");
			else if (tabCase[yDest][xDest].estEau() && i == 2)
				System.out.println("La case au sud contient de l'eau");
			else if (tabCase[yDest][xDest].estMinerai() && i == 2)
				System.out.println("La case au sud contient du minerai");
			else if (tabCase[yDest][xDest].estRoche() && i == 2)
				System.out.println("La case au sud contient de la roche");
			else if (tabCase[yDest][xDest].estLibre() && i == 3)
				System.out.println("La case a l'ouest est libre");
			else if (tabCase[yDest][xDest].estEau() && i == 3)
				System.out.println("La case a l'ouest contient de l'eau");
			else if (tabCase[yDest][xDest].estMinerai() && i == 3)
				System.out.println("La case a l'ouest contient du minerai");
			else if (tabCase[yDest][xDest].estRoche() && i == 3)
				System.out.println("La case a l'ouest contient de la roche");
		}
	}

	// Déplacer robot
	public void deplacerRobot(int direction) throws TimeOut, RobotCoule{
		String strDirection = monRobot.getStrDirection(direction);
		int xDest, yDest; // Coordonnées destination
		xDest = monRobot.calculerCoordX(direction);
		yDest = monRobot.calculerCoordY(direction);
		if (direction == 999) {
			System.out.println("============================================\n\t\t   DETECT\n============================================");
			this.detect();
			System.out.println("============================================");
		}
		else if (tabCase[yDest][xDest].estLibre()){ // case destination vide
			System.out.println("\nDeplacement vers " + strDirection);
			tabCase[monRobot.getPositionY()][monRobot.getPositionX()].libererCase(); // on libère la case d'origine
			af.changerCase(monRobot.getPositionY(), monRobot.getPositionX(), ' ');
			monRobot.vaVers(direction);
			af.changerCase(monRobot.getPositionY(), monRobot.getPositionX(), 'A');
			tabCase[monRobot.getPositionY()][monRobot.getPositionX()].recevoirRobot(); // on reçoit le robot sur case
			temps++; // déplacement = 1 unité de temps
			if (temps > tempsMax) {
				throw new TimeOut();
			}
		} 
		else if (tabCase[yDest][xDest].estEau()){ // case destination contient eau	
			System.out.println("\nDeplacement vers " + strDirection);
			af.changerCase(monRobot.getPositionY(), monRobot.getPositionX(), ' ');
			monRobot.setEtat(false);
			af.afficher();
			throw new RobotCoule();
		}		
		else if (tabCase[yDest][xDest].estMinerai()) { // case destination contient minerai					
			System.out.println("\nDeplacement vers " + strDirection + "\n\nExtraction minerai");
			tabCase[monRobot.getPositionY()][monRobot.getPositionX()].libererCase(); // on libÃ¨re la case d'origine
			af.changerCase(monRobot.getPositionY(), monRobot.getPositionX(), ' ');
			monRobot.vaVers(direction);
			monRobot.totalMinerai = monRobot.totalMinerai + tabCase[monRobot.getPositionY()][monRobot.getPositionX()].quantiteMinerai; // ajout quantité minerai contenu dans la case dans variable monRobot.totalMinerai
			tabCase[monRobot.getPositionY()][monRobot.getPositionX()].extraire(); // on extrait le minerai
			af.changerCase(monRobot.getPositionY(), monRobot.getPositionX(), 'A');
			temps = temps + 3; // extraction = 3 unités de temps
			if (temps > tempsMax) {
				throw new TimeOut();
			}
		}	
		else if (tabCase[yDest][xDest].estRoche()){ // Déplacement impossible - obstacle montagne
			System.out.println("\nDeplacement vers " + strDirection + " impossible - obstacle montagne");
		}
	}
}


	