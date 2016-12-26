package ru.sberbank.javaschool.core.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity(name = "LOANS")
public class Loan implements DomainObject {

    private static final long serialVersionUID = 7850686165777433673L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "PAID")
    private BigDecimal paid;

    @Column(name = "LOAN_DATE")
    private Timestamp loanDate;

    @Column(name = "ANNUAL_INTEREST")
    private Double annualInterest;

    @Column(name = "LOAN_EXPIRATION_DATE")
    private Timestamp loanExpirationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPaid() {
        return paid;
    }

    public void setPaid(BigDecimal paid) {
        this.paid = paid;
    }

    public Timestamp getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Timestamp loanDate) {
        this.loanDate = loanDate;
    }

    public Double getAnnualInterest() {
        return annualInterest;
    }

    public void setAnnualInterest(Double annualInterest) {
        this.annualInterest = annualInterest;
    }

    public Timestamp getLoanExpirationDate() {
        return loanExpirationDate;
    }

    public void setLoanExpirationDate(Timestamp loanExpirationDate) {
        this.loanExpirationDate = loanExpirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Loan loan = (Loan) o;

        if (!id.equals(loan.id)) {
            return false;
        }
        if (!amount.equals(loan.amount)) {
            return false;
        }
        if (paid != null ? !paid.equals(loan.paid) : loan.paid != null) {
            return false;
        }
        if (!loanDate.equals(loan.loanDate)) {
            return false;
        }
        if (!annualInterest.equals(loan.annualInterest)) {
            return false;
        }
        return loanExpirationDate.equals(loan.loanExpirationDate);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + amount.hashCode();
        result = 31 * result + (paid != null ? paid.hashCode() : 0);
        result = 31 * result + loanDate.hashCode();
        result = 31 * result + annualInterest.hashCode();
        result = 31 * result + loanExpirationDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", amount=" + amount +
                ", paid=" + paid +
                ", loanDate=" + loanDate +
                ", annualInterest=" + annualInterest +
                ", loanExpirationDate=" + loanExpirationDate +
                '}';
    }
}
