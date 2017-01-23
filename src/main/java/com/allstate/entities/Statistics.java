package com.allstate.entities;

import com.allstate.enums.Result;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "statistics")
@Data
public class Statistics {
    private int id;
    private int version;
    private Result result;
    private double betAmount;
    private User user;
    private Date created;
    private Date modified;

    public Statistics() {
    }
    public Statistics(Result result, double betAmount, User user) {
        this.result = result;
        this.betAmount = betAmount;
        this.user = user;
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

    @Column(nullable = false, columnDefinition = "ENUM('WON', 'LOST')")
    @Enumerated(EnumType.STRING)
    public Result getResult() {
        return result;
    }
    public void setResult(Result result) {
        this.result = result;
    }

    @Column(nullable = false)
    @DecimalMin(value = "0")
    public double getBetAmount() {
        return betAmount;
    }
    public void setBetAmount(double betAmount) {
        this.betAmount = betAmount;
    }

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
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
}
