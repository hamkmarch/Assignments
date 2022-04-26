package bubblesort;

import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) 
    {   
        
    Scanner input = new Scanner(System.in); 
        
    int intNumberOfNumbers;
    int intCounter;
    int intSwap;
    int intInput;
   
    System.out.println("Input number of integers to sort");
    intNumberOfNumbers = input.nextInt();
 
    int intInputArray[] = new int[intNumberOfNumbers];
 
    System.out.println("Enter " + intNumberOfNumbers+ " integers");
 
    for (intCounter = 0; intCounter < intNumberOfNumbers; intCounter++)
    {
        intInputArray[intCounter] = input.nextInt();
    }    
        
    for (intCounter = 0; intCounter < ( intNumberOfNumbers - 1 ); intCounter++) 
    {
        for (intInput = 0; intInput < intNumberOfNumbers - intCounter - 1; intInput++) 
        {
            if (intInputArray[intInput] > intInputArray[intInput+1])
            {
                intSwap = intInputArray[intInput];
                intInputArray[intInput] = intInputArray[intInput + 1];
                intInputArray[intInput + 1] = intSwap;
            }
        }
    }
 
    System.out.print("The numbers have been sorted: ");
 
    for (intCounter = 0; intCounter < intNumberOfNumbers; intCounter++)
    {
        System.out.print(intInputArray[intCounter] + " ");
    }
    
    System.out.println("");
    
}
    
}
