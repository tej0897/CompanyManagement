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
    private double noOfStocks;

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

    public double getNoOfStocks() {
        return noOfStocks;
    }

    public void setNoOfStocks(double noOfStocks) {
        this.noOfStocks = noOfStocks;
    }

    public Company(int companyID, String companyName, double stockPrice, double noOfStocks) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.stockPrice = stockPrice;
        this.noOfStocks = noOfStocks;
    }

    public Company() {
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyID=" + companyID +
                ", companyName='" + companyName + '\'' +
                ", stockPrice=" + stockPrice +
                ", noOfStocks=" + noOfStocks +
                '}';
    }
}
