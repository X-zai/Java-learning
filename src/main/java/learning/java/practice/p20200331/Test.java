package learning.java.practice.p20200331;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        //创建病人
        List<Patient> patients = new ArrayList<Patient>();
        Patient patient01 = new Patient("小王", 37.4);
        Patient patient02 = new Patient("小美", 38.3);
        Patient patient03 = new Patient("小刘", 36.9);
        Patient patient04 = new Patient("小张", 37.2);
        Patient patient05 = new Patient("小青", 37.3);
        Patient patient06 = new Patient("小宋", 37.5);
        Patient patient07 = new Patient("小李", 37.6);
        Patient patient08 = new Patient("小明", 36.8);
        Patient patient09 = new Patient("小杨", 36.9);
        Patient patient10 = new Patient("小秦", 37.4);
        patients.add(patient01);
        patients.add(patient02);
        patients.add(patient03);
        patients.add(patient04);
        patients.add(patient05);
        patients.add(patient06);
        patients.add(patient07);
        patients.add(patient08);
        patients.add(patient09);
        patients.add(patient10);

        //有多少人体温超过37.3
        int feverNumber = 0;
        System.out.println("开始检查...");
        for (Patient patient : patients) {
            if (patient.getTemperature() > 37.3) {
                System.out.println(patient.getName() + "，体温超过37.3");
                feverNumber++;
            }
        }
        System.out.println("总共有【" + feverNumber + "】人体温超过37.3，需要隔离。");

        //有哪些人人体温一样
        //以此取出每一个病人
        for (Patient patient : patients) {
            //和每一个其他病人比较体温
            for (Patient other : patients) {
                //名字不是自己，体温相同
                if (!patient.getName().equals(other.getName())
                    && patient.getTemperature() == other.getTemperature()) {
                    System.out.println(patient.getName() + "、" + other.getName() + "，体温相同，都是"
                                       + other.getTemperature());
                }
            }
        }
    }

}
