import java.util.Scanner;

public class Calculator {
    Scanner scanner = new Scanner(System.in);
    int menu;
    double number1;
    double number2;
    char operator;
    Main main = new Main();
    UI ui = new UI();

    public void run(){
        ui.hello();
        menu = scanner.nextInt();
        while (true) {      //Пока пользователь не ввёл 1, программа будет продолжаться
            if (menu == 1) {
                System.out.println("Завершаю программу");
                break;
            }
            if (menu != 2) {            //Проверка на правильно введённую цифру
                ui.wrongHello();
                menu = scanner.nextInt();
                continue;
            }
            ui.choseOperator();   //Принимаем оператор
            String s = scanner.next();
            if (s.equals("exit")) {     //Если exit, то программа завершается
                System.out.println("Завершаю программу");
                break;
            }
            operator = s.charAt(0);     //Берем первый символ строки
            if (ui.isInvalidOperator(operator)) continue;      //Проверка есть ли такой оператор
            System.out.println("Введите сначало число 1, потом число 2");       //Берем числа 1 и 2

            try{                                    //Берем в try-catch, на случай если будет введён не double
                String s1 = scanner.next();
                number1 = Double.parseDouble(s1);
                String s2 = scanner.next();
                number2 = Double.parseDouble(s2);
            }
            catch (NumberFormatException e){
                ui.wrongNumberFormat();
                continue;
            }
            getTheResult(operator, number1, number2);//Передаём в метод Calculator класса Main
        }
        scanner.close();
    }

    public void  getTheResult(char operator, double number1, double number2){ //Калькулятор
        switch (operator){
            case('+'):  //Если сложение
                System.out.println(number1 + " + " + number2 + " = " + (number1 + number2));
                break;
            case('-'):  //Если вычитание
                System.out.println(number1 + " - " + number2 + " = " + (number1 - number2));
                break;
            case('*'):  //Если умножение
                System.out.println(number1 + " * " + number2 + " = " + (number1*number2));
                break;
            case('/'): //Если деление
                if (number2 == 0){
                    System.out.println("Делитель не может быть равен нулю");
                    break;
                }
                System.out.println(number1 + " / " + number2 + " = " + (number1/number2));
                break;
        }
    }
}
