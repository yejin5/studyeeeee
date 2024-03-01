package javaStudy;

import java.util.Scanner;

public class getAvg {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        /*int arr[] = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }*/

        long sum = 0;
        long max = 0;

        for(int i=0; i<n; i++) {
            int temp = sc.nextInt();
            if(temp > max) max = temp;
            sum += temp;

            //if(arr[i] > max) max = arr[i];
            //sum += arr[i];
        }

        System.out.println(" @@ avg ==> " + sum*100.0/max/n);

    }
}
