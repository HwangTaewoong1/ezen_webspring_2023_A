package day04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.WebServlet;
import java.util.List;

// 스프링 빈 : 스프링 컨테이너(저장소)에 저장된 객체 [ 이유 : 스프링이 대신 객체 관리 => 여러 개발자들이 작업했을때 기준 ]

// @Controller // Spring MVC 중 해당 클래스를 Controller 로 사용
@RestController // Controller + ResponseBody
@RequestMapping("/todo") // HTTP로부터의 해당 클래스의 매핑 주소 만들기
public class ToDoController {
    // REST : HTTP기반으로 GET, POST , PUT , DELETE 메소드 이용한 웹 서비스
    // 1. [C]
    // @ResponseBody          // 응답객체 자동 지원 [ *단 해당 클래스가 @RestController 사용했을 때 생략가능.
    @PostMapping("")          // HTTP 요청중 POST 메소드 요청일 때. http://localhost:80/todo
    public boolean doPost( @RequestBody TodoDto todoDto ){  // 요청 매개변수 : 입력받은 정보들 [ Dto ]
                        // @RequestBody : HTTP BODY( POST , PUT ) JSON형식으로 요청 매핑
        System.out.println("ToDoController.doPost"); System.out.println("todoDto = " + todoDto);
        return false;
    }
    // 2. [R]
    @GetMapping("") // HTTP 요청중 GET 메소드 요청일 때. http://localhost:80/todo
    public List<TodoDto> doGet(){ // 요청 매개변수 : 출력에 필요한 정보들 [ X ]
        System.out.println("ToDoController.doGet");
        return null;    // List<TodoDto> 타입 반환 [ 테스트 할때는 null ]
    }
    // 3. [U]
    @PutMapping("") // HTTP 요청중 PUT 메소드 요청일 때. http://localhost:80/todo
    public boolean doPut( @RequestBody TodoDto todoDto ){ // 요청 매개변수 : 수정에 필요한 정보들 [ Dto ]
        System.out.println("ToDoController.doPut"); System.out.println("todoDto = " + todoDto);
        return false;
    }
    // 4. [D]
    @DeleteMapping("") // HTTP 요청중 DELETE 메소드 요청일 때. http://localhost:80/todo
    public boolean doDelete( @RequestParam int tno ){ // 요청 매개변수 : 삭제에 필요한 정보들 [ int ]
                        // @RequestParam : 쿼리스트링 에서의 매개변수 요청 할 때.
        System.out.println("ToDoController.doDelete"); System.out.println("tno = " + tno);
        return false;
    }
}
