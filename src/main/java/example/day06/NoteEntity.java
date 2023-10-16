package example.day06;
/*
    DDL : 테이블 생성 , 테이블 수정 , 테이블 삭제
        JSP프로젝트 : MYSQL 워크벤치 작성.
        SPRING DATA JPA : SQL 작성할 필요가 없다. 엔티티클래스가 곧 테이블 생성
 */

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity // 해당 클래스가 엔티티 임을 주입 [ 실제 테이블 매핑 / 연결 ]
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class NoteEntity {
    @Id // no필드를 pk필드로 선정 // @GeneratedValue ( strategy = GenerationType.IDENTITY) : auto_increment
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int no; // 게시물번호

    private String title; // 게시물 내용

    private String writer; // 작성자

    private String password; // 패스워드

    private LocalDateTime date; // 작성일자


    // * 엔티티를 dto로 변환해주는 함수
    public NoteDto toDto() {
        return new NoteDto( this.no,
                    this.title, this.writer,
                    this.password, this.date );
    }

}
