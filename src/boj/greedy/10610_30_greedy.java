package boj.greedy; //10610 30 그리디, 정수론 , 30의 배수 조건 1. 끝자리수가 0인지. 2. 각자라수의 합이 3의 배수인지, 조건 검사후 내림차순 정렬.
import java.util.*;
import java.io.*;
public class boj {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String n = br.readLine();
		StringBuilder res = new StringBuilder();
		if(isValid(n)) {
			Integer[] arr = new Integer[n.length()];
			for(int i=0; i<n.length(); i++) {
				arr[i] = n.charAt(i) - '0';
			}
			Arrays.sort(arr, Collections.reverseOrder());
			for(int i=0; i<arr.length; i++) {
				res.append(arr[i]);
			}
		}
		else
			res.append("-1");
		bw.write(res.toString());
		bw.flush();
		bw.close();		
	}
	public static boolean isValid(String str) {
		int sum=0;
		if(str.contains("0")) {
			for(int i=0; i<str.length(); i++) {
				sum += str.charAt(i) -'0';
			}
			if((sum % 3) == 0)
				return true;
			else
				return false;
		}
		else
			return false;		
	}
}
