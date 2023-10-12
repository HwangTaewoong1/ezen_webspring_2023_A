package example.day04;


import lombok.*;

@Builder
@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {
    private int tno;         // 번호
    private String tcontent; // 내용물
    private boolean tstate;   // 상태
}
