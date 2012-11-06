package br.rcbop;
public class Ordenacao {

	public static void PreOrdem(Tree DLR) {
		if (DLR != null) {
			System.out.print(DLR.get() + " ");
			PreOrdem(DLR.getL());
			PreOrdem(DLR.getR());
		}

	}

	public static void OrdemSimetrica(Tree LDR) {
		if (LDR != null) {
			OrdemSimetrica(LDR.getL());
			System.out.print(LDR.get() + " ");
			OrdemSimetrica(LDR.getR());
		}
	}

	public static void OrdemFinal(Tree LRD) {
		if (LRD != null) {
			OrdemFinal(LRD.getL());
			OrdemFinal(LRD.getR());
			System.out.print(LRD.get() + " ");
		}
	}

}
