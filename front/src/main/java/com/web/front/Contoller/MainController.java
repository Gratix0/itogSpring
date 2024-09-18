package com.web.front.Contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/customers")
    public String customers(@RequestParam(name="a", required = false, defaultValue = "0") int a,
                                 Model model) {
        return "customers";
    }

    @GetMapping("/employees")
    public String employes(@RequestParam(name="a", required = false, defaultValue = "0") int a,
                                 Model model) {
        return "employees";
    }
    @GetMapping("/locations")
    public String locations(@RequestParam(name="a", required = false, defaultValue = "0") int a,
                                 Model model) {
        return "locations";
    }
    @GetMapping("/order")
    public String order(@RequestParam(name="a", required = false, defaultValue = "0") int a,
                                 Model model) {
        return "order";
    }
    @GetMapping("/ingredients")
    public String ingredients(@RequestParam(name="a", required = false, defaultValue = "0") int a,
                                 Model model) {
        return "ingredients";
    }
    @GetMapping("/sauces")
    public String sauces(@RequestParam(name="a", required = false, defaultValue = "0") int a,
                                 Model model) {
        return "sauces";
    }
    @GetMapping("/shawarmas")
    public String shawarmas(@RequestParam(name="a", required = false, defaultValue = "0") int a,
                                 Model model) {
        return "shawarmas";
    }
    @GetMapping("/suppliers")
    public String suppliers(@RequestParam(name="a", required = false, defaultValue = "0") int a,
                                 Model model) {
        return "suppliers";
    }
    @GetMapping("/home")
    public String home(@RequestParam(name="a", required = false, defaultValue = "0") int a,
                                 Model model) {
        return "home";
    }
    @GetMapping("/orderCheck")
    public String orderCheck(@RequestParam(name="a", required = false, defaultValue = "0") int a,
                                 Model model) {
        return "orderCheck";
    }
}