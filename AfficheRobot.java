public interface AfficheRobot{
	/**
	* Initialise la représentation interne du terrain
	* d'après le tableau de carcatères tab.
	* @param tab matrice de caractères qui représente le terrain.
	*/
	void initialiser(char[][] tab);
	
	/**
	* Modifie avec c le contenu de la case de coordonnées x,t du terrain.
	* Cette méthode n'éffectue pas d'affichage.
	* @param x
	* @param y
	* @param c
	*/
	void changerCase(int x, int y, char c);
	
	/**
	* Affiche l'état courant du terrain d'après sa représentation interne.
	*/
	void afficher();
	
	/**
	* Finalisation des affichages.
	*/
	void terminer();
	
}
