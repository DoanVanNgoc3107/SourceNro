package dragon.t;

public class PlayerData {

	public int playerID;
	public String name;
	public short head;
	public short body;
	public short leg;
	public long powpoint;

	public PlayerData(int playerID, String name, short head, short body, short leg, long ppoint) {
		this.playerID = playerID;
		this.name = name;
		this.head = head;
		this.body = body;
		this.leg = leg;
		this.powpoint = ppoint;
	}
}
