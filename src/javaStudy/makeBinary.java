package javaStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class makeBinary {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int answer[] = new int[2];

        while(s.length() > 1) {
            int cnt = 0;

            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == '0')
                    answer[1]++;
                else
                    cnt++;
            }

            s = Integer.toBinaryString(cnt);
            answer[0]++;
        }

        System.out.println(" @@ answer => " + Arrays.toString(answer));
    }
}
