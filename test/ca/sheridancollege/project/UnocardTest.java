/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.project;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gagan
 */
public class UnocardTest {
    
    public UnocardTest() {
    }
    
   public void testConstructorWithValueAndColor() {
        Unocard card = new Unocard(5, "Red");
        assertEquals(5, card.value);
        assertEquals("Red", card.color);
    }
    
    @Test
    public void testGetFaceWithValueAndColor() {
        Unocard card = new Unocard(5, "Red");
        assertEquals("[Red 5]", card.getFace());
    }
    
    @Test
    public void testCanPlaceWithMatchingColor() {
        Unocard card1 = new Unocard(5, "Red");
        Unocard card2 = new Unocard(7, "Red");
        assertTrue(card1.canPlace(card2, "Red"));
    }
    
    @Test
    public void testCanPlaceWithMatchingValue() {
        Unocard card1 = new Unocard(5, "Red");
        Unocard card2 = new Unocard(5, "Green");
        assertTrue(card1.canPlace(card2, "Green"));
    }
    
    @Test
    public void testCanPlaceWithWildCard() {
        Unocard card1 = new Unocard(13, "none");
        Unocard card2 = new Unocard(8, "Blue");
        assertTrue(card1.canPlace(card2, "Green"));
    }
    
    // BAD TESTS
    
    @Test
    public void testConstructorWithInvalidValue() {
        Unocard card = new Unocard(0, "Red");
        assertEquals(0, card.value); // Value should be capped at 27
    }
    
    @Test
    public void testConstructorWithInvalidColor() {
        Unocard card = new Unocard(5, "none");
        assertEquals("none", card.color); // Invalid color should default to "none"
    }
    
    
    @Test
    public void testCanPlaceWithMismatchedColorAndValue() {
        Unocard card1 = new Unocard(5, "Red");
        Unocard card2 = new Unocard(8, "Blue");
        assertFalse(card1.canPlace(card2, "Green"));
    }
    
    // BOUNDARY TESTS
    
    @Test
    public void testConstructorWithValueBoundary() {
        Unocard card = new Unocard(27, "Red");
        assertEquals(27, card.value); // Value should be capped at 27
    }
    
    @Test
    public void testConstructorWithColorBoundary() {
        Unocard card = new Unocard(5, "none");
        assertEquals("none", card.color); // "none" is a valid color for wild cards
    }
    
    
    
    @Test
    public void testCanPlaceWithValueBoundary() {
        Unocard card1 = new Unocard(27, "Red");
        Unocard card2 = new Unocard(13, "Green");
        assertTrue(card1.canPlace(card2, "Red")); // Value should be capped at 13
    }
}

