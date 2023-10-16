package example.day06;

import lombok.*;

import java.time.LocalDateTime;

// Dto 사용처 :
    // AJAX(json/text/form) --> DTO --> Controller
@NoArgsConstructor @AllArgsConstructor
@Getter@Setter@ToString@Builder
public class NoteDto {
    private int no; // 게시물번호
    private String title; // 게시물 내용
    private String writer; // 작성자
    private String password; // 패스워드
    private LocalDateTime date; // 작성일자
    // + DB 없지만 추가적으로 필요한 코드

    // * dto를 엔티티로 변환해주는 함수 [service에서 사용]
    public NoteEntity toEntity() {
        return NoteEntity.builder()
                    .date(this.date)
                    .title(this.title)
                    .no(this.no)
                    .password(this.password)
                    .writer(this.writer)
                    .build();
    }

}
