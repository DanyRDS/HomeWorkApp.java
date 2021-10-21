import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp {
    public static char [][] map;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 3;

    public static final char DOT_EMPTY = '.';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';



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



        // Домашнее задание 3

        //задание 1
        fillArray();

        //задание 2
        int size = 100;
        fillArray100(size);

        //задание 3
        arrayMultiplication();

        //Задание 4
        diagonalArray();

        //Задание 5
        arrayInitialValue(5, 4);

        //Задание 6
        minAndMaxElements();

        //Задание 7
        int[] balanceArray = {2, 2, 3, 1, 0, 0};
        System.out.println();
        System.out.println("Исходный массив: " + Arrays.toString(balanceArray));
        boolean statement = checkBalance(balanceArray);
        System.out.println("Верно ли, что суммы левой и правой части равны где либо?: " + statement);

        //Задание 8 (проверил при n больше, меньше и равным нулю)
        int[] arrayA = {1, 2, 3, 4, 5, 6, 7};
        arrayCycle(arrayA, 2);

        int[] arrayB = {1, 2, 3, 4, 5, 6, 7};
        arrayCycle(arrayB, -2);

        int[] arrayC = {1, 2, 3, 4, 5, 6, 7};
        arrayCycle(arrayC, 0);

        initMap();
        showMap();

        while (true){
            human();
            showMap();
            if (vinner(DOT_X)) {
                System.out.println("Победил человек");
            break;
            }
            if (isMapFull()) {
                System.out.println("Карта заполнена. Ничья");
                break;
            }


            computer();
            showMap();
            if (vinner(DOT_O)) {
                System.out.println("Победил компьютер");
                break;
            }
            if (isMapFull()) {
                System.out.println("Карта заполнена. Ничья");
                break;
            }
        }
    }

    // Домашнее задание 4
    //Инициализация карты (заполнение)
    public static void initMap () {
    map = new char [SIZE][SIZE];

    for (int i = 0; i < SIZE; i++){
        for (int j = 0; j < SIZE; j++){
            map [i][j] = DOT_EMPTY;
        }
    }
    }
    //Вывод карты в консоль
    public static void showMap (){
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i);
            System.out.print(' ');
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++){
            System.out.print(i+1);
            System.out.print(' ');

            for (int j = 0; j < SIZE; j++){
                System.out.print(map[i][j]);
                System.out.print(' ');
            }

        System.out.println();
        }
        //System.out.println(Arrays.toString(map));
    }

    //Ход игрока (крестики)
    public static void human (){
    int x;
    int y;


        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введите координаты X и Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));


        map [y][x] = DOT_X;
    }

    //Проверка координат
    public static boolean isCellValid (int x, int y){
    if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
        return false;
        }

    if (map[y][x] == DOT_EMPTY){
        return true;
        }

    return false;

    }

    //Ход ИИ
    public static void computer (){
        int x;
        int y;


        Random myRandom = new Random();
        do {
            System.out.println("Введите координаты X и Y");
            x = myRandom.nextInt(SIZE);
            y = myRandom.nextInt(SIZE);
        } while (!isCellValid(x, y));

        System.out.println("Компьютер совершил ход в точке:");
        System.out.println("Х - " + (x + 1));
        System.out.println("Y - " + (y + 1));
        map [y][x] = DOT_O;
    }

    //Проверка победы (переделана при помощи циклов)
    public static boolean vinner (char symb){
       // if (map[0][0] == symb && map [0][1] == symb && map[0][2] == symb) return true;
       // if (map[1][0] == symb && map [1][1] == symb && map[1][2] == symb) return true;
       // if (map[2][0] == symb && map [2][1] == symb && map[2][2] == symb) return true;
       // if (map[0][0] == symb && map [1][1] == symb && map[2][2] == symb) return true;
       // if (map[2][0] == symb && map [1][1] == symb && map[0][2] == symb) return true;
       // if (map[0][0] == symb && map [1][0] == symb && map[2][0] == symb) return true;
       // if (map[0][1] == symb && map [1][1] == symb && map[2][1] == symb) return true;
       // if (map[0][2] == symb && map [1][2] == symb && map[2][2] == symb) return true;

        boolean leftDiagonal = true;
        boolean rightDiagonal = true;
        boolean cols;
        boolean rows;

        for (int i = 0; i < SIZE; i++){
              leftDiagonal &= (map[i][i] == symb);
              rightDiagonal &= (map [3-i-1][i] == symb);
            }
        if (leftDiagonal || rightDiagonal) return true;

        for (int i = 0; i < SIZE; i++){
            cols = true;
            rows = true;
            for (int j = 0; j < SIZE; j++){
                cols &= (map[i][j] == symb);
                rows &= (map[j][i] == symb);
            }
            if (cols || rows) return true;
        }



        //for (int i = 0; i < SIZE; i++) {
        //    for (int j = 0; j < SIZE; j++) {
        //        if (i == j || i + j + 1 == SIZE) size[i][j] = 1;


        return false;
    }

    //Ничья
    public static boolean isMapFull (){
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
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
        return (c >= 10 && c <= 20);
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
        return (a < 0);
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
    public static boolean years(int year) {
        if (year % 400 == 0) {
            return true;
        } else return year % 4 == 0 && year % 100 != 0;
    }
    //Домашнее задание 3

    //задание 1

    public static void fillArray() {
        System.out.println();
        int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(array1));
        for (int i = 0; i < 10; i++) {
            array1[i] = array1[i] == 0 ? 1 : 0;
        }
        System.out.println(Arrays.toString(array1));
    }

    //задание 2

    public static void fillArray100(int size) {
        System.out.println();
        int[] array2 = new int[size];
        for (int i = 0; i < 100; i++) array2[i] = i + 1;
        System.out.println(Arrays.toString(array2));
    }

    //Задание 3
    public static void arrayMultiplication() {
        System.out.println();
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(array3));
        for (int i = 0; i < 12; i++) {
            if (array3[i] < 6) array3[i] = array3[i] * 2;
        }
        System.out.println(Arrays.toString(array3));
    }

    //Задание 4
    public static void diagonalArray() {
        System.out.println();
        int[][] array4 = new int[5][5];
        //Заполняем диагонали
        for (int i = 0; i < array4.length; i++) {
            for (int j = 0; j < array4.length; j++) {
                if (i == j || i + j + 1 == array4.length) array4[i][j] = 1;
            }
        }
        //Выводим массив
        for (int i = 0; i < array4.length; i++) {
            for (int j = 0; j < array4.length; j++) {
                System.out.print(array4[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    //Задание 5
    public static int[] arrayInitialValue(int len, int initialValue) {
        System.out.println();
        int[] array5 = new int[len];
        for (int i = 0; i < array5.length; i++) array5[i] = initialValue;
        return array5;
    }

    //Задание 6 (два способа)
    public static void minAndMaxElements() {
        System.out.println();
        int[] array6 = {3, 5, 7, 2, 1, 0, 8, 15, 9, 21};
        int max = array6[0];
        int min = array6[0];
        for (int i = 1; i < array6.length; i++) {
            //if (array6[i] > max) max = array6[i];
            //if (array6[i] < min) min = array6[i];
            max = Math.max(max, array6[i]);
            min = Math.min(min, array6[i]);
        }
        System.out.println("Максимальный элемент массива: " + max);
        System.out.println("Минимальный элемент массива: " + min);
    }

    //Задание 7
    public static boolean checkBalance(int[] array7) {
        int left = 0;

        for (int i = 0; i < array7.length; i++) {
            left += array7[i];

            int right = 0;
            for (int j = (i + 1); j < array7.length; j++) right += array7[j];

            if (left == right) return true;
        }
        return false;
    }

    //Задание 8
    public static void arrayCycle(int[] array8, int n) {
        int a;
        System.out.println();
        System.out.println("Исходный массив: " + Arrays.toString(array8));

        //Смещение массива влево
        if (n>0) {
            for (a=0; a < n; a++) {
                int temp = array8[0];
                for (int i = 0; i < array8.length - 1; i++) {
                    array8[i] = array8[i + 1];
                }
                array8[array8.length - 1] = temp;
            }
            System.out.println("Смещённый массив: " + Arrays.toString(array8));
        }

        //Смещение массива вправо
        if (n<0) {
            for (a=0; a > n; a--) {
                int temp = array8[array8.length - 1];
                for (int i = array8.length - 2; i >= 0; i--) {
                    array8[i + 1] = array8[i];
                }
                array8[0] = temp;
            }
            System.out.println("Смещённый массив: " + Arrays.toString(array8));
        }
    }

}
