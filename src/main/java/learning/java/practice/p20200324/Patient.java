package learning.java.practice.p20200324;

/**
 * 病人类
 * 
 * @author Rayliu40k
 * @version $Id: Patient.java, v 0.1 Mar 20, 2020 4:22:21 PM Rayliu40k Exp $
 */
public class Patient {

	/** 名字 */
	private String name;/** 年龄 */
	private int old;
	
	/** 体温 */
	private double temperature;

	public double getOld() {
		return old;
	}

	public void setOld(int old) {
		this.old = old;
	}

	/**
	 * 构造方法
	 */
	public Patient(String name,int old , double temperature) {
		this.name = name;
		this.old = old;
		this.temperature = temperature;
	}

	/**
	 * Getter method for property <tt>name</tt>.
	 * 
	 * @return property value of name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method for property <tt>name</tt>.
	 * 
	 * @param name value to be assigned to property name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter method for property <tt>temperature</tt>.
	 * 
	 * @return property value of temperature
	 */
	public double getTemperature() {
		return temperature;
	}

	/**
	 * Setter method for property <tt>temperature</tt>.
	 * 
	 * @param temperature value to be assigned to property temperature
	 */
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

}
