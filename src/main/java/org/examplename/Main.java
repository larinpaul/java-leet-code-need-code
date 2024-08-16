package org.examplename;

import java.math.BigDecimal;
import java.math.BigInteger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);

        }

        System.out.println("Let's test the BigInteger class! :)");

        BigInteger bi1 = new BigInteger("12345678900987654321");
        BigInteger bi2 = new BigInteger("2");

        BigInteger bi3 = bi1.divide(bi2);

        System.out.println(bi1);
        System.out.println(bi2);
        System.out.println(bi3);

        BigDecimal bd1 = new BigDecimal("1234567890.0987654321");
        BigDecimal bd2 = new BigDecimal("3.0");

        BigDecimal bd3 = bd1.divide(bd2);
        System.out.println(bd1);
        System.out.println(bd2);
        System.out.println(bd3);

        System.out.println();
        for (BigInteger bi = BigInteger.valueOf(5);
             bi.compareTo(BigInteger.ZERO) > 0;
             bi = bi.subtract(BigInteger.ONE)) {

            System.out.println(bi);
        }


    }
}
