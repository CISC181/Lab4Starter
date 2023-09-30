package pkgCore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import pkgEnum.eCardDestination;
import pkgEnum.eDrawCount;
import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;
import pkgException.HandException;

public class GamePlay { 

	private Rule Rle;
	//private ArrayList<Player> GamePlayers = new ArrayList<Player>();
	private HashMap<UUID, Player> GamePlayers = new HashMap<UUID, Player>();
	private HashMap<UUID, HandPoker> GameHand = new HashMap<UUID, HandPoker>();
	private ArrayList<Card> CommonCards = new ArrayList<Card>();

	private Deck GameDeck;

	/**
	 * GamePlay - Create an instance of GamePlay. For every player in the table, add
	 * them to the game Set the GameDeck.
	 * 
	 * @param t
	 * @param rle
	 */
	public GamePlay(Table t, Rule rle) {
		
		this.Rle = rle;		
		for (var p: t.getTablePlayer())
		{
			this.GamePlayers.put(p.getPlayerID(), p);
		}		
		GameDeck = new Deck();
	}

	public void Draw(Player p, CardDraw CD) throws DeckException, HandException {

		for (int crdCnt = 0; crdCnt < CD.getCardCount().getCardCount(); crdCnt++) {
			if (CD.getCardDestination() == eCardDestination.COMMON) {
				CommonCards.add(GameDeck.Draw());
			} else {
				GameHand.get(p.getPlayerID()).Draw(GameDeck);
			}
		}
	}

	/**
	 * @author BRG
	 * @version Lab #3
	 * @since Lab #3
	 * 
	 * getCommonCards - returns the common cards for the game.
	 * There's a bit of a cheat- return 'jokers' for cards that are 
	 * not yet dealt.  If there are supposed to be 5 community cards,
	 * and in the current state of the game there are 3, return the
	 * three + two jokers. 
	 * 
	 * @return - list of community cards.
	 */
	public ArrayList<Card> getCommonCards() {
		
		return CommonCards;
	}

	/**
	 * @author BRG
	 * @version Lab #3
	 * @since Lab #3
	 * 
	 * setCommonCards - setter for CommonCards.  Be careful!  You should only use this method in reflections for testing!!
	 * 
	 * @return - list of community cards.
	 */
	private GamePlay setCommonCards(ArrayList<Card> commonCards) {
		CommonCards.clear();
		CommonCards = (ArrayList<Card>) commonCards.clone();
		return this;
	}

	/**
	 * @author BRG
	 * @version Lab #3
	 * @since Lab #3
	 * GetGamePlayer - return the Player object for a given PlayerID
	 * @param PlayerID - ID for the Player
	 * @return - Player object
	 */
	private Player GetGamePlayer(UUID PlayerID)
	{
		return this.GamePlayers.get(PlayerID);
	}

	/**
	 * @author BRG
	 * @version Lab #3
	 * @since Lab #3
	 * 
	 * GetPlayersHand - return the Hand in the GameHand hashmap for a given player
	 * @param player 
	 * @return
	 */
	public HandPoker GetPlayersHand(Player player) {
		return GameHand.get(player.getPlayerID());
	}

	/**
	 * @author BRG
	 * @version Lab #3
	 * @since Lab #3
	 * 
	 * getRle - Get the rule for the game.  It's set in the constructor
	 * @return
	 */
	public Rule getRle() {
		return Rle;
	}
	
	/**
	 * @author BRG
	 * @version Lab #3
	 * @since Lab #3
	 * 
	 * StartGame - Create a new HandPoker for each player, put it in the 
	 * GameHand map, execute the first Draw
	 * 
	 * @throws DeckException
	 * @throws HandException
	 */
	public void StartGame() throws DeckException, HandException  {
		
        // Looping through the HashMap
        for (Map.Entry<UUID,Player> mapElement : GamePlayers.entrySet()) {
            UUID key = mapElement.getKey();
 
            // Adding some bonus marks to all the students
            Player value = mapElement.getValue();
            
			HandPoker hp = new HandPoker(value,this);
			GameHand.put(key, hp);
			Draw(value, this.Rle.getCardDraw(eDrawCount.FIRST)); 
        }
	}

}