package example.팀과제.연관관계설계;


import ezenweb.model.entity.MemberEntity;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "orderEntity")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ono;
    private int oamount;

    @ToString.Exclude // toString() 함수에 제외하는 필드
    @JoinColumn( name = "pno_fk" ) // FK 필드로 사용하는 어노테이션 ( name = "FK필드명" )
    @ManyToOne // 다수가 하나에게 [ Fk ]
    private ProductEntity productEntity;
}
