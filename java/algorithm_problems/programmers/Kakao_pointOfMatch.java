package programmers;

import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kakao_pointOfMatch {
    private static final Pattern URL = Pattern.compile("<meta property=\"og:url\" content=\"https://(.+?)\"/>");
    private static final Pattern External_URL = Pattern.compile("<a href=\"https://(.+?)\">");
    static int solution(String word, String[] pages){
        List<pageInfo> plist = new ArrayList<>();
        int idx=0;

        //페이지 탐색
        for(String str : pages){
            int start = str.indexOf("<head>");
            int end = str.indexOf("</head>");
            String head = str.substring(start,end);
            Matcher m = URL.matcher(head);
            String url="";
            if(m.find()){
                url = m.group(1);
            }

            Queue<String> hrefs = new LinkedList<>();
            start = str.indexOf("<body>");
            end = str.indexOf("</body>");
            String body = str.substring(start,end);
            m = External_URL.matcher(body);
            int linkCnt=0;
            while(m.find()){
                hrefs.add(m.group(1));
                linkCnt++;
            }
            word = word.toLowerCase();
            body = body.toLowerCase();
            int defaultCnt=0;
            int find = body.indexOf(word);
            while(find != -1){
                char pre = body.charAt(find-1);
                char post = body.charAt(find+word.length());
                if(!Character.isLetter(pre) && !Character.isLetter(post)){ //앞 뒤 단어가 문자가 아닐경우 카운트
                    defaultCnt++;
                }
                find = body.indexOf(word, find+1);
            }
            plist.add(new pageInfo(idx,url,defaultCnt,linkCnt));
            while(!hrefs.isEmpty()){
                plist.get(idx).link.add(hrefs.poll());
            }
            idx++;
        }

        //점수 계산
        for(pageInfo target : plist){
            for(pageInfo temp : plist){
                if(target==temp) continue;
                if(!temp.link.isEmpty()){
                    if(temp.link.contains(target.url)){
                        if(temp.pointOFBasic != 0 && temp.numOfLink != 0){
                            target.pointOfLink += (temp.pointOFBasic / temp.numOfLink);
                        }
                    }
                }
            }
            target.pointOfMatch = target.pointOFBasic + target.pointOfLink;
        }

        //매칭 점수 기준 내림차순, 인덱스 기준 오름차순 정렬
        Collections.sort(plist, new Comparator<pageInfo>() {
            @Override
            public int compare(pageInfo o1, pageInfo o2) {
                if(o1.pointOfMatch < o2.pointOfMatch){
                    return 1;
                }else if(o1.pointOfMatch == o2.pointOfMatch){
                    if(o1.index > o2.index){
                        return 1;
                    }
                }
                return -1;
            }
        });

        return plist.get(0).index;

    }
    public static void main(String[] args){
        String word = "blind";
        String[] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};
        int ans = solution(word, pages);
        System.out.println(ans);

    }
}
class pageInfo{
    int index;
    String url;
    double pointOFBasic;
    double numOfLink;
    double pointOfLink=0;
    double pointOfMatch=0;
    List<String> link = new ArrayList<>();
    public pageInfo(int index, String url, double pointOFBasic, double numOfLink){
        this.index=index;
        this.url = url;
        this.pointOFBasic = pointOFBasic;
        this.numOfLink = numOfLink;
    }
}
