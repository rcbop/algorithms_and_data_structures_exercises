package lists;

public class ListaArray {

	/**
	 * A classe Lista_Vetor se comporta como a API LinkedList (podem ser
	 * inseridos elementos da lista entre dois outros elementos j� inseridos) s�
	 * que com o armazenamento feito em ARRAY.
	 * 
	 * @author Rog�rio Peixoto
	 * 
	 **/

	private int qtd_elementos = 0;
	private String vet[];

	public ListaArray() {
		this.vet = new String[1];
	}

	public void add(int index, String a) {
		if (isEmpty()) {
			vet[0] = a;
			qtd_elementos++;
		} else if (index <= 0 || index >= vet.length) {
			return;
		} else {
			expand(vet.length);
			String temp = "";
			for (int i = vet.length - 1; i > index; i--) {
				vet[i] = vet[i - 1];
			}
			vet[index] = a;
			qtd_elementos++;
		}
	}

	public void addFirst(String a) {
		if (isEmpty()) {
			vet[0] = a;
			qtd_elementos++;
		} else {
			expandFirst(vet.length);
			vet[0] = a;
			qtd_elementos++;
		}
	}

	public void addLast(String a) {
		if (isEmpty()) {
			vet[0] = a;
			qtd_elementos++;
		} else {
			expandLast(vet.length);
			vet[vet.length - 1] = a;
			qtd_elementos++;
		}
	}

	public void clear() {
		String temp[] = new String[1];
		vet = temp;
		qtd_elementos = 0;
	}

	public String get(int index) {
		if (isEmpty() || index >= vet.length || index < 0) {
			return null;
		} else {
			return vet[index];
		}
	}

	public String getFirst() {
		return vet[0];
	}

	public String getLast() {
		return vet[vet.length - 1];
	}

	public void remove(int index) {
		if (isEmpty() || index >= vet.length || index <= 0) {
			return;
		} else {
			int tamanho_ant = vet.length;
			for (int i = index; i < vet.length - 1; i++) {
				vet[i] = vet[i + 1];
			}
			reduce(tamanho_ant);
			qtd_elementos--;
		}
	}

	public String removeFirst() {
		if (isEmpty()) {
			return null;
		} else {
			for (int i = 0; i < vet.length - 1; i++) {
				vet[i] = vet[i + 1];
			}
			reduce(vet.length);
			qtd_elementos--;
		}
		return vet[0];
	}

	public String removeLast() {
		if (isEmpty()) {
			return null;
		} else {
			reduce(vet.length);
			qtd_elementos--;
			return vet[vet.length - 1];
		}
	}

	public void set(int index, String a) {
		if (isEmpty() || index >= vet.length || index <= 0) {
			return;
		} else {
			vet[index] = a;
		}
	}

	public int size() {
		return qtd_elementos;
	}

	// <<===M�TODOS AUXILIARES===>>>

	public void expand(int tamanho_vet) {
		String[] vtemp = new String[tamanho_vet + 1];
		String temp = "";
		for (int i = 0; i < vet.length; i++) {
			temp = vet[i];
			vtemp[i] = temp;
		}
		vet = vtemp;
	}

	public void expandLast(int tamanho_vet) {
		String[] vtemp = new String[tamanho_vet + 1];
		String temp = "";
		for (int i = 0; i < vet.length; i++) {
			temp = vet[i];
			vtemp[i] = temp;
		}

		vet = vtemp;
	}

	public void expandFirst(int tamanho_vet) {
		String[] vtemp = new String[tamanho_vet + 1];
		String temp = "";
		for (int i = 0; i < vet.length; i++) {
			temp = vet[i];
			vtemp[i + 1] = temp;
		}
		vet = vtemp;
	}

	public void reduce(int tamanho_vet) {
		String[] temp = new String[tamanho_vet - 1];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = vet[i];
		}
		vet = temp;
	}

	public boolean isEmpty() {
		if (qtd_elementos > 0) {
			return false;
		} else {
			return true;
		}
	}
}