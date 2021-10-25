package tamagotchi;

public class VO {

	private String id;
	private String pw;
	private String nick;
	private int lv;
	private int hp;
	private int ep;
	private int turn;
	private int days;
	

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public VO() {
		this.lv = 1;
		this.hp = 100;
		this.ep = 0;
		this.turn = 1;
		
	}

	public void VO(String id, String pw, String nick) {
		
		this.id = id;
		this.pw = pw;
		this.nick = nick;
		this.lv = 1;
		this.hp = 100;
		this.ep = 0;
		this.turn = 1;

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
	public int getEp() {
		return ep;
	}
	public void setEp(int ep) {
		this.ep = ep;
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
