import java.awt.Color;

import javax.swing.JFrame;


public class Ventana extends JFrame{
	
	
	public Ventana(int x, int y, String titulo){
		this.setSize(x, y);
		this.setTitle(titulo);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
