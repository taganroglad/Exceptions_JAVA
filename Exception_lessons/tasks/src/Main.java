import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные в следующем порядке: Фамилия Имя Отчество Дата Рождения НомерТелефона Пол");
        String input = scanner.nextLine();

        try {
            Person person = parseInput(input);
            saveToFile(person);
            System.out.println("Данные успешно сохранены в файл.");
        } catch (InputFormatException e) {
            System.out.println("Ошибка формата ввода: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка чтения-записи файла: " + e.getMessage());
            e.printStackTrace();
        }

        scanner.close();
    }

    private static Person parseInput(String input) throws InputFormatException {
        String[] data = input.split(" ");

        if (data.length != 6) {
            throw new InputFormatException("Количество данных не совпадает с требуемым");
        }

        String surname = data[0];
        String firstName = data[1];
        String middleName = data[2];
        String birthDate = data[3];
        String phoneNumber = data[4];
        String gender = data[5];

        if (!isValidDate(birthDate)) {
            throw new InputFormatException("Неверный формат даты рождения");
        }

        if (!isValidPhoneNumber(phoneNumber)) {
            throw new InputFormatException("Неверный формат номера телефона");
        }

        if (!isValidGender(gender)) {
            throw new InputFormatException("Неверный формат пола");
        }

        return new Person(surname, firstName, middleName, birthDate, phoneNumber, gender);
    }

    private static boolean isValidDate(String date) {
        return true;
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {

        return true;
    }

    private static boolean isValidGender(String gender) {

        return true;
    }

    private static void saveToFile(Person person) throws IOException {
        String filename = person.getSurname() + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(person.toString());
            writer.newLine();
        }
    }
}

class Person {
    private String surname;
    private String firstName;
    private String middleName;
    private String birthDate;
    private String phoneNumber;
    private String gender;

    public Person(String surname, String firstName, String middleName, String birthDate, String phoneNumber, String gender) {
        this.surname = surname;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return surname + firstName + middleName + birthDate + " " + phoneNumber + gender;
    }
}

class InputFormatException extends Exception {
    public InputFormatException(String message) {
        super(message);
    }
}
