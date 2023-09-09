import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VeiculoCargaTela extends JFrame{
	
private static VeiculoCargaTela veiculoCargaTela;
	
	int largura = 310, altura  = 310;	
	
	//Botões
	 JButton cadastrar = new JButton("Cadastrar");
	 JButton consultarExcluir = new JButton("Consultar/Excluir placa");
	 JButton imprimirExcluirTodos = new JButton("Imprimir/Excluir todos");
	 JButton sair = new JButton("Sair");
	
	JPanel panel = new JPanel();
	
	private VeiculoCargaTela() {
		super("Veículos de Carga");
		inicializaComponentes();
		setLocationRelativeTo(null);
	}
	
	public static VeiculoCargaTela getVeiculoPasseioTela() {
		if(veiculoCargaTela == null) {
			veiculoCargaTela = new VeiculoCargaTela();
		}
		return veiculoCargaTela;
	}
	
	private void inicializaComponentes() {
		
		setLayout(new GridBagLayout());
		setSize(310, 310);
		
		panel.setLayout(new GridLayout(4,1,0,10));
		
		panel.add(cadastrar);
		panel.add(consultarExcluir);
		panel.add(imprimirExcluirTodos);
		panel.add(sair);
		
		getContentPane().add(panel);	
				
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//funcões botões
		 cadastrar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				CadastroCargaTela.getCadastroCargaTela().setVisible(true);;		
			}
		});
		 
		consultarExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ConsultarExcluirCargaTela.getConsultarExcluirCargaTela().setVisible(true);
				
			}
		});
		
		imprimirExcluirTodos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ImprimirExcluirTodosCargaTela.getImprimirExcluirTodosCargaTela().setVisible(true);
				
			}
		});
		 
		 sair.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();		
			}			
		});
	}

}
