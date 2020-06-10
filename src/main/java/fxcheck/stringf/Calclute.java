package fxcheck.stringf;

import java.util.Stack;

/**
 * Create by xudong
 * Author: xudong
 * Date: 2020-06-09
 */
public class Calclute {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int length = s.length();
        char sign = '+';
        int n = 0;
        for(int i = 0; i < length; i++){
            char c = s.charAt(i);
            if(!iscompute(c) && c!=' '){
                n = n*10 + (c - '0');
            }
            if(iscompute(c) || i == length-1){
                switch (sign){
                    case '+': stack.push(n); break;
                    case '-': stack.push(-n); break;
                    case '*':
                        int pre = stack.pop();
                        stack.push(pre * n);
                        break;
                    case '/':
                        int pres = stack.pop();
                        stack.push(pres/n);
                        break;
                }
                n = 0;
                sign = c;

            }
        }
        int result = 0;
        while (!stack.isEmpty()){
            result += stack.pop();
        }

        return result;

    }

    private boolean iscompute(char tmp){
        return tmp=='*' || tmp=='/' || tmp == '+' || tmp == '-';
    }


    public static void main(String[] args) {
        Calclute c = new Calclute();
        String jisuan = "3+2*2";
        int result = c.calculate(jisuan);
        System.out.println(result);
    }
}
