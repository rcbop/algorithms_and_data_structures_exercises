package br.rcbop;

public class Teste {
	public static void main(String[] args) {
		Tree A = new Tree(42);
		A.Insert(32);
		A.Insert(57);
		A.Insert(20);
		A.Insert(37);
		A.Insert(52);
		A.Insert(61);
		A.Insert(18);
		A.Insert(21);
		A.Insert(34);
		A.Insert(39);
		A.Insert(48);
		A.Insert(54);
		A.Insert(58);
		A.Insert(70);
		A.Insert(64);

		System.out.print("Pr�-Ordem:\n");
		Ordenacao.PreOrdem(A);
		System.out.println();
		System.out.println();
		System.out.print("Ordem Sim�trica:\n");
		Ordenacao.OrdemSimetrica(A);
		System.out.println();
		System.out.println();
		System.out.print("Ordem Final:\n");
		Ordenacao.OrdemFinal(A);
	}
}
