import java.util.Iterator;
import java.util.List;

public class Teste {	
	
	private static Leitura leitura = new Leitura();

	public static void main(String[] args) {
		
		BDVeiculos bdVeiculos = new BDVeiculos();
		
		boolean continua = true;
		int opcao = 0;
		
		while(continua) {
			
			System.out.println("\n=====================================================\n");
			
			System.out.println("Sistema de Gestão de Veículos - Menu Inicial\n");
			
			System.out.println("1. Cadastrar Veículo de Passeio");
			System.out.println("2. Cadastrar Veículo de Carga");
			System.out.println("3. Imprimir todos os Veículos de Passeio ");
			System.out.println("4. Imprimir todos os Veículos de Carga");
			System.out.println("5. Imprimir Veículo de Passeio pela Placa");
			System.out.println("6. Imprimir Veículo de Carga pela Placa");
			System.out.println("7. Excluir Veículo de Passeio pela Placa");
			System.out.println("8. Excluir Veículo de Carga pela Placa");
			System.out.println("9. Sair do Sistema") ;
			
			System.out.println("\n=====================================================");
			
			try {
				opcao = Integer.parseInt(leitura.entDados("Digite uma das opções acima: ")); 				
			} catch (NumberFormatException e) {
				System.out.println("O valor digitado deve ser um número entre 1 e 7");
				leitura.entDados("");
				continue;
			}
			
			switch(opcao) {			
				case 1:
					try {
						cadastraNovoVeiculoDePasseio(BDVeiculos.getListaPasseio());						
					} catch (VeicExistException excecao) {
						System.out.println("\n" + excecao.getMessage());					
					}
					break;
				case 2:
					try {
						cadastraNovoVeiculoDeCarga(BDVeiculos.getListaCarga());						
					} catch (VeicExistException excecao) {
						System.out.println("\n" + excecao.getMessage());
					}
					break;
				case 3:
					imprimeTodosVeiculosPorTipo(TipoVeiculo.PASSEIO, BDVeiculos.getListaPasseio());
					break;
				case 4:
					imprimeTodosVeiculosPorTipo(TipoVeiculo.CARGA, BDVeiculos.getListaCarga());
					break;
				case 5:
					imprimirVeiculoPelaPlaca(TipoVeiculo.PASSEIO, BDVeiculos.getListaPasseio());
					break;
				case 6:
					imprimirVeiculoPelaPlaca(TipoVeiculo.CARGA, BDVeiculos.getListaCarga());
					break;
				case 7:
					excluirVeiculoPorTipoEPlaca(TipoVeiculo.PASSEIO, BDVeiculos.getListaPasseio());
					break;
				case 8:
					excluirVeiculoPorTipoEPlaca(TipoVeiculo.CARGA, BDVeiculos.getListaCarga());
					break;
				case 9:
					System.out.println("Finalizando sistema...");
					System.out.println("Sistema finalizado.");
					continua = false;
					break;
				default:
					System.out.println("\nAtenção: O valor digitado deve ser um número entre 1 e 7");	
					continue;
			}
		}// fim while

	} // fim main	
	
	private static void excluirVeiculoPorTipoEPlaca(TipoVeiculo tipoVeiculo, List<? extends Veiculo> listaVeiculo) {
		String tipo = TipoVeiculo.PASSEIO.equals(tipoVeiculo) ? "PASSEIO" : "CARGA"; 
		System.out.println("\nImpressão de veículo de " + tipo + " pela placa.");
		String placa = leitura.entDados("\nDigite a placa: ");
		boolean achouPlaca = false;
		
		Iterator<? extends Veiculo> iterator = listaVeiculo.iterator();
		while(iterator.hasNext()) {
			Veiculo veiculo = iterator.next();
			if(veiculo.getPlaca().equals(placa)) {				
				iterator.remove();
				achouPlaca = true;
			}
		}
		if(!achouPlaca) {
			System.out.println("\n-> Não há nenhum veículo de " + tipo + " cadastrado com a placa '" + placa + "'.");
		} else {
			System.out.println("\nVeículo de passeio de placa \"" + placa + "\" removido");
		}
	}

	public static void cadastraNovoVeiculoDePasseio(List<Passeio> listaVeiculo)
			throws VeicExistException {
		boolean cadastrarNovoVeiculo = true;
		while (cadastrarNovoVeiculo) {

			System.out.println("\n----------- Cadastro de veículo de passeio----------\n");
			String placa = leitura.entDados("Placa: ");
			if (encontraPlaca(placa, listaVeiculo)) {
				throw new VeicExistException();
			} else {
				Passeio passeio = formularioPasseio(placa);
				listaVeiculo.add(passeio);
				if (!desejaNovo("passeio")) {
					cadastrarNovoVeiculo = false;
					break;
				}
			}
			continue;
		}
	}
	
	public static void cadastraNovoVeiculoDeCarga(List<Carga> listaCarga)
			throws VeicExistException {
		boolean cadastrarNovoVeiculo = true;
		while (cadastrarNovoVeiculo) {
			System.out.println("\n----------- Cadastro de veículo de carga----------\n");
			String placa = leitura.entDados("Placa: ");
			if (encontraPlaca(placa, listaCarga)) {
				throw new VeicExistException();
			} else {
				Carga carga = formularioCarga(placa);
				listaCarga.add(carga);
				if (!desejaNovo("carga")) {
					cadastrarNovoVeiculo = false;
					break;
				}
			}
			continue;
		}
	}
	
