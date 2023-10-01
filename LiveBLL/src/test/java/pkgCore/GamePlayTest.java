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
		
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.CLUBS, eRank.ACE,1));
		cards.add(new Card(eSuit.CLUBS, eRank.TEN,1));
		cards.add(new Card(eSuit.DIAMONDS, eRank.JACK,1));
		cards.add(new Card(eSuit.SPADES, eRank.JACK,1));
		cards.add(new Card(eSuit.HEARTS, eRank.JACK,1));
		
		HandPoker HP = new HandPoker();		
		HP = HandHelper.setHandPoker(HP, cards);
		Assertions.assertTrue(HP instanceof HandPoker);
		
		
		gp = GamePlayHelper.setGameHand(p1.getPlayerID(), gp, HP);
		
		HandPoker hp = gp.GetPlayersHand(p1);
		
		
		try {
			hp.ScoreHand();
		} catch (HandException e) {
			e.printStackTrace();
		}

		Assertions.assertEquals(eHandStrength.ThreeOfAKind, HP.getHSP().geteHandStrength());
		Assertions.assertEquals(eRank.JACK, HP.getHSP().getHiCard().geteRankValue());
		
		
	}

}
