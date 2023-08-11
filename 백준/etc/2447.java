import java.util.Scanner;

import static java.util.Collections.reverse;


public class Main {
	public static String[] Star(int n){
		if(n==3) return first;

		String []result = new String[n];
		for(int i=0;i<n;i++){
			result[i] = "";
		}
		String []arr = Star(n/3);
		int m=0;
		int j=0;
		for(int i=0;i<n/3;i++){
			for(int k=0;k<3;k++){//arr기준끝까지출력해야지
				result[i] += arr[i];
			}
		}
		m=0;
		j=0;
		for(int i=n/3;i<n/3*2;i++,j++){
			for(int k=0;k<3;k++){
				if(k==1){
					for(int z=0;z<n/3;z++) result[i] += " ";
				}
				else result[i] += arr[j];
			}
		}
		m=0;
		j=0;
		for(int i=n/3*2;i<n;i++,j++){
			for(int k=0;k<3;k++){//arr기준끝까지출력해야지
				result[i] += arr[j];
			}
		}
		return result;


	}
	static String[]first = {"***", "* *", "***"};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String []arr2 = Star(n);
		for(int i=0;i<n;i++){
			System.out.println(arr2[i]);
		}

	}


}