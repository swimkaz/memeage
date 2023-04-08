import java.io.File;
import java.io.IOException;
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Memeage Class: Setting and Getting Memes into Images
// Files: FourBytes, Color, Image, ColorPlusChar, IO.File, IO.IOException
// Course: CS300 Fall 2019
//
// Author: Karen Zhou
// Email: kmzhou2@wisc.edu
// Lecturer's Name: Professor Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: NONE
// Partner Email: NONE
// Partner Lecturer's Name: NONE
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: CS Learning Tutor helped me by suggesting a way to know if the '\0' is never
// reached in the image while getting the meme. He suggested that I use a boolean
// variable that is set to true, and it is changed to false if it is reached
// and when it is still true at the end, the exception is thrown and nothing
// is returned
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * setting and getting memes from image files
 * 
 * @author swimk
 *
 */
public class Memeage extends Image {
  public Memeage(File file) throws IOException {
    super(file);
  }

  public Memeage(File file, String meme) throws IOException, IllegalArgumentException {
    super(file);
    try {
      setMeme(meme);
      super.saveAs(file);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException(e.getMessage());
    }
  }

  /**
   * sets meme into object
   * 
   * @param meme, string to be set in image
   */
  public void setMeme(String meme) throws IllegalArgumentException {
    int length = (super.getHeight()) * (super.getWidth());
    if (meme.length() >= length) {
      throw new IllegalArgumentException("The meme string is larger than or equal to "
          + Integer.toString(length) + " pixels, the pixel #s of image");
    }
    char[] characterlist = new char[length];
    for (int a = 0; a < length; a++) {
      if (a < meme.length())
        characterlist[a] = meme.charAt(a);
    }
    int b = 0;
    for (int i = 0; i < super.getHeight(); i++) {
      for (int j = 0; j < super.getWidth(); j++) {
        FourBytes check = new FourBytes(characterlist[b]);
        if (check.getInt() > 127) {
          throw new IllegalArgumentException(
              "The character at index" + b + "'s ACSII code is" + "greater than 127");
        }
        if (b <= meme.length()) {
          if (b == meme.length()) {
            ColorPlusChar character = new ColorPlusChar(super.getColor(j, i), '\0');
            Color c = new Color(character.getARGB());
            super.setColor(j, i, c);
          } else {
            ColorPlusChar character = new ColorPlusChar(super.getColor(j, i), characterlist[b]);
            Color c = new Color(character.getARGB());
            super.setColor(j, i, c);
            b++;
          }
        }
      }
    }
  }

  public String getMeme() throws IllegalStateException {
    char[] charList = new char[(super.getWidth() * super.getWidth())];
    int a = 0;
    String results = "";
    char check = 'a';
    boolean f = true;
    while (check != '\0') {
      for (int i = 0; i < super.getHeight(); i++) {
        for (int j = 0; j < super.getWidth(); j++) {
          ColorPlusChar character = new ColorPlusChar(super.getColor(j, i));
          charList[a] = character.revealChar();
          check = character.revealChar();
          FourBytes c = new FourBytes(character.revealChar());
          if (c.getInt() > 127) {
            throw new IllegalStateException("A character is larger than 127 in ASCII");
         }
          if (check == '\0') {
            f = false;
          }
          a++;
          results = results + String.valueOf(character.revealChar());
        }
      }
    }
    if (f == true) {
      throw new IllegalStateException(
          "None of the characters has a null('\0'), which signifies" + "the end of the message");
    } else
      return results;
  }
}
