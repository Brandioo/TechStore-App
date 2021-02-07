package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "computers")
@Data
public class Computers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "computerID")
    private Integer computerID;
    private String computerName;
    private String ComputerType;
    private String isbn;
    private LocalDateTime dateOfPublication;
    private String supplier;
    private Integer quantity;
    private Integer price;
    private String createdBy;
    private LocalDateTime createdOn;
    private String modifiedBy;

    @OneToMany(mappedBy = "computers")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<CartelRecord> cartelRecords = new HashSet<>();

    public Computers(String bookName, String genere, String isbn, String supplier, Integer quantity, Integer price, LocalDateTime createdOn) {
        this.computerName = bookName;
        this.ComputerType = genere;
        this.isbn = isbn;
        this.supplier = supplier;
        this.quantity = quantity;
        this.price = price;
        this.createdOn = createdOn;
    }



    public Computers() {

    }
}
