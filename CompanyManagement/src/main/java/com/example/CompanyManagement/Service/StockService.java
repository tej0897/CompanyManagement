package com.example.CompanyManagement.Service;

import com.example.CompanyManagement.Model.Stock;

public interface StockService {

    public int getAllStocks(int companyID);
    public boolean deleteStock(int companyID);
    public boolean addStock(Stock stock);
}
