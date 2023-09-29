import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StringChecker {
    final static int stringLength = 6; // количество данных
    final static String DATE_FORMAT = "dd.MM.yyyy"; // формат даты
    private int phoneNumberLength = 11; // количесто символов в номере телефона
    private String name;
    private String surname;
    private String patronymic;
    private String dateOfBirth;
    private long phoneNumber;
    private char sex;

    public void checkString(String value) throws StringLengthException {
        String[] str = null;
        if (value == null) {
            throw new StringLengthException("Вместо данных передан null");
        }
        str = value.split(" ");
        if (str.length != stringLength) {
            throw new StringLengthException("Введено неверное количество параметров, введено " + str.length + " необходимо " + stringLength);
        }

        boolean flagDateChecker = false;
        boolean flagSexChecker = false;
        boolean flagPhoneNumberChecker = false;
        boolean flagNameChecker = false;

        for (int i = 0; i < str.length; i++) {
            if (!flagDateChecker && isDateValid(str[i])) {
                System.out.println("The date of birth found");
                dateOfBirth = str[i];
                flagDateChecker = true;
            } else if (!flagSexChecker && isSex(str[i])) {
                sex = stringToChar(str[i]);
                flagSexChecker = true;
                System.out.println("The sex found");

            } else if (!flagPhoneNumberChecker && isPhoneNumber(str[i]) && str[i].length() == phoneNumberLength) {
                {
                    phoneNumber = stringToNumber(str[i]);
                    flagPhoneNumberChecker = true;
                    System.out.println("The phone number found");
                }
            } else if (!flagNameChecker && isName(str[i])) {
                surname = str[i];
                int temp = 0;
                for (int j = i + 1; j < str.length; j++) {
                    if (isName(str[j]) && !isSex(str[j])) {
                        name = str[j];
                        temp = j;
                        break;
                    }
                }
                if(temp != 0 && temp != str.length) {
                    for (int k = temp + 1; k < str.length; k++) {
                        if (isName(str[k]) && !isSex(str[k])) {
                            patronymic = str[k];
                            flagNameChecker = true;
                        }
                    }
                }

                if (flagNameChecker)
                    System.out.println("Name, surname, patronymic found");
            }
        }

        if (!flagDateChecker) {
            System.out.println("В введенных данных не найдена дата");
        }
        if (!flagSexChecker) {
            System.out.println("Введен некорректный пол, пол должен быть m или f");
        }
        if (!flagPhoneNumberChecker) {
            System.out.printf("Не введен корректный номер телефона, необходимо %d цифр\n", phoneNumberLength);
        }
        if(!flagNameChecker){
            System.out.println("Не найдены корректные фамилия и/или имя и/или отчество");
        }
    }

    private static boolean isDateValid(String value) {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(value);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private static boolean isPhoneNumber(String value) {
        try {
            long num = Long.parseLong(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static long stringToNumber(String value) {
        long num = 0;
        try {
            num = Long.parseLong(value);
        } catch (NumberFormatException e) {
        }
        return num;
    }

    private static char stringToChar(String value) {
        return value.charAt(0);
    }

    private static boolean isSex(String value){
        if(value.length() == 1){
            char sexTemp = stringToChar(value);
            if (sexTemp == 'f' || sexTemp == 'm'){
                return true;
            }
        }
        return false;
    }

    private static boolean isName(String value){
        String regex = "[a-zA-Zа-яА-Я]*$";
        return value.matches(regex);
    }


    public User chekingUser() {
        User newUser = null;
        try {
            if (surname != null && name != null && patronymic != null && dateOfBirth != null && phoneNumber != 0 && sex != 0){
                newUser = new User(surname, name, patronymic, dateOfBirth, phoneNumber, sex);
            }
        } catch (NullPointerException e) {
            System.out.println("Введены не корректные данные, исправьте ошибки приведенные выше");
        }
        return  newUser;
    }

    public int getPhoneNumberLength() {
        return phoneNumberLength;
    }
}
