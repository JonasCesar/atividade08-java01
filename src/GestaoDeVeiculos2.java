import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GestaoDeVeiculos2 {


	public void carregaJanela() {
		int largura = 310, altura  = 200;
		
		JFrame frameJanela = new JFrame("Gestão de Veículos");
		frameJanela.setLayout(new GridBagLayout());
		frameJanela.setSize(largura, altura);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1,0,10));
		panel.setSize(200, 200);
		
		JButton passeio = new JButton("    Passeio    ");
		JButton carga = new JButton("    Carga    ");		
		
		panel.add(passeio);
		panel.add(carga);
		
		frameJanela.getContentPane().add(panel);
				
		frameJanela.setVisible(true);
		frameJanela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		passeio.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				exibirMenuPasseio();				
			}		
		});
		
		carga.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				exibirMenuCarga();				
			}
		});
	}
	
	public void exibirMenuPasseio(){
		 JFrame frameMenuPasseio = new JFrame("Veículos de Passeio");
		 frameMenuPasseio.setLayout(new GridBagLayout());
		 frameMenuPasseio.setSize(310, 310);
		 
		 JPanel panel = new JPanel();
		 panel.setLayout(new GridLayout(4,1,0,10));
		 
		 JButton cadastrar = new JButton("Cadastrar");
		 JButton consultarExcluir = new JButton("Consultar/Excluir placa");
		 JButton imprimirExcluirTodos = new JButton("Imprimir/Excluir todos");
		 JButton sair = new JButton("Sair");
		 
		 
		 panel.add(cadastrar);
		 panel.add(consultarExcluir);
		 panel.add(imprimirExcluirTodos);
		 panel.add(sair);
		 
		 frameMenuPasseio.getContentPane().add(panel);		 		 
		 
		 frameMenuPasseio.setVisible(true);
		 frameMenuPasseio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 
		 //funcões botões
		 cadastrar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				exibirCadastroDePasseio();			
			}
		});
		 
		 sair.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				sair(frameMenuPasseio);			
			}			
		});
		 
	}
	
	public void exibirMenuCarga(){
		 JFrame frameMenuCarga = new JFrame("Veículos de Passeio");
		 frameMenuCarga.setLayout(new GridBagLayout());
		 frameMenuCarga.setSize(310, 310);
		 
		 JPanel panel = new JPanel();
		 panel.setLayout(new GridLayout(4,1,0,10));
		 
		 JButton cadastrar = new JButton("Cadastrar");
		 JButton consultarExcluir = new JButton("Consultar/Excluir placa");
		 JButton imprimirExcluirTodos = new JButton("Imprimir/Excluir todos");
		 JButton sair = new JButton("Sair");
		 
		 
		 panel.add(cadastrar);
		 panel.add(consultarExcluir);
		 panel.add(imprimirExcluirTodos);
		 panel.add(sair);
		 
		 frameMenuCarga.getContentPane().add(panel);		 		 
		 
		 frameMenuCarga.setVisible(true);
		 frameMenuCarga.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 
		//funcões botões
		 sair.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				sair(frameMenuCarga);			
			}			
		});
	}
	
	private void exibirCadastroDePasseio() {
		
		int tamanhoTextField = 15;
		
		JFrame frame = new JFrame("Cadastro de Passeio");
		frame.setLayout(new FlowLayout());
		frame.setSize(410, 410);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(9, 2));
		panel.setSize(410,410);

        JLabel qtdPassageirosLabel = new JLabel("Qtd. Passageiros:");
        JTextField qtdPassageirosField = new JTextField(tamanhoTextField);

        JLabel placaLabel = new JLabel("Placa: ");
        JTextField placaField = new JTextField(tamanhoTextField);

        JLabel marcaLabel = new JLabel("Marca: ");
        JTextField marcaField = new JTextField(tamanhoTextField);

        JLabel modeloLabel = new JLabel("Modelo: ");
        JTextField modeloField = new JTextField(tamanhoTextField);

        JLabel corLabel = new JLabel("Cor: ");
        JTextField corField = new JTextField(tamanhoTextField);

        JLabel qtdRodasLabel = new JLabel("Qtd. Rodas: ");
        JTextField qtdRodasField = new JTextField(tamanhoTextField);

        JLabel velocidadeMaximaLabel = new JLabel("Velocidade Máxima: ");
        JTextField velocidadeMaximaField = new JTextField(tamanhoTextField);

        JLabel qtdPistoesLabel = new JLabel("Qtd. Pistões: ");
        JTextField qtdPistoesField = new JTextField(tamanhoTextField);

        JLabel potenciaLabel = new JLabel("Potência: ");
        JTextField potenciaField = new JTextField(tamanhoTextField);
        
        panel.add(qtdPassageirosLabel);
        panel.add(qtdPassageirosField);
        panel.add(placaLabel);
        panel.add(placaField);
        panel.add(marcaLabel);
        panel.add(marcaField);
        panel.add(modeloLabel);
        panel.add(modeloField);
        panel.add(corLabel);
        panel.add(corField);
        panel.add(qtdRodasLabel);
        panel.add(qtdRodasField);
        panel.add(velocidadeMaximaLabel);
        panel.add(velocidadeMaximaField);
        panel.add(qtdPistoesLabel);
        panel.add(qtdPistoesField);
        panel.add(potenciaLabel);
        panel.add(potenciaField);		

		frame.getContentPane().add(panel);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void sair(JFrame jframe) {
		jframe.dispose();
	}
}
