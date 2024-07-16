/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.Random;

public class ReferenceGenerator {
    private static final Random RANDOM = new Random();

    public static String getRandomRef() {
        return String.valueOf(RANDOM.nextInt(10000));
    }
}

