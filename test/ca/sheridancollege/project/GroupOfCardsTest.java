/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ca.sheridancollege.project;




import java.util.ArrayList;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class GroupOfCardsTest {

    public GroupOfCards groupOfCards;
   

   

    @Test
public void testGroupOfCardsGood() {
    GroupOfCards groupOfCards = new GroupOfCards(52);
    assertEquals(52, groupOfCards.getSize());
}
@Test
public void testSetSizeMaxBoundary() {
    GroupOfCards groupOfCards = new GroupOfCards(0);
    groupOfCards.setSize(1000);
    assertEquals(1000, groupOfCards.getSize());
}

@Test(expected = NullPointerException.class)
public void testShuffleNullPointer() {
    GroupOfCards groupOfCards = new GroupOfCards(0);
    groupOfCards.shuffle();
}


}
