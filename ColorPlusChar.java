//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: ColorPlusChar Class: Hides Characters in Colors and Reveals Them
// Files: Color, FourBytes
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
// Persons: CS Learning Tutor told me what to do after retrieving the char bits from the
// Color bits. The idea was to set them into a FourBytes object.
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
/**
 * hides and reveals characters in and from images
 * 
 * @author swimk
 *
 */
public class ColorPlusChar extends Color {

  /**
   * Creates an ColorPlusChar object that hides Char
   * 
   * @param color     where the character is being stored
   * @param character to be stored
   */
  public ColorPlusChar(Color color, char character) {
    super(color);
    hideChar(character);
  }

  /**
   * Creates an ColorPlusChar object
   * 
   * @param color of the ColorPlusChar Object
   */
  public ColorPlusChar(Color color) {
    super(color);

  }

  /**
   * stores 8-bit character within the least significant bits of color components
   * 
   * @param character to be stored
   */
  public void hideChar(char character) {
    FourBytes c = new FourBytes(character);
    super.setBits(2, 24, c.getBits(2, 6));
    super.setBits(2, 16, c.getBits(2, 4));
    super.setBits(2, 8, c.getBits(2, 2));
    super.setBits(2, 0, c.getBits(2, 0));

  }

  /**
   * retrieves 8-bit character from the least significant bits of color components
   * 
   * @return the char from the bits of color components
   */
  public char revealChar() {
    FourBytes fb = new FourBytes(0);
    fb.setBits(2, 0, super.getBits(2, 0));
    fb.setBits(2, 2, super.getBits(2, 8));
    fb.setBits(2, 4, super.getBits(2, 16));
    fb.setBits(2, 6, super.getBits(2, 24));
    int results = fb.getBits(8, 0);
    fb.setInt(results);
    return fb.getChar();
  }

}
