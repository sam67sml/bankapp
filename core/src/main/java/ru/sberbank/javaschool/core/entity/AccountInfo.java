package ru.sberbank.javaschool.core.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "ACCOUNT_INFO")
public class AccountInfo implements DomainObject {

    private static final long serialVersionUID = -601283564794268923L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "BALANCE")
    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "CURRENCY_ID", foreignKey = @ForeignKey(name = "ACCOUNT_INFO_CURRENCIES_ID_fk"))
    private Currency currency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AccountInfo that = (AccountInfo) o;

        if (!id.equals(that.id)) {
            return false;
        }
        if (!balance.equals(that.balance)) {
            return false;
        }
        return currency.equals(that.currency);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + balance.hashCode();
        result = 31 * result + currency.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "id=" + id +
                ", balance=" + balance +
                ", currency=" + currency +
                '}';
    }
}
