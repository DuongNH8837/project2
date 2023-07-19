package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringDealer {
    /**
     * Trim spaces.
     *
     * @param str the string need to be trimmed
     * @return String after be trimmed
     */
    public String trimMax(String str) {
        if (str == null) return "";
        return str.trim().replaceAll("\\s+"," ");
    }

    /**
     * Check if email is valid or not.
     *
     * @param email the input email
     * @return boolean value, true if email is valid, false if not
     */
    public boolean checkEmailRegex(String email){
        String regex = "^[a-zA-Z0-9!#$%&'*+/=?^`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$";
        return email.matches(regex);
    }

    /**
     * Check if phone number is valid or not.
     *
     * @param phone the input phone number
     * @return boolean value, true if phone number is valid, false if not
     */
    public boolean checkPhoneRegex(String phone){
        String regex = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";
        return phone.matches(regex);
    }

    public int validateInteger(String value, String invalidMessage){
        int number = -1;
        try{
            number = Integer.parseInt(value);
        } catch (NumberFormatException nfe){
            System.out.println(invalidMessage);
        }
        return number;
    }

    public float validateFloat(String value, String invalidMessage){
        float number = -1;
        try{
            number = Float.parseFloat(value);
        } catch (NumberFormatException nfe) {
            System.out.println(invalidMessage);
        }
        return number;
    }

    public Date convertStringToDate(String value, String invalidMessage){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(value);
        } catch (ParseException e) {
            System.out.println(invalidMessage);
            return null;
        }
        return date;
    }
}
