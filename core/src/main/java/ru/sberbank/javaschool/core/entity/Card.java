package ru.sberbank.javaschool.core.entity;


import javax.persistence.*;

@Entity(name = "CARDS")
public class Card implements DomainObject {

    private static final long serialVersionUID = 2177161725605206333L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NUMBER", length = 16)
    private String number;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = CardType.class)
    @PrimaryKeyJoinColumn(referencedColumnName = "ID")
    private CardType cardType;

    @Column(name = "EXPIRATION_DATE")
    private java.sql.Timestamp expirationDate;

    @Column(name = "SECURE_CODE")
    private String secureCode;

    @Column(name = "IS_BLOCK")
    private boolean isBlock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID", foreignKey = @ForeignKey(name = "CARDS_ACCOUNTS_ID_fk"))
    private Account account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public java.sql.Timestamp getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(java.sql.Timestamp expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getSecureCode() {
        return secureCode;
    }

    public void setSecureCode(String secureCode) {
        this.secureCode = secureCode;
    }

    public boolean getIsBlock() {
        return isBlock;
    }

    public void setIsBlock(boolean isBlock) {
        this.isBlock = isBlock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Card card = (Card) o;

        if (isBlock != card.isBlock) {
            return false;
        }
        if (!id.equals(card.id)) {
            return false;
        }
        if (!number.equals(card.number)) {
            return false;
        }
        if (!cardType.equals(card.cardType)) {
            return false;
        }
        if (!expirationDate.equals(card.expirationDate)) {
            return false;
        }
        return secureCode.equals(card.secureCode);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + number.hashCode();
        result = 31 * result + cardType.hashCode();
        result = 31 * result + expirationDate.hashCode();
        result = 31 * result + secureCode.hashCode();
        result = 31 * result + (isBlock ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", cardType=" + cardType +
                ", expirationDate=" + expirationDate +
                ", secureCode='" + secureCode + '\'' +
                ", isBlock=" + isBlock +
                '}';
    }
}
