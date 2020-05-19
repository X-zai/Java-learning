/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package learning.java.practice.p20200512.ray;

/**
 * 学生类
 * 
 * @author Rayliu40k
 * @version $Id: Student.java, v 0.1 May 19, 2020 9:57:58 AM Rayliu40k Exp $
 */
public class Student {

    /** 姓名 */
    private String name;

    /** 家长 */
    private String parent;

    /** 语文成绩 */
    private int    chineseScore;

    /** 数学成绩 */
    private int    mathScore;

    /** 英语成绩 */
    private int    englishScore;

    /**
     * 构造方法 
     */
    public Student(String name, String parent, int chineseScore, int mathScore, int englishScore) {
        this.name = name;
        this.parent = parent;
        this.chineseScore = chineseScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
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
     * Getter method for property <tt>parent</tt>.
     * 
     * @return property value of parent
     */
    public String getParent() {
        return parent;
    }

    /**
     * Setter method for property <tt>parent</tt>.
     * 
     * @param parent value to be assigned to property parent
     */
    public void setParent(String parent) {
        this.parent = parent;
    }

    /**
     * Getter method for property <tt>chineseScore</tt>.
     * 
     * @return property value of chineseScore
     */
    public int getChineseScore() {
        return chineseScore;
    }

    /**
     * Setter method for property <tt>chineseScore</tt>.
     * 
     * @param chineseScore value to be assigned to property chineseScore
     */
    public void setChineseScore(int chineseScore) {
        this.chineseScore = chineseScore;
    }

    /**
     * Getter method for property <tt>mathScore</tt>.
     * 
     * @return property value of mathScore
     */
    public int getMathScore() {
        return mathScore;
    }

    /**
     * Setter method for property <tt>mathScore</tt>.
     * 
     * @param mathScore value to be assigned to property mathScore
     */
    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    /**
     * Getter method for property <tt>englishScore</tt>.
     * 
     * @return property value of englishScore
     */
    public int getEnglishScore() {
        return englishScore;
    }

    /**
     * Setter method for property <tt>englishScore</tt>.
     * 
     * @param englishScore value to be assigned to property englishScore
     */
    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }
    
}
