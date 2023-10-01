package pkgHelper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import pkgCore.Card;
import pkgCore.Hand;
import pkgCore.HandPoker;

public class HandHelper {

	/**
	 * @author BRG
	 * @version Lab #1
	 * @since Lab #1
	 * 
	 *        getCards - getCardsInDeck is private. It must be tested.
	 */
	private static ArrayList<Card> setCards(HandPoker HP, ArrayList<Card> cards) {
		try {
			
			Hand h = (Hand)HP;

			// Consume the Deck class
			Class<?> c = Class.forName("pkgCore.HandPoker");
			
	        Class[] cArg = new Class[1];
	        cArg[0] = ArrayList.class;
	         
			// Set the cards in the deck
			Method mSetCards = c.getDeclaredMethod("setCards", cArg);					
			// Set the method accessible
			mSetCards.setAccessible(true);
			// Invoke the method, return the results
			mSetCards.invoke(h, cards);

		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		} catch (IllegalAccessException x) {
			x.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		// Return the results
		return cards;
	}
	
	/**
	 * @author BRG
	 * @version Lab #1
	 * @since Lab #1
	 * 
	 *        getCards - getCardsInDeck is private. It must be tested.
	 */
	public static HandPoker setHandPoker(HandPoker HP, ArrayList<Card> cards) {
		try {
			
			//Hand h = (Hand)HP;

			// Consume the Deck class
			Class<?> c = Class.forName("pkgCore.Hand");
			
	        Class[] cArg = new Class[1];
	        cArg[0] = ArrayList.class;
	         
			// Set the cards in the deck
			Method mSetCards = c.getDeclaredMethod("setCards", cArg);					
			// Set the method accessible
			mSetCards.setAccessible(true);
			// Invoke the method, return the results
			mSetCards.invoke(HP, cards);

		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		} catch (IllegalAccessException x) {
			x.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		// Return the results
		return HP;
	}
}
