import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GestaoDeVeiculos implements ActionListener {
	

	JFrame janela = new JFrame();
	private int largura = 500, altura = 500;
	
	private JButton passeio = new JButton();
	private JButton carga = new JButton();
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void carregaJanela() {
		
		janela.setSize(largura, altura);
		passeio.setText("Passeio");
		carga.setText("Carga");
		janela.add(carga);
		janela.add(passeio);
		
		
		
		janela.setLayout(new GridBagLayout());
		janela.setVisible(true);
	}
}
