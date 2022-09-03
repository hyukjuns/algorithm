package programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;

public class Kaka0_openchat {

      static String[] solution(String[] record){
          HashMap<String, String> userList = new HashMap<>();
          Queue<User> logList = new LinkedList<>();
          for(String message : record){
            String[] log = message.split(" ");
            //log[0] : E/L/C, log[1] : UID, log[2] : NIC NAME
            if(log[0].equals("Enter")){
                if(userList.containsKey(log[1])){
                    if(!userList.get(log[1]).equals(log[2])){
                        userList.put(log[1],log[2]);
                    }
                }
                else{
                    userList.put(log[1],log[2]);
                }
                logList.add(new User(log[1], true));

            }
            else if(log[0].equals("Leave")){
                logList.add(new User(log[1], false));
            }
            else{
                userList.put(log[1],log[2]);
            }
        }
        String[] answer = new String[logList.size()];

          for(int i=0; i<answer.length; i++){
              User u = logList.poll();
              String nicName = userList.get(u.uid);
              if(u.isLogin){
                  answer[i] = nicName+"님이 들어왔습니다.";
              }
              else{
                  answer[i] = nicName+"님이 나갔습니다.";
              }
          }
          return answer;
      }
//    static String[] solution(String[] record){
//        ArrayList<User> logList = new ArrayList<>();
//        for(String message : record){
//            String[] log = message.split(" ");
//            //log[0] : E/L/C, log[1] : UID, log[2] : NIC NAME
//            if(log[0].equals("Enter")){
//                for(User u : logList){
//                    if(u.uid.equals(log[1])){
//                        u.nic = log[2];
//                    }
//                }
//                logList.add(new User(log[1],log[2],true));
//            }
//            else if(log[0].equals("Leave")){
//                String leaveNicname="";
//                for(User u : logList){
//                    if(u.uid.equals(log[1])){
//                       leaveNicname = u.nic;
//                       break;
//                    }
//                }
//                logList.add(new User(log[1], leaveNicname, false));
//            }
//            else{
//                for(User u : logList){
//                    if(u.uid.equals(log[1])){
//                        u.nic = log[2];
//                    }
//                }
//            }
//        }
//        String[] answer = new String[logList.size()];
//        for(int i=0; i<logList.size(); i++){
//            String nicname = logList.get(i).nic;
//            boolean loged = logList.get(i).isLogin;
//            if(loged){
//                answer[i] = nicname+"님이 들어왔습니다.";
//            }
//            else{
//                answer[i] = nicname+"님이 나갔습니다.";
//            }
//        }
//        return answer;
//    }
    public static void main(String[] args){
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] answer = solution(record);
        for(int i=0; i<answer.length; i++){
            System.out.println(answer[i]);
        }
    }
}
class User{
    String uid;
    boolean isLogin;
    public User(String uid, boolean isLogin){
        this.uid = uid;
        this.isLogin = isLogin;
    }
}
