package javaStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class makeJadenCaseString {

    /*
    * JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다.
    * 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다.
    * 문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수를 완성해주세요.
    *
    * s는 길이 1 이상 200 이하인 문자열입니다.
    * s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다.
    * 숫자는 단어의 첫 문자로만 나옵니다.
    * 숫자로만 이루어진 단어는 없습니다.
    *
    * input
    * for the last week
    *
    * return
    * For The Last Week
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String answer = "";
        String[] arr = s.split(" ");

        for(int i=0; i<arr.length; i++) {
            String str = arr[i];

            if(arr[i].length() == 0) {
                answer += " ";
            } else {
                answer += str.substring(0,1).toUpperCase();
                answer += str.substring(1,str.length()).toLowerCase();
                answer += " ";
            }

        }

        if(s.substring(s.length()-1, s.length()).equals(" ")) {
            System.out.println(" @@ answer ==> " + answer);
        }

        System.out.println(" @@ answer ==> " + answer.substring(0, answer.length()-1));

    }
}
