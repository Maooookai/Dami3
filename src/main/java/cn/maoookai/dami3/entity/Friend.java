package cn.maoookai.dami3.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "friends")
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "qq",nullable = false)
    private Long qq;

    @Column(name = "from_account")
    private Long fromAccount;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "nick")
    private String nick;

    @Column(name = "remark")
    private String remark;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Friend friend = (Friend) o;
        return id != null && Objects.equals(id, friend.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
