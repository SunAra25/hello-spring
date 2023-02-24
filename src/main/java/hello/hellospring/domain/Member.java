package hello.hellospring.domain;

import javax.persistence.*;

@Entity
public class Member {
    //실제 테이블과 mapping
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 만약 컬럼 이름이 username이라면 아래처럼 mapping!
    //@Column(name = "username")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
