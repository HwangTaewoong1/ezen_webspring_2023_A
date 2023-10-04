package day03.restful;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController// 해당 클래스를 스프링 MVC중 컨트롤러 객체로 사용 // 스프링 컨트롤러 객체를 빈에 등록
public class RestController4 {
    // 1. GET
    @RequestMapping( value = "/day03/blue" , method = RequestMethod.GET)
    public String getBlue(HttpServletRequest request ) throws IOException {
        //
        String param1 = request.getParameter("param1");
        System.out.println("param1 : " + param1);
        // 응답
        return "정상응답";
    }
    // 2. POST
    @RequestMapping( value = "/day03/blue" , method = RequestMethod.POST)

    public String postBlue(HttpServletRequest request) throws IOException {
        //
        String param1 = request.getParameter("param1");
        System.out.println("param1 : " + param1);
        // 응답
        return "정상응답";
    }
    // 3. PUT
    @RequestMapping( value = "/day03/blue" , method = RequestMethod.PUT)

    public String putBlue(HttpServletRequest request) throws IOException {
        //
        String param1 = request.getParameter("param1");
        System.out.println("param1 : " + param1);
        // 응답
        return "정상응답";
    }
    // 4. DELETE
    @RequestMapping( value = "/day03/blue" , method = RequestMethod.DELETE)

    public String deleteBlue(HttpServletRequest request ) throws IOException {
        //
        String param1 = request.getParameter("param1");
        System.out.println("param1 : " + param1);
        // 응답
        return "정상응답";
    }
}
