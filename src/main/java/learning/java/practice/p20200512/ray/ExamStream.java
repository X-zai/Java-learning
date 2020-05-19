/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package learning.java.practice.p20200512.ray;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 期末考试(流式编程)
 * 
 * @author Rayliu40k
 * @version $Id: Main.java, v 0.1 May 19, 2020 10:06:41 AM Rayliu40k Exp $
 */
public class ExamStream {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        //准备数据
        List<Student> students = new ArrayList<Student>();
        Student student01 = new Student("小王", "王芳", 89, 90, 91);
        Student student02 = new Student("小李", "李海", 65, 88, 83);
        Student student03 = new Student("小宋", "宋阳", 78, 65, 89);
        Student student04 = new Student("小明", "张大明", 93, 88, 92);
        Student student05 = new Student("小芳", "夏芳", 67, 87, 76);
        Student student06 = new Student("小秦", "秦岚", 85, 95, 80);
        Student student07 = new Student("小刘", "刘东", 90, 90, 86);
        students.add(student01);
        students.add(student02);
        students.add(student03);
        students.add(student04);
        students.add(student05);
        students.add(student06);
        students.add(student07);

        top3InCourses(students);
    }

    /**
     * 找出单科成绩最高的前3名，并发送钉钉消息给他的家长
     * 
     * @param students 所有学生
     */
    public static void top3InCourses(List<Student> students) {
        //1. 语文
        //1.1 找出语文成绩前3的分数
        List<Integer> top3ChineseScore = students.stream()
            //按照语文成绩生成新列表
            .map(Student::getChineseScore)
            //按照成绩的倒序排序(高分 -> 低分)
            .sorted(Comparator.reverseOrder())
            //取前3个
            .limit(3)
            //放到新List
            .collect(Collectors.toList());
        //打印结果
        System.out.println(top3ChineseScore);

        //1.2 找出语文成绩前3的分数对应的学生
        List<Student> top3ChineseScoreStudents = students.stream()
            //获取语文成绩前3的学生
            .filter(student -> top3ChineseScore.contains(student.getChineseScore()))
            //按照成绩的倒序排序(高分 -> 低分)
            .sorted(Comparator.comparing(Student::getChineseScore).reversed())
            //放到新List
            .collect(Collectors.toList());
        //打印结果
        top3ChineseScoreStudents.forEach(student -> {
            System.out.println("-----");
            System.out.println(student.getName());
            System.out.println(student.getChineseScore());
            System.out.println(student.getParent());
        });

        //1.4 发送钉钉消息
        int rank = 0;
        for (Student student : top3ChineseScoreStudents) {
            rank++;
            String contenet = "家长【" + student.getParent() + "】您好，您的孩子【" + student.getName()
                              + "】在本次期末考试中，【语文】获得" + student.getChineseScore() + "分，排名全班第【" + rank
                              + "】，恭喜您。";
            System.out.println(contenet);
        }

        //发送钉钉消息
        //TODO

        //2. 数学
        //3. 英语
    }

}
