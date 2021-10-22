package tamagotchi;

public class VO {

	private String id;
	private String pw;
	private String nick;

	public VO() {
	}

	public VO(String id, String pw, String nick) {
		
		this.id = id;
		this.pw = pw;
		this.nick = nick;

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
	
	
	
	

	@Override
	public String toString() { // 아이디 패스워드 닉네임 기능 리턴값 보내주는 것.
		return "VO [id=" + id + ", pw=" + pw + ", nick=" + nick + "]";
	}

}
