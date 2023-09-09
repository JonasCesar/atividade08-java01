import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GestaoDeVeiculos extends JFrame{
	
	static GestaoDeVeiculos gestaoDeVeiculos;
	
	int largura = 310, altura  = 150;
	
	//Botões
	JButton passeio = new JButton("    Passeio    ");
	JButton carga = new JButton("    Carga    ");
	
	JPanel panel = new JPanel();
	
	private GestaoDeVeiculos() {
		super("Gestão de Veículos");
		inicializarComponentes();
		setLocationRelativeTo(null);
	}
	
	public static GestaoDeVeiculos getGestaoDeVeiculos() {
		if(gestaoDeVeiculos == null) {
			gestaoDeVeiculos = new GestaoDeVeiculos();
		}
		return gestaoDeVeiculos;
	}
	
	private void inicializarComponentes(){
		
		setLayout(new GridBagLayout());
		setSize(largura, altura);
		
		panel.add(passeio);
		panel.add(carga);
		
		getContentPane().add(panel);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		passeio.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				VeiculoPasseioTela.getVeiculoPasseioTela().setVisible(true);;		
			}		
		});
		
		carga.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				VeiculoCargaTela.getVeiculoPasseioTela().setVisible(true);				
			}
		});
	}
	
}
