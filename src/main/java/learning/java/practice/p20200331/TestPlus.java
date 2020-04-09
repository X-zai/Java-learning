package learning.java.practice.p20200331;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TestPlus {

    public static void main(String[] args) throws Exception {
        //创建病人
        List<PatientPlus> allPatients = new ArrayList<PatientPlus>();
        PatientPlus patient01 = new PatientPlus("510103198403254118", "小王", 28, 37.4, "中坝社区");
        PatientPlus patient02 = new PatientPlus("510104196507218121", "小美", 28, 38.3, "黄忠社区");
        PatientPlus patient03 = new PatientPlus("510102199511023322", "小刘", 55, 36.9, "蓓蕾社区");
        PatientPlus patient04 = new PatientPlus("510106195509225413", "小张", 67, 37.2, "苏坡社区");
        PatientPlus patient05 = new PatientPlus("510104198507212114", "小宋", 18, 37.5, "芳草社区");
        PatientPlus patient06 = new PatientPlus("510107199507213115", "小李", 14, 37.6, "中坝社区");
        PatientPlus patient07 = new PatientPlus("510104197507214126", "小明", 78, 36.8, "芳草社区");
        PatientPlus patient08 = new PatientPlus("510109199801115123", "小杨", 55, 36.9, "蓓蕾社区");
        PatientPlus patient09 = new PatientPlus("510104197603217112", "小秦", 25, 38.5, "芳草社区");
        allPatients.add(patient01);
        allPatients.add(patient02);
        allPatients.add(patient03);
        allPatients.add(patient04);
        allPatients.add(patient05);
        allPatients.add(patient06);
        allPatients.add(patient07);
        allPatients.add(patient08);
        allPatients.add(patient09);

        //输入病人信息
        while (true) {
            System.out.print("请输入病人信息：");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();
            //1.查询病人
            List<PatientPlus> matchedPatients = queryPatient(allPatients, input);
            if (matchedPatients != null) {
                for (PatientPlus patient : matchedPatients) {
                    //2.计算病人出院时间
                    caculateDays(patient);
                }
            }
            System.out.println("---------------------");
        }
    }

    /**
     * 查询病人
     * 
     * @param patients 病人列表
     * @param condition 条件
     * @return 符合条件的病人列表
     */
    public static List<PatientPlus> queryPatient(List<PatientPlus> allPatients, String condition) {
        //校验：条件不能为空
        if (condition == null || condition.trim().length() == 0) {
            System.out.println("条件不能为空");
            return null;
        }

        List<PatientPlus> matchedPatients = new ArrayList<>();
        for (PatientPlus patient : allPatients) {
            //查询身份证号
            if (condition.trim().equals(patient.getIdentityCard())) {
                matchedPatients.add(patient);
            }
            //查询姓名
            if (condition.trim().equals(patient.getName())) {
                matchedPatients.add(patient);
            }
            //查询社区
            if (condition.trim().equals(patient.getCommunity())) {
                matchedPatients.add(patient);
            }
        }
        return matchedPatients;
    }

    /**
     * 计算病人出院时间
     * 
     * @param patient 病人
     */
    public static void caculateDays(PatientPlus patient) {
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
