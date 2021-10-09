public class HomeWorkApp {
    public static void main(String[] args) {
        // задания разделены пустой строкой для удобства чтения
        System.out.println("Задание 2");
        printThreeWords();
        System.out.println("");
        System.out.println("Задание 3");
        checkSumSign();
        System.out.println("");
        System.out.println("Задание 4");
        printColor();
        System.out.println("");
        System.out.println("Задание 5");
        compareNumbers();

        //Домашнее задание 2
        //объявим переменные
        int x = 2;
        int y = 13;
        int year = 2004;
        String message = "привет";

        // Запустим первый метод
        // Вернем значение true или false
        boolean t = addTwoNumbers(x, y);
        System.out.println(t);

        // Проверим второй метод
        number(x);

        // Запустим третий метод
        // Вернем значение true или false
        boolean u = numberBoolean(x);
        System.out.println(u);

        // Проверим четвертый метод
        cycle(x, message);

        // Пятый метод (високосный год)
        Boolean p = years(year);
        System.out.println(p);

    }
    public static void printThreeWords() {
        System.out.println("orange");
        System.out.println("banana");
        System.out.println("apple");
    }

    public static void checkSumSign() {
        // ОБЪЯВЛЯЕМ ПЕРЕМЕННЫЕ
        int a = 5;
        int b = -3;
        int sum = a + b;
        // СОЗДАЕМ СТРУКТУРУ if
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else if (sum < 0) {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 101;
        if (value > 100) {
            System.out.println("зеленый");
        } else if (value > 0 && value <= 100) {
            System.out.println("желтый");
        } else if (value <= 0) {
            System.out.println("красный");
        }
    }

    public static void compareNumbers() {
        int a = 11;
        int b = -8;
        if (a >= b) {
            System.out.println("a >= b");
        } else if (a < b) {
            System.out.println("a < b");
        }
    }
// Домашнее задание 2
    // Задание 1

    public static boolean addTwoNumbers(int a, int b) {
        int c = a + b;
        if (c >= 10 && c <= 20) {
            return true;
        } else {
            return false;
        }
    }

    // Задание 2
    public static void number(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    // Задание 3
    public static boolean numberBoolean(int a) {
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    // Задание 4
    public static boolean cycle(int a, String message) {
        do {
            System.out.println(message);
            a--;
        } while (a > 0);
        return false;
    }

    //Задание 5 (вискокосный год)
    public static boolean years (int year) {
        if (year % 400 == 0) {
            return true;
        }
        else if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }
        else {
            return false;
        }
    }

}
