package com.allstate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    private int id;
    private int version;
    private String userName;
    private double balance;
    private Date created;
    private Date modified;
    //private List<Transaction> transactions;

    public User() {
    }
    public User(String userName, double balance) {
        this.userName = userName;
        this.balance = balance;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Version
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }

    @Column(unique = true, nullable = false)
    @Size(min = 3)
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(nullable = false)
    @DecimalMin(value = "0")
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @CreationTimestamp
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }

    @UpdateTimestamp
    public Date getModified() {
        return modified;
    }
    public void setModified(Date modified) {
        this.modified = modified;
    }

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
//    @JsonIgnore
//    public List<Transaction> getTransactions() {
//        return transactions;
//    }
//    public void setTransactions(List<Transaction> transactions) {
//        this.transactions = transactions;
//    }
}