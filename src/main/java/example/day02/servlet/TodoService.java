package example.day02.servlet;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TodoService {


    public void register(TodoDto todoDto) {
        System.out.println("TodoService.register");
    }

    public List<TodoDto> getList() {

        List<TodoDto> todoDtos = IntStream.range(0, 10).mapToObj(i -> {
            TodoDto todoDto = TodoDto.builder().tno((long) i).title("Todo.." + i).dueDate(LocalDate.now()).build();
            return todoDto;
        }).collect(Collectors.toList());
        return todoDtos;
    }
}