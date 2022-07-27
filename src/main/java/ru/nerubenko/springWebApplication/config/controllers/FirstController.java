package ru.nerubenko.springWebApplication.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam("name") String name, @RequestParam("surname") String surname, Model model// обязательно
                            // задаются параметры после знака ?
                            //HttpServletRequest request p.s. нужен когда необходимо получить весь запрос разом
                            ) {
        //String name = request.getParameter("name"); p.s. при HttpServletRequest для того чтобы получить значение
        // параметра name
        //String surname = request.getParameter("surname"); p.s. при HttpServletRequest для того чтобы получить
        // значение параметра surname
        model.addAttribute("message", "Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return"first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a, @RequestParam("b") int b,
                             @RequestParam("action") String action, Model model) {
        double c = 0;
        switch (action) {
            case "multiplication" -> c = a * b;
            case "addition" -> c = a + b;
            case "subtraction" -> c = a - b;
            case "division" -> c = a / (double) b;
            default -> c = 0;
        }
        model.addAttribute("result", "Result " + action + "is: " + c);
        return "first/calculator";
    }
}
