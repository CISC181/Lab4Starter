package pkgCore;

import java.util.UUID;

public class Player {

	private UUID PlayerID;
	private String PlayerName;
	 
	public Player(UUID playerID, String playerName) {
		super();
		PlayerID = playerID;
		PlayerName = playerName;
	}
		
	public Player(String playerName) {
		this.PlayerID = UUID.randomUUID();
		PlayerName = playerName;
	}

	public String getPlayerName() {
		return PlayerName;
	}

	public void setPlayerName(String playerName) {
		PlayerName = playerName;
	}

	public UUID getPlayerID() {
		return PlayerID;
	}
	
	
	
	
}