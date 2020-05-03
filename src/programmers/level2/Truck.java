package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Truck {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time=0;
        Queue<Trucks> waitTrucks = new LinkedList<>();
        for(int i : truck_weights){
            waitTrucks.add(new Trucks(i, 0));
        }

        Queue<Trucks> movingTrucks = new LinkedList<>();
        while(true){
            time++;
            if(!movingTrucks.isEmpty()){
                int size = movingTrucks.size();
                while(size-- > 0){
                    Trucks temp = movingTrucks.poll();
                    if(temp.time >= bridge_length){
                        continue;
                    }else{
                        temp.time++;
                        movingTrucks.add(temp);
                    }
                }
            }

            if(movingTrucks.isEmpty() && waitTrucks.isEmpty())
                break;

            if(movingTrucks.isEmpty() && waitTrucks.peek().weight < weight){
                Trucks temp = waitTrucks.poll();
                movingTrucks.add(new Trucks(temp.weight, temp.time+1));
            }else {
                int sum=0;
                int size = movingTrucks.size();
                while(size-- > 0){
                    Trucks temp = movingTrucks.poll();
                    sum += temp.weight;
                    movingTrucks.add(temp);
                }
                if(!waitTrucks.isEmpty()) {
                    if (sum + waitTrucks.peek().weight <= weight) {
                        Trucks temp = waitTrucks.poll();
                        movingTrucks.add(new Trucks(temp.weight, temp.time+1));
                    }
                }
            }
        }
        return time;
    }

    public static void main(String[] args) {
        int blen = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        System.out.println(solution(blen,weight,truck_weights));
    }
}
class Trucks{
    int weight;
    int time;
    public Trucks(int weight, int time){
        this.weight=weight;
        this.time=time;
    }
}
