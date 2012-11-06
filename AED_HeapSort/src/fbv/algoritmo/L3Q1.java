package fbv.algoritmo;
	
	public class L3Q1 {
		
		Arquivo arq;
		
		int[] heap;
		
		int heapSize;
		
		int compareHeap;
		int compareMerge;
		
		void reset(int size){
			heap = new int[size];
			heapSize = size;
			compareHeap = 0;
			data = new int[size];
			compareMerge = 0;
		}
		
		void heapify(int i){
			int l = 2*i + 1;
			int r = l + 1;
			int largest = i;
			if(l < heapSize){
				compareHeap++;
				if(heap[l] > heap[largest]){
					largest = l; 
				}
			}
			if(r < heapSize && heap[r] > heap[largest]){
				largest = r; 
			}
			if(largest != i){
				int temp = heap[largest];
				heap[largest] = heap[i];
				heap[i] = temp;
				heapify(largest);
			}
		}
		
		void buildHeap(){
			heapSize = heap.length;
			for(int i = heapSize/2 - 1; i >= 0; i--){
				heapify(i);
			}
		}
		
		void heapSort(){
			buildHeap();
			for(int i = heapSize - 1; i > 0; i--){
				int temp = heap[0];
				heap[0] = heap[i];
				heap[i] = temp;
				heapSize--;
				heapify(0);
			}
		}
		
		int[] data;
		
		public void mergesort(int left, int right){
		      if (left < right){
		         int half = (left+right)/2;
		         mergesort(left, half);
		         mergesort(half + 1, right);
		         merge(left, half, right);
		      }
		   } 
		

		
		private void merge(int left, int half, int right){
		      int[] temp = new int[right - left + 1];
		      int copied  = 0;
		      int copied1 = left;
		      int copied2 = half + 1;

		      while((copied1 <= half) && (copied2 <= right)){
		         if(data[copied1] < data[copied2]){
		            temp[copied++] = data[copied1++];
		         }else{
		            temp[copied++] = data[copied2++];
		         }
		         compareMerge++;
		      }

		      while(copied1 <= half){
		         temp[copied++] = data[copied1++];
		      }
		      while(copied2 <= right){
		         temp[copied++] = data[copied2++];
		      }

		      for(int i = 0; left + i <= right; i++){
		         data[left + i] = temp[i];
		      }
		}	
}

