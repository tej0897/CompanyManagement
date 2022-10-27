package com.example.CompanyManagement.Service;

import com.example.CompanyManagement.Exceptions.CompanyAlreadyExistsException;
import com.example.CompanyManagement.Model.Company;
import com.example.CompanyManagement.Repository.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private CompanyRepo companyRepo;

    @Override
    public List<Company> getAllCompany() {
        return companyRepo.findAll();
    }

    @Override
    public Company addCompany(Company company) throws CompanyAlreadyExistsException {
        Optional <Company> optionalCompany = companyRepo.findById(company.getCompanyID());
        if (optionalCompany.isPresent()){
            throw new CompanyAlreadyExistsException();
        }
        companyRepo.saveAndFlush(company);
        return company;
    }

    @Override
    public boolean deleteCompany(int companyID) {
        companyRepo.deleteById(companyID);
        return true;
    }

    @Override
    public boolean updateCompany(Company company) {
        Company company1 = companyRepo.getById(company.getCompanyID());
        company1.setCompanyID(company.getCompanyID());
        company1.setCompanyName(company.getCompanyName());
        company1.setStockPrice(company.getStockPrice());
        company1.setNoOfStocks(company.getNoOfStocks());
        companyRepo.saveAndFlush(company1);
        return true;
    }

    @Override
    public Company getCompanyByID(int companyID) {
        Optional <Company> company = companyRepo.findById(companyID);
        if (company.isPresent()){
            return company.get();
        }
        return null;
    }
}
