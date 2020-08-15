package learning.java.practice.p20200802;

public class lfs_ {
	public String mz;

	public String getName() {
		return mz;
	}

	public void setName(String name) {
		this.mz = name;
	}

	public int getOld() {
		return nl;
	}

	public void setOld(int old) {
		this.nl = old;
	}

	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	public int nl;
	public String xb;

	public lfs_(String mz, int nl, String xb) {
		this.mz = mz;
		this.nl = nl;
		this.xb = xb;
	}

}
