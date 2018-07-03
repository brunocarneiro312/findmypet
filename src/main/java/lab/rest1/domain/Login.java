package lab.rest1.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TB_LOGIN")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "login_generator")
    @SequenceGenerator(name = "login_generator", sequenceName = "SQ_LOGIN")
    @Column(name = "ID")
    private Long loginId;

    @Column(name = "USERNAME", unique = true, nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "login")
    private User user;

    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
