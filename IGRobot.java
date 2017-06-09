import java.awt.*;
import javax.swing.*;
import java.util.*;

class SpecialPanel extends JPanel{
    char[][] matrice;
    Color blanc = Color.white;
    Color noir = new Color(150,120,120);
    private HashMap<Character,ImageIcon>  images;
    SpecialPanel(char[][]  je, HashMap<Character,ImageIcon> im){
		matrice = je;
		images = im;
    }
    public void paintComponent(Graphics g) {
		super.paintComponent(g);  
		for (int i=0; i<matrice.length; i++){
			for (int j=0; j<matrice[0].length; j++){
			images.get(matrice[i][j]).paintIcon(this,g,j*48,i*48);
			}
		}
    }
}

public class IGRobot extends JFrame implements AfficheRobot{
   	private char[][] matrice;
    private HashMap<Character,ImageIcon>  images;
    private SpecialPanel jpane;
	public IGRobot(){
		images = new  HashMap<Character,ImageIcon>();
		this.associerCharImage(' ',"r-sand.png");
		this.associerCharImage('*',"r-rock.png");
		this.associerCharImage('#',"r-water.png");
		this.associerCharImage('$',"r-coal.png");
		this.associerCharImage('A',"r-robot.png");
    }
	
	public void initialiser(char[][]  je){
		if (matrice != null)
			throw new FenetreExisteDeja();
		matrice = new char[je.length][je[0].length];
		matrice = je;
		this.setTitle("Terrain");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jpane = new SpecialPanel(matrice, images);
		this.setContentPane(jpane);
		jpane.setPreferredSize(new Dimension(matrice[0].length*48,matrice.length*48));
		jpane.setBackground(Color.black);
		this.pack();
		this.setVisible(true);
    }
	
	public void changerCase(int x, int y, char c){
		matrice[x][y]=c;
    }
   
	public void associerCharImage(char c, String s){
		images.put(c,new ImageIcon("images/" + s));
	}
	
	public void afficher(){
		jpane.repaint();
	}
	
	public void terminer(){
		this.dispose();
	}
}
class FenetreExisteDeja extends RuntimeException{}

