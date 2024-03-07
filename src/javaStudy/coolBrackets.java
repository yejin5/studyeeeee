package javaStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.sql.SQLOutput;

public class coolBrackets {

    /*
    * 괄호가 바르게 짝지어졌다는 것은 '('문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다.
    * 예를 들어,
    * ()() 또는 ((())()) 는 올바른 괄호입니다.
    * )()( 또는 )()) 는 올바르지 않은 괄호입니다.
    * '(' 또는 ')'로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고,
    * 올바르지 않은 괄호이면 false 를 return 하는 함수를 완성해주세요.
    *
    * 제한사항
    * 문자열 s의 길이 : 100,000 이하의 자연수
    * 문자열 s는 '(' 또는 ')'로만 이루어져 있습니다.
    *
    * input
    * ()()
    *
    * return
    * true
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        boolean answer = true;
        int result = 0;

        char sArr[] = s.toCharArray();

        if(sArr[0] == ')')
            //return false;

        for(int i=0; i<s.length(); i++) {
            if(sArr[i] == '(') {
                result += 1;
            } else {
                if(result > 0)
                    result -= 1;
            }

        }

        answer = result == 0 ? true : false;

        //return answer;
    }
}
