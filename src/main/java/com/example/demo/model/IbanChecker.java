package com.example.demo.model;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class IbanChecker {

    public IbanChecker() {

    }

    private static List<Country> getCountriesInformation(String fileName) {
        List<Country> countries = new ArrayList<>();

        File file = new File(fileName);
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return countries;
        }

        String fileLine;
        while (true) {
            try {
                if ((fileLine = br.readLine()) == null)  {
                    break;
                }
                else {
                    String[] countryInfo;
                    countryInfo = fileLine.split(" ");
                    countries.add(new Country(countryInfo[0], Integer.valueOf(countryInfo[1])));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countries;
    }

    public boolean isIbanCorrect(String iban) {
        BigInteger ibanInInt;
        BigInteger mod = new BigInteger("97");

        String countriesInfo = "src/main/java/com/example/demo/resource/countriesInfo.txt";
        List<Country> countries = getCountriesInformation(countriesInfo);

        for (Country c : countries) {
            if (c.getCountryCode().equals(iban.substring(0, 2)) && c.getIbanLength() == iban.length()) {
                iban = swapChars(iban);

                for (int i = 0; i < iban.length(); i++) {
                    if (!Character.isDigit(iban.charAt(i))) {
                        iban = changeIbanLettersToNumbers(iban, i);
                    }
                }

                ibanInInt = new BigInteger(iban);


                return ibanInInt.mod(mod).equals(new BigInteger("1"));
            }
        }

        return false;
    }

    private static String changeIbanLettersToNumbers(String iban, int i) {
        String newIban = iban.substring(0, i);
        newIban += Integer.toString(Character.getNumericValue(iban.charAt(i)));
        newIban += iban.substring(i + 1);
        return newIban;
    }

    private static String swapChars(String iban) {
        iban += iban.substring(0, 4);
        iban = iban.substring(4);
        return iban;
    }
}
