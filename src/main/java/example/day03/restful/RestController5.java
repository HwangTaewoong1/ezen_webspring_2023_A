package example.day03.restful;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController// 해당 클래스를 스프링 MVC중 컨트롤러 객체로 사용 // 스프링 컨트롤러 객체를 빈에 등록
@RequestMapping(value = "/day03/get") // 클래스에 매핑 URL 정의할 경우 해당 클래스 안에 메소드
public class RestController5 {
    // 1. GET
    @RequestMapping( value = "/pink" , method = RequestMethod.GET)
    public String getPink(HttpServletRequest request ) throws IOException {
        //
        String param1 = request.getParameter("param1");
        System.out.println("param1 : " + param1);
        // 응답
        return "정상응답";
    }
    // 2. POST
    @RequestMapping( value = "/pink" , method = RequestMethod.POST)

    public String postPink(HttpServletRequest request) throws IOException {
        //
        String param1 = request.getParameter("param1");
        System.out.println("param1 : " + param1);
        // 응답
        return "정상응답";
    }
    // 3. PUT
    @RequestMapping( value = "/pink" , method = RequestMethod.PUT)

    public String putPink(HttpServletRequest request) throws IOException {
        //
        String param1 = request.getParameter("param1");
        System.out.println("param1 : " + param1);
        // 응답
        return "정상응답";
    }
    // 4. DELETE
    @RequestMapping( value = "/pink" , method = RequestMethod.DELETE)

    public String deletePink(HttpServletRequest request ) throws IOException {
        //
        String param1 = request.getParameter("param1");
        System.out.println("param1 : " + param1);
        // 응답
        return "정상응답";
    }
}
