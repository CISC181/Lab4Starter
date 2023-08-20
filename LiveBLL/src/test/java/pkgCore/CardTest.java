package pkgCore;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class CardTest {

	/**
	 * @author BRG
	 * @version Lab #1
	 * @since Lab #1
	 * 
	 *        Card_Create_Test - Test to make sure constructor works, getter/setter works
	 */
	
	@Test
	public void Card_Create_Test() {
		Card c = new Card(eSuit.CLUBS, eRank.EIGHT, (short) 1);
		assertNotNull(c);
		
		
		assertEquals(eSuit.CLUBS, c.geteSuitValue());
		assertEquals(eRank.EIGHT, c.geteRankValue());
		assertFalse(c.isWild());
	}

	/**
	 * @author BRG
	 * @version Lab #1
	 * @since Lab #1
	 * 
	 *        Card_Equal_Test - test to make sure the equals method works
	 */
	@Test
	public void Card_Equal_Test() {
		Card c1 = new Card(eSuit.HEARTS, eRank.TWO, (short) 1);
		Card c2 = new Card(eSuit.HEARTS, eRank.TWO, (short) 2);

		assertTrue(c1.equals(c2));

		Card c3 = new Card(eSuit.HEARTS, eRank.THREE, (short) 3);
		assertFalse(c1.equals(c3));
	}

	/**
	 * @author BRG
	 * @version Lab #1
	 * @since Lab #1
	 * 
	 *        Card_Sort_Test - test to make sure the card sorting works
	 */
	@Test
	public void Card_Sort_Test() {

		ArrayList<Card> cards = new ArrayList<Card>();
		Card c1 = new Card(eSuit.CLUBS, eRank.TWO,(short) 1);
		Card c2 = new Card(eSuit.CLUBS, eRank.EIGHT,(short) 1);
		Card c3 = new Card(eSuit.DIAMONDS, eRank.SIX,(short) 1);

		cards.add(c1);
		cards.add(c2);
		cards.add(c3);

		Collections.sort(cards);

		
		assertEquals(cards.get(0).geteRankValue(), eRank.EIGHT);
		assertEquals(cards.get(1).geteRankValue(), eRank.SIX);
		assertEquals(cards.get(2).geteRankValue(), eRank.TWO);
	}

}