package pkgCore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Table {

	/**
	 * @author BRG
	 * @version Lab #3
	 * @since Lab #3
	 * 
	 *        TableID - UUID for the table. Makes it unique
	 */
	private UUID TableID;
	/**
	 * @author BRG
	 * @version Lab #3
	 * @since Lab #3
	 * 
	 *        TableName - Name of the table
	 */
	private String TableName;

	/**
	 * @author BRG
	 * @version Lab #3
	 * @since Lab #3
	 */
	private HashMap<UUID, Player> hmTablePlayers = new HashMap<UUID, Player>();

	/**
	 * @author BRG
	 * @version Lab #3
	 * @since Lab #3
	 * 
	 *        Table - Constructor
	 * 
	 *        Create an instance of Table. Set the TableID as a random UUID, set the
	 *        TableName attribute
	 * @param tableName
	 */
	public Table(String tableName) {
		TableID = UUID.randomUUID();
		TableName = tableName;
	}

	/**
	 * @author BRG
	 * @version Lab #3
	 * @since Lab #3
	 * 
	 *        SetTablePlayers - set the TablePlayers ArrayList with given Players
	 * @param Players - set of Players to add to the table
	 */
	public void SetTablePlayers(ArrayList<Player> Players) {
		this.hmTablePlayers.clear();
		for (var p : Players) {
			this.hmTablePlayers.put(p.getPlayerID(), p);
		}
	}

	/**
	 * @author BRG
	 * @version Lab #3
	 * @since Lab #3
	 * 
	 *        AddPlayerToTable - Add a single Player to the table.
	 * @param player - Player to be added
	 */
	public void AddPlayerToTable(Player player) {
		this.hmTablePlayers.put(player.getPlayerID(), player);
	}

	/**
	 * @author BRG
	 * @version Lab #3
	 * @since Lab #3
	 * 
	 *        RemovePlayerFromTable - Remove a single player from the Table.
	 * @param p
	 */
	public void RemovePlayerFromTable(Player p) {
		this.hmTablePlayers.remove(p);
	}

	/**
	 * @author BRG
	 * @version Lab #3
	 * @since Lab #3
	 * 
	 *        getTablePlayer - return an ArrayList of players at the table
	 * @return
	 */
	public ArrayList<Player> getTablePlayer() {
		ArrayList<Player> players = new ArrayList<Player>();
		this.hmTablePlayers.forEach((key, value) -> {
			players.add(value);
		});

		return players;
	}

	/**
	 * @author BRG
	 * @version Lab #3
	 * @since Lab #3
	 * 
	 *        getTablePlayer(PlayerID) return a single player
	 * @return
	 */
	public Player getTablePlayers(UUID PlayerID) {

		return this.hmTablePlayers.get(PlayerID);
	}

}