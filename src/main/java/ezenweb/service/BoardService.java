package ezenweb.service;

import ezenweb.model.dto.BoardDto;
import ezenweb.model.entity.BoardEntity;
import ezenweb.model.repository.BoardEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardEntityRepository boardEntityRepository;

    // 1. [C] 글쓰기
    @Transactional
    public boolean write(BoardDto boardDto) {
      BoardEntity boardEntity =
              boardEntityRepository.save(boardDto.savetoEntity());
      if ( boardEntity.getBno() >= 1 ) { return true; }
      return false;
    }

    // 2. [R] 게시글 출력
    @Transactional
    public List<BoardDto> getAll() {
        List<BoardEntity> entities = boardEntityRepository.findAll();
        List<BoardDto> boardDtos = new ArrayList<>();
        entities.forEach( e -> { boardDtos.add(e.alltoDto()); });
        return boardDtos;
    }

    // 3. [U] 게시글 수정
    @Transactional
    public boolean update(BoardDto boardDto) {
      Optional<BoardEntity> optionalBoardEntity =
              boardEntityRepository.findById(boardDto.getBno());
      if( optionalBoardEntity.isPresent() ){

         BoardEntity boardEntity = optionalBoardEntity.get();

         boardEntity.setBtitle((boardDto.getBtitle()));
         boardEntity.setBcontent((boardDto.getBcontent()));
         boardEntity.setBfile((boardDto.getBfile()));
      }
       return false;
    }

    // 4. [D] 게시글 삭제
    @Transactional
    public boolean delete(int bno) {
        boardEntityRepository.deleteById( bno );
        return false;
    }
}
