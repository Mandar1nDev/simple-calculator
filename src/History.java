import java.util.ArrayList;
import java.util.Scanner;

public class History{
    ArrayList<String> arrayList = new ArrayList<>();
    private Scanner scanner;
    private UI ui;
    public History(Scanner scanner){
        this.scanner = scanner;
        this.ui = ui;
    }
    public void runHistoryMenu(){
        int menu;
        while (true){
            ui.historyMenu();
            if (!scanner.hasNextInt()){
                System.out.println("Введите число от 1 до 4");
                continue;
            }
            int a = scanner.nextInt();
            if (a == 4){break;}
            switch (a){
                case(1):
                    get();
                    continue;
                case(2):
                    ui.getN();
                    while (!scanner.hasNextInt()){
                        System.out.println("Пожалуйста, введите число");
                        ui.getN();
                    }
                    get(scanner.nextInt());
                    continue;
                case(3):
                    ui.getN();
                    while (!scanner.hasNextInt()){
                        System.out.println("Пожалуйста, введите число");
                        ui.getN();
                    }
                    int n = scanner.nextInt();
                    if (n >= arrayList.size()){
                        System.out.println("""
                                ------------------------------------------------------------
                                Вы ввели больше, чем в истории запросов
                                ------------------------------------------------------------""");
                        continue;
                    }
                    remove(n);
                    System.out.println("Готово");
                    continue;
            }
        }
    }

    public void add(String s){
        arrayList.addFirst(s);
    }
    public void get(){      //Выдать 10 последних запросов
        for (String s: arrayList){
            System.out.println(s);
        }
    }
    public void get(int a){      //Выдать какое-то количество
        for (int i = 0; i < a; i++) {
            System.out.println(arrayList.get(i));
        }
    }
    public void remove(int a){
        for (int i = 0; i < a; i++) {
            arrayList.remove(0);
        }
    }
    public void getAll(){       //Выдать всю историю сразу
        for(String s: arrayList){
            System.out.println(s);
        }
    }
}