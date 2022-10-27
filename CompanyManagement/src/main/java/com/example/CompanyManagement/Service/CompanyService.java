package com.example.CompanyManagement.Service;

import com.example.CompanyManagement.Exceptions.CompanyAlreadyExistsException;
import com.example.CompanyManagement.Model.Company;

import java.util.List;

public interface CompanyService {

    public List<Company> getAllCompany();
    public Company addCompany(Company company) throws CompanyAlreadyExistsException;
    public boolean deleteCompany(int companyID);
    public boolean updateCompany(Company company);
    public Company getCompanyByID(int companyID);

}
