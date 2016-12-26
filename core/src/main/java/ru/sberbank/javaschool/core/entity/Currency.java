package ru.sberbank.javaschool.core.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "CURRENCIES")
public class Currency implements DomainObject {

    private static final long serialVersionUID = 7647115129063645693L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CURRENCY_NAME")
    private String currencyName;

    @OneToMany(mappedBy = "currency")
    private Set<AccountInfo> accInfoSet = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Currency currency = (Currency) o;

        if (!id.equals(currency.id)) {
            return false;
        }
        return currencyName.equals(currency.currencyName);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + currencyName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", currencyName='" + currencyName + '\'' +
                '}';
    }

}
