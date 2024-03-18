//package com.invman.inventory.controller.old;
//
//import com.invman.inventory.model.hr.Employee;
//import com.invman.inventory.model.hr.Provider;
//import com.invman.inventory.model.hr.Seller;
//import com.invman.inventory.service.old.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/employees")
//public class EmployeeController {
//
//    @Autowired
//    EmployeeService employeeService;
//
//    @GetMapping
//    public ResponseEntity<?> listAllEmployees() {
//        return new ResponseEntity<>(employeeService.listAllEmployees(), HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
//        if (employee instanceof Seller) {
//            return new ResponseEntity<>(employeeService.createSeller((Seller) employee), HttpStatus.CREATED);
//        } else if (employee instanceof Provider) {
//            return new ResponseEntity<>(employeeService.createProvider((Provider) employee), HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
//        if (employee instanceof Seller) {
//            return new ResponseEntity<>(employeeService.updateSeller((Seller) employee, id), HttpStatus.OK);
//        } else if (employee instanceof Provider) {
//            return new ResponseEntity<>(employeeService.updateProvider((Provider) employee, id), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//}