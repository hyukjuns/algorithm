package boj.Simulation;

import java.io.*;

public class Simul_6679 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=1000; i<10000; i++){
            int sum=getDigitSum(i,10);
            if(sum != getDigitSum(i,12))
                continue;
            if(sum != getDigitSum(i,16))
                continue;
            bw.write(i+"\n");
        }
        bw.flush();
        bw.close();
    }
    public static int getDigitSum(int decimalNum, int pivot){
        int sum=0;
        int mok=0;
        int nmg=0;
        int min = pivot-1;
        while(decimalNum > min){
            mok = decimalNum / pivot;
            nmg = decimalNum % pivot;
            decimalNum = mok;
            sum += nmg;
        }
        return sum+mok;
    }
}
