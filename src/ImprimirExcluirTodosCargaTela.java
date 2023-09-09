import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ImprimirExcluirTodosCargaTela extends JFrame {
	
	private static ImprimirExcluirTodosCargaTela imprimirExcluirTodosTela;
	int largura = 950, altura = 500;
	
	private String[] colunas = {"Placa", "Marca", "Modelo", "Cor", "Qtd. Rodas", "Veloc. Máx.", "Qtd. Pistões", "Potência", "Tara", "Carga Máx."};	
	private DefaultTableModel model = new DefaultTableModel(colunas, 0);
	
	private JTable tableDados = new JTable(model);
	private JScrollPane barraRolagem = new JScrollPane(tableDados);
	
	private JButton imprimirTodos = new JButton("Imprimir Todos");
	private JButton excluirTodos = new JButton("Excluir Todos");
	private JButton sair = new JButton("Sair");
	
	JPanel panelTable = new JPanel();
	JPanel panelButtons = new JPanel();
	JPanel panelPrincipal = new JPanel();
	
	private ImprimirExcluirTodosCargaTela() {
		super("Imprimir/Excluir todos");
		inicializaComponentes();
		setLocationRelativeTo(null);
	}
	
	public static ImprimirExcluirTodosCargaTela getImprimirExcluirTodosCargaTela() {
		if(imprimirExcluirTodosTela == null) {
			imprimirExcluirTodosTela = new ImprimirExcluirTodosCargaTela();
		}
		return imprimirExcluirTodosTela;
	}

	private void inicializaComponentes() {
		//setLayout(new GridLayout(2,1,10,10));
		setLayout(new BorderLayout());
		setSize(largura, altura);
		
		
		panelTable.setLayout(new GridLayout(1,1));
		//panelTable.setLayout(new BorderLayout());
		
		//panelTable.setBackground(Color.WHITE);
		panelTable.add(barraRolagem, BorderLayout.CENTER);
		
		getContentPane().add(panelTable);
		
//		imprimirTodos.setPreferredSize(new Dimension(250, 50));
//		excluirTodos.setPreferredSize(new Dimension(250, 50));
//		sair.setPreferredSize(new Dimension(250, 50));
		
		panelButtons.setLayout(new FlowLayout());
		panelButtons.add(imprimirTodos);
		panelButtons.add(excluirTodos);
		panelButtons.add(sair);
		
		getContentPane().add(panelButtons, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}

}
