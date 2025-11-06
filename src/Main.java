import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);  // один сканер на всю программу
        UI ui = new UI();
        History history = new History(scanner);    // передаём сканер
        Calculator calculator = new Calculator(scanner, ui, history);
        calculator.run();
        scanner.close();  // закрываем один раз в конце
    }
}