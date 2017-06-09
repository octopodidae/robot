public class ITRobot implements AfficheRobot{
	
	char[][] matrice;
		
	// Constructeur
	public ITRobot() {
	}
	
	// Initialiser
	public void initialiser(char[][] tab){
	matrice = new char[tab.length][tab[0].length];
	matrice = tab;
	}

	public void changerCase(int x, int y, char c){
		matrice[x][y]=c;
    }
	
	public void afficher(){
		for (int i=0; i<matrice.length; i++){
				System.out.println("\t\t\t");
				for (int j=0; j<matrice[0].length; j++){
					System.out.print(matrice[i][j] + " ");
				}
				System.out.print(" ");
			}
		System.out.println(" ");
    }
	
	public void terminer(){
		System.out.println("\nFin du programme");
	}
}
