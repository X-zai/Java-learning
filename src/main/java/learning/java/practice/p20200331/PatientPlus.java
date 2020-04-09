package learning.java.practice.p20200331;

/**
 * 病人类
 * 
 * @author Rayliu40k
 * @version $Id: Patient.java, v 0.1 Mar 20, 2020 4:22:21 PM Rayliu40k Exp $
 */
public class PatientPlus {

    /** 身份证 */
    private String identityCard;

    /** 名字 */
    private String name;

    /** 年龄 */
    private int    age;

    /** 体温 */
    private double temperature;

    /** 社区 */
    private String community;

    /**
     * 构造方法
     */
    public PatientPlus(String identityCard, String name, int age, double temperature,
                    String community) {
        this.identityCard = identityCard;
        this.name = name;
        this.age = age;
        this.temperature = temperature;
        this.community = community;
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

    /**
     * Getter method for property <tt>identityCard</tt>.
     * 
     * @return property value of identityCard
     */
    public String getIdentityCard() {
        return identityCard;
    }

    /**
     * Setter method for property <tt>identityCard</tt>.
     * 
     * @param identityCard value to be assigned to property identityCard
     */
    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    /**
     * Getter method for property <tt>community</tt>.
     * 
     * @return property value of community
     */
    public String getCommunity() {
        return community;
    }

    /**
     * Setter method for property <tt>community</tt>.
     * 
     * @param community value to be assigned to property community
     */
    public void setCommunity(String community) {
        this.community = community;
    }

    /**
     * Getter method for property <tt>age</tt>.
     * 
     * @return property value of age
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter method for property <tt>age</tt>.
     * 
     * @param age value to be assigned to property age
     */
    public void setAge(int age) {
        this.age = age;
    }

}
