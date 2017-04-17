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

        // create integer for lives
        int lives = 6;

        // ask player 1 to enter word, then scan it in
        System.out.println("Player 1: Enter a word for Player 2 to guess:");
        String word = input.nextLine();

        // blank spaces
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        // create int for wordlength
        int wordlength = word.length();

        // for loop for each letter in word
        for (int i = 0; i < wordlength; i++) {
            // create substring for a letter
            String temp = word.substring(i, i + 1);
            // convert letter into char
            char wordChar = temp.charAt(0);
            // replace every char with a dash
            word = word.replace(wordChar, '-');
        }

        // output hidden word
        System.out.println(word);
        // create stringbuilder for word
        StringBuilder finalWord = new StringBuilder(word);

        // loop while lives are over 0
        while (lives > 0) {
            // tell player 2 to guess a letter
            System.out.println("Player 2: Guess a letter:");
            // scan in guess then convert it to char
            String guess = input.nextLine();
            char guessChar = guess.charAt(0);

            // if the word contains the guess
            if (word.contains(guess)) {
                // for loop for each letter in word
                for (int i = 0; i < wordlength; i++) {
                    char temp = word.charAt(i);
                    // if letter is the guess, replace it with the guess
                    if (temp == guess.charAt(0)) {
                        finalWord.setCharAt(i, guessChar);
                        System.out.println(finalWord);

                    } // if word doesn't contain guess, subtract 1 life and tell user how many lives are left
                    else {
                        lives--;
                        System.out.println("You now have " + lives + " lives.");
                    }

                    // if player runs out of lives, end game
                    if (lives == 0) {
                        System.out.println("You lose.");
                        break;
                    }
                }

            }
        }
    }
}
