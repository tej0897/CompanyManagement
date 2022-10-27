package com.example.CompanyManagement.Controller;


import com.example.CompanyManagement.Exceptions.CompanyAlreadyExistsException;
import com.example.CompanyManagement.Model.Company;
import com.example.CompanyManagement.ResponseHandler.MyResponse;
import com.example.CompanyManagement.Service.CompanyServiceImpl;
import com.example.CompanyManagement.Service.StockServiceImpl;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CompanyController {

    @Autowired
    private CompanyServiceImpl companyService;

    @Autowired
    private StockServiceImpl stockService;

    @GetMapping("/getAllCompanies")
    public ResponseEntity<?> getAllCompanies(){
        List<Company> companies = companyService.getAllCompany();
        if (companies!=null){
//            for (Company company : companies){
//                int stockSet =stockService.getAllStocks(company.getCompanyID());
//                company.setStockPrice(stockSet);
//            }
            return new ResponseEntity<>(companies, HttpStatus.OK);
        }
        return MyResponse.generateCustomResponseFormat("Could not retrieve data", HttpStatus.CONFLICT,null);
    }

    @PostMapping("/addCompany")
    public ResponseEntity<?> addCompany(@RequestBody Company company) throws CompanyAlreadyExistsException
    {
        if (companyService.addCompany(company)!=null){
            return new ResponseEntity<>(company, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Conflict while adding", HttpStatus.CONFLICT);
    }

    @Hidden
    @DeleteMapping("/deleteCompany/{companyID}")
    public ResponseEntity<?> deleteCompany(@PathVariable("companyID") int companyID){
        if (companyService.deleteCompany(companyID)){   //stockService.deleteStock(companyID) &&
            return new ResponseEntity<>("Record Deleted", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("record cannot be deleted", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/updateCompany")
    public ResponseEntity<?> updateCompany(@RequestBody Company company){
        if (companyService.updateCompany(company)){
            return new ResponseEntity<>(company, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("cannot be updated", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/getCompanyID/{id}")
    public ResponseEntity<?> getCompanyByID(@PathVariable("companyID") int companyID){
        Company company = companyService.getCompanyByID(companyID);
        if (company!=null){
            return new ResponseEntity<Company>(company, HttpStatus.OK);
        }
        return new ResponseEntity<>("Cannot be fetched", HttpStatus.NO_CONTENT);
    }


}
