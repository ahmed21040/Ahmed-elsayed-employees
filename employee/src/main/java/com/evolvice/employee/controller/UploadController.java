package com.evolvice.employee.controller;

import com.evolvice.employee.entities.Employee;
import com.evolvice.employee.entities.EmployeeListContainer;
import com.evolvice.employee.services.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload")
    public String singleFileUpload(Model model, @RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) throws IOException {

        List<Employee> employees = uploadService.extractFileContent(file);

        redirectAttributes.addFlashAttribute("Employees", EmployeeListContainer.builder().employees(employees).build());
        return "redirect:employees";
    }

    @GetMapping("/employees")
    public String employeesPage() {
        return "employees";
    }
}
