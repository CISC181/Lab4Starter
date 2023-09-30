package pkgCore;

import java.util.ArrayList;
import java.util.UUID;

import pkgException.DeckException;
import pkgException.HandException;


public abstract class Hand {

	private UUID HandID;
	private ArrayList<Card> cards;
	private HandScore HS;
	
	/**
	 * @author BRG
	 * @version Lab #3
	 * @since Lab #3
	 * GP - This is the GamePlay that owns the hand.  
	 */
	private GamePlay GP = null;
	
	/**
	 * @author BRG
	 * @version Lab #3
	 * @since Lab #3
	 * 
	 */
	private Player player = null; 
	
	/**
	 * @author BRG
	 * @version Lab #2
	 * @since Lab #2
	 * 
	 *        Hand no-arg constructor.
	 * 
	 *        This constructor should initialize 'cards' ArrayList.
	 */
	public Hand() {
		this.HandID = UUID.randomUUID();
		cards = new ArrayList<Card>();
	}

	/**
	 * @author BRG
	 * @version Lab #3
	 * @since Lab #3
	 * 
	 *        Hand one-arg constructor.
	 * 
	 *        This constructor passes in the instance of GamePlay
	 */	
	public Hand(Player p, GamePlay gp)
	{
		this();
		this.GP = gp;
		this.player = p;
	}
	
	/**
	 * @author BRG
	 * @version Lab #2
	 * @since Lab #2
	 * 
	 * @return - this method should return the 'cards' ArrayList.
	 */
	protected ArrayList<Card> getCards() {
		return cards;
	}

	protected void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	


	/**
	 * @author BRG
	 * @version Lab #2
	 * @since Lab #2
	 * @param d - given deck to draw from
	 * @throws DeckException - if deck is empty, throw DeckException
	 * 
	 *                       This method doesn't actually return anything, just adds
	 *                       a card to the 'cards' ArrayList, drawing from given
	 *                       deck.
	 */
	public Hand Draw(Deck d) throws DeckException {
		cards.add(d.Draw());
		return this;
	}

	/**
	 * @author BRG
	 * @version Lab #2
	 * @since Lab #2
	 * @return This method should return the HS (HandScore) attribute
	 */
	protected HandScore getHS() {
		return HS;
	}

	/**
	 * @author BRG
	 * @version Lab #2
	 * @since Lab #2
	 * @param hS - given HandScore
	 * 
	 *           This method will set the HandScore for the Hand.
	 */
	protected void setHS(HandScore hS) {
		HS = hS;
	}

	/**
	 * This abstract method must be implemented in each class that extends Hand.
	 * HandPoker and HandBlackJack will be evaluated differently, but must be
	 * evaluated.
	 * 
	 * @author BRG
	 * @version Lab #2
	 * @since Lab #2
	 * @return HandScore calculated for given Hand
	 * @throws HandException
	 */
	public abstract HandScore ScoreHand() throws HandException;

	protected void AddCard(Card c) {
		cards.add(c);
	}

	public UUID getHandID() {
		return HandID;
	}

	
	
	

}