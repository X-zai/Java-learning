package learning.java.example;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class IDCardUtil {
    private static Properties props    = new Properties();              // Properties默认编码是iso8859-1
    private static String     filePath = "IDCardAddressCode.properties";// 当前目录下的IDCardAddressCode.properties

    static {
        InputStream in = IDCardUtil.class.getResourceAsStream(filePath);
        try {
            props.load(in);
        } catch (Exception e) {

        }
    }

    /**
     * 根据所传身份证号解析其性别
     * 
     * @param cid 身份证号
     * @return 性别
     */
    public static String parseGender(String cid) {
        String gender = null;
        char c = cid.charAt(cid.length() - 2);
        int sex = Integer.parseInt(String.valueOf(c));
        if (sex % 2 == 0) {
            gender = "女";
        } else {
            gender = "男";
        }
        return gender;
    }

    /**
     * 校验规则： 1、将前面的身份证号码17位数分别乘以不同的系数。第i位对应的数为[2^(18-i)]mod11。从第一位到第十七位的系数分别为：7 9 10
     * 5 8 4 2 1 6 3 7 9 10 5 8 4 2 ； 2、将这17位数字和系数相乘的结果相加； 3、用加出来和除以11，看余数是多少？；
     * 4、余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位身份证的号码为1 0 X 9 8 7 6 5 4 3 2；
     * 
     * @return 返回false说明，身份证号码不符合规则，返回true说明身份证号码符合规则
     */
    public static boolean checkCardId(String cid) {
        boolean flag = false;
        int len = cid.length();
        int kx = 0;
        for (int i = 0; i < len - 1; i++) {
            int x = Integer.parseInt(String.valueOf(cid.charAt(i)));
            int k = 1;
            for (int j = 1; j < 18 - i; j++) {
                k *= 2;
            }
            kx += k * x;
        }
        int mod = kx % 11;
        int[] mods = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Character[] checkMods = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' };
        for (int i = 0; i < 11; i++) {
            if (mod == mods[i]) {
                Character lastCode = cid.charAt(len - 1);
                if (checkMods[i].equals(lastCode)) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    /**
     * 根据身份证号码，返回年龄
     * 
     * @param cid
     * @return
     */
    public static int parseAge(String cid) {
        int age = 0;
        String birthDayStr = cid.substring(6, 14);
        Date birthDay = null;
        try {
            birthDay = new SimpleDateFormat("yyyyMMdd").parse(birthDayStr);
        } catch (ParseException e) {

        }
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) {
            throw new IllegalArgumentException("您还没有出生么？");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH) + 1;
        int dayBirth = cal.get(Calendar.DAY_OF_MONTH);
        age = yearNow - yearBirth;
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth && dayNow < dayBirth) {
                age--;
            }
        } else {
            age--;
        }
        return age;
    }

    /**
     * 通过身份证号码解析其出生所在地
     * 
     * @param cid
     * @return
     */
    public static String parseAddress(String cid, String[] args) {
        String address = null;
        String addressCode = cid.substring(0, 6);
        try {
            address = new String(props.get(addressCode).toString().getBytes("iso-8859-1"), "utf-8");
        } catch (Exception e) {
            System.out.println("身份证号不存在!!!");
            try {
                main(args);
            } catch (Exception e1) {

            }
        }
        return address;
    }

    /**
     * Main方法，用来做测试的
     * 
     * @param args
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("身份证号:");
        //1、输入的身份证号
        String cid = br.readLine();
        //2、校验身份证号
        //2.1、身份证号不能为空！
        if (cid == null || cid.trim().length() == 0) {
            System.out.println("身份证号不能为空");
            main(args);
        }
        //2.1、身份证号是不是18位 or 是不是数字
        if (cid.length() != 18 || !isNumber(cid)) {
            System.out.println("请输入正确的身份证号!!!");
            BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("是否继续查询??? (y/n):");
            String input = br1.readLine();
            if (input.equals("y")) {
                main(args);
            } else if (input.equals("n")) {
                System.exit(0);
            } else {
                main(args);
            }
        }
        boolean flag = checkCardId(cid);
        System.out.println("身份证号是否通过校验:" + flag);
        if (flag == false) {
            System.out.println("身份证号不存在!!!");
            System.out.print("是否继续查询??? (y/n):");
            BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
            String input = br2.readLine();
            if (input.equals("y")) {
                main(args);
            } else if (input.equals("n")) {
                System.exit(0);
            } else {
                main(args);
            }
        }
        String gender = parseGender(cid);
        System.out.println("性别:" + gender);
        int age = parseAge(cid);
        System.out.println("年龄:" + age);
        String address = parseAddress(cid, args);
        System.out.println("出生地:" + address);
        System.out.print("是否继续查询??? (y/n):");
        BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
        String input = br3.readLine();
        if (input.equals("y")) {
            main(args);
        } else if (input.equals("n")) {
            System.exit(0);
        } else {
            main(args);
        }
    }

    public static boolean isNumber(String input) {
        boolean isNumber = true;
        try {
            Long.valueOf(input).longValue();
        } catch (Exception e) {
            isNumber = false;
        }
        return isNumber;
    }
}