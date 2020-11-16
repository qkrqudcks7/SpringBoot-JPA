package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepositoryOld;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional // 얘가 기본적으로 롤백을 해버려서, 롤백 false를 넣어야 된다.
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepositoryOld memberRepository;

    @Test
    @Rollback(false)
    void 회원가입() throws Exception{
        //given
        Member member= new Member();
        member.setName("park");
        //when
        Long joinId = memberService.join(member);

        //then
        assertEquals(member ,memberRepository.findOne(joinId));
    }
    @Test
    void 중복_회원_예외() throws Exception{
        //given
        Member member1= new Member();
        member1.setName("park1");

        Member member2 = new Member();
        member2.setName("park1");

        //when
        memberService.join(member1);

        //then
        IllegalStateException thrown=assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertEquals("이미 존재하는 회원입니다." ,thrown.getMessage());

    }
}