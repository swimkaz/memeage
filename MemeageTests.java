import java.io.File;
import java.io.IOException;

//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: FourBytes, Color, Image, ColorPlusChar, Memeage Tester Class
// Files: IO.file, IO.IOException, FourBytes, Color, Image, ColorPlusChar, Memeage
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
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
/**
 * Tests Memeage, Color, Image, FourBytes classes's methods
 * 
 * @author swimk
 *
 */
public class MemeageTests {

  /**
   * Tests FourBytes' GetBits method
   * 
   * @return true if functionality is correct, false otherwise
   */
  public static boolean testFourBytesGetBits() {
    FourBytes bitstring = new FourBytes(13312);
    if (bitstring.getBits(4, 10) == 13) {
      return true;
    }
    return false;
  }

  /**
   * Tests FourBytes' SetBits method
   * 
   * @return true if functionality is correct, false otherwise
   */
  public static boolean testFourBytesSetBits() {
    FourBytes bitstring = new FourBytes(0);
    bitstring.setBits(3, 8, 13);
    if (bitstring.getInt() == 1280) {
      return true;
    }
    return false;
  }

  /**
   * Tests Color Class's constructor, setter methods, and getter methods
   * 
   * @return true if functionality is correct, false otherwise
   */
  public static boolean testColor() {
    Color test = new Color(34, 12, 6, 255);
    if (test.getBits(8, 0) != 255) {
      return false;
    }
    test.setGreen(255);
    if (test.getGreen() != 255) {
      return false;
    }
    return true;
  }

  /**
   * Tests Image Class's constructor and getter methods
   * 
   * @return true if functionality is correct, false otherwise
   */
  public static boolean testImage() {
    File file = new File("testImage.png");
    try {
      Image test = new Image(file);
      if (test.getHeight() != 3) {
        System.out.print("Error: Height is ");
        return false;
      }
      if (test.getWidth() != 3) {
        System.out.print("Error: Width is ");
        return false;
      }
      Color t = new Color(test.getColor(1, 1));
      if (!(t.getRed() == 0 && t.getGreen() == 255 && t.getBlue() == 255)) {
        System.out.print("Error: Color is ");
        return false;
      }
    } catch (IOException e) {
      System.out.print("Error: IO is ");
      return false;
    }
    return true;
  }

  /**
   * Tests ColorPlusChar Class's constructor, setter methods, and getter methods
   * 
   * @return true if functionality is correct, false otherwise
   */
  public static boolean testColorPlusChar() {
    Color hidden = new Color(36, 255, 0, 255);
    ColorPlusChar hide = new ColorPlusChar(hidden, 'k');
    if (hide.revealChar() != 'k') {
      return false;
    }
    return true;
  }

  /**
   * Tests Memeage Class' constructor, setter methods, and getter methods
   * 
   * @return true if functionality is correct, false otherwise
   */
  public static boolean testMemeage() {
    File file = new File("image01.png");
    try {
      Memeage test = new Memeage(file, "Computer Science is cool");
      String results = test.getMeme();
      if (results.equals("Computer Science is cool")) {
        return false;
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return false;
    } catch (IllegalStateException e) {
      System.out.println(e.getMessage());
      return false;
    } catch (IOException e) {
      System.out.println("Input/Output Error");
      return false;
    }
    return true;
  }

  /**
   * * Main Method calls the different test methods
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(testFourBytesGetBits());
    System.out.println(testFourBytesSetBits());
    System.out.println(testColor());
    System.out.println(testImage());
    System.out.println(testColorPlusChar());
    System.out.println(testMemeage());
  }


}
