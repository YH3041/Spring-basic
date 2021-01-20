package hello.core.singleton;

public class StatefulService {

    //order(주문)을 하고 값을 필드에 저장
    private int price; //상태를 유지하는 필드

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; //문제 발생
    }

    public int getPrice() {
        return price;
    }
}
