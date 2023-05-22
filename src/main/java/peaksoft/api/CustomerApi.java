package peaksoft.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Customer;
import peaksoft.sevicies.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerApi {
    private final CustomerService customerService;

    @Autowired
    public CustomerApi(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{agencyId}")
    public String getAllCustomers(@PathVariable("agencyId") Long agencyId, Model model) {
        model.addAttribute("customers", customerService.getAllCustomers(agencyId));
        return "/customer/customerMainPage";
    }

    @GetMapping("/new/{agencyId}")
    public String create(@PathVariable("agencyId") Long agencyId, Model model) {
        model.addAttribute("agencyId", agencyId);
        model.addAttribute("newCustomer", new Customer());
        return "/customer/newCustomer";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("newCustomer") Customer customer, Long agencyId) {
        customerService.saveCustomer(agencyId, customer);
        return "redirect:/customers/" + agencyId;
    }
}
