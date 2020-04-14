package learning.java.practice.p20200331;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception {
        List<Patient> allPatients = new ArrayList<Patient>();
        Patient patient01 = new Patient("510103198403254118", "小王", 28, 37.4, "中坝社区");
        Patient patient02 = new Patient("510104196507218121", "小美", 28, 38.3, "黄忠社区");
        Patient patient03 = new Patient("510102199511023322", "小刘", 55, 36.9, "蓓蕾社区");
        Patient patient04 = new Patient("510106195509225413", "小张", 67, 37.2, "苏坡社区");
        Patient patient05 = new Patient("510104198507212114", "小宋", 18, 37.5, "芳草社区");
        Patient patient06 = new Patient("510107199507213115", "小李", 14, 37.6, "中坝社区");
        Patient patient07 = new Patient("510104197507214126", "小明", 78, 36.8, "芳草社区");
        Patient patient08 = new Patient("510109199801115123", "小杨", 55, 36.9, "蓓蕾社区");
        Patient patient09 = new Patient("510104197603217112", "小秦", 25, 38.5, "芳草社区");
        allPatients.add(patient01);
        allPatients.add(patient02);
        allPatients.add(patient03);
        allPatients.add(patient04);
        allPatients.add(patient05);
        allPatients.add(patient06);
        allPatients.add(patient07);
        allPatients.add(patient08);
        allPatients.add(patient09);
        while (true) {
            System.out.print("Please enter patient information:");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();
            List<Patient> matchedPatients = queryPatient(allPatients, input);
            if (matchedPatients != null) {
                for (Patient patient : matchedPatients) {
                    caculateDays(patient);
                }
            }
            System.out.println("————————————————————————");
        }
    }
    public static List<Patient> queryPatient(List<Patient> allPatients, String condition) {
        if (condition == null || condition.trim().length() == 0) {
            System.err.println("[WARNING]Condition cannot be empty");
            return null;
        }

        List<Patient> matchedPatients = new ArrayList<>();
        for (Patient patient : allPatients) {
            if (condition.trim().equals(patient.getIdentityCard())) {
                matchedPatients.add(patient);
            }
            if (condition.trim().equals(patient.getName())) {
                matchedPatients.add(patient);
            }
            if (condition.trim().equals(patient.getCommunity())) {
                matchedPatients.add(patient);
            }
        }
        return matchedPatients;
    }
    public static void caculateDays(Patient patient) {
        if (patient.getAge() <= 35 && patient.getTemperature() >= 37) {
            System.out
                .println(patient.getName() + ","
                         + String.format("%.0f", (patient.getTemperature() - 37) / 0.2) + "天后出院");
        } else if (patient.getAge() > 35 && patient.getAge() < 55
                   && patient.getTemperature() >= 37) {
            System.out
                .println(patient.getName() + ","
                         + String.format("%.0f", (patient.getTemperature() - 37) / 0.1) + "天后出院");
        } else if (patient.getAge() >= 55 && patient.getTemperature() >= 37) {
            System.out
                .println(patient.getName() + ","
                         + String.format("%.0f", (patient.getTemperature() - 37) / 0.05) + "天后出院");
        }
    }
}
