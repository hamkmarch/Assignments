package average;

//Needed for input and sleeping of code
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Average 
{
    //Need to throws Exception to allow number input into brackets of sleep code    
    public static void main(String[] args) throws Exception 
    {
        //THE SLEEPING IS UNNECESSARY JUST MAKES IT OUTPUT NICER    
        
        //All variables needed to run program
        Scanner input = new Scanner(System.in);
        int intCounter = 0;
        int intNumberOfNumbers;
        double dblNumberInput;
        double dblTotal = 0;
        double dblAverage;
    
        //Initial prompt
        System.out.println("How many numbers do you want to input?");
        intNumberOfNumbers = input.nextInt();
        System.out.println("");
        
        //Used to disallow the amount of numbers to be inputted to be 0
        while (intNumberOfNumbers == 0)
        {
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("That is not an option");
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("How many numbers do you want to input?");
            intNumberOfNumbers = input.nextInt();
            System.out.println("");
        }    
    
        //Counter for the addition of the numbers inputted
        while(intCounter != intNumberOfNumbers)
        {
            System.out.println("Please input a number");
            dblNumberInput = input.nextDouble();
        
            //Used to disallow the number inputted to be 0
            while (dblNumberInput == 0)
            {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("Thats not an option");
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("");
                System.out.println("Please input a number");
                dblNumberInput = input.nextDouble();
            }
        
            //Running total outputted and counter increased by 1
            dblTotal = dblTotal + dblNumberInput;
            intCounter ++;
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("The total is " + dblTotal);
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("");
        }
    
        //Just to make it look better
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.print("Calculating");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.print(".");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.print(".");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.print(".");
        TimeUnit.MILLISECONDS.sleep(3500);
    
        //Solves and prints the average
        dblAverage = (dblTotal/intNumberOfNumbers);
        System.out.println("");
        System.out.println("The average is " + dblAverage);
    }
}
