package com.evolvice.employee.controller;

import com.evolvice.employee.entities.EmployeeListContainer;
import com.evolvice.employee.entities.WorkTogether;
import com.evolvice.employee.services.WorkWithService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WorkWithController {

    @Autowired
    private WorkWithService workWithService;

    @GetMapping("/workTogether")
    public String employeesPage() {
        return "workTogether";
    }

    @RequestMapping(value = "/workWith", method = RequestMethod.POST)
    public String saveUsers(@ModelAttribute("Employees") EmployeeListContainer employeeList, RedirectAttributes redirectAttributes) throws Exception {
        WorkTogether workTogether = workWithService.getLongestTime(employeeList.getEmployees());

        if (workTogether == null) {
            return "redirect:notResult";
        }

        redirectAttributes.addFlashAttribute("workTogether", workTogether);
        return "redirect:workTogether";
    }

    @GetMapping("/notResult")
    public String notResult() {
        return "notResult";
    }
}
