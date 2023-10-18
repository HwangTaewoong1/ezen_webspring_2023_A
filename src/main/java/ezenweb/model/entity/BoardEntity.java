package ezenweb.model.entity;

import ezenweb.model.dto.BoardDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;


// ------------------------- 1. 엔티티를 이용한 테이블을 생성할 때 -------------------------------
@Entity // 해당 클래스를 엔티티로 사용
@Builder@AllArgsConstructor@NoArgsConstructor@ToString@Setter@Getter
@Table( name = "board" ) // 테이블명 설정
@DynamicInsert // @ColumnDefault가 적용될 수 있도록 해주는 어노테이션
public class BoardEntity extends BaseTime{ // 테이블 설계
    // 필드 설계
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY ) // my sql : auto_increment
    @Column
    private int bno;
    @Column( name = "btitle" , length = 200 , nullable = false ) // 생략가능 [ 필드 속성을 커스텀하기 위해서 작성 ]
    private String btitle;
    @Column( columnDefinition = "longtext" , nullable = true) // db에서 longtext 사용하는데 , java 문자열 처리가 String[최대 255] 밖에 없네..
    private String bcontent;
    @Column
    @ColumnDefault("0") // "'문자처리'" vs "숫자
    private int bview;
    // private LocalDateTime bdate; // BaseTime 클래스로부터 상속받으면 자동..
    // private LocalDateTime udate; // BaseTime 클래스로부터 상속받으면 자동..
    // [ BaseTime 클래스가 상속해주는 필드 : 1. 작성일 , 2. 수정일 ]
    @Column( columnDefinition = "longtext" , nullable = true )
    private String bfile;
    @Column
    private int mno;


    // entity -> dto [ 상황에 따라 여러개 선언 ]
    // 1. [ 전체 => 게시판 출력 페이지 ] 출력 할때.
    public BoardDto alltoDto() {
        return BoardDto.builder()
                .bno( this.bno )
                .btitle( this.btitle )
                .bcontent( this.bcontent )
                .bfile( this.bfile )
                .bview( this.bview )
                .mno( this.mno )
                .cdate( this.getCdate() )
                .udate( this.getUdate() )
                .build();
    }
    // 2. [ 개별 => 게시판 개별 페이지 ] 출력 할 때.
    public BoardDto idtoDto() {
        return BoardDto.builder()
                .bno( this.bno )
                .btitle( this.btitle )
                .bcontent( this.bcontent )
                .bfile( this.bfile )
                .bview( this.bview )
                .mno( this.mno )
                .cdate( this.getCdate() )
                .udate( this.getUdate() )
                .build();
    }
}

/*
------------------------- 2. 직접 DDL 작성해서  테이블을 생성할 때 -------------------------------
    Create table board (
        bno int auto_increment,
        btitle varchar(255) ,
        bcontent longtext,
        bview int ,
        cdate datetime default now() ,
        udate datetime default now() ,
        bfile longtext
        mno Integer
        primary key ( bno )
    );

 */