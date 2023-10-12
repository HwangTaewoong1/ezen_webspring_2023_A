package example.day03.mapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/day03/delete")
public class DeleteMappingController {
    @DeleteMapping("/method1")
    public boolean method1(@RequestParam String param1 ){
        System.out.println("param1 = " + param1);
        return true;
    }
    @DeleteMapping("/method2")
    public boolean method2( ParamDto parmas ){
        System.out.println("map = " + parmas);
        return false;

    }

}

