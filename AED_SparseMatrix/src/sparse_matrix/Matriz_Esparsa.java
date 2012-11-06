package sparse_matrix;


/**
 *A matriz esparsa funciona como uma estrutura reposit�rio de dados em que se
 * economiza espa�o na mem�ria, pois s�o apenas armazenados os elementos que tem
 * valor diferente de "0". Quando um usu�rio tenta adicionar um valor "0"
 * atravez de uma valida��o ela autom�ticamente exclui o valor armazenado
 * naquela posi��o.
 * 
 * @author Rog�rio Peixoto
 * 
 */

public class Matriz_Esparsa {

	private int num_linhas;
	private int num_colunas;
	private int qtd_elementos;
	private int tamanho;

	private Elemento repositorio[];

	// CONSTRUTOR;
	public Matriz_Esparsa(int num_linhas, int num_colunas) {
		repositorio = new Elemento[1];
		setNum_linhas(num_linhas);
		setNum_colunas(num_colunas);
		tamanho = num_linhas * num_colunas;
	}

	public int get(int pos_linha, int pos_coluna) throws Exception {
		int valor_retorno = 0;
		if (pos_linha < num_linhas && pos_coluna < num_colunas) {
			for (int i = 0; i < repositorio.length; i++) {
				if (repositorio[i].getPos_linha() == pos_linha
						&& repositorio[i].getPos_coluna() == pos_coluna) {
					valor_retorno = repositorio[i].getValor();
					break;
				}
			}
		} else {
			throw new InvalidParameterException();
		}
		return valor_retorno;
	}

	public void add(int pos_linha, int pos_coluna, int valor) {
		if (qtd_elementos <= tamanho && pos_linha < num_linhas
				&& pos_coluna < num_colunas) {
			Elemento v = new Elemento(pos_linha, pos_coluna, valor);
			// IF PARA ADICIONAR VALOR NA MATRIZ SE ESTIVER VAZIA;
			if (estaVazia()) {
				qtd_elementos++;
				repositorio[0] = v;
			} else {
				for (int j = 0; j < repositorio.length; j++) {

					// IF PARA SUBSTITUI��O OU "SET" DE VALORES;
					if (repositorio[j].testaTamanho(v) == false) {
						for (int i = 0; i < repositorio.length; i++) {
							if (repositorio[i].getPos_linha() == pos_linha
									&& repositorio[i].getPos_coluna() == pos_coluna) {
								repositorio[i].setValor(valor);
								break;
							}
						}
					}
					// IF PARA ADI��O DE VALORES NA ULTIMA POSI��O;
					else if (j == repositorio.length - 1) {
						qtd_elementos++;
						expandeUltimo();
						repositorio[repositorio.length - 1] = v;
						break;
					}
					// IF PARA ADI��O DE VALOR NO MEIO DA MATRIZ;
					else if (repositorio[j].testaTamanho(v) == false) {
						qtd_elementos++;
						expande(j);
						repositorio[j] = v;
						break;
					}
					// IF PARA REMO��O CASO VALOR INSERIDO FOR "0";
					else {
						if (repositorio[j].testaTamanho(v) == false
								&& valor == 0) {
							reduz(j);
						}
					}
				}
			}
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	// <<<=====M�TODOS AUXILIARES=====>>>

	public int getNum_linhas() {
		return num_linhas;
	}

	public void setNum_linhas(int num_linhas) {
		if (num_linhas >= 0) {
			this.num_linhas = num_linhas;
		} else {
			return;
		}
	}

	public int getNum_colunas() {
		return num_colunas;
	}

	public void setNum_colunas(int num_colunas) {
		if (num_colunas >= 0) {
			this.num_colunas = num_colunas;
		} else {
			return;
		}
	}

	// RETORNA TRUE SE A MATRIZ ESTA VAZIA;
	public boolean estaVazia() {
		return (qtd_elementos == 0);
	}

	// ABRE UM SLOT NA POSI��O PASSADA POR PAR�METRO;
	public void expande(int posicao_atual) {
		Elemento[] vetor_auxiliar = new Elemento[repositorio.length + 1];
		for (int i = 0; i < repositorio.length; i++) {
			if (i < posicao_atual) {
				vetor_auxiliar[i] = repositorio[i];
			} else {
				vetor_auxiliar[i + 1] = repositorio[i];
			}
		}
		repositorio = vetor_auxiliar;
	}

	// ABRE UM SLOT DE ARMAZENAMENTO NO FIM DO REPOSIT�RIO;
	public void expandeUltimo() {
		Elemento[] vetor_auxiliar = new Elemento[repositorio.length + 1];
		for (int i = 0; i < repositorio.length; i++) {
			vetor_auxiliar[i] = repositorio[i];
		}
		repositorio = vetor_auxiliar;
	}

	// REDUZ O ARRAY NA POSI��O DO REPOSIT�RIO ONDE O ELEMENTO FOI REMOVIDO;
	public void reduz(int posicao_atual) {
		Elemento[] vetor_auxiliar = new Elemento[repositorio.length - 1];
		for (int i = 0; i < repositorio.length; i++) {
			if (i < posicao_atual) {
				vetor_auxiliar[i] = repositorio[i];
			} else {
				vetor_auxiliar[i] = repositorio[i + 1];
			}

		}
	}

	// EXCE��O LEVANTADA SE OS PARAMETROS PASSADOS PELO USU�RIO FOREM INV�LIDOS;
	class InvalidParameterException extends Exception {
		public InvalidParameterException() {
			super();
		}
	}
}
