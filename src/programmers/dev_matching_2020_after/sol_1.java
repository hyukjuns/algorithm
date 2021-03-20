package programmers.dev_matching_2020_after;

import java.util.StringTokenizer;

public class sol_1 {
    public static void main(String[] args){
        System.out.println(solution("PM 01:00:00",10));
    }
    public static String solution(String p, int n) {
        int hour = n/3600;
        int minute = (n%3600) / 60;
        int second = (n%3600) % 60;
        //System.out.println(hour+""+minute+""+second);
        StringTokenizer st = new StringTokenizer(p);
        String day = st.nextToken();
        int nHour=0;
        int nMinute = 0;
        int nSecond = 0;
        if(day.equals("PM")){
            String time = st.nextToken();
            StringTokenizer nst = new StringTokenizer(time,":");
            nHour = Integer.parseInt(nst.nextToken()); //hour
            nMinute = Integer.parseInt(nst.nextToken());
            nSecond = Integer.parseInt(nst.nextToken());

            nSecond += second;
            if(nSecond >= 60){
                nSecond -= 60;
                nMinute += 1;
            }
            nMinute += minute;
            if(nMinute >= 60){
                nMinute -= 60;
                nHour += 1;
            }
            nHour += hour;

            //trans for 24hour
            nHour += 12;
            //System.out.println(nHour);
            if(nHour >= 24) nHour = 0;
            else if(nHour >= 12)    nHour -= 12;
        }else {
            String time = st.nextToken();
            StringTokenizer nst = new StringTokenizer(time,":");
            nHour = Integer.parseInt(nst.nextToken()); //hour
            nMinute = Integer.parseInt(nst.nextToken());
            nSecond = Integer.parseInt(nst.nextToken());

            nSecond += second;
            if(nSecond >= 60){
                nSecond -= 60;
                nMinute += 1;
            }
            nMinute += minute;
            if(nMinute >= 60){
                nMinute -= 60;
                nHour += 1;
            }
            nHour += hour;

            //trans for 24hour
            nHour += 12;
            //System.out.println(nHour);
            if(nHour >= 24) nHour = 12;
            else if(nHour >= 12)    nHour -= 12;
        }
        String ans="";
        if(nHour < 10)  ans += "0"+nHour;
        else    ans += nHour;
        ans += ":";
        if(nMinute < 10)    ans+= "0"+nMinute;
        else    ans += nMinute;
        ans += ":";
        if(nSecond < 10)    ans += "0"+nSecond;
        else    ans += nSecond;
        return ans;
    }
}
