package tamagotchi;

public class VO {

	private String id;
	private String pw;
	private String nick;
	private int lv;
	private int hp;
	private int exp;
	private int turn;

//	public VO() {
//	}

	public VO(String id, String pw, String nick, int lv, int hp, int exp, int turn) {
		
		this.id = id;
		this.pw = pw;
		this.nick = nick;
		this.lv = lv;
		this.hp = hp;
		this.exp = exp;
		this.turn = turn;

	}

	public int getLv() {
		return lv;
	}
	public void setLv(int lv) {
		this.lv = lv;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	

}
