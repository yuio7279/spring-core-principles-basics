package hello.core.singleton;

public class StatefulService {
    //private int price; //상태를 유지하는 필드
    public int order(String name, int price){
        System.out.println("name : "+name+" price : "+price);
        //this.price = price; //여기가 문제

        return price; //공유필드를 주지않고 리턴해버리자.
    }
    /*public int getPrice(){
        return price;
    }*/
}
