package hello.core.member;

public class MemberServiceImpl implements MemberService {

    //여기에 MemoryMemberRepository가 할당된다.
    private final MemberRepository memberRepository;

    //생성자에 MemoryMemberRepository가 들어와서
    //MemberServiceImple은 MemberRepository(인터페이스)에만 의존한다.
    //MemoryMemberRepository에는 의존하지 않음
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
