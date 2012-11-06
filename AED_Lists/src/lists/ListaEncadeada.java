package lists;

class No { // CLASSE No
	Object O;
	No prox;

	No(Object O) { // CONSTRUTOR DE No()
		this.O = O;
		prox = null;
	}
}

/**
 * A classe Lista_Dinamica funciona como a collection LinkedList utilizando-se
 * de uma abstracao de ponteiros que s�o as referencias da classe No. O prox
 * permite percorrer a lista, fazendo iteracoes nela com semelhanca as feitas em
 * vetores.
 * 
 * @author Rog�rio Peixoto
 * 
 */

public class ListaEncadeada { // CLASSE Lista_Dinamica

	private No primeiro, ultimo;
	private int numero_nos;

	public ListaEncadeada() // CONSTRUTOR DE Lista_Dinamica()
	{
		primeiro = null;
		ultimo = null;
		numero_nos = 0;
	}

	// <<<====M�TODOS DE MANIPULA��O====>>>

	public void add(Object O, int posicao) {

		No novoNo = new No(O);
		if (posicao <= 1) {
			addFirst(novoNo);
			return;
		}
		if (posicao > numero_nos) {
			addLast(novoNo);
			return;
		} else {
			numero_nos++;
			No noTemp = primeiro.prox;
			posicao--;
			for (int i = 1; i < posicao; i++) {
				noTemp = noTemp.prox;
			}
			novoNo.prox = noTemp.prox;
			noTemp.prox = novoNo;
		}
	}

	public void addFirst(Object O) {
		numero_nos++;
		No novoNo = new No(O);
		if (isEmpty()) {
			primeiro = novoNo;
			ultimo = primeiro;
		} else {
			novoNo.prox = primeiro;
			primeiro = novoNo;
		}
	}

	public void addLast(Object O) {
		numero_nos++;
		No novoNo = new No(O);
		if (isEmpty()) {
			primeiro = novoNo;
		} else {
			ultimo.prox = novoNo;
			ultimo = novoNo;
		}
	}

	public void clear() {
		primeiro = null;
		ultimo = null;
	}

	public Object get(int index) {
		int qnt_aux = 1;
		No atual = primeiro;

		while (atual != null) {
			if (qnt_aux == index) {
				return atual.O;
			}
			qnt_aux += +1;
			atual = atual.prox;
		}
		return null;
	}

	public Object getFirst() {
		return primeiro.O;
	}

	public Object getLast() {
		return ultimo.O;
	}

	public Object remove(int index) {
		No atual = null;
		No anterior = null;
		if (!isEmpty()) {
			atual = primeiro;
			int i = 0;
			while (atual != ultimo && i < index) {
				anterior = atual;
				atual = atual.prox;
				i++;
			}
			if (anterior != null) {
				anterior.prox = atual.prox;
			} else {
				primeiro = atual.prox;
			}
			atual.prox = null;

		} else {
			return null;
		}
		return atual.O;
	}

	public Object removeFirst() {
		numero_nos--;
		primeiro = primeiro.prox;
		return primeiro.O;
	}

	public Object removeLast() {
		numero_nos--;
		No atual = null;
		No anterior = null;
		int i = 0;

		atual = primeiro;
		while (i <= numero_nos) {
			anterior = atual;
			atual = atual.prox;
			i++;
			if (atual.equals(ultimo)) {
				ultimo = anterior;
				ultimo.prox = null;
			}
		}
		return ultimo.O;
	}

	public int size() {
		return numero_nos;
	}

	// <<<<=====Metodos Auxiliares=====>>>>

	public boolean isEmpty() {
		return (primeiro == null && ultimo == null);
	}

}
