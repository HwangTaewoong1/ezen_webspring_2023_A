package ezenweb.model.repository;

import ezenweb.model.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardEntityRepository extends JpaRepository<BoardEntity, Integer > {
    // extends JpaRepository< 조작할 엔티티 , 조작할 엔티티의 pk 필드 타입  >

}
