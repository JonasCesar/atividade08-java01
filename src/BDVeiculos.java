import java.util.ArrayList;
import java.util.List;

public class BDVeiculos {
	
	private static List<Passeio> listaPasseio = new ArrayList<Passeio>();
	private static List<Carga> listaCarga = new ArrayList<Carga>();
	
	public BDVeiculos() {
		
	}

	public static List<Passeio> getListaPasseio() {
		return listaPasseio;
	}

	public static List<Carga> getListaCarga() {
		return listaCarga;
	}

	public static void setListaPasseio(List<Passeio> listaPasseio) {
		BDVeiculos.listaPasseio = listaPasseio;
	}

	public static void setListaCarga(List<Carga> listaCarga) {
		BDVeiculos.listaCarga = listaCarga;
	}

	
	
}
