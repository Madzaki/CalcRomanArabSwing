package calc.swing;

public class Convert {
    static int convertToArab(String romanNum) { //Конвертация арабских в римские числа
        String num;
        int arabHundred = 0;
        int arabTen = 0;
        int arabOne = 0;
        for (int index1 = 0; index1 <= 2; index1++) {
            for (int index3 = 0; index3 <= 8; index3++){
                num = Numerals.allNums[index1][0][index3];
                if (num.equals(romanNum)) {
                    if (index1 == 2) {
                        arabHundred = 100 * Integer.parseInt(Numerals.allNums[index1][1][index3]);
                        break;
                    } else if (index1 == 1) {
                        arabTen = 10 * Integer.parseInt(Numerals.allNums[index1][1][index3]);
                        break;
                    } else {
                        arabOne = Integer.parseInt(Numerals.allNums[index1][1][index3]);
                        break;
                    }
                }
            }
        }
        return arabHundred + arabTen + arabOne;
    }
    static String convertToRoman(String arabNum) { //Конвертация римских в арабские числа
        char[] splitArab = arabNum.toCharArray();	//разделение арабского числа на единицы, десятки и сотни
        String romanHundred = "";
        String romanTen = "";
        String romanOne = "";
        for (int index1 = splitArab.length-1; index1 >= 0; index1--) {
            int index = splitArab.length - index1 - 1;
            String arab1 = Character.toString(splitArab[index]);

            for (int index3 = 0; index3 <= 8; index3++){
                String w = Numerals.allNums[index1][1][index3];
                if (w.equals(arab1)) {
                    if (index1 == 2) {
                        romanHundred = Numerals.allNums[2][0][index3];
                        break;
                    } else if (index1 == 1) {
                        romanTen = Numerals.allNums[1][0][index3];
                        break;
                    } else {
                        romanOne = Numerals.allNums[0][0][index3];
                        break;
                    }
                }
            }
        }
        return romanHundred + romanTen + romanOne;
    }
}
