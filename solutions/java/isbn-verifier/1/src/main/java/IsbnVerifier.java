import java.util.ArrayList;
import java.util.List;

class IsbnVerifier {
    boolean isValid(String stringToVerify) {
        if (stringToVerify == null) {
            return false;
            //throw new IllegalArgumentException("string is null");
        }
        stringToVerify = stringToVerify.trim();
        if (stringToVerify.isEmpty()) {
            return false;
            //throw new IllegalArgumentException("string is empty");
        }

        // last character → check digit
        char last = stringToVerify.charAt(stringToVerify.length() - 1);
        int check;
        if (Character.isDigit(last)) {
            check = Character.getNumericValue(last);
        } else if (last == 'X') {
            check = 10;
        } else {
            return false;
            //throw new IllegalArgumentException("invalid check digit: '" + last + "'");
        }
        String remainder = stringToVerify.substring(0,stringToVerify.length()-1);
        List<Integer> digits = new ArrayList<>(9);
        for (int i = 0; i < remainder.length(); i++) {
            char c = remainder.charAt(i);
            if (c == '-') {
                continue;
            }
            if (Character.isDigit(c)) {
                digits.add(Character.getNumericValue(c));
            } else {
                return false;
                //throw new IllegalArgumentException("Invalid character: " + c);
            }
        }

        if (digits.size() != 9) {
            return false;
            //throw new IllegalArgumentException("wrong number of digits. Expected 9 + checksum, got " + digits.size());
        }

        // Time for the big check!
        int sum = digits.get(0)*10 + digits.get(1)*9 + digits.get(2)*8 +
          digits.get(3)*7 + digits.get(4)*6 + digits.get(5)*5 +
          digits.get(6)*4 + digits.get(7)*3 + digits.get(8)*2 + check;

        return sum % 11 == 0;
    }

}
