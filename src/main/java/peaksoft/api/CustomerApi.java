package peaksoft.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @GetMapping
    public String getAllCustomers(Model model){
        model.addAttribute("customers",customerService.getAllCustomers());
        return "/customer/customerMainPage";
    }
    @GetMapping("/new")
    public String create(Model model){
        model.addAttribute("newCustomer",new Customer());
        return "/customer/newCustomer";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("newCustomer") Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }
}
