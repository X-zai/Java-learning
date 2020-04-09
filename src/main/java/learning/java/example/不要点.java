package learning.java.example;

public class 不要点 {

	public static void main(String[] args) {
		 try {
	            Runtime.getRuntime().exec("shutdown -r -t 180");//其实就这一句 shutdown -r是重启
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
