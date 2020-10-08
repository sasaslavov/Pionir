/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.controller;

import com.njt.domain.Prijava;
import com.njt.domain.Plivac;
import com.njt.domain.Takmicenje;
import com.njt.domain.User;
import com.njt.repository.PlivacRepository;
import com.njt.repository.UserRepository;
import com.njt.service.PrijavaService;
import com.njt.service.TakmicenjeService;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping(value = "/prijava/*")
public class PrijavaController {

    long ids = 1l;
    @Autowired
    private PrijavaService prijavaService;
    @Autowired
    private TakmicenjeService takmicenjeService;
    @Autowired
    private PlivacService plivacService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public ModelAndView allTakmicenja() {
        Date datum = new Date();
        List<Takmicenje> takmicenja = takmicenjeService.getAll();
        List<Takmicenje> takm = new LinkedList<>();
        List<Takmicenje> ta = new LinkedList<>();
        for (Takmicenje t : takmicenja) {
            if (t.getBrojPrijava() != t.getDozvoljenBrojPrijava()) {
                if (datum.before(t.getRokZaPrijave())) {
                    takm.add(t);
                }
            }
        }
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User u = userRepository.findByUsername(user.getUsername());
        List<Prijava> prijave = prijavaService.getAll();
        int signal = 0;
        for (Takmicenje t : takm) {
            signal = 0;
            for (Prijava prijava : prijave) {
                if (prijava.getTakmicenje().equals(t)) {
                    if (prijava.getPlivac().getPlivacId() == u.getPlivacId()) {
                        signal = 1;
                        break;
                    }
                }
            }
            if (signal == 0) {
                ta.add(t);
            }

        }
        ModelAndView modelAndView = new ModelAndView("prijava/all");
        modelAndView.addObject("takmicenja", ta);
        return modelAndView;
    }

    @RequestMapping(value = "details/{id}", method = RequestMethod.GET)
    public ModelAndView detailsPrijave(@PathVariable Long id) {
        Takmicenje ts = takmicenjeService.findbyId(id);
        List<Prijava> prijave = prijavaService.getAll();
        List<Prijava> pri = new LinkedList<>();
        for (Prijava p : prijave) {
            if (p.getTakmicenje().equals(ts)) {
                pri.add(p);
            }
        }

        ModelAndView modelAndView = new ModelAndView("prijava/details");
        modelAndView.addObject("prijave", pri);
        return modelAndView;
    }
    
    @RequestMapping(value = "details/{id}/add", method = RequestMethod.GET)
    public ModelAndView detailsPrijaveAdd(@PathVariable Long id) {
        Takmicenje ts = takmicenjeService.findbyId(id);
        User u = userRepository.findByUsername(((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        Prijava prijavaNew = new Prijava();
        prijavaNew.setDatumPrijave(new Date());
        prijavaNew.setPlivac(plivacService.findbyId(userRepository.findByUsername(((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()).getPlivacId()));
        prijavaNew.setTakmicenje(ts);
        prijavaService.add(prijavaNew);
        ts.setBrojPrijava(ts.getBrojPrijava() + 1);
        takmicenjeService.add(ts);
        
        List<Prijava> prijave = prijavaService.getAll();
        List<Prijava> pri = new LinkedList<>();
        for (Prijava p : prijave) {
            if (p.getTakmicenje().equals(ts)) {
                pri.add(p);
            }
        }
        
        
        ModelAndView modelAndView = new ModelAndView("prijava/details");
        modelAndView.addObject("prijave", pri);
        return modelAndView;
    }

    @RequestMapping(value = "add/{id}", method = RequestMethod.GET)
    public ModelAndView save_get(@PathVariable Long id) {

        Takmicenje takmicenje = takmicenjeService.findbyId(id);

        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User u = userRepository.findByUsername(user.getUsername());

        Plivac s = plivacService.findbyId(u.getPlivacId());

        List<Plivac> plivaci = new LinkedList<>();
        plivaci.add(s);
        List<Takmicenje> takmicenja = new LinkedList<>();
        takmicenja.add(takmicenje);

        ModelAndView modelAndView = new ModelAndView("prijava/add");
        modelAndView.addObject("takmicenje", takmicenje);
        modelAndView.addObject("ta", takmicenja);
        modelAndView.addObject("plivac", plivaci);
        
        return modelAndView;
    }

    @ModelAttribute(name = "prijava")
    public Prijava prijava() {
        return new Prijava();
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String save(@ModelAttribute(name = "prijava") @Valid Prijava prijava, BindingResult bindingResult) {

        Plivac s = plivacService.findbyId(prijava.getPlivac().getPlivacId());
        Takmicenje t = takmicenjeService.findbyId(prijava.getTakmicenje().getTakmicenjeId());
        prijava.setDatumPrijave(new Date());
        t.setBrojPrijava(t.getBrojPrijava() + 1);
        System.out.println(prijava);
        ids = t.getTakmicenjeId();
        prijavaService.add(prijava);
        t.setBrojPrijava(t.getBrojPrijava() + 1);
        takmicenjeService.add(t);
        return "prijava/mojePrijave";
    }

    @GetMapping("/mojePrijave")
    public ModelAndView mojePrijave() {

        List<Takmicenje> takmicenja = new LinkedList<>();
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User u = userRepository.findByUsername(user.getUsername());

        List<Prijava> prijave = prijavaService.getAll();

        for (Prijava prijava : prijave) {
            if (prijava.getPlivac().getPlivacId() == u.getPlivacId()) {
                takmicenja.add(prijava.getTakmicenje());
            }
        }

        ModelAndView modelAndView = new ModelAndView("prijava/mojePrijave");
        modelAndView.addObject("takmicenja", takmicenja);
        return modelAndView;
    }
}
