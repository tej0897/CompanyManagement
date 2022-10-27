package com.example.CompanyManagement.Repository;

import com.example.CompanyManagement.Model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface StockRepo extends JpaRepository<Stock, Integer> {
    @Query(value="select s from Stock s where s.companyIDfk = :companyIDfk")
    public int getAllStocks(int companyID);

    @Modifying
    @Query(value="delete from Stock where companyIDfk= :companyIDfk")
    public void deleteStock(int companyID);
}
