package sparse_matrix;

/**
 * A matriz esparsa funciona como uma estrutura reposit�rio de dados em que se
 * economiza espa�o na mem�ria, pois s�o apenas armazenados os elementos que tem
 * valor diferente de "0". Quando um usu�rio tenta adicionar um valor "0"
 * atravez de uma valida��o ela autom�ticamente exclui o valor armazenado
 * naquela posi��o.
 * 
 * @author Rog�rio Peixoto
 * 
 */

public class Elemento {

	private int pos_linha;
	private int pos_coluna;
	private int valor;

	public Elemento(int pos_linha, int pos_coluna, int valor) {
		this.pos_linha = pos_linha;
		this.pos_coluna = pos_coluna;
		this.valor = valor;
	}

	// Retorna verdadeiro se ocorrer estouro de tamanho, tanto em colunas como
	// em linhas.
	public boolean testaTamanho(Elemento v) {
		if (v.getPos_linha() != this.pos_linha
				&& v.getPos_linha() > this.pos_linha) {
			return true;
		} else if (v.getPos_coluna() != this.pos_coluna
				&& v.getPos_coluna() > this.pos_coluna) {
			return true;
		} else {
			return false;
		}
	}

	public int getPos_linha() {
		return pos_linha;
	}

	public void setPos_linha(int pos_linha) {
		this.pos_linha = pos_linha;
	}

	public int getPos_coluna() {
		return pos_coluna;
	}

	public void setPos_coluna(int pos_coluna) {
		this.pos_coluna = pos_coluna;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

}
