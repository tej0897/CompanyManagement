package com.example.CompanyManagement.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Company {
    @Id
    private int companyID;
    private String companyName;
    private double stockPrice;
    private String location;

    @JsonIgnore
    @OneToMany(targetEntity = Stock.class)
    private Set<Stock> stockSet;

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyID=" + companyID +
                ", companyName='" + companyName + '\'' +
                ", stockPrice=" + stockPrice +
                ", location='" + location + '\'' +
                '}';
    }

    public Company(int companyID, String companyName, double stockPrice, String location) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.stockPrice = stockPrice;
        this.location = location;
    }

    public Company() {
    }
}
