public class User {
    private String name;
    private String surname;
    private String patronymic;
    private String dateOfBirth;
    private long phoneNumber;
    private char sex;

    public User(String surname, String name, String patronymic, String dateOfBirth, long phoneNumber, char sex) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public char getSex() {
        return sex;
    }

    public void printInfo() throws NullPointerException{
        try {
            System.out.printf("%s %s %s %s %d %s", surname, name, patronymic, dateOfBirth, phoneNumber, sex);
        } catch (NullPointerException e) {
            System.out.println("Введены не корректные данные, исправьте ошибки приведенные выше");
        }
    }
}
