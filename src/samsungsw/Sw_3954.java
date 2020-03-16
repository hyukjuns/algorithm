package samsungsw;

import java.io.IOException;
import java.util.Scanner;

public class Sw_3954 {
    static int time;
    static int[] stack = new int[4097];
    static int[] loopStack = new int[4097];
    static int maxPcIdx;
    static void print(int target){

    }
    static void makePair(char[] opcode, int opcodeSize){
        int top=-1;
        for(int i=0; i<opcodeSize; i++){
            if(opcode[i]=='['){
                stack[++top]=i;
            }
            else if(opcode[i]==']'){
                stack[++top] = i;
                loopStack[stack[top]] = stack[top - 1];
                loopStack[stack[top-1]] = i;
                top -= 2;
            }
        }
    }
    static boolean startProgram(int[] memory, char[] opcode, String input){
        int pc=0;
        int idx=0;
        int inputPointer=0;
        while(pc < opcode.length){
            if(time > 50000000)
                break;
            time++;
            int fetch = opcode[pc];
            switch (fetch){
                case '-':
                    memory[idx] = (memory[idx]-1) % 256;
                    break;
                case '+':
                    memory[idx] = (memory[idx]+1) % 256;
                    break;
                case '<':
                    if(idx==0){
                        idx = memory.length-1;
                    }
                    else{
                        idx = idx - 1;
                    }
                    break;
                case '>':
                    if(idx==memory.length-1){
                        idx = 0;
                    }
                    else{
                        idx = idx + 1;
                    }
                    break;
                case '[':
                    if(memory[idx] == 0){
                        pc = loopStack[pc];
                    }
                    break;
                case ']':
                    if(memory[idx] != 0){
                        pc = loopStack[pc];
                    }
                    break;
                case '.':
                    print(memory[idx]);
                    break;
                case ',':
                    if(inputPointer == input.length()){
                        memory[idx] = 255;
                    }
                    else{
                        memory[idx] = input.charAt(inputPointer++);
                    }
                    break;
            }
            pc++;
            maxPcIdx = pc > maxPcIdx ? pc : maxPcIdx;
        }
        if(time > 50000000){
            if(pc < opcode.length)
                return true;
            else if(pc >= opcode.length)
                return false;
        }
        return false;

    }
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        while(testCase-- >0){
            time=0;
            int memSize = sc.nextInt();
            int opcodeSize = sc.nextInt();
            int inputSize = sc.nextInt();
            int[] memory = new int[memSize];
            char[] opcode = new char[opcodeSize];
            String opcodeStr = sc.next();
            for(int i=0; i<opcodeSize; i++){
                opcode[i] = opcodeStr.charAt(i);
            }
            String input = sc.next();
            makePair(opcode,opcodeSize);
            maxPcIdx=0;
            boolean isLoops = startProgram(memory,opcode,input);
            if(isLoops)
                System.out.println("Loops "+loopStack[maxPcIdx]+" "+maxPcIdx);
            else
                System.out.println("Terminates");
        }
    }
}
