package boj.Math;

import java.io.*;

public class Math_1076 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] colors = {"black","brown","red","orange","yellow",
                            "green","blue","violet","grey","white"};
        Resist[] res = new Resist[10];
        for(int i=0; i<10; i++){
            res[i] = new Resist(colors[i],i,(long)Math.pow(10,i));
        }
        String value1 = br.readLine();
        String value2 = br.readLine();
        String multi = br.readLine();
        String sum = "";
        for(int i=0; i<10; i++){
            if(value1.equals(res[i].color))
                sum += String.valueOf(res[i].value);
        }
        for(int i=0; i<10; i++) {
            if (value2.equals(res[i].color))
                sum += String.valueOf(res[i].value);
        }
        long ans = Integer.parseInt(sum);
        for(int i=0; i<10; i++) {
            if (multi.equals(res[i].color))
                ans = ans * res[i].multi;
        }

        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
}
class Resist{
    String color;
    int value;
    long multi;
    public Resist(String color, int value, long multi) {
        this.color = color;
        this.value = value;
        this.multi = multi;
    }
}