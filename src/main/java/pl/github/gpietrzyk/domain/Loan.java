package pl.github.gpietrzyk.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue
    private int loanId;
}
