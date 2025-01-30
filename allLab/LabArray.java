package test;

	class SimpleArray{
		private long[] a;
		 public SimpleArray(int size)
		 {a = new long[size];}
		 
		public void setElem(int index, long value)
		{a[index] = value;}
		
		public long getElem(int index)
		{return a[index];}
		
		public int findMax(int nElems) {
			if (nElems <+ 0) {
				return -1;
			}
			int maxIndex = 0;
			for (int i = 1; i < nElems;  i++) {
				if (a[i] > a[maxIndex]) {
					maxIndex = i;
				}
			}
			return maxIndex;
		}
		
		public Long removeMax(int nElems) {
			int maxIndex = findMax(nElems);
			if(maxIndex == -1) {
				System.out.println("Cannot find max. Array is empty.");
				return null;
			}
			long maxValue = a[maxIndex];
			for (int i = maxIndex; i < nElems -1; i++) {
				a[i] = a[i + 1];
			}
			System.out.println(maxValue + "has been removed.");
			return maxValue;
		}
	} 
	
	class LabArray {
		public static void main(String[] args) {
			SimpleArray arr;
			arr = new SimpleArray(100);
			int nElems = 0;
			int j;
			
			arr.setElem(0, 77);
			arr.setElem(1, 99);
			arr.setElem(2, 44);
			arr.setElem(3, 55);
			arr.setElem(4, 22);
			arr.setElem(5, 88);
			arr.setElem(6, 11);
			arr.setElem(7, 00);
			arr.setElem(8, 66);
			arr.setElem(9, 33);
			nElems = 10;
			
			for (j = 0; j < nElems; j++)
				System.out.print(arr.getElem(j) + " ");
	        System.out.println("");
	        
			int maxIndex = arr.findMax(nElems);
			System.out.println("Index of max value: " + maxIndex);
			 arr.removeMax(nElems);
			 nElems--;
			 
			 for ( j = 0; j < nElems; j++)
				 System.out.print(arr.getElem(j) + " ");
			 System.out.println("");
		}
	}

