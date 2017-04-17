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

        int lives = 6;

        System.out.println("Player 1: Enter a word for Player 2 to guess:");
        String word = input.nextLine();

        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        int wordlength = word.length();

       
       

       
           
           for (int i = 0; i < wordlength; i++) {
               
               String temp = word.substring(i, i+1);
               
               char wordChar = temp.charAt(0);
               
               word = word.replace (wordChar, '-');
           }

           
           System.out.println(word);
           
           StringBuilder finalWord = new StringBuilder(word);
           
           while (lives > 0) {
               
               System.out.println("Player 2: Guess a letter:");
               
               String guess = input.nextLine();
               char guessChar = guess.charAt(0);
               
            if (word.contains(guess)) {
                   
                   for (int i = 0; i < word.length();) {
                       char temp = word.charAt(i);
                     
                   if (temp == guess.charAt(0)) 
                         finalWord.setCharAt(i, guess.charAt(0));
                   i--;
                       
                   }
                       System.out.println(finalWord);
                       
                   }
               }
           }
    }
