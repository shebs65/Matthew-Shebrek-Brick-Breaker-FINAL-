/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

import java.util.Scanner;

/**
 *
 * @author Matt
 */
public class Assignment5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int lives = 0;
        
       
        
        System.out.println("Player 1: Enter a word for Player 2 to guess:");
        String word = input.nextLine();
        
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        
        int wordlength = word.length();
        
        String hiddenWord = "";
        
        for (int i = 0; i < wordlength; i++){
            System.out.print("-" + hiddenWord);
        
            
        while (lives >0) {
            System.out.println("You have " + lives + " lives left. Guess a letter:");
           String guess = input.nextLine();
           char guessc = (guess.charAt(0));
           
           for (int x = 0; x < wordlength; x++){
               if (word.charAt(i) == guessc)
                   hiddenWord.setCharAt(i, guess.charAt(0));
           }
           
        }
            
    }
    
}
