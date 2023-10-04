package day03.mapping;

import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/day03/post")
public class PostMappingController {
    /*
        HttpServletRequest 요청 가능
    */
    // 1.
    @PostMapping("/method1")
    //public String method1(@RequestParam String param1 ){
    public String method1(@RequestBody String param1 ){
        System.out.println("PostMappingController.method1");
        System.out.println("param1 = " + param1);
        return "정상응답";
    }
    // 2.
    @PostMapping("/method2")
    //public String method2(@RequestParam Map<String , String > map ){ // Dto 권장하지만 DTO가 없을때 여러개 메개변수를 매핑 할때.
    public String method2(@RequestBody Map<String , String > map ){ // Dto 권장하지만 DTO가 없을때
        System.out.println("PostMappingController.method2");
        System.out.println("map = " + map);
        return "정상응답";
    }
    // 3.
    @PostMapping("/method3")
    //public String method3(  ParamDto paramDto ){ // Dto 권장하지만 DTO가 없을때 여러개 메개변수를 매핑 할때.
    public String method3(  @RequestBody  ParamDto paramDto ){ // Dto 권장하지만 DTO가 없을때 여러개 메개변수를 매핑
        System.out.println("PostMappingController.method3");
        System.out.println("paramDto = " + paramDto);
        return "정상응답";
    }
}
