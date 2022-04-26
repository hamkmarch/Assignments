package carsalestest;

import java.util.Scanner;

public class CarSalesTest {

    static Scanner Input = new Scanner (System.in);
    
    public static int intCarsSold = 0;
    public static int intLoopCounter = 1;
    public static int intSalesPersonInput;
    public static int intCarSoldPrice;
    public static double dblCommissionRec;
    public static int intSalesPersonAmount;
    
    public static void main(String[] args) {
        
        Input();
        
        String strSalesPersonName[] = new String[intSalesPersonAmount];
        double dblCommissionRecTotal[] = new double[intSalesPersonAmount];
        
        NameInput(strSalesPersonName);
        Processing(strSalesPersonName, dblCommissionRecTotal);
        Sorting(strSalesPersonName, dblCommissionRecTotal);
        Output(strSalesPersonName, dblCommissionRecTotal);
       
    }
    
    public static void NumberInput() {
        
        while(!Input.hasNextInt())
        {
            Input.next();
            System.out.println("Please input a number");
        }  
        
    }
    
    public static void Input(){
    
        System.out.println("How many sales people were there this month?");
         
        NumberInput(); 
        
        intSalesPersonAmount = Input.nextInt();
        
        //Loop to prevent input of more than 5
        while (intSalesPersonAmount < 1 || intSalesPersonAmount > 5)
        {
            System.out.println("The most you can have is 5");
            
            NumberInput();
            
            intSalesPersonAmount = Input.nextInt();
            
        } 
    
    }
    
    public static void NameInput(String strSalesPersonName[]){
    
        int intSalesPersonCounter = 0;
        
        //Input.nextInt() needs to fire a blank input otherwise the input for the player names won't work
        strSalesPersonName[intSalesPersonCounter] = Input.nextLine();
        
        //Loop for the input of salesperson names
        while (intSalesPersonCounter != intSalesPersonAmount)
        {
            System.out.println("What is Salesperson " + (intSalesPersonCounter + 1) + "'s name?");
            strSalesPersonName[intSalesPersonCounter] = Input.nextLine();
            intSalesPersonCounter ++;
        }
    
    }
    
    public static void Processing(String strSalesPersonName[], double dblCommissionRecTotal[]){
    
        while (intLoopCounter == 1)
        {    
            System.out.print("Who sold a car?");
            
            int intSalesPersonCounter = 0;
            
            //Loop to print IDs of salespeople
            while (intSalesPersonCounter != intSalesPersonAmount)
            {
                System.out.print(" - " + strSalesPersonName[intSalesPersonCounter] + " has ID " + (intSalesPersonCounter + 1));
                intSalesPersonCounter ++;
            }
            
            System.out.println();
            System.out.println("Input 0 to stop");
            
            if (intLoopCounter == 1)
            {
                NumberInput(); 
                intSalesPersonInput = Input.nextInt();
                
                //Loop to prevent unavailable ID inputted
                while (intSalesPersonAmount < 1 || intSalesPersonInput > intSalesPersonAmount)
                {
                    System.out.println("Please input a valid ID");
                    
                    NumberInput();
                    
                    intSalesPersonInput = Input.nextInt();
                   
                }    
                
                //If statement to stop loop when 0 inputted
                if (intSalesPersonInput == 0)
                {
                    intLoopCounter ++;
                } 
            
                else
                {    
                    
           
                    System.out.println("How much did the car sell for?");
                
                    if (intSalesPersonInput != 0)
                    {    
                        NumberInput();
                        
                        intCarSoldPrice = Input.nextInt();
                        
                        //If statements - > 20000 = 10% || <= 20000 = 8%
                        if (intCarSoldPrice > 20000)
                        {
                            dblCommissionRec = intCarSoldPrice * 0.1;
                        }
            
                        else
                        {   
                            dblCommissionRec = intCarSoldPrice * 0.08;
                        }
                        
                        //Rounding
                        dblCommissionRec = dblCommissionRec * 100;
                        dblCommissionRec = Math.round(dblCommissionRec);
                        dblCommissionRec = dblCommissionRec / 100;
                        
                        //Adding commission to salesperson total sales
                        dblCommissionRecTotal[intSalesPersonInput - 1] = dblCommissionRecTotal[intSalesPersonInput - 1] + dblCommissionRec;
                        
                        //Rounding
                        dblCommissionRecTotal[intSalesPersonInput - 1] = dblCommissionRecTotal[intSalesPersonInput - 1] * 100;
                        dblCommissionRecTotal[intSalesPersonInput - 1] = Math.round(dblCommissionRecTotal[intSalesPersonInput - 1]);
                        dblCommissionRecTotal[intSalesPersonInput - 1] = dblCommissionRecTotal[intSalesPersonInput - 1] / 100;
                        
                        System.out.println(strSalesPersonName[intSalesPersonInput - 1] + " earned $" + dblCommissionRec);
            
                        intCarsSold ++;
                        
                    }
                }
            }    
        } 
    
    }
    
    public static void Sorting(String strSalesPersonName[], double dblCommissionRecTotal[]){
    
        
        //Sorting names and sales amounts simultaneously (needs to be a for loop, tried while and didn't work
        for (int intCounter = 0; intCounter < (intSalesPersonAmount - 1); intCounter ++)         
        {
            
            for (int intSecondCounter = 0; intSecondCounter < intSalesPersonAmount - intCounter - 1; intSecondCounter++) 
            {
                
                if (dblCommissionRecTotal[intSecondCounter] > dblCommissionRecTotal[intSecondCounter + 1])
                {
                    String strSwap = strSalesPersonName[intSecondCounter];
                    strSalesPersonName[intSecondCounter] = strSalesPersonName[intSecondCounter + 1];
                    strSalesPersonName[intSecondCounter + 1] = strSwap;
                    double dblSwap = dblCommissionRecTotal[intSecondCounter];
                    dblCommissionRecTotal[intSecondCounter] = dblCommissionRecTotal[intSecondCounter + 1];
                    dblCommissionRecTotal[intSecondCounter + 1] = dblSwap;
                }
            
            }
            
        }
    
    }
    
    public static void Output(String strSalesPersonName[], double dblCommissionRecTotal[]){
    
        int intSalesPersonCounter = intSalesPersonAmount - 1;
        double dblTotalSalesAmount = 0;
        int intTotalCounter = 0;
        
        //Loop to add up total sales
        while (intTotalCounter != intSalesPersonAmount)
        {
            dblTotalSalesAmount = dblTotalSalesAmount + dblCommissionRecTotal[intTotalCounter];
            intTotalCounter ++;
        } 
        
        //Rounding
        dblTotalSalesAmount = dblTotalSalesAmount * 100;
        dblTotalSalesAmount = Math.round(dblTotalSalesAmount);
        dblTotalSalesAmount = dblTotalSalesAmount / 100;
        
        
        System.out.println("$" + dblTotalSalesAmount + " was earned on " + intCarsSold + " sales.");
        
        //Print salesperson sales amounts
        while (intSalesPersonCounter != -1)
        {
            System.out.println(strSalesPersonName[intSalesPersonCounter] + " earned $" + dblCommissionRecTotal[intSalesPersonCounter]);
            intSalesPersonCounter --;
        }
    
    }
    
}
