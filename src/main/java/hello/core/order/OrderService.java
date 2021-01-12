package hello.core.order;

public interface OrderService {
    //Order에 최종 Order 결과를 반환한다.
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
