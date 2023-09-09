import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CadastroCargaTela extends JFrame{
	
	private static CadastroCargaTela cadastroCargaTela;
	//largura altura
	int largura = 410, altura = 325;
	int tamanhoTextField = 15;
			
	//Botões
	JLabel taraLabel = new JLabel("Tara: ");
    JTextField taraField = new JTextField(tamanhoTextField);
    
    JLabel cargaMaxLabel = new JLabel("Carga Máx.: ");
    JTextField cargaMaxField = new JTextField(tamanhoTextField);

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
    
    JButton cadastrar = new JButton("Cadastrar");
    JButton limpar = new JButton("Limpar");
    JButton novo = new JButton("Novo");
    JButton sair = new JButton("Sair");
	
	//Jpanel
	JPanel panelForm = new JPanel();
	JPanel panelButtons = new JPanel();
	
	private CadastroCargaTela() {
		super("Cadastro de Carga");
		inicializaComponentes();
		setLocationRelativeTo(null);
	}
	
	public static CadastroCargaTela getCadastroCargaTela() {
		if(cadastroCargaTela == null) {
			cadastroCargaTela = new CadastroCargaTela();
		}
		return cadastroCargaTela;
	}

	private void inicializaComponentes() {
		
		setLayout(new FlowLayout());
		setSize(largura, altura);
		
		//panel form
		panelForm.setLayout(new GridLayout(10, 2, 0, 5));
		
		panelForm.add(taraLabel);
        panelForm.add(taraField);
        panelForm.add(cargaMaxLabel);
        panelForm.add(cargaMaxField);
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
        panelButtons.add(cadastrar);
        panelButtons.add(limpar);
        panelButtons.add(novo);
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
