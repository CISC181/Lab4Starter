package pkgCore;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pkgEnum.eHandStrength;
import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.HandException;
import pkgHelper.HandHelper;


public class HandPokerTest {

	@Test
	public void HandPoker_HighCard() {
		
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.CLUBS, eRank.ACE,1));
		cards.add(new Card(eSuit.CLUBS, eRank.TEN,1));
		cards.add(new Card(eSuit.DIAMONDS, eRank.JACK,1));
		
		HandPoker HP = new HandPoker();
		
		HP = HandHelper.setHandPoker(HP, cards);
		
		
		HP.setCards(cards);
		
		try {
			HP.ScoreHand();
		} catch (HandException e) {
			e.printStackTrace();
		}

		Assertions.assertEquals(eHandStrength.HighCard, HP.getHSP().geteHandStrength());
		Assertions.assertEquals(eSuit.CLUBS, HP.getCards().get(0).geteSuitValue());
		Assertions.assertEquals(eSuit.CLUBS, HP.getCards().get(2).geteSuitValue());
		
	}
	
	@Test
	public void HandPoker_Pair() {
		
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.CLUBS, eRank.ACE,1));
		cards.add(new Card(eSuit.CLUBS, eRank.TEN,1));
		cards.add(new Card(eSuit.DIAMONDS, eRank.JACK,1));
		cards.add(new Card(eSuit.DIAMONDS, eRank.TEN,1));
		cards.add(new Card(eSuit.DIAMONDS, eRank.TWO,1));
		
		HandPoker HP = new HandPoker();
		HP.setCards(cards);
		
		try {
			HP.ScoreHand();
		} catch (HandException e) {
			e.printStackTrace();
		}

		Assertions.assertEquals(eHandStrength.Pair, HP.getHSP().geteHandStrength());
		Assertions.assertEquals(eRank.TEN, HP.getHSP().getHiCard().geteRankValue());
		Assertions.assertEquals(eRank.ACE, HP.getHSP().getKickers().get(0).geteRankValue());
		Assertions.assertEquals(eRank.JACK, HP.getHSP().getKickers().get(1).geteRankValue());
		Assertions.assertEquals(eRank.TWO, HP.getHSP().getKickers().get(2).geteRankValue());
	}	

	@Test
	public void HandPoker_TwoPair() {
		
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.CLUBS, eRank.ACE,1));
		cards.add(new Card(eSuit.CLUBS, eRank.TEN,1));
		cards.add(new Card(eSuit.DIAMONDS, eRank.JACK,1));
		cards.add(new Card(eSuit.DIAMONDS, eRank.TEN,1));
		cards.add(new Card(eSuit.CLUBS, eRank.JACK,1));
		
		HandPoker HP = new HandPoker();
		HP.setCards(cards);
		
		try {
			HP.ScoreHand();
		} catch (HandException e) {
			e.printStackTrace();
		}

		Assertions.assertEquals(eHandStrength.TwoPair, HP.getHSP().geteHandStrength());
		Assertions.assertEquals(eRank.JACK, HP.getHSP().getHiCard().geteRankValue());
		Assertions.assertEquals(eRank.TEN, HP.getHSP().getLoCard().geteRankValue());		
		Assertions.assertEquals(eRank.ACE, HP.getHSP().getKickers().get(0).geteRankValue());
	}	

	@Test
	public void HandPoker_ThreeOfaKind() {
		
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.CLUBS, eRank.ACE,1));
		cards.add(new Card(eSuit.CLUBS, eRank.TEN,1));
		cards.add(new Card(eSuit.HEARTS, eRank.TEN,1));
		cards.add(new Card(eSuit.DIAMONDS, eRank.TEN,1));
		cards.add(new Card(eSuit.CLUBS, eRank.JACK,1));
		
		HandPoker HP = new HandPoker();
		HP.setCards(cards);
		
		try {
			HP.ScoreHand();
		} catch (HandException e) {
			e.printStackTrace();
		}

		Assertions.assertEquals(eHandStrength.ThreeOfAKind, HP.getHSP().geteHandStrength());
		Assertions.assertEquals(eRank.TEN, HP.getHSP().getHiCard().geteRankValue());
		Assertions.assertNull(HP.getHSP().getLoCard());
		
		Assertions.assertEquals(eRank.ACE, HP.getHSP().getKickers().get(0).geteRankValue());
		Assertions.assertEquals(eRank.JACK, HP.getHSP().getKickers().get(1).geteRankValue());
	}	
	
	@Test
	public void HandPoker_FullHouse1() {
		
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.CLUBS, eRank.ACE,1));
		cards.add(new Card(eSuit.CLUBS, eRank.ACE,1));
		cards.add(new Card(eSuit.HEARTS, eRank.ACE,1));
		cards.add(new Card(eSuit.DIAMONDS, eRank.TEN,1));
		cards.add(new Card(eSuit.CLUBS, eRank.TEN,1));
		
		HandPoker HP = new HandPoker();
		HP.setCards(cards);
		
		try {
			HP.ScoreHand();
		} catch (HandException e) {
			e.printStackTrace();
		}

		Assertions.assertEquals(eHandStrength.FullHouse, HP.getHSP().geteHandStrength());
		Assertions.assertEquals(eRank.ACE, HP.getHSP().getHiCard().geteRankValue());
		Assertions.assertEquals(eRank.TEN, HP.getHSP().getLoCard().geteRankValue());
		
	}		
	
	@Test
	public void HandPoker_FullHouse2() {
		
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.CLUBS, eRank.ACE,1));
		cards.add(new Card(eSuit.CLUBS, eRank.ACE,1));
		cards.add(new Card(eSuit.HEARTS, eRank.TEN,1));
		cards.add(new Card(eSuit.DIAMONDS, eRank.TEN,1));
		cards.add(new Card(eSuit.CLUBS, eRank.TEN,1));
		
		HandPoker HP = new HandPoker();
		HP.setCards(cards);
		
		try {
			HP.ScoreHand();
		} catch (HandException e) {
			e.printStackTrace();
		}

		Assertions.assertEquals(eHandStrength.FullHouse, HP.getHSP().geteHandStrength());
		Assertions.assertEquals(eRank.TEN, HP.getHSP().getHiCard().geteRankValue());
		Assertions.assertEquals(eRank.ACE, HP.getHSP().getLoCard().geteRankValue());
		
	}		
	
	@Test
	public void HandPoker_Staight1() {
		
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.CLUBS, eRank.TEN,1));
		cards.add(new Card(eSuit.CLUBS, eRank.JACK,1));
		cards.add(new Card(eSuit.CLUBS, eRank.QUEEN,1));
		cards.add(new Card(eSuit.CLUBS, eRank.KING,1));
		cards.add(new Card(eSuit.DIAMONDS, eRank.ACE,1));
		
		HandPoker HP = new HandPoker();
		HP.setCards(cards);
		
		try {
			HP.ScoreHand();
		} catch (HandException e) {
			e.printStackTrace();
		}

		Assertions.assertEquals(eHandStrength.Straight, HP.getHSP().geteHandStrength());
		Assertions.assertEquals(eRank.ACE, HP.getHSP().getHiCard().geteRankValue());
		Assertions.assertNull(HP.getHSP().getLoCard());
		
	}	
	
	@Test
	public void HandPoker_Staight2() {
		
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.CLUBS, eRank.ACE,1));
		cards.add(new Card(eSuit.CLUBS, eRank.TWO,1));
		cards.add(new Card(eSuit.CLUBS, eRank.THREE,1));
		cards.add(new Card(eSuit.CLUBS, eRank.FOUR,1));
		cards.add(new Card(eSuit.DIAMONDS, eRank.FIVE,1));
		
		HandPoker HP = new HandPoker();
		HP.setCards(cards);
		
		try {
			HP.ScoreHand();
		} catch (HandException e) {
			e.printStackTrace();
		}

		Assertions.assertEquals(eHandStrength.Straight, HP.getHSP().geteHandStrength());
		Assertions.assertEquals(eRank.FIVE, HP.getHSP().getHiCard().geteRankValue());
		Assertions.assertNull(HP.getHSP().getLoCard());
		
	}	
	
	@Test
	public void HandPoker_Staight3() {
		
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.CLUBS, eRank.SIX,1));
		cards.add(new Card(eSuit.CLUBS, eRank.TWO,1));
		cards.add(new Card(eSuit.CLUBS, eRank.THREE,1));
		cards.add(new Card(eSuit.CLUBS, eRank.FOUR,1));
		cards.add(new Card(eSuit.DIAMONDS, eRank.FIVE,1));
		
		HandPoker HP = new HandPoker();
		HP.setCards(cards);
		
		try {
			HP.ScoreHand();
		} catch (HandException e) {
			e.printStackTrace();
		}

		Assertions.assertEquals(eHandStrength.Straight, HP.getHSP().geteHandStrength());
		Assertions.assertEquals(eRank.SIX, HP.getHSP().getHiCard().geteRankValue());
		Assertions.assertNull(HP.getHSP().getLoCard());
		
	}	
	
	@Test
	public void HandPoker_StraightFlush() {
		
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.CLUBS, eRank.SIX,1));
		cards.add(new Card(eSuit.CLUBS, eRank.TWO,1));
		cards.add(new Card(eSuit.CLUBS, eRank.THREE,1));
		cards.add(new Card(eSuit.CLUBS, eRank.FOUR,1));
		cards.add(new Card(eSuit.CLUBS, eRank.FIVE,1));
		
		HandPoker HP = new HandPoker();
		HP.setCards(cards);
		
		try {
			HP.ScoreHand();
		} catch (HandException e) {
			e.printStackTrace();
		}

		Assertions.assertEquals(eHandStrength.StraightFlush, HP.getHSP().geteHandStrength());
		Assertions.assertEquals(eRank.SIX, HP.getHSP().getHiCard().geteRankValue());
		Assertions.assertNull(HP.getHSP().getLoCard());
		
	}		
	
	@Test
	public void HandPoker_RoyalFlush() {
		
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.CLUBS, eRank.TEN,1));
		cards.add(new Card(eSuit.CLUBS, eRank.JACK,1));
		cards.add(new Card(eSuit.CLUBS, eRank.QUEEN,1));
		cards.add(new Card(eSuit.CLUBS, eRank.KING,1));
		cards.add(new Card(eSuit.CLUBS, eRank.ACE,1));
		
		HandPoker HP = new HandPoker();
		HP.setCards(cards);
		
		try {
			HP.ScoreHand();
		} catch (HandException e) {
			e.printStackTrace();
		}

		Assertions.assertEquals(eHandStrength.RoyalFlush, HP.getHSP().geteHandStrength());
		Assertions.assertEquals(eRank.ACE, HP.getHSP().getHiCard().geteRankValue());
		Assertions.assertNull(HP.getHSP().getLoCard());
		
	}	


}