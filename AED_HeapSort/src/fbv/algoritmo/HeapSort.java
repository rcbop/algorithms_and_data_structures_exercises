package fbv.algoritmo;

public class HeapSort {

	public static void main(String[] args){
		long start = System.currentTimeMillis();
		Arquivo arq = new Arquivo("L3Q1.in","L3Q1.out");
		L3Q1 questao = new L3Q1();
		questao.arq = arq;
		
		int conjunto = 1;
		
		while(!arq.isEndOfFile()){
			arq.print("Conjunto #");
			arq.println(conjunto);
			int total = arq.readInt();
			questao.reset(total);
			for(int i = 0; i < total; i++){
				int atual = arq.readInt();
				questao.heap[i] = atual;
				questao.data[i] = atual; 
			}
			questao.heapSort();
			questao.mergesort(0, total - 1);
			for(int i = 0; i < total; i++){
				arq.print(questao.heap[i]);
				arq.print(" ");
			}
			arq.println();
			if(questao.compareHeap == questao.compareMerge){
				arq.println("Empate: [m][h]");
			}else{
				arq.print("Vencedor: ");
				if(questao.compareHeap < questao.compareMerge){
					arq.println("[h]");
				}else{
					arq.println("[m]");
				}
			}
			arq.print("Mergesort: ");
			arq.print(questao.compareMerge);
			arq.println(" comparacoes");
			arq.print("Heapsort: ");
			arq.print(questao.compareHeap);
			arq.println(" comparacoes");
			arq.println();
			conjunto++;
		}		
		arq.close();
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
