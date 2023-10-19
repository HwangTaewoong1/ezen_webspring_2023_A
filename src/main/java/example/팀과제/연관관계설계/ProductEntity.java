package example.팀과제.연관관계설계;

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
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pno;
    private String pname;

    @Builder.Default
    @OneToMany( mappedBy = "productEntity")
    private List<OrderEntity> orderEntityList = new ArrayList<OrderEntity>();

    @ToString.Exclude // toString() 함수에 제외하는 필드
    @JoinColumn( name = "cno_fk" ) // FK 필드로 사용하는 어노테이션 ( name = "FK필드명" )
    @ManyToOne // 다수가 하나에게 [ Fk ]
    private CategoryEntity categoryEntity;

}
