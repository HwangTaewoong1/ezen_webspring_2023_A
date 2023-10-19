package example.객체연관관계;

import lombok.*;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
@ToString @Builder
public class 게시물 {
    private int 게시물번호;
    private String 게시물제목;
    private String 게시물내용;
    // 게시물은 1명의 회원 작성 하므로 리스트가 아닌 객체 필드
    @ToString.Exclude // 해당 필드는 ToString 제외. 주로 참조객체 FK에 걸어주는걸 권장
    private 회원 작성한회원; // 회원객체의 주소값을 가지는 필드 [ 참조필드 FK ]
}
