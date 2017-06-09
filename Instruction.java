public class Instruction  {
	
	String ligne;
	int calcul;
	
	public Instruction(String l) {
		this.ligne = l;	
	}
	
	public int splitInstruction() {
		int res = -1;
		if (this.ligne.split(":",2)[0].equals("advance") && this.ligne.split(":",2)[1].equals("0")){
			res = 0;
		}
		else if (this.ligne.split(":",2)[0].equals("advance") && this.ligne.split(":",2)[1].equals("1")){
				res = 1;
		}
		else if (this.ligne.split(":",2)[0].equals("advance") && this.ligne.split(":",2)[1].equals("2")){
			res = 2;
		}
		else if (this.ligne.split(":",2)[0].equals("advance") && this.ligne.split(":",2)[1].equals("3")){
			res = 3;
		}
		else if (this.ligne.equals("detect")){
			res = 999;
		}
		return res;
	}
	
}


