package ch06_memorystructure;

public class ReferenceParamEx {

	public static void main(String[] args) {
		int[] arr = new int[] {3, 2, 1, 4, 5, 6};
		
		printArr(arr);
		sortArr(arr);
		printArr(arr);
		System.out.println("sum = " + sumArr(arr));
	}
	
	// 배열의 모든 요소를 출력
	static void printArr(int[] arr) {
		System.out.print("[");
		
		for (int i : arr)	
			System.out.print(i + ",");
		System.out.println("]");
	}
	
	// 배열의 모든요소 합 반환
	static int sumArr(int[] arr) {
		int sum = 0;
		
		for (int i =0; i < arr.length; i++)
			sum += arr[i];
		return sum;
	}
	
	// 배열을 오름차순으로 정
	static void sortArr(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr.length - 1 - i; j++)
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
	}

}
/*
[3,2,1,4,5,6,]
[1,2,3,4,5,6,]
sum = 21
*/