	public static boolean desejaNovo(String tipo) {
		String opcao = leitura.entDados("\nDeseja cadastrar novo veiculo de " + tipo + "? (s:SIM / n:NÃO)");
		if(opcao.equalsIgnoreCase("n")){
			return false;
		} else if(opcao.equalsIgnoreCase("s")) {
			return true;
		}
		return desejaNovo(tipo);
	}
	
	
	public static boolean encontraPlaca(String placa, List<?> listaVeiculo) {
		for(Object v : listaVeiculo) {
			Veiculo veiculo = (Veiculo) v;
			if(veiculo.getPlaca().equals(placa)) {
				return true;
			}
		}
		return false;
	}
	
	public static int encontraVagaVeiculo(Veiculo listaVeiculo[]) {
		for(int i = 0; i < listaVeiculo.length; i++) {
			if(listaVeiculo[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	public static Passeio formularioPasseio(String placa) {
		Passeio passeio = new Passeio();		
		passeio.setMarca(leitura.entDados("Marca: "));
		passeio.setModelo(leitura.entDados("Modelo: "));		
		passeio.setPlaca(placa);
		passeio.setCor(leitura.entDados("Cor: "));
		try {
			passeio.setVelocMaxima(Float.parseFloat(leitura.entDados("Velocidade Máxima")));			
		} catch(VelocException excecao){
			System.out.println("\n" + excecao.getMessage());
			System.out.println("Será automaticamente atribuída uma velocidade máxima válida de 100 Km/h.\n");
			try {
				passeio.setVelocMaxima(100f);
			} catch (VelocException excecao2) {
				System.out.println(excecao2.getMessage());
			}
		}
		passeio.setQtdRodas(Integer.parseInt(leitura.entDados("Quantidade de Rodas: ")));
		passeio.getMotor().setQtdPist(Integer.parseInt(leitura.entDados("Quantidade de Pistões do Motor: ")));
		passeio.getMotor().setPotencia(Integer.parseInt(leitura.entDados("Potência do Motor: ")));
		passeio.setQtdPassageiros(Integer.parseInt(leitura.entDados("Quantidade de Passageiros: ")));
		return passeio;
	}
	
	public static Carga formularioCarga(String placa) {
		Carga carga = new Carga();		
		carga.setMarca(leitura.entDados("Marca: "));
		carga.setModelo(leitura.entDados("Modelo: "));				
		carga.setPlaca(placa);
		carga.setCor(leitura.entDados("Cor: "));
		
		try {
			carga.setVelocMaxima(Float.parseFloat(leitura.entDados("Velocidade Máxima")));		
		}catch (VelocException excecao) {
			System.out.println("\n" + excecao.getMessage());
			System.out.println("Será automaticamente atribuída uma velocidade máxima válida de 90 Km/h.\n");
			try {
				carga.setVelocMaxima(90f);				
			}catch (VelocException excecao2) {
				System.out.println(excecao2.getMessage());
			}
		}
		
		carga.setQtdRodas(Integer.parseInt(leitura.entDados("Quantidade de Rodas: ")));
		carga.getMotor().setQtdPist(Integer.parseInt(leitura.entDados("Quantidade de Pistões do Motor: ")));
		carga.getMotor().setPotencia(Integer.parseInt(leitura.entDados("Potência do Motor: ")));
		carga.setCargaMax(Integer.parseInt(leitura.entDados("Carga Máxima: ")));
		carga.setTara(Integer.parseInt(leitura.entDados("Tara: ")));
		
		return carga;
	}
	
	public static String imprimePasseio(Passeio passeio) {
		return passeio.toString();
	}
	
	public static String imprimeCarga(Carga carga) {
		return carga.toString();
	}
	
	public static void imprimeTodosVeiculosPorTipo(TipoVeiculo tipoVeiculo, List<? extends Veiculo> listaVeiculo) {
		String tipo = TipoVeiculo.PASSEIO.equals(tipoVeiculo) ? "PASSEIO" : "CARGA";
		System.out.println("\nTodos os veículos de " + tipo + ":");
		if (!listaVeiculo.isEmpty()) {
			int indice = 1;
			for (Veiculo veiculo : listaVeiculo) {
				System.out.println("\nVEÍCULO DE " + tipo + " - [" + indice + "]");
				System.out.println();
				System.out.println(veiculo.toString());
				indice++;
			}
		} else {
			System.out.println("\n-> Não há veículos de " + tipo + " cadastrados.");
		}

	}
	
	public static void imprimirVeiculoPelaPlaca(TipoVeiculo tipoVeiculo, List<? extends Veiculo> listaVeiculo) {
		String tipo = TipoVeiculo.PASSEIO.equals(tipoVeiculo) ? "PASSEIO" : "CARGA"; 
		System.out.println("\nImpressão de veículo de " + tipo + " pela placa.");
		String placa = leitura.entDados("\nDigite a placa: ");
		boolean achouPlaca = false;
		for (Veiculo veiculo : listaVeiculo) {
			if(veiculo.getPlaca().equalsIgnoreCase(placa.trim())) {
				System.out.println("---------------------------------");
				System.out.println("\nVEÍCULO DE " + tipo + " COM A PLACA '" + placa + "':\n");
				System.out.println(veiculo.toString());
				achouPlaca = true;
				break;
			}
		}
		if(!achouPlaca) {
			System.out.println("\n-> Não há nenhum veículo de " + tipo + " cadastrado com a placa '" + placa + "'.");
		}
	}

}

