public class solution2 {
    static String select="";
    static int point;

    static void check(String select, String answer, String[] sheets){
        String str1 = sheets[select.charAt(0)-'0'];
        String str2 = sheets[select.charAt(1)-'0'];
        System.out.println("select: "+select);
        int cheatPossible=0;
        for(int i=0; i<answer.length(); i++){
            char ans = answer.charAt(i);
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            if(ans == ch1 || ans == ch2 ){
                continue;
            }
            else if(ans != ch1 && ans != ch2){
                if(ch1==ch2){
                    cheatPossible++;
                }
            }
        }
        int lcs=0;
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i=1; i<=str1.length(); i++){
            if(str1.charAt(i-1) == answer.charAt(i-1))  continue;
            for(int j=1; j<=str2.length(); j++){
                if(str2.charAt(j-1) == answer.charAt(j-1))  continue;
                if(str1.charAt(i-1)==str2.charAt(j-1) && i==j){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if(lcs < dp[i][j]){
                        lcs = dp[i][j];
                    }
                }
            }
        }
        System.out.println("cheat" + cheatPossible);
        System.out.println("lcs :" +lcs);
        point = Math.max(point,cheatPossible + (int)Math.pow(lcs,2));

    }
    static void dfs(int max, int idx, String str,String answer, String[] sheets){
        if(max==str.length()){
//            System.out.println(str);
            check(str, answer,sheets);
            return;
        }
        for(int i=idx; i<sheets.length; i++){
            dfs(max,i+1,str+i,answer,sheets);
        }
    }
    static int solution(String answer_sheet, String[] sheets){
        dfs(2,0,"",answer_sheet,sheets);
        System.out.println(point);
        return -1;
    }
    public static void main(String[] args) {
        String[] sheets = {"3241523133","4121314445","3243523133","4433325251","2412313253"};
        solution("4132315142",sheets);
    }
}
