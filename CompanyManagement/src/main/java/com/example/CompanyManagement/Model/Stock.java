package com.example.CompanyManagement.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Stock {

    @Id
    @GeneratedValue
    private int stockID;
    int stockPrice;
    private int companyIDfk;

    public int getCompanyIDfk() {
        return companyIDfk;
    }

    public void setCompanyIDfk(int companyIDfk) {
        this.companyIDfk = companyIDfk;
    }

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

    public Stock(int stockID, int stockPrice, int companyIDfk) {
        this.stockID = stockID;
        this.stockPrice = stockPrice;
        this.companyIDfk = companyIDfk;
    }

    public Stock() {
    }

}
