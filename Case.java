public class Case {

	// Variables
	char natureTerrain;
	Robot robot;
	int quantiteMinerai;
	
	// Constructeur
	Case(char nt, Robot r) {
		natureTerrain = nt;
		robot = r;
		if (natureTerrain == '$')
			this.quantiteMinerai = 100;
		else
			this.quantiteMinerai = 0;
	}
	
	// Départ du robot de la case (on libère la case)
	public void libererCase() {
		this.natureTerrain = ' ';
	}
	
	// Arrivé du robot sur la case
	public void recevoirRobot() {
		this.natureTerrain = 'A';
	}
	
	// Extraction minerai
	public void extraire() {
		this.libererCase();
		this.recevoirRobot();
	}
	
	// Case est libre
	public boolean estLibre() {
		boolean libre = false;
		if (this.natureTerrain == ' ') 
			libre = true;
		return libre;
	}
	
	// Case est eau
	public boolean estEau()  {
		boolean eau = false;
		if (this.natureTerrain == '#')
			eau = true;
		return eau;
	}
	
	// Case est minerai
	public boolean estMinerai()  {
		boolean minerai = false;
		if (this.natureTerrain == '$')
			minerai = true;
		return minerai;
	}
	
	// Case est roche (montagne)
	public boolean estRoche()  {
		boolean roche = false;
		if (this.natureTerrain == '*')
			roche = true;
		return roche;
	}
}