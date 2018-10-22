/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adamoxy.database;

/**
 *
 * @author Revool
 */
public class test {

    public static void main(String[] args) {
        int i = 0, x = 0;
        if (i == 0) {
            x = 2;
        }
        switch (x) {
            case 1:
                System.out.println("this is case 1 but x = " + x);
                x = 3;
                break;
            case 2:
                System.out.println("this is case 2 but x = " + x);
                x = 1;
                break;
            case 3:
                System.out.println("this is case 3 but x = " + x);
                x = 4;
                break;
            case 4:
                System.out.println("this is case 4 but x = " + x);
                break;
        }
    }
}
