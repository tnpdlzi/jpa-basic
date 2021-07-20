package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

// 관례에 따라 Member 테이블에 들어감.
// @Table(name = "USER") 하면 유저 테이블로 들어감. 기본으로는 클래스 이름과 동일하게 들어간다.
@Entity // JPA가 관리하는 객체이다.
public class Member {
//
//    @Id // PK가 뭔지 알려준다.
//    private Long id;
//
////    @Column(name = "username") 이거 하면 username 컬럼으로 들어감.
//    private String name;

//    // 기본 키 매핑
//    @Id // pk 매핑
//    private Long id;
//
//    @Column(name = "name", nullable = false) // 객체는 username인데 디비에는 name일 때. nullable을 false로 하면 not null이 걸린다.
//    private String username;
//
//    private Integer age; // 제일 적합한거 알아서 찾아서 맞춰줌.
//
//    // enum타입을 쓸 때. 디비에는 이넘 타입이 없다. 기본이 ORDINAL로 되어있다. 근데 그렇게 쓰지 말자. STRING 쓰자. 오디널은 순서를 디비에 저장하고 STRING은 이름을 저장하게 된다.
//    // 추가 사항이 늘었을 때 ORDINAL로 하면 순서가 바껴서 힘들어버린다. 그렇기 때문에 STRING 필수.
//    @Enumerated(EnumType.STRING)
//    private RoleType roleType;
//
//    // @Temporal은 LocalDate랑 LocalDateTime이 있기 떄문에 생략 가능한 부분이다.
//
//    // 날짜 타입. date, time, timestamp의 3가지 타입이 있다. 디비는 이걸 구분하기 때문에 매핑정보를 줘야함.
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//
//    // 하이버네이트는 알아서 date, timestamp로 들어가게 된다.
//    private LocalDate testLocalDate;
//    private LocalDateTime testLocalDateTime;
//
//    // 데이터베이스에 varchar를 넘어서는 걸 넣고 싶을 때. Lob. 여기서는 String이라 CLOB이 된다.
//    @Lob // Lob은 지정할 수 있는 속성이 없다. 문자면 CLOB, 나머지는 BLOB으로 매핑이 된다.
//    private String description;
//
//    //디비랑 상관 없이 하고 싶을때. 매핑하지 않는다.
//    @Transient
//    private int temp;

    // 기본 키 매핑
    @Id // pk 매핑
    @GeneratedValue(strategy = GenerationType.AUTO) // 기본 값은 AUTO. 셋 중에 하나가 알아서 선택됨.
//    @GeneratedValue(strategy = GenerationType.IDENTITY) //mysql의 auto auto increament이다. null로 넣으면 알아서 만들어준다. 문제는 ID 값을 넣지를 않아서 ID값을 알려면 DB에 값이 들어가봐야 알 수 있다. 영속성 컨텍스트에서 관리되려면 pk값이 있어야 한다.
    // 그럼 어떤 제약이 생기냐? @Id가 있어야 한다. JPA입장에선 pk가 없어서 값을 넣을 방법이 없다. 그래서 이 IDENTITY 전략에서만 em.persist를 호출하자마자 바로 디비에 insert query를 날려버린다. commit 시점이 아닌.
    // 그럼 값이 들어가게 되고 JPA가 이 값을 가져오게 된다. 버퍼링을 못 한다는 점이 근데 큰 차이가 있지 않기 때문에 그냥 이렇게 쓰면 된다.
//    @GeneratedValue(strategy = GenerationType.SEQUENCE) // sequence 오브젝트를 만들어낸다. 디비의 시퀀스 오브젝트를 통해 값을 제너레이트한다. 시퀀스에서 값을 가져와 값을 증가시켜서 넣는다.
    // 시퀀스를 테이블 별로 하고 싶으면 SequenceGenerator를 사용하면 된다. 시퀀스는 em.persist에서 call next value for MEMBER_SEQ를 한다. id값을 받아와서 증가시켜서 넣는 것. 그래서 버퍼링이 되는 방식.
    // allocationSize를 통해 성능 개선 가능. call next하면 계속 네트워크를 타야하니까 이 Size만큼 미리 불러 놓는거다. 메모리에서 1씩 쓰고 다 쓰면 next call 한 번 쓰는 방식. 메모리에 올려놓고 쓰는 방식.
//    @GeneratedValue(strategy = GenerationType.TABLE) // 키 생성 전용 테이블을 하나 만들게 된다. 데이터베이스 시퀀스를 흉내내는 것. 모든 데이터베이스에서 사용할 수 있으나 성능이 안 좋다. TableGenerator를 만들어서 사용.
    private Long id;

    @Column(name = "name")
    private String username;


    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
