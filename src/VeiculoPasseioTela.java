import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VeiculoPasseioTela extends JFrame {

	private static VeiculoPasseioTela veiculoPasseioTela;

	int largura = 310, altura = 305;

	// Botões
	JButton cadastrar = new JButton("Cadastrar");
	JButton consultarExcluir = new JButton("Consultar/Excluir placa");
	JButton imprimirExcluirTodos = new JButton("Imprimir/Excluir todos");
	JButton sair = new JButton("Sair");

	JPanel panel = new JPanel();

	private VeiculoPasseioTela() {
		super("Veículos de Passeio");
		inicializaComponentes();
		setLocationRelativeTo(null);
	}

	public static VeiculoPasseioTela getVeiculoPasseioTela() {
		if (veiculoPasseioTela == null) {
			veiculoPasseioTela = new VeiculoPasseioTela();
		}
		return veiculoPasseioTela;
	}

	private void inicializaComponentes() {

		setLayout(new GridBagLayout());
		setSize(largura, altura);

		panel.setLayout(new GridLayout(4, 1, 0, 10));

		panel.add(cadastrar);
		panel.add(consultarExcluir);
		panel.add(imprimirExcluirTodos);
		panel.add(sair);

		getContentPane().add(panel);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// funcões botões
		cadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CadastroPasseioTela.getCadastroPasseioTela().setVisible(true);
			}
		});

		consultarExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ConsultarExcluirPasseioTela.getConsultarExcluirPasseioTela().setVisible(true);

			}
		});
		
		imprimirExcluirTodos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ImprimirExcluirTodosPasseioTela.getImprimirExcluirTodosPasseioTela().setVisible(true);
				
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
