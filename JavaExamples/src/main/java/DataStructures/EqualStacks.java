package DataStructures;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class EqualStacks {

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter();

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);
        
        System.out.println("result>>>>>>."+result);

        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();*/
    }
    
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
    	
    	int total1=0,total2=0,total3=0;
    	Queue<Integer> stack1 = new LinkedList<Integer>();
    	Queue<Integer> stack2 = new LinkedList<Integer>();
    	Queue<Integer> stack3 = new LinkedList<Integer>();
    	
    	if(h1.length == 0 || h2.length == 0 || h3.length==0) {
    		return -1;
    	}
    	for(int i=0;i<h1.length;i++) {
    		total1 += h1[i];
    		stack1.add(h1[i]);
    	}
    	for(int i=0;i<h2.length;i++) {
    		total2 += h2[i];
    		stack2.add(h2[i]);
    	}
    	for(int i=0;i<h3.length;i++) {
    		total3 += h3[i];
    		stack3.add(h3[i]);
    	}
    	
    	while(!((total1 == total2) && (total2 == total3) && (total3 == total1))) {
    		if((total1>total2) || (total1>total3)) {
    			total1 -= stack1.remove();
    		} 
    		if((total2>total1) || (total2>total3)) {
    			total2 -= stack2.remove();
    		} 
    		if((total3>total1) || (total3>total2)) {
    			total3 -= stack3.remove();
    		}
    	}
    	return total1;
    }
}
