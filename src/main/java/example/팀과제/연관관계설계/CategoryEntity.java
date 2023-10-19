package example.팀과제.연관관계설계;

import ezenweb.model.entity.BoardEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int cno;
    private String cname;

    // 게시물 목록 = 내가 쓴 게시물
    @Builder.Default  // 빌더 패턴 사용시 해당 필드에 값을 기본 값으로 사용
    // @OneToMany( mappedBy = "참조할 객체명 ")
    @OneToMany( mappedBy = "categoryEntity")// 1. 하나가 다수에게 [ PK ] 실제 db영향x
    private List<ProductEntity> productEntityList = new ArrayList<ProductEntity>();
}
