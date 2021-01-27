
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MIKS
 */
public class task1 {
    static int[][] mat = new int[10][6];

   static void func1 (int num, int[][] mat) {
       for (int i = 0; i < num; i++) {
           for (int j = 0; j < num - i - 1; j++) {
               if (mat[j][1] > mat[j + 1][1]) {
                   for (int k = 0; k < 5; k++) {
                       int temp = mat[j][k];
                       mat[j][k] = mat[j + 1][k];
                       mat[j + 1][k] = temp;
                   }
               }
           }
       }
   }

   static void completionTime(int num, int[][] mat) {
       int temp, val = -1;
       mat[0][3] = mat[0][1] + mat[0][2];
       mat[0][5] = mat[0][3] - mat[0][1];
       mat[0][4] = mat[0][5] - mat[0][2];

       for (int i = 1; i < num; i++) {
           temp = mat[i - 1][3];
           int low = mat[i][2];
           for (int j = i; j < num; j++) {
               if (temp >= mat[j][1] && low >= mat[j][2]) {
                   low = mat[j][2];
                   val = j;
               }
           }
           mat[val][3] = temp + mat[val][2];
           mat[val][5] = mat[val][3] - mat[val][1];
           mat[val][4] = mat[val][5] - mat[val][2];
           for (int k = 0; k < 6; k++) {
               int tem = mat[val][k];
               mat[val][k] = mat[i][k];
               mat[i][k] = tem;
           }
       }
   }


   public static void main(String[] args) {
       int num;
       int[] arr = new int [5];
      

       Scanner sc = new Scanner(System.in);

       System.out.println("Enter number of Process: ");
       num = sc.nextInt();

       System.out.println("...Enter the process ID...");
       for (int i = 0; i < num; i++) {
           System.out.println("...Process " + (i + 1) + "...");
           System.out.println("Enter Process Id: ");
           mat[i][0] = sc.nextInt();
           System.out.println("Enter Arrival Time: ");
           mat[i][1] = sc.nextInt();
           System.out.println("Enter Burst Time: ");
           mat[i][2] = sc.nextInt();
       }

       System.out.println("Before Arrange...");
       System.out.println("Process ID\tArrival Time\tBurst Time");
       for (int i = 0; i < num; i++) {
           System.out.printf("%d\t\t%d\t\t%d\n",
               mat[i][0], mat[i][1], mat[i][2]);
       }

       func1(num, mat);
       completionTime(num, mat);
       System.out.println("Average Arrival Time\tAverage Burst Time\tAverage Waiting Time\tAverage Turnaround Time");
       for (int i = 0; i < num; i++) {
          
           arr[0]=arr[0]+mat[i][0];
           arr[1]=arr[1]+mat[i][1];
           arr[2]=arr[2]+mat[i][2];
           arr[3]=arr[3]+mat[i][4];
           arr[4]=arr[4]+mat[i][5];
       }
       System.out.printf("%d\t\t%d\t\t%d\t\t%d\t\t%d\n",
             arr[0]/num, arr[1]/num, arr[2]/num, arr[3]/num, arr[4]/num);
       sc.close();
   }
}
