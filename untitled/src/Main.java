import java.util.Scanner;

class SportCar {
    private String whatCar;
    private String color;
    private String city;

    public void setCar(String car) {
        whatCar = car;
    }

    public void setColor(String carColor) {
        color = carColor;
    }

    public void setCity(String carCity) {
        city = carCity;
    }

    public void drive() {
        if (whatCar != null && color != null && city != null) {
            System.out.println("Вы едете на " + color + " " + whatCar + " в город " + city + ".");
        } else {
            System.out.println("Пожалуйста, выберите машину, цвет и город перед поездкой.");
        }
    }

    public static void main(String[] args) {
        String[] cars = {"Феррари", "Порше", "Ламборгини", "Макларен", "Астон Мартин"};

        System.out.println("Доступные спортивные машины:");
        for (int i = 0; i < cars.length; i++) {
            System.out.println((i + 1) + ". " + cars[i]);
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("Выберите номер машины (1-5): ");
        int choice = scanner.nextInt();

        if (choice >= 1 && choice <= 5) {
            String chosenCar = cars[choice - 1];

            System.out.print("Выберите цвет машины: ");
            String color = scanner.next();

            System.out.print("Введите город, куда поедете: ");
            String city = scanner.next();

            SportCar sportCar = new SportCar();
            sportCar.setCar(chosenCar);
            sportCar.setColor(color);
            sportCar.setCity(city);

            sportCar.drive();
        } else {
            System.out.println("Неверный выбор машины.");
        }
    }
}
