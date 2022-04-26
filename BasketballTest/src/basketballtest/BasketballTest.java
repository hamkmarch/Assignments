/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballtest;

/**
 *
 * @author hmarch
 */
import java.util.Scanner;
public class BasketballTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        
        int[] intScore = new int[3];
        int intPlayerCounter = 0;
        int intPlayerAmount;
        int intShotCounter = 0;
        
        intScore[0] = 0;
        intScore[1] = 2;
        intScore[2] = 3;
        
        int intScoreLength = intScore.length;
        int intScoreRNG = (int) (Math.random() * intScoreLength);
        int intScoreResult = intScore[intScoreRNG];
        
        System.out.println("How many players will play?");
        
        intPlayerAmount = input.nextInt();
        
        while (intPlayerCounter != intPlayerAmount)
        {
            System.out.println("What is your name?");
            
            while (intShotCounter != 10)
            {
                
            }    
        }    
    }
    
}
