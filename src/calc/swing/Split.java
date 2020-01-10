package calc.swing;

import java.util.regex.Pattern;

public class Split {

    public static String num1;
    public static String num2;
    public static String mathAct;

    static void splitExp(String input) { //Разделение выражения на состовляющии
        Pattern patSymb = Pattern.compile("(\\s*[\\*/\\+-]\\s*)+"); //Шаблон-разделитель: математические операции
        String[] nums = patSymb.split(input);
        num1 = nums[0];
        num2 = nums[1];
        Pattern patDig = Pattern.compile("\\s*(\\d|[IVXLCD])+\\s*"); //Шаблон-разделитель: арабские и римские числа
        String[] opers = patDig.split(input);
        mathAct = opers[1];
    }
}
