/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.controller;

import com.njt.domain.Prijava;
import com.njt.domain.Takmicenje;
import com.njt.service.PrijavaService;
import com.njt.service.TakmicenjeService;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jovan Petrovic
 */
@Controller
@RequestMapping(value = "/takmicenje/*")
public class TakmicenjeController {

    @Autowired
    private TakmicenjeService takmicenjeService;

    @Autowired
    private PrijavaService prijavaService;

    @GetMapping("/all")
    public ModelAndView allTakmicenja() {

        List<Takmicenje> takmicenja = takmicenjeService.getAll();
        for (Takmicenje s : takmicenja) {
            System.out.println(s);
        }
        ModelAndView modelAndView = new ModelAndView("takmicenje/all");
        modelAndView.addObject("takmicenja", takmicenja);
        return modelAndView;
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public ModelAndView get(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("takmicenje/view");
        Takmicenje takmicenje = takmicenjeService.findbyId(id);
        List<Prijava> pri = prijavaService.getAll();
        List<Prijava> prijave = new LinkedList<>();

//        pri.stream().filter(item -> item.getTakmicenje().equals(takmicenje)).forEach(item -> prijave.add(item));
        for (Prijava p : pri) {
            if (p.getTakmicenje().equals(takmicenje)) {
                prijave.add(p);
            }
        }
        modelAndView.addObject("viewTakmicenje", takmicenje);
        modelAndView.addObject("prijave", prijave);

        return modelAndView;
    }

}
