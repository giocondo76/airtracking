package com.nc.models;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "usr")
public class User {
        @Id
        @GeneratedValue(strategy=GenerationType.SEQUENCE)
        private Integer id;

        @Column(name="name", nullable=false)
        private String name;

        @Column(name="email", nullable=false)
        private String email;


        @Column(name="password")
        private String password;

        @ManyToOne (fetch=FetchType.LAZY,
                cascade=CascadeType.ALL)
        @JoinColumn (name="role")
        private Role role;

        @ManyToOne (fetch=FetchType.LAZY,
                cascade=CascadeType.ALL)
        @JoinColumn (name="location")
        private Location location;

        public User() {
        }

        public User(Integer id, String name, String email, String password, Role role, Location location) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.password = password;
            this.role = role;
            this.location = location;
        }

    public <T> User(String username, String password, List<T> ts) {
    }

    public Integer getId() {
                    return id;
                }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }


        public Role getRole() {
            return role;
        }

        public void setRole(Role role) {
            this.role = role;
    }

    public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", location=" + location +
                '}';
    }
}
