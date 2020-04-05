import java.util.Scanner;

public class Main {

  static private int counter = 0;
  static private int maxPermutations;

  public static void main(String args[]) {
    // input from the user
    String word = input().toLowerCase();

    // convert the word from String to char[]
    char[] wordInLetters = new char[word.length()];
    for (int i = 0; i < word.length(); i++) {
      wordInLetters[i] = word.charAt(i);
    }

    System.out.println("\nHere are the anagrams of " + word);
    makeAnagrams(wordInLetters, 0);
  }

  private static void makeAnagrams(char[] letters, int fixedLetters) {
    if (fixedLetters == letters.length - 1) {
      if (counter < maxPermutations) {
        counter++;
        output(letters);
      }
    } 
    else {
      for (int j = fixedLetters; j < letters.length; j++) {
        // c is created just to switch letters[fixedLetters] with letters[j]
        char c = letters[fixedLetters];
        letters[fixedLetters] = letters[j];
        letters[j] = c;
        makeAnagrams(letters, fixedLetters + 1);

        // swap back, to avoid errors
        c = letters[fixedLetters];
        letters[fixedLetters] = letters[j];
        letters[j] = c;
      }
    }
  }

  private static String input() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("\nEnter a word:  ");
    String word = scanner.next();
    System.out.print("Enter the maximum number of permutations you want to create:  ");
    maxPermutations = scanner.nextInt();
    scanner.close();

    return word;
  }

  private static void output(char[] letters) {
    System.out.print("\n" + counter + ".  ");
    for (int i = 0; i < letters.length; i++) {
      if (i == 0) {
        char letter = Character.toUpperCase(letters[i]);
        System.out.print(letter);
      } 
      else {
        System.out.print(letters[i]);
      }
    }
  }
}