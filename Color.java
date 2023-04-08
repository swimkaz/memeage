//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Color in Bytes Class
// Files: FourBytes
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
 * creates Color Objects and Color's setter and getter methods
 * 
 * @author swimk
 *
 */
public class Color extends FourBytes {

  /**
   * Creates Color object
   * 
   * @param argb; int representation of alpha, red, green, blue together
   */
  public Color(int argb) {
    super(argb);
  }

  /**
   * Creates Color object
   * 
   * @param alpha; int representation of alpha
   * @param red;   int representation of red
   * @param green; int representation of green
   * @param blue;  int representation of blue
   */
  public Color(int alpha, int red, int green, int blue) {
    super(0);
    setAlpha(alpha);
    setRed(red);
    setGreen(green);
    setBlue(blue);
  }

  /**
   * Creates Color object
   * 
   * @param other; another Color Object
   */
  public Color(Color other) {
    super(other.getARGB());
  }

  /**
   * Gets ARGB value of Color object
   * 
   * @return int representation ARGB
   */
  public int getARGB() {
    int ARGB = super.getInt();
    return ARGB;
  }

  /**
   * Gets alpha value of Color object
   * 
   * @return int representation of alpha
   */
  public int getAlpha() {
    int alpha = super.getBits(8, 24);
    return alpha;
  }

  /**
   * Gets red value of Color object
   * 
   * @return int representation of red
   */
  public int getRed() {
    int red = super.getBits(8, 16);
    return red;
  }

  /**
   * Gets green value of Color object
   * 
   * @return int representation of green
   */
  public int getGreen() {
    int green = super.getBits(8, 8);
    return green;
  }

  /**
   * Gets blue value of Color object
   * 
   * @return int representation of blue
   */
  public int getBlue() {
    int blue = super.getBits(8, 0);
    return blue;
  }

  /**
   * Sets ARGB value of Color object
   * 
   * @param argb value to be set
   */
  public void setARGB(int argb) {
    super.setInt(argb);
  }

  /**
   * Sets alpha value of Color object
   * 
   * @param alpha value to be set
   */
  public void setAlpha(int alpha) {
    super.setBits(8, 24, alpha);
  }

  /**
   * Sets red value of Color object
   * 
   * @param red value to be set
   */
  public void setRed(int red) {
    super.setBits(8, 16, red);
  }

  /**
   * Sets green value of Color object
   * 
   * @param green value to be set
   */
  public void setGreen(int green) {
    super.setBits(8, 8, green);
  }

  /**
   * Sets blue value of Color object
   * 
   * @param blue value to be set
   */
  public void setBlue(int blue) {
    super.setBits(8, 0, blue);
  }

}
