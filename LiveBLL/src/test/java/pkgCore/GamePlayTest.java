package pkgCore;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pkgEnum.eGame;
import pkgEnum.eHandStrength;
import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;
import pkgException.HandException;
import pkgHelper.GamePlayHelper;
import pkgHelper.HandHelper;

public class GamePlayTest {

	@Test
	public void HandPoker_ThreeOfAKind1() {
		
		Table t = new Table("MyTable");
		Rule r = new Rule(eGame.FiveStud);
		
		Player p1 = new Player("Bob");
		Player p2 = new Player("Jim");
		
		t.AddPlayerToTable(p1);
		t.AddPlayerToTable(p2);
		
		GamePlay gp = new GamePlay(t,r);
		
		ArrayList<Card> P1Cards = new ArrayList<Card>();
		
		P1Cards.add(new Card(eSuit.CLUBS, eRank.ACE,1));
		P1Cards.add(new Card(eSuit.CLUBS, eRank.TEN,1));
		P1Cards.add(new Card(eSuit.DIAMONDS, eRank.JACK,1));
		P1Cards.add(new Card(eSuit.SPADES, eRank.JACK,1));
		P1Cards.add(new Card(eSuit.HEARTS, eRank.JACK,1));
		
		HandPoker HP = new HandPoker();		
		HP = HandHelper.setHandPoker(HP, P1Cards);
		Assertions.assertTrue(HP instanceof HandPoker);		
		gp = GamePlayHelper.setGameHand(p1.getPlayerID(), gp, HP);
		
		
		
		
		
		
		ArrayList<Card> P2Cards = new ArrayList<Card>();
		
		P2Cards.add(new Card(eSuit.CLUBS, eRank.ACE,1));
		P2Cards.add(new Card(eSuit.CLUBS, eRank.TEN,1));
		P2Cards.add(new Card(eSuit.DIAMONDS, eRank.ACE,1));
		P2Cards.add(new Card(eSuit.SPADES, eRank.JACK,1));
		P2Cards.add(new Card(eSuit.HEARTS, eRank.JACK,1));
		
		HandPoker HP2 = new HandPoker();		
		HP2 = HandHelper.setHandPoker(HP2, P2Cards);
		
		Assertions.assertTrue(HP2 instanceof HandPoker);		
		gp = GamePlayHelper.setGameHand(p2.getPlayerID(), gp, HP2);
		
		Assertions.assertEquals(eHandStrength.TwoPair, HP2.getHSP().geteHandStrength());
		Assertions.assertEquals(eRank.ACE, HP2.getHSP().getHiCard().geteRankValue());
		Assertions.assertEquals(eRank.JACK, HP2.getHSP().getLoCard().geteRankValue());
		
		HandPoker hpWinner = gp.WinningHand();
		var pWinner = gp.WinningPlayer();
		
		Assertions.assertEquals(p1, pWinner.get(0));
		Assertions.assertEquals(eHandStrength.ThreeOfAKind, hpWinner.getHSP().geteHandStrength());
	}

}
