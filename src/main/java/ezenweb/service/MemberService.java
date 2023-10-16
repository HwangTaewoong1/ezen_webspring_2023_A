package ezenweb.service;

import ezenweb.model.dto.MemberDto;
import ezenweb.model.entity.MemberEntity;
import ezenweb.model.repository.MemberEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    // Controller -> Service -> Repository
    // Controller <- Service <- Repository
    @Autowired
    private MemberEntityRepository memberEntityRepository;

    // 1. [C] 회원가입
    @Transactional // 트랜잭션 : 여러개 SQL를 하나의 최소 단위 [ 성공 , 실패 !! 함수내 일부 SQL만 성공]
    public boolean postMember(MemberDto memberDto) {
        // 1. dto --> entity 변경 후 [ 필수적으로 ] repository 통한 insert
        MemberEntity memberEntity
            = memberEntityRepository.save(memberDto.toEntity());
        // 2. insert 된 엔티티 확인후 성공/실패 유무
            // 3. 만약에 회원번호가 0보다 크면 ( auto_increment 적용 됨. )
        if ( memberEntity.getMno() >= 1 ) { return true; }
        return false;
    }
    // 2. [R] 회원정보 호출
    @Transactional
    public MemberDto getMember( int mno ) {
        // 1. mno[회원번호pk]를 이용한 회원 엔티티 찾기
         Optional<MemberEntity> optionalMemberEntity = memberEntityRepository.findById(mno);
        // 2. optinal 클래스로 검색한 반환값 확인
       if ( optionalMemberEntity.isPresent() ) { // 3. 만약에 optinal 클래스 안에 엔티티가 들어 있으면
           // 4. optinal 클래스에서 엔티티 꺼내기
           MemberEntity memberEntity = optionalMemberEntity.get();
           // 5. 엔티티 -> dto 변환해서 반환
           return memberEntity.toDto();
       }
        return null;
    }
    // 3. [U] 회원정보 수정
    @Transactional // 트랜잭셔널 : 하나/여럿 작업들을 묶어서 최소단위 업무처리
    public boolean updateMember(MemberDto memberDto) {
        // 1. 수정할 엔티티 찾 [ mno ].
        Optional<MemberEntity> optionalMemberEntity =
                memberEntityRepository.findById(memberDto.getMno());
        // 2. optinal 클래스로 검색한 반환값 확인
        if(optionalMemberEntity.isPresent()) {
            // 3. 포장내 내용물 꺼내기 = 포장된 곳에서 엔티티 꺼내는 과정 .get();
            MemberEntity memberEntity = optionalMemberEntity.get();
            // 4. 수정 : 별도의 수정함수가 없음 [ 엔티티 객체를 수정하면 테이블과 매핑된 상태이므로 DB의 정보도 같이 수정 ]
            memberEntity.setMname(memberDto.getMname()); // update
            memberEntity.setMpassword(memberDto.getMpassword()); // update
            memberEntity.setMphone(memberDto.getMphone()); // update
            // 5. 성공시
            return true;
        }
        return false;
    }
    // 4. [D] 회원탈퇴
    @Transactional
    public boolean deleteMember(int mno) {
        // 1. 삭제할 엔티티 찾기
        Optional<MemberEntity> optionalMemberEntity =
            memberEntityRepository.findById(mno);
        // 2. 만약에 삭제할 엔티티가 반환/검색 존재하면
        if(optionalMemberEntity.isPresent()) {
            // 3. 엔티티 삭제
            memberEntityRepository.deleteById(mno);
            return true;
        }
        return false;
    }

    // 5. 아이디 찾기
    @Transactional
    public MemberDto findId( MemberDto memberDto ) {
        // 1. 검색할 엔티티 찾기
        Optional<MemberEntity> optionalMemberEntity = Optional.ofNullable(memberEntityRepository.findIdByMnameAndMphone(memberDto.getMname(), memberDto.getMphone()));
        if(optionalMemberEntity.isPresent()) {
            MemberEntity memberEntity = optionalMemberEntity.get();
            return memberEntity.toDto();
        }
        return null;
    }
    // 6. 비밀번호 찾기
    @Transactional
    public MemberDto findPassword( MemberDto memberDto ) {
        Optional<MemberEntity> optionalMemberEntity = Optional.ofNullable(memberEntityRepository.findPwByMemailAndMphone(memberDto.getMemail(), memberDto.getMphone()));
        if (optionalMemberEntity.isPresent()) {
            MemberEntity memberEntity = optionalMemberEntity.get();
            return memberEntity.toDto();
        }
        return null;
    }
    // 7. 로그인
    @Transactional
    public boolean login(String memail, String mpassword) {
        Optional<MemberEntity> optionalMemberEntity = Optional.ofNullable(memberEntityRepository.findByMemailAndMpassword(memail, mpassword));
        return optionalMemberEntity != null;
    }
    // 8. 로그아웃
}
