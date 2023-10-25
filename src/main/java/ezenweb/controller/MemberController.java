package ezenweb.controller;

import ezenweb.model.dto.MemberDto;
import ezenweb.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

// IOC : 제어역전( 객체 관리를 스프링에게 위임 = 왜?? 개발자가 편하려고/협업하려고(객체 공유해서 쓸려고 = 서로 다른 객체 사용했을때 문제발생 = 싱글톤 ))
// DI(Dependency Injection) : 의존성 주입 [ 스프링이 객체를 관리하니까.. 스프링에게 객체를 의존(부탁) 해서 주입(가져오기)]
@RestController // 컨트롤러(@Component 포함 = 스프링 컨테이너(스프링 관리하는 메모리 공간 ) 빈(객체) 등록 ) + ResponseBody
@RequestMapping("/member") // 클래스 매핑
// @CrossOrigin("http://localhost:3000") // 교차 리소스 공유 [ 해당 주소 ]
public class MemberController {
    // Controller -> Service 요청
    // Controller <- Service 응답
    @Autowired
    private MemberService memberService;

    // 1. [C] 회원가입
    @PostMapping("/post")
    public boolean postMember(@RequestBody MemberDto memberDto) {
        boolean result = memberService.postMember(memberDto);
        return result;
    }
    /*
    // 2. [R] 회원정보 호출 [ 1명 ] : 세션을 구현 안했을때.
    @GetMapping("/get")
    public MemberDto getMember(@RequestParam int mno) {
    MemberDto memberDto = memberService.getMember(mno);
        return memberDto;
    }
    */

    // 3. [U] 회원정보 수정
    @PutMapping("/put")
    public boolean updateMember(@RequestBody MemberDto memberDto) {
        boolean result = memberService.updateMember(memberDto);
        return result;
    }
    // 4. [D] 회원탈퇴
    @DeleteMapping("/delete")
    public boolean deleteMember(@RequestParam int mno) {
        boolean result = memberService.deleteMember(mno);
        return result;
    }

    // 5. 아이디 찾기
    @PostMapping("/getfindId")
    public MemberDto findId(@RequestBody MemberDto memberDto) {
        MemberDto result = memberService.findId(memberDto);
        return result;
    }

    // 6. 비밀번호 찾기
    @PostMapping("/getfindPassword")
    public MemberDto findPassword(@RequestBody MemberDto memberDto) {
        MemberDto result = memberService.findPassword(memberDto);
        return result;
    }

    /*
    // 7. 로그인 (태웅 ver)
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody MemberDto memberDto, HttpSession session) {
        if (memberService.login(memberDto.getMemail(), memberDto.getMpassword())) {
            // 로그인 성공
            session.setAttribute("loggedInMember", memberDto.getMemail());
            return ResponseEntity.ok("로그인 성공");
        } else {
            // 로그인 실패
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
        }
    }

    // 8. 로그아웃 (태웅 ver)
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 세션에서 사용자 정보를 삭제
        session.invalidate(); // 세션을 무효화하여 모든 세션 데이터를 삭제

        // 로그아웃 후 리다이렉트할 페이지를 지정하거나 홈페이지로 이동
        return "로그아웃 성공(세션 데이터 삭제)";
    }
    */

    // 5. [강사님.VER] [ post ] 로그인      get/post     요청(아이디/비밀번호) / 응답
    @PostMapping("/login")
    public boolean login(@RequestBody MemberDto memberDto , HttpServletRequest request) {
        boolean result = memberService.login(memberDto);
        return result;
    }
    // 6. [강사님.VER] [ get ] 로그아웃      get/post     요청(아이디/비밀번호) / 응답
    @GetMapping("/logout")
    public boolean logout() {
        boolean result = memberService.logout();
        return result;
    }
    // 2. [R] 회원정보 호출 [ 로그인된 회원 호출 ] 세션을 구현 했을때 강사님 ver
    @GetMapping("/get")
    public MemberDto getMember() {
        return memberService.getMember();
    }

}
