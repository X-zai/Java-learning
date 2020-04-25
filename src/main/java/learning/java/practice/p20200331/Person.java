package learning.java.practice.p20200331;

/**
 * 病人类
 * 
 * @author Rayliu40k
 * @version $Id: Patient.java, v 0.1 Mar 20, 2020 4:22:21 PM Rayliu40k Exp $
 */
public class Person {

	/** 身份证 */
	private String identityCard;

	/** 名字 */
	private String name;

	/** 年龄 */
	private int age;

	/** 体温 */
	private double temperature;

	/** 社区 */
	private String community;

	public Person(String identityCard, String name, int age, double temperature, String community) {
		this.identityCard = identityCard;
		this.name = name;
		this.age = age;
		this.temperature = temperature;
		this.community = community;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public int getAge() {
		return age;
	}
 
	public void setAge(int age) {
		this.age = age;
	}

}
