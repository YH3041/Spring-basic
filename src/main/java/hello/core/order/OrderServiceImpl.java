package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
//주문 생성 요청이오면b
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //    private  final  DiscountPolicy discountPolicy = new RateDiscountPolicy();
//    private  DiscountPolicy discountPolicy; //인터페이스에만 의존하지만 NPE 발생


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

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
