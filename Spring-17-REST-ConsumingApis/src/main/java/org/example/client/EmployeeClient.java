package org.example.client;
import org.example.dto.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "https://dummyapi.io", name = "EMPLOYEE-CLIENT")
public interface EmployeeClient {

    @GetMapping("/data/v1/user?limit=10")
    Employee getEmployee();

}