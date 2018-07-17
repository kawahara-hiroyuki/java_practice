class quicksort{

	public static void quicksort(int a[],int startID, int endID){
	
		int pivot = a[(int)((startID+endID)/2)];

		int left = startID;
		int right = endID;

		while(true){
			while(a[left]<pivot){
				left++;
			}

			while(pivot < a[right]){
				right--;
			}

			if(right<=left){
				break;
			}
	
			int tmp = a[left];
			a[left] = a[right];
			a[right] = tmp;

			left++;
			right--;
		}
		
		if(startID < left-1){
			quicksort(a,startID,left-1);
		}
		
		if(right+1<endID){
			quicksort(a,right+1,endID);
		}
	}

	public static void main(String args[]){
		int a[] = {10,3,1,9,7,6,8,2,4,5};
	
		quicksort(a,0,a.length-1);
	
		for(int i:a){
			System.out.println(i);
		}
	}
}
