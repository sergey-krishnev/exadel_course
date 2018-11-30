package jpa.Factories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputTypeReader {
    public static String getStrNum() throws IOException {
        String strNum = null;

        BufferedReader bis = null;
        try {
            bis = new BufferedReader(new InputStreamReader(System.in));

            strNum = bis.readLine();
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) bis.close();
        }
        return strNum;
    }
}
