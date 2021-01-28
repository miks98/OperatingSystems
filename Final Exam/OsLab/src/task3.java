//Java Program for Bankers Algorithm 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MIKS
 */

class task3 {
    int n = 3;
 // Number of processes 
    int m = 3; 
// Number of resources 
    int need[][] = new int[n][m]; 
    int [][]max; int [][]alloc; 
    int []avail; 
    int safeSequence[] = new int[n]; 
    boolean flag;
    
    void initializeValues() { 
        // P0, P1, P2 are the Process names here 
        // Allocation Matrix 
        alloc = new int[][] { { 0, 0, 0 }, /*P0*/{ 0, 0, 0 }, /*P1*/ {0, 0, 0 }}; //P2 
        // MAX Matrix 
        max = new int[][] { { 0, 0, 2 }, /*P0*/ { 2,0, 0 }, /*P1*/ {0, 0, 0 }}; //P2 
        // Available Resources 
        avail = new int[] { 3, 2, 2 }; 
        
    }
    void isSafe() { 
        int count=0;
        //visited array to find the already allocated process 
        boolean visited[] = new boolean[n]; 
        for (int i = 0;i < n; i++) { 
            visited[i] = false;
        } 
        //work array to store the copy of available resources 
        int work[] = new int[m]; 
        for (int i = 0;i < m; i++) { 
            work[i] = avail[i];
        } 
        while (count<n)
        { boolean flag = false;
        for (int i = 0;i < n; i++)
        { if (visited[i] == false) { int j;
        }   int j; 
        for (j = 0;j < m; j++) 
        { if (need[i][j] > work[j]) break; }
        if (j == m) { safeSequence[count++]=i;
        }
        visited[i]=true; 
        flag=true; 
        for (j = 0;j < m; j++) 
        { work[j] = work[j]+alloc[i][j];
        } 
        } 
        }
    
    if (flag == false)
    { 
    }  
    if (count < n) 
    {
        System.out.println("The System is UnSafe!");
    }else 
    { System.out.println("One of the SAFE Sequence:"); 
    
    for (int i = 0;i < n; i++) {
        System.out.print("P" + safeSequence[i]);
    }       int i = 0; 
if (i != n-1) 
        System.out.print(" -> "); 
    }
    }
    void calculateNeed() { 
        for (int i = 0;i < n; i++) 
            { for (int j = 0;j < m; j++) {
                need[i][j] = max[i][j]-alloc[i][j];
            }
    } }

    public static void main(String[] args) { 
        int i, j, k;
        task3 obj = new task3(); 
        obj.initializeValues();
        //Calculate the Need Matrix 
        obj.calculateNeed(); // Check whether system is in safe state or not 
        obj.isSafe(); } } 