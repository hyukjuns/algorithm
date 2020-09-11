package programmers.kakao_blind_2019;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class sol_1 {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] ans = solution(input);
        for(int i=0; i<ans.length; i++){
            bw.write(ans[i]+"\n");
        }
        bw.flush();
        bw.close();
    }
    public static String[] solution(String[] record){
        Queue<UserInfo> log = new LinkedList<>();
        String status="";
        String uid="";
        String nic="";
        HashMap<String,String> hm = new HashMap();
        for(int i=0; i<record.length; i++){
            StringTokenizer st = new StringTokenizer(record[i]);
            status = st.nextToken();
            if(status.equals("Leave")){
                uid = st.nextToken();
                log.add(new UserInfo(status,uid)); //출입여부 체크
            }else if(status.equals("Enter")){
                uid = st.nextToken();
                nic = st.nextToken();
                hm.put(uid,nic); // 채팅창 밖에서 닉네임 변경후 들어왔을경우 대비;
                log.add(new UserInfo(status,uid)); //출입여부 체크
            }else if(status.equals("Change")){
                uid = st.nextToken();
                nic = st.nextToken();
                hm.put(uid,nic); // 채팅창 안에서 닉네임 변경했을 경우 대비
            }
        }
        String[] ans = new String[log.size()];
        int idx=0;
        while(!log.isEmpty()){
            UserInfo logTemp = log.poll();
            if(logTemp.status.equals("Enter")){
               ans[idx++] =  hm.get(logTemp.uid)+"님이 들어왔습니다.";
            }else{
                ans[idx++] = hm.get(logTemp.uid)+"님이 나갔습니다.";
            }
        }
        return ans;
    }
}
class UserInfo{
    String status;
    String uid;
    public UserInfo(String status, String uid){
        this.status = status;
        this.uid = uid;
    }
}
