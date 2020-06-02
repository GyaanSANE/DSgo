package algorithms.sort.merge;

public class MergeSort {

	public static int[] mergeSort(int[] arr) {
		if(arr.length<2) {
			return arr;
		}
		int n = arr.length;
		int mid = n/2;
		int[] left = new int[mid];
		int[] right = new int[n-mid];
		
		for(int i=0;i<mid;i++) {
			left[i] = arr[i];
		}
		for(int j=mid;j<n;j++) {
			right[j-mid] = arr[j];
		}
		mergeSort(left);
		mergeSort(right);
		arr = merge(left,right,arr);
		return arr;
	}

	private static int[] merge(int[] left, int[] right, int[] arr) {
		int i,j,k;
		i=j=k=0;
		while(i<left.length && j<right.length) {
			if (left[i]<right[j]) {
				arr[k] = left[i];
				i++;
				k++;
			}else {
				arr[k] = right[j];
				j++;
				k++;
			}	
		}
		while(i<left.length) {
			arr[k] = left[i];
			i++;
			k++;
		}
		while(j<right.length) {
			arr[k] = right[j];
			j++;
			k++;
		}
		return arr;
	}
	
	public static void printArray(int[] arr) {
		for(int i:arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
