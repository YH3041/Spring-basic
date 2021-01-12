package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;


//주문 생성 요청이오면
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();


    @Override
     //회원정보 조회 -> 할인 정책에 넘긴다. -> 최종생성된 order를 반환
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        //단일 책임 원칙 잘지켰다 -> OrderService는 할인에 대해서 모른다 discountPolicy가 알아서 한다(결과 값만 던져줌).
        //할인에 대한 변경 시 주문까지 갈 필요가 없음.
        int discountPrice = discountPolicy.discount(member, itemPrice);

        //Order 만들어서 반환
       return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
