package ezenweb.controller;

import ezenweb.model.dto.BoardDto;
import ezenweb.model.dto.MemberDto;
import ezenweb.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 1. [C] 글쓰기
    @PostMapping("")
    public boolean write(BoardDto boardDto) {
        return boardService.write(boardDto);
    }
    // 2. [R] 게시글 출력
    @GetMapping("")
    public List<BoardDto> getAll() {
        return boardService.getAll();
    }
    // 3. [U] 게시글 수정
    @PutMapping("")
    public boolean update( BoardDto boardDto ) {
        return boardService.update(boardDto);
    }
    // 4. [D] 게시글 삭제
    @DeleteMapping("")
    public boolean delete(@RequestParam int bno) {
        return boardService.delete(bno);
    }

}
