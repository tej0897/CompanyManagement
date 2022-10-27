package com.example.CompanyManagement.Service;

import com.example.CompanyManagement.Model.Stock;
import com.example.CompanyManagement.Repository.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService{

    @Autowired
    private StockRepo stockRepo;

    @Override
    public int getAllStocks(int companyID) {
        return stockRepo.getAllStocks(companyID);
    }

    @Override
    public boolean deleteStock(int companyID) {
        stockRepo.deleteStock(companyID);
        return true;
    }

    @Override
    public boolean addStock(Stock stock) {
        Stock stock1 = new Stock();
        stock1.setStockID(stock.getStockID());
        stock1.setStockPrice(stock.getStockPrice());
        stock1.setCompanyIDfk(stock.getCompanyIDfk());
        stock1.setsCompanyName(stock.getsCompanyName());
        stockRepo.saveAndFlush(stock1);
        return true;
    }
}
