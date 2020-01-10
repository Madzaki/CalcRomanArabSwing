package calc.swing;

import javax.swing.*;

public class MathClass {
    static String calcThis(String input) {
        String answer = "";
        PatternClass.isExp(input); //Определение введенных чисел как арабских или римских
        Split.splitExp(input);	//Разделение на составляющии введеного выражения
        int num1=0;
        int num2=0;
        if ((PatternClass.isArab)&&(!PatternClass.isRoman)) {  //Если оба числа арабские
            num1 = Integer.parseInt(Split.num1);
            num2 = Integer.parseInt(Split.num2);
        } else if ((!PatternClass.isArab)&&(PatternClass.isRoman)) {    //Если оба числа римские
            num1 = Convert.convertToArab(Split.num1);
            num2 = Convert.convertToArab(Split.num2);
        }
        if ((num1 > 10)|(num2 > 10)|(num1 < 1)|(num2 < 1)) {
            if ((PatternClass.isArab)&&(!PatternClass.isRoman)) {
                /*Проверка соответсвия введенных чисел - от 1 до 10*/
                JOptionPane.showMessageDialog(null, "'" + num1 + "' or '" + num2 + "' is not from 1 to 10.", "Warning!", JOptionPane.PLAIN_MESSAGE);
                throw new ArithmeticException("\n'" + num1 + "' or '" + num2 + "' is not from 1 to 10." );
            } else if ((!PatternClass.isArab)&&(PatternClass.isRoman)) {
                /*Проверка соответсвия введенных чисел - от 1 до 10*/
                JOptionPane.showMessageDialog(null, "'" + Split.num1 + "' or '" + Split.num2 + "' is not from 1 to 10.", "Warning!", JOptionPane.PLAIN_MESSAGE);
                throw new ArithmeticException("\n'" + Split.num1 + "' or '" + Split.num2 + "' is not from 1 to 10." );
            }
        } else if (num2 >= num1 & Split.mathAct.equals("-") & PatternClass.isRoman) {
            /*Проверка римских чесел на возможность получения отрицательных значений*/
            JOptionPane.showMessageDialog(null, "'" + num2 + "' is greater than or equal to '" + num1 + "'.", "Warning!", JOptionPane.PLAIN_MESSAGE);
            throw new ArithmeticException("\n'" + num2 + "' is greater than or equal to '" + num1 + "'.");
        } else {
            int res = 0;
            switch (Split.mathAct) {
                case "+": res = num1 + num2;
                    break;
                case "-": res = num1 - num2;
                    break;
                case "*": res = num1 * num2;
                    break;
                case "/": res = num1 / num2;
                    if (num1 % num2 > 0) {
                        /*Проверка чесел на возможность получения дробных значений*/
                        JOptionPane.showMessageDialog(null, "The answer is not integer.", "Warning!", JOptionPane.PLAIN_MESSAGE);
                        throw new ArithmeticException("\nThe answer is not integer.");
                    } else {
                        break;
                    }
                default: System.out.println("I can't calculate it...");
            }
            String resStr = Integer.toString(res);
            if ((PatternClass.isArab)&&(!PatternClass.isRoman)) {
                answer = "The answer is '" + resStr + "' of Arabic numerals.";
                System.out.println("The answer is '" + resStr + "' of Arabic numerals.");
            } else if ((!PatternClass.isArab)&&(PatternClass.isRoman)) {
                String romanRes = Convert.convertToRoman(resStr);
                answer = "The answer is '" + romanRes + "' of Roman numerals.";
                System.out.println("The answer is '" + romanRes + "' of Roman numerals.");
            }
        }
        return answer;
    }
}
