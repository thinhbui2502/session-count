package com.codegym.controller;

import com.codegym.model.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("counter")
public class CounterController {

    @ModelAttribute("counter")
    public Counter setUpCounter() {
        return new Counter();
    }

    @GetMapping("/count")
    public ModelAndView getCounter(@ModelAttribute("counter") Counter counter) {
        counter.increment();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("counter", counter);
        return modelAndView;
    }
}
