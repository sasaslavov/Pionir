/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.controller;

import com.njt.domain.Prijava;
import com.njt.domain.Plivac;
import com.njt.service.PrijavaService;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.njt.service.PlivacService;

/**
 *
 * @author Jovan Petrovic
 */
@Controller
@RequestMapping(value = "/plivac/*")
public class PlivacController {
    
    @Autowired
    private PlivacService plivacService;
    
    @Autowired 
    private PrijavaService prijavaService;
    
    @GetMapping("/all")
    public ModelAndView allPlivaci(){

        List<Plivac> plivaci = plivacService.getAll();
        ModelAndView modelAndView = new ModelAndView("plivac/all");
        modelAndView.addObject("plivaci",plivaci);
        return modelAndView;
    }
    
    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public ModelAndView get(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("plivac/view");
        Plivac plivac = plivacService.findbyId(id);
        List<Prijava> pri = prijavaService.getAll();
        List<Prijava> prijave = new LinkedList<>();

        for (Prijava p : pri) {
            if (p.getPlivac().equals(plivac)) {
                prijave.add(p);
            }
        }
        modelAndView.addObject("viewPlivac", plivac);
        modelAndView.addObject("prijave", prijave);
        return modelAndView;
    }
    
}
