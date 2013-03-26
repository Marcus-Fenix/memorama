import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Memoria extends Ventana implements Runnable,MouseListener,ActionListener{
	
	private JButton botones[][],facil,normal,dificil;
	private String imagenes[] = {"CANADA.JPG","CHILE.JPG","CHINA.JPG","EU.JPG","MEXICO.JPG"};
	private String imagenes0[] = {"BLANCO.jpg"};
	private JPanel panelBotones;
	Random generador = new Random();
	private int hola = 0,aux,auy,score;
	private JLabel tiempo,nombre,ganaste;
	private Thread reloj;
	private boolean jugada = true;
	private Icon imagenes1,imagenes2;
	int seg = 0, min = 0, horas = 0;

	public Memoria(int x, int y, String titulo) {
		super(x, y, titulo);
		// TODO Auto-generated constructor stub
		this.setLayout(null);
		
		panelBotones = new JPanel();
		botones = new JButton[ 6 ][ 6 ];
		panelBotones.setLayout( new GridLayout( botones.length , botones[0].length) );
		
		nombre = new JLabel("JUEGO DE MEMORIA");
		nombre.setBounds(200, 100, 300, 100);;
		nombre.setForeground(Color.blue);
		nombre.setFont(new java.awt.Font("Forte", 0, 20));
		add(nombre);
///////////////////////facil///////////////////////////////////////////////////////
		facil = new JButton("Facil");
		facil.setBounds(50, 200, 150, 30);
		facil.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 20));
		facil.setForeground(Color.red);
		facil.setBackground(Color.black);
		add(facil);
		facil.addMouseListener(new MouseListener(){
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Ventana ventana;
				ventana = new Ventana(600,600,"JUEGO");
				ventana.setVisible(true);
				String imagenes[] = {"CANADA.JPG","CHILE.JPG"};
				for ( int y1 = 0; y1 < botones.length; y1++ )
					for ( int x1 = 0; x1 < botones[0].length; x1++ ){
						hola = generador.nextInt(imagenes.length);
						imagenes2 = createImageIcon(imagenes0[0]);
						botones[ y1 ][ x1 ] = new JButton(imagenes2);
						botones[y1][x1].setName(imagenes[hola]);
						Dimension tamanoGema = new  Dimension(imagenes2.getIconHeight(),imagenes2.getIconWidth());
						botones[ y1 ][ x1 ].setPreferredSize(tamanoGema);
						agregarAccion(botones[y1][x1],x1,y1);
						panelBotones.add( botones[ y1 ][ x1 ] );
					}
				ventana.add(panelBotones,BorderLayout.CENTER);
				ventana.add(tiempo,BorderLayout.SOUTH);
				reloj.start();
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
			});
/////////////////////////////normal/////////////////////////////////////////////////
		normal = new JButton("Normal");
		normal.setBounds(50, 250, 150, 30);
		normal.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 20));
		normal.setForeground(Color.red);
		normal.setBackground(Color.black);
		add(normal);
        normal.addMouseListener(new MouseListener(){
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Ventana ventana;
				ventana = new Ventana(600,600,"JUEGO");
				ventana.setVisible(true);
				String imagenes[] = {"CANADA.JPG","CHILE.JPG","MEXICO.JPG"};
				for ( int y1 = 0; y1 < botones.length; y1++ )
					for ( int x1 = 0; x1 < botones[0].length; x1++ ){
						hola = generador.nextInt(imagenes.length);
						imagenes2 = createImageIcon(imagenes0[0]);
						botones[ y1 ][ x1 ] = new JButton(imagenes2);
						botones[y1][x1].setName(imagenes[hola]);
						Dimension tamanoGema = new  Dimension(imagenes2.getIconHeight(),imagenes2.getIconWidth());
						botones[ y1 ][ x1 ].setPreferredSize(tamanoGema);
						agregarAccion(botones[y1][x1],x1,y1);
						panelBotones.add( botones[ y1 ][ x1 ] );
					}
				ventana.add(panelBotones,BorderLayout.CENTER);
				ventana.add(tiempo,BorderLayout.SOUTH);
				reloj.start();
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
			});
/////////////////////////////dificil//////////////////////////////////////////////
		dificil = new JButton("Dificil");
		dificil.setBounds(50, 300, 150, 30);
		dificil.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 20));
		dificil.setForeground(Color.red);
		dificil.setBackground(Color.black);
		add(dificil);
		dificil.addMouseListener(new MouseListener(){
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Ventana ventana;
				ventana = new Ventana(600,600,"JUEGO");
				ventana.setVisible(true);
				String imagenes[] = {"CANADA.JPG","CHILE.JPG","CHINA.JPG","EU.JPG","MEXICO.JPG"};
				for ( int y1 = 0; y1 < botones.length; y1++ )
					for ( int x1 = 0; x1 < botones[0].length; x1++ ){
						hola = generador.nextInt(imagenes.length);
						imagenes2 = createImageIcon(imagenes0[0]);
						botones[ y1 ][ x1 ] = new JButton(imagenes2);
						botones[y1][x1].setName(imagenes[hola]);
						Dimension tamanoGema = new  Dimension(imagenes2.getIconHeight(),imagenes2.getIconWidth());
						botones[ y1 ][ x1 ].setPreferredSize(tamanoGema);
						agregarAccion(botones[y1][x1],x1,y1);
						panelBotones.add( botones[ y1 ][ x1 ] );
					}
				ventana.add(panelBotones,BorderLayout.CENTER);
				ventana.add(tiempo,BorderLayout.SOUTH);
				reloj.start();
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
			});
////////////////////////////////////////////////////////////////////////////////////
		this.tiempo = new JLabel();
		reloj = new Thread(this);
		//reloj.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(seg < 59){
				if(seg == 59){
					seg = 0; 
					min ++;
				}
				if(min == 59){
					min = 0;
					horas ++;
				}
				seg++;
				this.tiempo.setText("Tiempo  "+min+" : "+seg+"           "+"SCORE: "+score);
				reloj.sleep(1000);
			}
			Ventana ventana;
			ventana = new Ventana(300,200,"PERDISTE");
			ventana.setVisible(true);
			ventana.add(ganaste = new JLabel("PERDISTE INTENTALO DE NUEVO"));
			//System.exit(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public void agregarAccion(final JButton boton,final int x, final int y){
		boton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evento){
					if(jugada){
						System.out.println(x+" "+y);
						imagenes1 = createImageIcon(botones[y][x].getName());
						botones[ y ][ x ].setIcon(imagenes1);
						aux = x;
						auy = y;
						jugada = false;
					}
					else{
						imagenes1 = createImageIcon(botones[y][x].getName());
						botones[ y ][ x ].setIcon(imagenes1);
						if(botones[y][x].getName() == botones[auy][aux].getName()){
							if(x == aux && y == auy){
								imagenes2 = createImageIcon(imagenes0[0]);
								botones[y][x].setIcon(imagenes2); 
							}
							else{
								botones[y][x].setEnabled(false);
								botones[auy][aux].setEnabled(false);
								score+=100;
								if(score >= 1800){
									Ventana ventana;
									ventana = new Ventana(300,200,"GANASTE");
									ventana.setVisible(true);
									ventana.add(ganaste = new JLabel("FELICIDADES GANASTE"));
									reloj.stop();
								}
							}
						}
						else{
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							imagenes2 = createImageIcon(imagenes0[0]);
							botones[ auy ][ aux ].setIcon(imagenes2);
							botones[ y ][ x ].setIcon(imagenes2);
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

