package ru.sberbank.javaschool.core.entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity(name = "ROLES")
public class Role implements DomainObject {

    private static final long serialVersionUID = -4450723432307475791L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ROLE_NAME")
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private transient List<Customer> customers = new LinkedList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Role role = (Role) o;

        if (!id.equals(role.id)) {
            return false;
        }
        if (!roleName.equals(role.roleName)) {
            return false;
        }
        return customers != null ? customers.equals(role.customers) : role.customers == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + roleName.hashCode();
        result = 31 * result + (customers != null ? customers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", customers=" + customers +
                '}';
    }
}
