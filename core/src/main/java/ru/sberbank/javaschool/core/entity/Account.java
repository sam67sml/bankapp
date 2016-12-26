package ru.sberbank.javaschool.core.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "ACCOUNTS")
public class Account implements DomainObject {

    private static final long serialVersionUID = 6834183497400604368L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "ACCOUNTS_CUSTOMERS_ID_fk"))
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "ACC_INFO_ID", foreignKey = @ForeignKey(name = "ACCOUNTS_ACCOUNT_INFO_ID_fk"))
    private AccountInfo accountInfo;

    @Column(name = "REGISTER_DATE")
    private java.sql.Timestamp registerDate;

    @Column(name = "LAST_LOGIN_DATE")
    private java.sql.Timestamp lastLoginDate;

    @Column(name = "ACC_NUMBER")
    private Long accNumber;

    @OneToMany(mappedBy = "account")
    private Set<Card> cards = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    public java.sql.Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(java.sql.Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    public java.sql.Timestamp getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(java.sql.Timestamp lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Long getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(Long accNumber) {
        this.accNumber = accNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        if (!id.equals(account.id)) {
            return false;
        }
        if (!customer.equals(account.customer)) {
            return false;
        }
        if (!accountInfo.equals(account.accountInfo)) {
            return false;
        }
        if (!registerDate.equals(account.registerDate)) {
            return false;
        }
        if (lastLoginDate != null ? !lastLoginDate.equals(account.lastLoginDate) : account.lastLoginDate != null) {
            return false;
        }
        return accNumber.equals(account.accNumber);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + customer.hashCode();
        result = 31 * result + accountInfo.hashCode();
        result = 31 * result + registerDate.hashCode();
        result = 31 * result + (lastLoginDate != null ? lastLoginDate.hashCode() : 0);
        result = 31 * result + accNumber.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", customer=" + customer +
                ", accountInfo=" + accountInfo +
                ", registerDate=" + registerDate +
                ", lastLoginDate=" + lastLoginDate +
                ", accNumber=" + accNumber +
                '}';
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }
}
