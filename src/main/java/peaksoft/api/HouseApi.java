package peaksoft.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.House;
import peaksoft.exception.MyException;
import peaksoft.sevicies.HouseService;

@Controller
@RequestMapping("/houses/{agencyId}")
public class HouseApi {
    private final HouseService houseService;
    @Autowired
    public HouseApi(HouseService houseService) {
        this.houseService = houseService;
    }
    @GetMapping("/new")
    public String create(@PathVariable Long agencyId, Model model){
        model.addAttribute("agencyId",agencyId);
        model.addAttribute("newHouse",new House());
        return "/house/newHouse";
    }
    @PostMapping("/save")
    public String save(@PathVariable Long agencyId, @ModelAttribute("newHouse") House house) throws MyException {
        houseService.saveHouse(agencyId,house);
        return "redirect:/houses/" + agencyId;
    }
    @GetMapping
    public String getAllHouses(@PathVariable Long agencyId, Model model){
        model.addAttribute("houses",houseService.getAllHouses(agencyId));
        model.addAttribute("agencyId",agencyId);
        return "/house/houseMainPage";
    }
    @GetMapping("/{houseId}/edit")
    public String edit(@PathVariable Long houseId,Model model){
        model.addAttribute("house",houseService.getHouseById(houseId));
        return "/house/updateHouse";
    }
}
