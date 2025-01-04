package com.kartik.service;

import com.kartik.entity.*;
import com.kartik.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final AddressRepository addressRepository;
    private final EmployeeRepository employeeRepository;
    private final ARepository aRepository;
    private final BRepository bRepository;
    private final CRepository cRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, AddressRepository addressRepository, EmployeeRepository employeeRepository, ARepository aRepository, BRepository bRepository, CRepository cRepository) {
        this.companyRepository = companyRepository;
        this.addressRepository = addressRepository;
        this.employeeRepository = employeeRepository;
        this.aRepository = aRepository;
        this.bRepository = bRepository;
        this.cRepository = cRepository;
    }

    @Override
    public ResponseEntity<Company> createCompany(Company company) {
        return new ResponseEntity<>(companyRepository.save(company), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Company> updateCompany(Long id, Company company) {
        try {
            Company newCompany = companyRepository.getById(id);
//            newCompany.setCompanyName(company.getCompanyName());
//            newCompany.setAddress(company.getAddress());
            newCompany.getEmployees().clear();
            newCompany.setEmployees(company.getEmployees());
            return new ResponseEntity<>(companyRepository.save(newCompany), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Address> deleteAddress(Long id) {
        try {

            Address address = addressRepository.getById(id);
            address.setCompany(null);
            addressRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Company> deleteCompany(Long id) {
        try {
            companyRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Employee> addEmp(Employee employee) {
        try {
            return new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Employee> updateEmp(Long id, Employee employee) {
        try {
            Employee employee1 = employeeRepository.getById(id);
            employee1.setName(employee.getName());
            return new ResponseEntity<>(employeeRepository.save(employee1), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @Override
//    public ResponseEntity<Address> addAddress(Address address) {
//        System.out.println("CommonServiceImpl.addAddress");
//        System.out.println(address.toString());
//        try {
//            return new ResponseEntity<>(addressRepository.save(address), HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @Override
    @Transactional
    public ResponseEntity<Address> addAddress(Address address) {
        System.out.println("CompanyServiceImpl.addAddress");

        addA();

        return ResponseEntity.ok(new Address());
    }

    private void addA() {
        A a = new A();
        a.setName("a");
        aRepository.save(a);
        addB();
    }

    private void addB() {
        B a = new B();
        a.setName("a");
        bRepository.save(a);
        addC();

    }

    private void addC() {
        throw new RuntimeException();
    }

    @Override
    @Cacheable(value = "company", key = "#id")
    public Company companyDetails(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<Employee> getEmp(Long id) {
        try {
            if (employeeRepository.findById(id).isPresent()) {
                return new ResponseEntity<>(employeeRepository.findById(id).get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Employee> deleteEmp(Long id) {
        try {
            employeeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
