package com.example.CompanyManagement.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Stock {

    @Id
    private int stockID;
    int stockPrice;
    String sCompanyName;
    private int companyIDfk;

    public int getStockID() {
        return stockID;
    }

    public void setStockID(int stockID) {
        this.stockID = stockID;
    }

    public int getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(int stockPrice) {
        this.stockPrice = stockPrice;
    }

    public String getsCompanyName() {
        return sCompanyName;
    }

    public void setsCompanyName(String sCompanyName) {
        this.sCompanyName = sCompanyName;
    }

    public int getCompanyIDfk() {
        return companyIDfk;
    }

    public void setCompanyIDfk(int companyIDfk) {
        this.companyIDfk = companyIDfk;
    }

    public Stock(int stockID, int stockPrice, String sCompanyName, int companyIDfk) {
        this.stockID = stockID;
        this.stockPrice = stockPrice;
        this.sCompanyName = sCompanyName;
        this.companyIDfk = companyIDfk;
    }

    public Stock() {
    }
}
