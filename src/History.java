import java.util.ArrayList;

public class History{
    ArrayList<String> arrayList = new ArrayList<>();
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
    public void getAll(){       //Выдать всю историю сразу
        for(String s: arrayList){
            System.out.println(s);
        }
    }
}