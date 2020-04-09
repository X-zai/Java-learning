package learning.java.practice.p20200324;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) throws Exception {
		List<Patient> patients = new ArrayList<Patient>();
		Patient patient01 = new Patient("小王", 28, 37.4);
		Patient patient02 = new Patient("小美", 28, 38.3);
		Patient patient03 = new Patient("小刘", 55, 36.9);
		Patient patient04 = new Patient("小张", 67, 37.2);
		Patient patient05 = new Patient("小宋", 18, 37.5);
		Patient patient06 = new Patient("小李", 14, 37.6);
		Patient patient07 = new Patient("小明", 78, 36.8);
		Patient patient08 = new Patient("小杨", 55, 36.9);
		Patient patient09 = new Patient("小秦", 25, 38.5);
		patients.add(patient01);
		patients.add(patient02);
		patients.add(patient03);
		patients.add(patient04);
		patients.add(patient05);
		patients.add(patient06);
		patients.add(patient07);
		patients.add(patient08);
		patients.add(patient09);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("please input");
			String name = br.readLine();
			for (Patient patient : patients) {
				if (name.equals(patient.getName())) {
					if (patient.getOld() <= 35 && patient.getTemperature() >= 37) {
						System.out.println(String.format("%.0f", (patient.getTemperature() - 37) / 0.2) + "days");
					} else if (patient.getOld() > 35 && patient.getOld() < 55 && patient.getTemperature() >= 37) {
						System.out.println(String.format("%.0f", (patient.getTemperature() - 37) / 0.1) + "days");
					} else if (patient.getOld() >= 55 && patient.getTemperature() >= 37) {
						System.out.println(String.format("%.0f", (patient.getTemperature() - 37) / 0.05) + "days");
					}
					Thread.sleep(1000);
				}
			}
		}
	}
}
