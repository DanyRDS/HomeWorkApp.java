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

}
