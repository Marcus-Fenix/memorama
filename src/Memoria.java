import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Memoria extends Ventana implements Runnable,MouseListener{
	
	private JButton botones[][];
	private String imagenes[] = {"CANADA.JPG","CHILE.JPG","CHINA.JPG","EU.JPG","MEXICO.JPG"};
	private JPanel panelBotones;
	Random generador = new Random();
	private int hola = 0,aux,auy;
	private JLabel tiempo;
	private Thread reloj;
	private boolean jugada = true;

	public Memoria(int x, int y, String titulo) {
		super(x, y, titulo);
		// TODO Auto-generated constructor stub
		
		panelBotones = new JPanel();
		botones = new JButton[ 4 ][ 4 ];
		panelBotones.setLayout( new GridLayout( botones.length , botones[0].length) );

		Icon imagenes1;
		for ( int y1 = 0; y1 < botones.length; y1++ )
			for ( int x1 = 0; x1 < botones[0].length; x1++ ){
				hola = generador.nextInt(imagenes.length);
				imagenes1 = createImageIcon(imagenes[hola]);
				botones[ y1 ][ x1 ] = new JButton(imagenes1);
				botones[y1][x1].setName(imagenes[hola]);
				Dimension tamanoGema = new  Dimension(imagenes1.getIconHeight(),imagenes1.getIconWidth());
				botones[ y1 ][ x1 ].setPreferredSize(tamanoGema);
				agregarAccion(botones[y1][x1],x1,y1);
				panelBotones.add( botones[ y1 ][ x1 ] );
			}
		add(panelBotones,BorderLayout.CENTER);
		this.tiempo = new JLabel();
		add(tiempo,BorderLayout.SOUTH);
		reloj = new Thread(this);
		reloj.start();
		
	}
	
	void agregarAccion(final JButton boton,final int x, final int y){
		boton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evento){
					
					if(jugada){
						System.out.println(botones[y][x].getName());
						aux = x;
						auy = y;
						jugada = false;
					}
					else{
						if(botones[y][x].getName() == botones[auy][aux].getName()){
							System.out.println("iguales");
						}
						jugada = true;
					}
				}
		});
	}
	
	protected ImageIcon createImageIcon(String nombreGema) 
	{

		java.net.URL imagenesURL = getClass().getResource("imagenes/" +nombreGema);

		//si encuentra en la carpeta la imagen indicada

		if (imagenesURL != null) {
			return new ImageIcon(imagenesURL);
		} else {
			//Cuando no encuentra la imagen           
			return new ImageIcon(getClass().getResource("imagenes/MEXICO.JPG"));
			
		}
	}

	int seg = 0, min = 0, horas = 0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true){
				if(seg == 59){
					seg = 0; 
					min ++;
				}
				if(min == 59){
					min = 0;
					horas ++;
				}
				seg++;
				this.tiempo.setText("Tiempo  "+min+" : "+seg);
				reloj.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("hola");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

