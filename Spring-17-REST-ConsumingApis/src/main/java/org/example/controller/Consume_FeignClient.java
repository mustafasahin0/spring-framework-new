package org.example.controller;

import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.example.client.EmployeeClient;
import org.example.client.UserClient;
import org.example.dto.ResponseWrapper;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Consume_FeignClient {

    private final UserClient userClient;
    private final EmployeeClient employeeClient;

    public Consume_FeignClient(UserClient userClient, EmployeeClient employeeClient) {
        this.userClient = userClient;
        this.employeeClient = employeeClient;
    }

    @GetMapping("/api/v1/users")
    public ResponseEntity<ResponseWrapper> getUsers() {

        return ResponseEntity.ok(new ResponseWrapper("UserList Retrieved", userClient.getUsers()));
    }

    @GetMapping("/api/v1/employee")
    public ResponseEntity<ResponseWrapper> getEmployee() {

        return ResponseEntity.ok(new ResponseWrapper("Successful", employeeClient.getEmployee("6581035d76db2e63dfd8ba0a")));
    }

}
