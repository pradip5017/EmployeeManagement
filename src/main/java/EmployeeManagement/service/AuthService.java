package EmployeeManagement.service;

import EmployeeManagement.dto.LoginRequest;
import EmployeeManagement.dto.LoginResponse;
import EmployeeManagement.dto.RegisterRequest;

public interface AuthService {

    String register(RegisterRequest request);

    LoginResponse login(LoginRequest request);
}
