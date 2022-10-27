package com.example.CompanyManagement.Controller;

import com.example.CompanyManagement.Model.Company;
import com.example.CompanyManagement.Model.Stock;
import com.example.CompanyManagement.Service.CompanyService;
import com.example.CompanyManagement.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/stocks")
public class StockController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private StockService stockService;

    @PostMapping("/add/{companyID}")
    public ResponseEntity<?> addStock(@PathVariable("companyID") int companyID, @RequestBody Stock stock){
        Company existCompany = companyService.getCompanyByID(companyID);
        if (existCompany!=null){
            existCompany.setStockPrice(stock.getStockPrice());
            stock.setStockID(stock.getStockID());
            stock.setCompanyIDfk(stock.getCompanyIDfk());

            if (companyService.updateCompany(existCompany) && stockService.addStock(stock)){
                return new ResponseEntity<>(stock, HttpStatus.CREATED);
            }
            return new ResponseEntity<>("Added", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Cannot be added", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/getAllReaders")
    public ResponseEntity<?> getAllStocks(@RequestParam("companyID") int companyID){
        int stocks = stockService.getAllStocks(companyID);
        if (stocks > 0){
            return new ResponseEntity<>(stocks, HttpStatus.OK);
        }
        return new ResponseEntity<>("No Stocks", HttpStatus.NO_CONTENT);

    }

}
