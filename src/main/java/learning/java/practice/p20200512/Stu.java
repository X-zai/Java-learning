package learning.java.practice.p20200512;

public class Stu {
	/** name */
	private String na;
	/** chinese */
	private int ch;
	/** math */
	private int ma;
	/** english */
	private int en;
	/** parent name */
	private String pa;

	public Stu(String na, int ch, int ma, int en, String pa) {
		this.na = na;
		this.ch = ch;
		this.ma = ma;
		this.en = en;
		this.pa = pa;
	}

	public String getNa() {
		return na;
	}

	public void setNa(String na) {
		this.na = na;
	}

	public int getCh() {
		return ch;
	}

	public void setCh(int ch) {
		this.ch = ch;
	}

	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public int getEn() {
		return en;
	}

	public void setEn(int en) {
		this.en = en;
	}

	public String getPa() {
		return pa;
	}

	public void setPa(String pa) {
		this.pa = pa;
	}
}
