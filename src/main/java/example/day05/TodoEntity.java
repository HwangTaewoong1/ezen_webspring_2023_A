package example.day05;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // JPA(ORM매핑) MYSQL 테이블과 매핑
@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoEntity {

    @Id // pk로 선정할 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private int tno;
    private String tcontent;
    private String tphone;
}

/*
    create table todo(
        tno int auto_increment primary key ,
        tcontent varchar(100) ,
        tstate boolean
    );
*/
