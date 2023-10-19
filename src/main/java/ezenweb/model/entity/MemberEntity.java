package ezenweb.model.entity;

import example.day06.NoteDto;
import ezenweb.model.dto.MemberDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity // 해당 클래스를 db테이블과 매핑 [ 엔티티 클래스 <----> DB 테이블 ( 엔티티 1개 객체 <---> DB테이블 내 레코드 1개 )
@Table(name = "member") // db 테이블명 정의 [ 생략시 해당 클래스명이 곧 db테이블 명으로 자동 생성 ]
public class MemberEntity extends BaseTime {
    @Id // 해당 필드를 PK로 선정
    @GeneratedValue( strategy = GenerationType.IDENTITY ) // auto_increment
    private int mno;            // 1. 회원번호
    
    @Column(name = "memail" ,length = 50 ,nullable = false , unique = true ) // 해당 필드 선정 [ 속성 )
    // name = "필드명" ,  length = 글자수 , nullable = false -> not null ( null 불가 ) ,  unique = true 중복 불가 ]
    private String memail;      // 2. 이메일 [회원아이디 대체 ]

    @Column( length = 30 , nullable = false ) // 해당 필드 선정 [ 최대 30글자 , not null ]
    private String mpassword;   // 3. 비밀번호

    @Column( length = 20 , nullable = false ) // 해당 필드 선정 [ 최대 20글자 , not null ]
    private String mname;       // 4. 이름

    @Column( length = 13 , nullable = false , unique = true ) // 해당 필드 선정 [ 최대 13글자 , not null , unique = true ]
    private String mphone;      // 5. 연락처

    @Column// 해당 필드 선정
    @ColumnDefault("'user'") // ColumnDefault("'초기값'") -> default ( 기본값 ) * 문자일 경우 '' 문자처리 해야함 !
    private String mrole;       // 6. 회원등급( 일반회원 = user , 관리자 회원 = admin )

    // 게시물 목록 = 내가 쓴 게시물
    @Builder.Default  // 빌더 패턴 사용시 해당 필드에 값을 기본 값으로 사용
    // @OneToMany( mappedBy = "참조할 객체명 ")
    @OneToMany( mappedBy = "memberEntity")// 1. 하나가 다수에게 [ PK ] 실제 db영향x
    private List<BoardEntity> boardEntityList = new ArrayList<BoardEntity>();

    // private LocalDateTime bdate; // BaseTime 클래스로부터 상속받으면 자동..
    // private LocalDateTime udate; // BaseTime 클래스로부터 상속받으면 자동..
    // [ BaseTime 클래스가 상속해주는 필드 : 1. 회원가입일자 , 2. 회원정보수정일 ]

    // Entity --> Dto 변환 함수
        // service에서 entity정보를 controller로 이동하기 위해서
    public MemberDto toDto() {
       return MemberDto.builder()
               .mno(this.mno)
               .memail(this.memail)
               .mpassword(this.mpassword)
               .mname(this.mname)
               .mphone(this.mphone)
               .mrole(this.mrole)
               .cdate(this.getCdate())
               .udate(this.getUdate())
               .build();
    }
}
