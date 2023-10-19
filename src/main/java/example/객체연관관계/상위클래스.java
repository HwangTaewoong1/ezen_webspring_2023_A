package example.객체연관관계;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class 상위클래스 {
    private String data;
    @Builder.Default // 빌더 패턴시 기본값(new ArrayList<>();)
    private List<하위클래스> 참조하위객체들 = new ArrayList<>();
}
