		import java.util.Scanner;

		import static java.util.Collections.reverse;

public class Main {
	static int[] save = new int[41];
	static int[] one = new int[41];
	static int[] zero = new int[41];
	public static int fibo(int n){
		if(save[n]==-1){//n번쨰에 값이 없을 경우
			save[n] = fibo(n-1) + fibo(n-2);
			one[n] = one[n-1] + one[n-2];
			zero[n] = zero[n-1] + zero[n-2];
		}
		return save[n];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int []arr = new int[n];
		//
		// Star(n);
		for(int i=0;i<n;i++){
			arr[i] = sc.nextInt();

		}
		for(int i=0;i<41;i++){
			save[i] = -1;
			one[i] = zero[i] = -1;
 		}
		save[0] = 0;
		save[1] = 1;
		one[0] = 0;
		one[1] = 1;
		zero[0] =1;
		zero[1] =0;
        
        int max = 0;
		for(int i=0;i<n;i++){
			if(max<arr[i]) max = arr[i];
		}

		fibo(max);
		for(int i=0;i<n;i++){
			System.out.println(zero[arr[i]] + " " + one[arr[i]]);
		}



	}


}
