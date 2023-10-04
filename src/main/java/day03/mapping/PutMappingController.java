package day03.mapping;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/day03/put")
public class PutMappingController {
    @PutMapping("/method1")
    //public String method1(@RequestParam String param1 ){
    public ParamDto method1(@RequestBody ParamDto paramDto ){
        return paramDto;
    }
    // 2.
    @PutMapping("/method2")
    //public String method2(@RequestParam Map<String , String > map ){ // Dto 권장하지만 DTO가 없을때 여러개 메개변수를 매핑 할때.
    public Map<String , String> method2(@RequestBody Map<String , String > map ){ // Dto 권장하지만 DTO가 없을때
        return map;
    }
    // 3.
    @PutMapping("/method3")
    //public String method3(  ParamDto paramDto ){ // Dto 권장하지만 DTO가 없을때 여러개 메개변수를 매핑 할때.
    public String method3(  @RequestBody  ParamDto paramDto ){ // Dto 권장하지만 DTO가 없을때 여러개 메개변수를 매핑
        System.out.println("PostMappingController.method3");
        System.out.println("paramDto = " + paramDto);
        return "정상응답";
    }
}
