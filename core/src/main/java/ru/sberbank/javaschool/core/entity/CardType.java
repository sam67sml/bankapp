package ru.sberbank.javaschool.core.entity;

import javax.persistence.*;

@Entity(name = "CARD_TYPES")
public class CardType implements DomainObject {

    private static final long serialVersionUID = 5631421919831040805L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TYPE_NAME")
    private String typeName;

    @ManyToOne
    @JoinColumn(name = "LOAN_ID", foreignKey = @ForeignKey(name = "CARD_TYPES_LOANS_ID_fk"))
    private Loan loan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }


    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CardType cardType = (CardType) o;

        if (!id.equals(cardType.id)) {
            return false;
        }
        if (!typeName.equals(cardType.typeName)) {
            return false;
        }
        return loan != null ? loan.equals(cardType.loan) : cardType.loan == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + typeName.hashCode();
        result = 31 * result + (loan != null ? loan.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CardType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", loan=" + loan +
                '}';
    }
}
