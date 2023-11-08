package ezenweb.model.repository;

import ezenweb.model.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardEntityRepository
    //extends JpaRepository< 조작할엔티티 , 조작할엔티티의PK필드타입 > {
    extends JpaRepository< BoardEntity, Integer > {

    // 추상메소드 이용한 엔티티 검색
    // - 기본 제공하는 함수 find~~ , delete ~~ , save ~~
    // 1. 해당하는 제목의 엔티티(게시물) 찾기
    BoardEntity findByBtitle(String btitle);
    //Optional<BoardEntity> findByBtitle(String btitle);
    boolean existsByBtitle(String btitle);
    // List<BoardEntity> findByAllBtitle(String btitle , Pageable pageable);
    // * 페이징처리
    Page<BoardEntity> findByBtitle(String btitle , Pageable pageable);
    // + mysql 실제 SQL 작성하기 @Query
        // @Query(value = "SQL작성" , nativeQuery = true)
        //  nativeQuery = true 사용하면 실제 mysql 에서 사용하는 sql 표현을 사용
        //  nativeQuery = false 이면 실제 mysql 표현식이 아닌 jpql [ java + MYSQL ] 표현식 사용
        // SQL 안에서 매개변수를 표현할 때 : 매개변수명      // Dao에서는 ?
    // @Query(value = "select * from board" , nativeQuery = true) // == findAll
    // @Query(value = "select * from board where = :bno" , nativeQuery = true) // == findById
    //@Query(value = "select * from board where = :btitle" , nativeQuery = true) // == findByBtitle
    // @Query(value = "select * from board where bcontent = :keyword" , nativeQuery = true) // == findByContent
    // @Query(value = "select * from board where btitle like %:keyword%" , nativeQuery = true) // == 내용이 포함된(검색)
    // Qurey 문에서 true이면 전체검색 .
    @Query(value = "select * from board where" +
            " if ( :keyword = '' , true , " +
            " if( :key = 'btitle' , btitle like %:keyword% ," +
            " if( :key = 'bcontent' , bcontent like %:keyword% , true  ) ) )" +
            " order by cdate desc"
            , nativeQuery = true)
    Page<BoardEntity>  findBySearch( String key , String keyword , Pageable pageable);

}
