import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Set<String> commands = new HashSet<>();
    static Scanner in = new Scanner(System.in);
    public static final String ERROR_MESSAGE = "Произошла ошибка. Можете воспользоваться командой \"help\"";
    public static final String ERROR_MESSAGE1 = "Изменение!!!!!!";
    public static final String CONTINUE_WORK = "Выражение посчитано. Продолжим?";
    public static final String ENTER = "Для продолжения нажмите enter";
    public static void main(String[] args) {
        commands.add("plus");
        commands.add("minus");
        commands.add("multi");
        commands.add("del");
        commands.add("help");
        getCommand();
    }

    public static void getCommand() {
        String command;
        System.out.println("Введите комманду: ");
        command = in.nextLine();
        if (command != null && !command.equals("")){
            if (commands.contains(command)){
                switch (command) {
                    case "plus" :{
                        long num1 = getInt();
                        long num2 = getInt();
                        System.out.println(num1 + " + " + num2 + " = " + summa(num1, num2));
                        System.out.println(CONTINUE_WORK);
                        in.nextLine();
                        getCommand();
                    }
                    case "minus" : {
                        long num1 = getInt();
                        long num2 = getInt();
                        System.out.println(num1 + " - " + num2 + " = " + minus(num1, num2));
                        System.out.println(CONTINUE_WORK);
                        in.nextLine();
                        getCommand();
                    }
                    case "multi" : {
                        long num1 = getInt();
                        long num2 = getInt();
                        System.out.println(num1 + " * " + num2 + " = " + multi(num1, num2));
                        System.out.println(CONTINUE_WORK);
                        in.nextLine();
                        getCommand();
                    }
                    case "del" : {
                        long num1 = getInt();
                        long num2 = getInt();
                        System.out.println(num1 + " / " + num2 + " = " + del(num1, num2));
                        System.out.println(CONTINUE_WORK);
                        in.nextLine();
                        getCommand();
                    }
                    case "help" : {
                        System.out.println("Ваш набор команд: \n" + """
                                plus - Сложение
                                minus - Вычитание
                                multi - Умножение
                                del - Деление
                                """);
                        System.out.print(ENTER);
                        in.nextLine();
                        getCommand();
                    }
                    default : {
                        in.nextLine();
                        getCommand();
                    }
                }
            } else {
                System.out.println(ERROR_MESSAGE);
                System.out.println(ENTER);
                in.nextLine();
                getCommand();
            }
        } else {
            System.out.println(ERROR_MESSAGE);
            System.out.println(ENTER);
            in.nextLine();
            getCommand();
        }
    }

    public static long getInt(){
        long num;
        System.out.print("Введите число: ");
        if (in.hasNextLong()){
            num = in.nextLong();
            return num;
        } else {
            System.out.println("Попробуйте снова...");
            in.next();
            num = getInt();
        }
        return num;
    }

    public static long summa(long num1, long num2){
        return num1 + num2;
    }
    public static long minus(long num1, long num2){
        return num1 - num2;
    }
    public static long multi(long num1, long num2){
        long result = num1 * num2;
        if (result < 0) {
            System.out.println("Допустимый диапазон числа превышен... Извините, попробуйте снова с меньшим числом");
            in.nextLine();
            getCommand();
        }
        return result;
    }
    public static double del(long num1, long num2){
        if (num2 == 0) {
            System.out.println("Деление на 0 невозможно. Попробуйте снова!");
            in.nextLine();
            getCommand();
        }
        return num1 * 1.0 / num2;
    }
}