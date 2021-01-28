/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MIKS
 */
class task2 
{ 
	// Method to allocate memory to 
	// blocks as per First fit algorithm 
	static void firstFit(int blockSize[], int m, 
						int processSize[], int n) 
	{ 
		// Stores block id of the 
		// block allocated to a process 
		int allocation[] = new int[n]; 
	
		// Initially no block is assigned to any process 
		for (int i = 0; i < allocation.length; i++) 
			allocation[i] = -1; 
	
		// pick each process and find suitable blocks 
		// according to its size ad assign to it 
		for (int i = 0; i < n; i++) 
		{ 
			for (int j = 0; j < m; j++) 
			{ 
				if (blockSize[j] >= processSize[i]) 
				{ 
					// allocate block j to p[i] process 
					allocation[i] = j; 
	
					// Reduce available memory in this block. 
					blockSize[j] -= processSize[i]; 
	
					break; 
				} 
			} 
		} 
	
		System.out.println("\nProcess No.\tProcess Size\tBlock no."); 
		for (int i = 0; i < n; i++) 
		{ 
			System.out.print(" " + (i+1) + "\t\t" + 
							processSize[i] + "\t\t"); 
			if (allocation[i] != -1) 
				System.out.print(allocation[i] + 1); 
			else
				System.out.print("Not Allocated"); 
			System.out.println(); 
		} 
	} 
	
        static void worstFit(int blockSize[], int m, int processSize[],  
                                                 int n) 
{ 
    // Stores block id of the block allocated to a 
    // process 
   int allocation[] = new int[n]; 
	
		// Initially no block is assigned to any process 
		for (int i = 0; i < allocation.length; i++) 
			allocation[i] = -1; 
	
    // pick each process and find suitable blocks 
    // according to its size ad assign to it 
    for (int i=0; i<n; i++) 
    { 
        // Find the best fit block for current process 
        int wstIdx = -1; 
        for (int j=0; j<m; j++) 
        { 
            if (blockSize[j] >= processSize[i]) 
            { 
                if (wstIdx == -1) 
                    wstIdx = j; 
                else if (blockSize[wstIdx] < blockSize[j]) 
                    wstIdx = j; 
            } 
        } 
  
        // If we could find a block for current process 
        if (wstIdx != -1) 
        { 
            // allocate block j to p[i] process 
            allocation[i] = wstIdx; 
  
            // Reduce available memory in this block. 
            blockSize[wstIdx] -= processSize[i]; 
        } 
    } 
  
    System.out.println( "\nProcess No.\tProcess Size\tBlock no.\n");
    for (int i = 0; i < n; i++) 
    { 
        System.out.println( "   " +( i+1)+ "\t\t" + processSize[i] + "\t\t"); 
        if (allocation[i] != -1) 
            System.out.println("allocation[i] + 1"); 
        else
            System.out.println( "Not Allocated");
    } 
} 
	
          static  void bestFit(int blockSize[], int m, int processSize[], int n) 
{ 
    // Stores block id of the block allocated to a 
    // process 
    int allocation[] = new int[n]; 
	
		// Initially no block is assigned to any process 
		for (int i = 0; i < allocation.length; i++) 
			allocation[i] = -1; 
	
    // pick each process and find suitable blocks 
    // according to its size ad assign to it 
    for (int i=0; i<n; i++) 
    { 
        // Find the best fit block for current process 
        int bestIdx = -1; 
        for (int j=0; j<m; j++) 
        { 
            if (blockSize[j] >= processSize[i]) 
            { 
                if (bestIdx == -1) 
                    bestIdx = j; 
                else if (blockSize[bestIdx] > blockSize[j]) 
                    bestIdx = j; 
            } 
        } 
  
        // If we could find a block for current process 
        if (bestIdx != -1) 
        { 
            // allocate block j to p[i] process 
            allocation[i] = bestIdx; 
  
            // Reduce available memory in this block. 
            blockSize[bestIdx] -= processSize[i]; 
        } 
    } 
  
    System.out.println("\nProcess No.\tProcess Size\tBlock no.\n");
    for (int i = 0; i < n; i++) 
    { 
         System.out.println("   " + (i+1) + "\t\t" + (processSize[i]) + "\t\t"); 
        if (allocation[i] != -1) 
            System.out.println(allocation[i] + 1);
        else
            System.out.println("Not Allocated");
    } 
} 
// Driver Code 
	public static void main(String[] args) 
	{ 
            int blockSize[] = {110,450,100,250,500}; 
            int processSize[] = {212, 417, 112, 426}; 
            int m = blockSize.length; 
            int n = processSize.length; 
                
            System.out.println("First Fit");
            firstFit(blockSize, m, processSize, n); 
            System.out.println("--------------------------");
            System.out.println("Worst Fit");
            worstFit(blockSize, m, processSize, n); 
            System.out.println("--------------------------");
            System.out.println("Best Fit");
            bestFit(blockSize, m, processSize, n); 
	} 
} 
