import java.util.ArrayList;
import java.io.*;
public class Robot {

	Programme thisProg;
	private int positionX;
	private int positionY;
	private boolean etat;
	int totalMinerai;
	int temps;
		
	// Constructeur
	Robot(String fileProg) throws FileNotFoundException, IOException {
		positionX = -1;
		positionY = -1;
		thisProg = new Programme(fileProg);
		etat = true;
		totalMinerai = 0;
	}
	
	// Afficher quantité minerai extrait
	public void afficherScore() {
		System.out.println("Score : " + totalMinerai + " tonnes de minerai extrait");
	}
	
	// Get etat
	public boolean getEtat() {
		return this.etat;
	}

	// Set etat
	public void setEtat(boolean b) {
		this.etat = b;
	}
	
	// Get PositionX 
	public int getPositionX() {
		return positionX;
	}
	
	// Get PositionY 
	public int getPositionY() {
		return positionY;
	}
	
	// set PositionX 
	public void setPositionX(int x) {
		positionX = x;
	}
	
	// Set PositionY 
	public void setPositionY(int y) {
		positionY = y;
	}
	
	// Calculer la coordonnée X de destination
	public int calculerCoordX(int direction){
		switch (direction) { // calculer coordonnées X destination
			case 0: // advance:0 (nord)
				return positionX;
			case 1: // advance:1 (est)
				return positionX+1;
			case 2: // advance:2 (sud)
				return positionX;
			case 3: // advance:0 (ouest)
				return positionX-1;
			default:
				return -1;
		}
	}
	
	// Calculer la coordonnée Y de destination
	public int calculerCoordY(int direction){
		switch (direction) { // calculer coordonnées Y destination
			case 0: // advance:0 (nord)
				return positionY-1;
			case 1: // advance:1 (est)
				return positionY;
			case 2: // advance:2 (sud)
				return positionY+1;
			case 3: // advance:0 (ouest)
				return positionY;
			default:
				return -1;
		}
	}
	
	// Changer la position du robot;
	void vaVers(int direction) {
		switch(direction) {
			case 0: // va vers nord
				positionY = positionY - 1;
				break;
			case 1: // va vers est
				positionX = positionX + 1;
				break;
			case 2: // va vers sud
				positionY = positionY + 1;
				break;
			case 3: // va vers ouest
				positionX = positionX - 1;
				break;
		}
	}
	
	// Get String direction
	public String getStrDirection(int direction){
		switch (direction) { 
			case 0: // advance:0 (nord)
				return "nord";
			case 1: // advance:1 (est)
				return "est";
			case 2: // advance:2 (sud)
				return "sud";
			case 3: // advance:0 (ouest)
				return "ouest";
			default:
				return "Erreur direction";
		}
	}

}