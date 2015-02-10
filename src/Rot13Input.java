import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The Rot13Input encodes and decodes text.
 *
 * This program reads lines of text from the user, encodes them using the
 * trivial "Rot13" substitution cipher, and then prints out the encoded lines.
 *
 * This example is from _Java Examples in a Nutshell_. (http://www.oreilly.com)
 * Copyright (c) 1997 by David Flanagan
 * This example is provided WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, modify, and distribute it for non-commercial purposes.
 * For any commercial use, see http://www.davidflanagan.com/javaexamples
 */
public class Rot13Input {

  /**
   * Primary method for the Rot13Input Function.
   * @param args Ignored.
   * @throws IOException Error messages for IO
   */
  public static void main(String[] args) throws IOException {

    // Get set up to read lines of text from the user
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    for (;;) {
      System.out.print("> ");
      String line = in.readLine();
      if ((line == null) || (line.equals("quit"))) {
        break;
      }
      StringBuffer buffer = new StringBuffer(line);
      for (int i = 0; i < buffer.length(); i++) {
        buffer.setCharAt(i, rot13(buffer.charAt(i)));
      }
      System.out.println(buffer);
    }
  }

  /**
   * This method performs the Rot13 substitution cipher.  It "rotates"
   * each letter 13 places through the alphabet.  Since the Latin alphabet
   * has 26 letters, this method both encodes and decodes.
   * @param character Character to be decoded
   * @return The decoded character
   */
  public static char rot13(char character) {

    // Handle uppercase characters
    if ((character >= 'A') && (character <= 'Z')) {
      character += 13;
      if (character > 'Z') {
        character -= 26;
      }
    }

    // Handle lowercase characters
    if ((character >= 'a') && (character <= 'z')) {
      character += 13;
      if (character > 'z') {
        character -= 26;
      }
    }
    return character;
  }
}