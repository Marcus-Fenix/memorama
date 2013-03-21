import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Memoria extends Ventana{
	
	private JButton botones[][];
	private String imagenes[] = {"scr/imagenes/CANADA.JPG","scr/imagenes/CHILE.JPG","scr/imagenes/CHINA.JPG","scr/imagenes/EU.JPG","scr/imagenes/MEXICO.JPG"};
	private JPanel panelBotones;
	Random generador = new Random();
	private int hola = 0;

	public Memoria(int x, int y, String titulo) {
		super(x, y, titulo);
		// TODO Auto-generated constructor stub
		
	}
	
	public void HacerBotones(){
	
		panelBotones = new JPanel();
		botones = new JButton[ 5 ][ 5 ];
		panelBotones.setLayout( new GridLayout( botones.length , botones[0].length) );

		Icon imagenes1;
		for ( int y = 0; y < botones.length; y++ )
			for ( int x = 0; x < botones[0].length; x++ ) 
			{
				hola = generador.nextInt(imagenes.length);
				imagenes1 = createImageIcon(imagenes[hola]);
				botones[ y ][ x ] = new JButton(imagenes1);
				Dimension tamanoGema = new  Dimension(imagenes1.getIconHeight(),imagenes1.getIconWidth());
				botones[ y ][ x ].setPreferredSize(tamanoGema);
				panelBotones.add( botones[ y ][ x ] );
			}
		add(panelBotones,BorderLayout.CENTER);
	}
	
	protected ImageIcon createImageIcon(String nombreGema) 
	{

		java.net.URL imgURL = getClass().getResource("scr/imagenes/" +nombreGema);

		//si encuentra en la carpeta la imagen indicada

		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			//Cuando no encuentra la imagen           
			return new ImageIcon(getClass().getResource("scr/imagenes/MEXICO.JPG"));
			
		}
	}
	

}

