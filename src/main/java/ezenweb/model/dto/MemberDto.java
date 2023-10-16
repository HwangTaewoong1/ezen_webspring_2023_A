package ezenweb.model.dto;

import example.day06.NoteEntity;
import ezenweb.model.entity.MemberEntity;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString @Builder
public class MemberDto {

    private int mno;            // 1. 회원번호
    private String memail;      // 2. 이메일 [회원아이디 대체 ]
    private String mpassword;   // 3. 비밀번호
    private String mname;       // 4. 이름
    private String mphone;      // 5. 연락처
    private String mrole;       // 6. 회원등급

    // + baseTime
    private LocalDateTime cdate;
    private LocalDateTime udate;

    // Dto -> Entity 변환 함수
        // service에서 dto정보를 DB 테이블 매핑에 저장하기 위해서
    public MemberEntity toEntity() {
        return MemberEntity.builder()
                .mno(this.mno)
                .memail(this.memail)
                .mpassword(this.mpassword)
                .mname(this.mname)
                .mphone(this.mphone)
                .mrole(this.mrole)
                .build();
    }

}
