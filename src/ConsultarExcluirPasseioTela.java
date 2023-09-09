import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConsultarExcluirPasseioTela extends JFrame{
	
	private static ConsultarExcluirPasseioTela consultarExcluirPasseioTela;
	//largura altura
	int largura = 410, altura = 325;
	int tamanhoTextField = 15;
	
	JLabel informeAPlacaLabel = new JLabel("INFORME A PLACA: ");
    JTextField informeAPlacaField = new JTextField(tamanhoTextField);
	
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
    
    //Botões
    JButton consultar = new JButton("Consultar");
    JButton excluir = new JButton("Excluir");    
    JButton sair = new JButton("Sair");
	
	//Jpanel
	JPanel panelForm = new JPanel();
	JPanel panelButtons = new JPanel();
	
	private ConsultarExcluirPasseioTela() {
		super("Cadastro de Passeio");
		inicializaComponentes();
		setLocationRelativeTo(null);
	}
	
	public static ConsultarExcluirPasseioTela getConsultarExcluirPasseioTela() {
		if(consultarExcluirPasseioTela == null) {
			consultarExcluirPasseioTela = new ConsultarExcluirPasseioTela();
		}
		return consultarExcluirPasseioTela;
	}

	private void inicializaComponentes() {
		
		setLayout(new FlowLayout());
		setSize(largura, altura);
		
		//panel form		
		panelForm.setLayout(new GridLayout(10, 2, 0, 5));
		
		informeAPlacaLabel.setForeground(Color.RED);
		
		panelForm.add(informeAPlacaLabel);
        panelForm.add(informeAPlacaField);
		panelForm.add(qtdPassageirosLabel);
        panelForm.add(qtdPassageirosField);
        panelForm.add(placaLabel);
        panelForm.add(placaField);
        panelForm.add(marcaLabel);
        panelForm.add(marcaField);
        panelForm.add(modeloLabel);
        panelForm.add(modeloField);
        panelForm.add(corLabel);
        panelForm.add(corField);
        panelForm.add(qtdRodasLabel);
        panelForm.add(qtdRodasField);
        panelForm.add(velocidadeMaximaLabel);
        panelForm.add(velocidadeMaximaField);
        panelForm.add(qtdPistoesLabel);
        panelForm.add(qtdPistoesField);
        panelForm.add(potenciaLabel);
        panelForm.add(potenciaField);
        
        getContentPane().add(panelForm);
        
        panelButtons.setLayout(new GridLayout(1,4, 3, 0));
        panelButtons.add(consultar);
        panelButtons.add(excluir);        
        panelButtons.add(sair);
        
        getContentPane().add(panelButtons);
        
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //funções botões
        sair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sair();				
			}
		});
		
	}
	
	private void sair() {
		dispose();
	}

}
