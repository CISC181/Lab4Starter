package pkgHelper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.UUID;

import pkgCore.Card;
import pkgCore.GamePlay;
import pkgCore.Hand;
import pkgCore.HandPoker;

public class GamePlayHelper {

	/**
	 * @author BRG
	 * @version Lab #1
	 * @since Lab #1
	 * 
	 *        getCards - getCardsInDeck is private. It must be tested.
	 */
	public static GamePlay setGameHand(UUID PlayerID, GamePlay gp, HandPoker HP) {
		try {
			
			Hand h = (Hand)HP;

			// Consume the Deck class
			Class<?> c = Class.forName("pkgCore.GamePlay");
			
	        Class[] cArg = new Class[2];
	        cArg[0] = UUID.class;
	        cArg[1] = HandPoker.class;
	         
			// Set the cards in the deck
			Method mSetCards = c.getDeclaredMethod("setPlayerHand", cArg);	
			// Set the method accessible
			mSetCards.setAccessible(true);
			
			// Invoke the method, return the results
			gp = (GamePlay) mSetCards.invoke(gp, PlayerID, HP);

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
		return gp;
	}
}
