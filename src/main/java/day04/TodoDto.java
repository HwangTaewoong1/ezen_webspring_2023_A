package day04;


import lombok.*;

@Builder
@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {
    private int tno;
    private String tcontent;
    private String tstate;
}
