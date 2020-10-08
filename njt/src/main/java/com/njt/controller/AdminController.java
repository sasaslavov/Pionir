/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.controller;

import com.njt.domain.Disciplina;
import com.njt.domain.Zemlja;
import com.njt.domain.Pol;
import com.njt.domain.Prijava;
import com.njt.domain.Rezultat;
import com.njt.domain.RezultatForma;
import com.njt.domain.RezultatId;
import com.njt.domain.Plivac;
import com.njt.domain.Status;
import com.njt.domain.Takmicenje;
import com.njt.domain.User;
import com.njt.service.PrijavaService;
import com.njt.service.RezultatService;
import com.njt.service.TakmicenjeService;
import com.njt.service.UserService;
import com.njt.service.SecurityService;
import com.njt.validator.UserValidator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.njt.service.DisciplinaService;
import com.njt.service.ZemljaService;
import com.njt.service.PlivacService;
import java.util.Locale;

/**
 *
 * @author Jovan Petrovic
 */
@Controller
@RequestMapping(value = "/admin/*")
public class AdminController {

    @Autowired
    private PlivacService plivacService;

    @Autowired
    private TakmicenjeService takmicenjeService;

    @Autowired
    private PrijavaService prijavaService;

    @Autowired
    private RezultatService rezultatService;

    @Autowired
    private UserService userService;

    @Autowired
    private DisciplinaService disciplinaService;

    @Autowired
    private ZemljaService zemljaService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "admin/welcomeAdmin";
    }

    @GetMapping("/plivaciAll")
    public ModelAndView allPlivaci() {

        List<Plivac> plivaci = plivacService.getAll();
        ModelAndView modelAndView = new ModelAndView("admin/plivaciAll");
        modelAndView.addObject("plivaci", plivaci);
        return modelAndView;
    }

    @RequestMapping(value = "/getS/{id}", method = RequestMethod.GET)
    public ModelAndView getPlivac(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("admin/plivaciView");
        Plivac plivac = plivacService.findbyId(id);
        modelAndView.addObject("viewPlivac", plivac);
        return modelAndView;
    }

    @RequestMapping(value = "/editS/{id}", method = RequestMethod.GET)
    public ModelAndView editPlivacaGet(@PathVariable("id") Long id) {
        Plivac s = plivacService.findbyId(id);
        List<Status> status = new LinkedList<Status>();
        List<Pol> pol = new LinkedList<Pol>();
        Status p = new Status("Aktivan");
        Status p2 = new Status("Neaktivan");
        status.add(p);
        status.add(p2);

        Pol pp = new Pol("M");
        Pol pp2 = new Pol("Z");
        pol.add(pp);
        pol.add(pp2);

        ModelAndView modelAndView = new ModelAndView("admin/plivaciEdit");
        modelAndView.addObject("zemlja", zemljaService.getAll());
        modelAndView.addObject("plivac", s);
        modelAndView.addObject("pol", pol);
        modelAndView.addObject("status", status);
        return modelAndView;
    }

    @RequestMapping(value = "/editS/{id}", method = RequestMethod.POST)
    public String editPlivacaPost(@PathVariable("id") Long id, @ModelAttribute("plivac") Plivac plivac) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",Locale.ENGLISH);
        String dateString = String.valueOf(plivac.getDatumRodjenja());
        java.util.Date dateStr = formatter.parse(dateString);

        plivac.setDatumRodjenja(dateStr);
        plivac.setPlivacId(id);
        System.out.println(plivac);
        plivacService.add(plivac);
        return "redirect:/admin/plivaciAll";
    }

    @RequestMapping(value = "/addS", method = RequestMethod.GET)
    public ModelAndView addPlivacaGet() {
        Plivac s = new Plivac();
        List<Status> status = new LinkedList<Status>();
        List<Pol> pol = new LinkedList<Pol>();
        Status p = new Status("Aktivan");
        Status p2 = new Status("Neaktivan");
        status.add(p);
        status.add(p2);

        Pol pp = new Pol("M");
        Pol pp2 = new Pol("Z");
        pol.add(pp);
        pol.add(pp2);

        ModelAndView modelAndView = new ModelAndView("admin/plivaciAdd");
        
        modelAndView.addObject("zemlja", zemljaService.getAll());
        modelAndView.addObject("plivac", s);
        modelAndView.addObject("pol", pol);
        modelAndView.addObject("status", status);
        return modelAndView;
    }

    @RequestMapping(value = "/addS", method = RequestMethod.POST)
    public String addPlivacaPost(@ModelAttribute("plivac") Plivac plivac) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",Locale.ENGLISH);
        String dateString = String.valueOf(plivac.getDatumRodjenja());
        java.util.Date dateStr = formatter.parse(dateString);

        plivac.setDatumRodjenja(dateStr);
        System.out.println(plivac);
        plivacService.add(plivac);
        return "redirect:/admin/plivaciAll";
    }

    @RequestMapping(value = "deleteS/{id}")
    public ModelAndView deletePlivac(@PathVariable("id") Long id) {
        Plivac plivac = plivacService.findbyId(id);
        List<Prijava> prijave = prijavaService.getAll();
        List<Rezultat> rezultati = rezultatService.getAll();
        List<User> users = userService.getAll();

        for (User user : users) {
            if (user.getPlivacId() == plivac.getPlivacId()) {
                userService.delete(user.getId());
                break;
            }
        }
        for (Prijava p : prijave) {
            if (p.getPlivac().equals(plivac)) {
                prijavaService.delete(p.getPrijavaId());
            }
        }
        for (Rezultat rezultat : rezultati) {
            if (rezultat.getPlivac().equals(plivac)) {
                rezultatService.delete(rezultat.getId());
            }
        }
        plivacService.delete(id);
        List<Plivac> plivaci = plivacService.getAll();
        ModelAndView modelAndView = new ModelAndView("admin/plivaciAll");
        modelAndView.addObject("plivaci", plivaci);
        return modelAndView;
    }

    @GetMapping("/takmicenjeAll")
    public ModelAndView allTakmicenja() throws ParseException {

        List<Takmicenje> takmicenja = takmicenjeService.getAll();

        ModelAndView modelAndView = new ModelAndView("admin/takmicenjeAll");
        modelAndView.addObject("takmicenja", takmicenja);

        return modelAndView;
    }

    @RequestMapping(value = "/getT/{id}", method = RequestMethod.GET)
    public ModelAndView getTakmicenje(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("admin/takmicenjeView");
        Takmicenje takmicenje = takmicenjeService.findbyId(id);
        modelAndView.addObject("viewTakmicenje", takmicenje);
        return modelAndView;
    }

    @RequestMapping(value = "/editT/{id}", method = RequestMethod.GET)
    public ModelAndView editTakmicenjeGet(@PathVariable("id") Long id) {
        Takmicenje t = takmicenjeService.findbyId(id);
        List<Disciplina> discipline = disciplinaService.getAll();
        List<Zemlja> zemlje = zemljaService.getAll();

        ModelAndView modelAndView = new ModelAndView("admin/takmicenjeEdit");

        modelAndView.addObject("takmicenje", t);
        modelAndView.addObject("discipline", discipline);
        modelAndView.addObject("zemlje", zemlje);
        return modelAndView;
    }

    @RequestMapping(value = "/editT/{id}", method = RequestMethod.POST)
    public String editTakmicenjePost(@PathVariable("id") Long id, @ModelAttribute("takmicenje") Takmicenje takmicenje) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",Locale.ENGLISH);
        String dateString = String.valueOf(takmicenje.getDatumOdrzavanja());
        java.util.Date dateStr = formatter.parse(dateString);
        String dateStringS = String.valueOf(takmicenje.getRokZaPrijave());
        Date dateSS = formatter.parse(dateStringS);

        takmicenje.setDatumOdrzavanja(dateStr);
        takmicenje.setRokZaPrijave(dateSS);
        takmicenje.setTakmicenjeId(id);
        System.out.println(takmicenje);
        takmicenjeService.add(takmicenje);
        return "redirect:/admin/takmicenjeAll";
    }

    @RequestMapping(value = "/addT", method = RequestMethod.GET)
    public ModelAndView addTakmicenjeGet() {
        List<Disciplina> discipline = disciplinaService.getAll();
        List<Zemlja> zemlja = zemljaService.getAll();
        Takmicenje takmicenje = new Takmicenje();

        ModelAndView modelAndView = new ModelAndView("admin/takmicenjeAdd");
        modelAndView.addObject("discipline", discipline);
        modelAndView.addObject("zemlja", zemlja);
        modelAndView.addObject("takmicenje", takmicenje);

        System.out.println("GETTTTTTTTTTTT");

        return modelAndView;
    }

    @RequestMapping(value = "/addT", method = RequestMethod.POST)
    public String addTakmicenjePost(@ModelAttribute("takmicenje") Takmicenje takmicenje) throws ParseException {
        System.out.println("postttttttttt");

        takmicenje.setBrojPrijava(0);

        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",Locale.ENGLISH);
        String dateString = String.valueOf(takmicenje.getDatumOdrzavanja());
        java.util.Date dateStr = formatter.parse(dateString);

        Date dateSS = formatter.parse(dateString);

        takmicenje.setDatumOdrzavanja(dateStr);
        takmicenje.setRokZaPrijave(dateSS);

        System.out.println(takmicenje);

        takmicenjeService.add(takmicenje);

        return "redirect:/admin/takmicenjeAll";
    }

    @RequestMapping(value = "deleteT/{id}")
    public ModelAndView deleteTakmicenje(@PathVariable("id") Long id) {
        Takmicenje takmicenje = takmicenjeService.findbyId(id);
        List<Prijava> prijave = prijavaService.getAll();
        List<Rezultat> rezultati = rezultatService.getAll();
        for (Prijava p : prijave) {
            if (p.getTakmicenje().equals(takmicenje)) {
                prijavaService.delete(p.getPrijavaId());
            }
        }
        for (Rezultat rezultat : rezultati) {
            if (rezultat.getTakmicenje().equals(takmicenje)) {
                rezultatService.delete(rezultat.getId());
            }
        }

        takmicenjeService.delete(id);
        List<Takmicenje> takmicenja = takmicenjeService.getAll();
        ModelAndView modelAndView = new ModelAndView("admin/takmicenjeAll");
        modelAndView.addObject("takmicenja", takmicenja);
        return modelAndView;
    }

    @GetMapping("/prijavaAll")
    public ModelAndView allPrijave() throws ParseException {

        List<Takmicenje> takmicenja = takmicenjeService.getAll();

        ModelAndView modelAndView = new ModelAndView("admin/prijavaAll");
        modelAndView.addObject("takmicenja", takmicenja);

        return modelAndView;
    }

    @RequestMapping(value = "/viewP/{id}", method = RequestMethod.GET)
    public ModelAndView getPrijaveZaTakmicenje(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("admin/prijavaView");
        Takmicenje takmicenje = takmicenjeService.findbyId(id);
        List<Prijava> pri = prijavaService.getAll();
        List<Prijava> prijave = new LinkedList<>();

        for (Prijava p : pri) {
            if (p.getTakmicenje().equals(takmicenje)) {
                prijave.add(p);
            }
        }
        System.out.println(prijave);
        modelAndView.addObject("viewTakmicenje", takmicenje);
        modelAndView.addObject("prijave", prijave);

        return modelAndView;
    }

    @RequestMapping(value = "/addP/{id}", method = RequestMethod.GET)
    public ModelAndView addPrijaveGet(@PathVariable("id") Long id) {
        Takmicenje takmicenje = takmicenjeService.findbyId(id);
        List<Prijava> prijave = prijavaService.getAll();
        List<Prijava> pri = new LinkedList<>();

        List<Plivac> plivaci = plivacService.getAll();
        List<Plivac> pli = new LinkedList<>();
        int signal = 0;

        for (Prijava p : prijave) {
            if (p.getTakmicenje().equals(takmicenje)) {
                pri.add(p);
            }
        }
      
        for (Plivac plivac : plivaci) {
            signal = 0;
            for (Prijava p : pri) {
                if (p.getPlivac().equals(plivac)) {
                    signal = 1;
                    break;
                }
            }
            if (signal == 0) {
                pli.add(plivac);
            }
        }

        List<Takmicenje> takmicenja = new LinkedList<>();
        takmicenja.add(takmicenje);
        System.out.println("PLIVAC DD" + pli);
        Prijava p = new Prijava();
        ModelAndView modelAndView = new ModelAndView("admin/prijavaAdd");
        modelAndView.addObject("takmicenja", takmicenja);
        modelAndView.addObject("takmicenje", takmicenje);
        modelAndView.addObject("plivaci", pli);
        modelAndView.addObject("prijava", p);
        modelAndView.addObject("prijave", pri);

        return modelAndView;
    }

    @RequestMapping(value = "/addP/{id}", method = RequestMethod.POST)
    public String addPrijavaPost(@PathVariable("id") Long id, @ModelAttribute("prijava") Prijava prijava) throws ParseException {
        Takmicenje takmicenje = takmicenjeService.findbyId(id);
        System.out.println(prijava);
        Plivac plivac = plivacService.findbyId(prijava.getPlivac().getPlivacId());
        prijava.setDatumPrijave(new Date());
        prijavaService.add(prijava);
        takmicenje.setBrojPrijava(takmicenje.getBrojPrijava() + 1);
        takmicenjeService.add(takmicenje);

        return "redirect:/admin/addP/" + takmicenje.getTakmicenjeId();
    }

    @RequestMapping(value = "deleteP/{id}")
    public ModelAndView deletePrijave(@PathVariable("id") Long id) {
        Prijava prijava = prijavaService.findbyId(id);
        prijavaService.delete(id);

        ModelAndView modelAndView = new ModelAndView("admin/prijavaView");
        Takmicenje takmicenje = takmicenjeService.findbyId(prijava.getTakmicenje().getTakmicenjeId());
        takmicenje.setBrojPrijava(takmicenje.getBrojPrijava() - 1);
        takmicenjeService.add(takmicenje);
        List<Prijava> pri = prijavaService.getAll();
        List<Prijava> prijave = new LinkedList<>();

        for (Prijava p : pri) {
            if (p.getTakmicenje().equals(takmicenje)) {
                prijave.add(p);
            }
        }
        System.out.println(prijave);
        modelAndView.addObject("viewTakmicenje", takmicenje);
        modelAndView.addObject("prijave", prijave);

        return modelAndView;

    }

    @GetMapping("/rezultatAll")
    public ModelAndView allRezultat() {

        List<Takmicenje> takmicenja = takmicenjeService.getAll();
        List<Takmicenje> takm = new LinkedList<>();
        Date date = new Date();
        for (Takmicenje takmicenje : takmicenja) {
            if (date.after(takmicenje.getDatumOdrzavanja())) {
                takm.add(takmicenje);
            }
        }

        ModelAndView modelAndView = new ModelAndView("admin/rezultatAll");
        modelAndView.addObject("takmicenja", takm);

        return modelAndView;
    }

    @RequestMapping(value = "/viewR/{id}", method = RequestMethod.GET)
    public ModelAndView getRezultatZaTakmicenje(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("admin/rezultatView");
        Takmicenje takmicenje = takmicenjeService.findbyId(id);
        List<Rezultat> rez = rezultatService.getAll();
        List<Rezultat> rezultati = new LinkedList<>();

        for (Rezultat r : rez) {
            if (r.getTakmicenje().equals(takmicenje)) {
                rezultati.add(r);
            }
        }
        modelAndView.addObject("viewTakmicenje", takmicenje);
        modelAndView.addObject("rezultati", rezultati);

        return modelAndView;
    }

    @RequestMapping(value = "/addR/{id}", method = RequestMethod.GET)
    public ModelAndView addRezultatiGet(@PathVariable("id") Long id) {
        Takmicenje takmicenje = takmicenjeService.findbyId(id);
        List<Prijava> prijave = prijavaService.getAll();
        List<Prijava> pri = new LinkedList<>();

        List<Rezultat> rezultati = new LinkedList<>();

        List<Plivac> plivaci = plivacService.getAll();
        List<Plivac> pli = new LinkedList<>();
        int signal = 0;

        for (Prijava p : prijave) {
            if (p.getTakmicenje().equals(takmicenje)) {
                pri.add(p);
            }
        }
        for (Plivac plivac : plivaci) {
            for (Prijava p : pri) {
                if (p.getPlivac().equals(plivac)) {
                    pli.add(plivac);
                }
            }

        }

        for (Plivac plivac : pli) {
            Rezultat rez = new Rezultat();
            rez.setPlivac(plivac);
            rez.setTakmicenje(takmicenje);
            rezultati.add(rez);
        }
        System.out.println("rez: " + rezultati);
        RezultatForma rezultatForma = new RezultatForma();
        rezultatForma.setRezultati(rezultati);
        ModelAndView modelAndView = new ModelAndView("admin/rezultatAdd");
        modelAndView.addObject("takmicenje", takmicenje);
        modelAndView.addObject("plivaci", pli);
        modelAndView.addObject("rezultatForma", rezultatForma);

        return modelAndView;
    }

    @RequestMapping(value = "/addR/{id}", method = RequestMethod.POST)
    public String addRezultatPost(@PathVariable("id") Long id, @ModelAttribute("rezultatForma") RezultatForma rezultatForma) throws ParseException {
        Takmicenje takmicenje = takmicenjeService.findbyId(id);
        List<Prijava> prijave = prijavaService.getAll();
        List<Prijava> pri = new LinkedList<>();

        List<Plivac> plivaci = plivacService.getAll();
        List<Plivac> pli = new LinkedList<>();
        int signal = 0;

        for (Prijava p : prijave) {
            if (p.getTakmicenje().equals(takmicenje)) {
                pri.add(p);
            }
        }
        for (Plivac plivac : plivaci) {

            for (Prijava p : pri) {
                if (p.getPlivac().equals(plivac)) {
                    pli.add(plivac);
                }
            }

        }

        List<Rezultat> rezultati = rezultatForma.getRezultati();
        System.out.println("rezultati: " + rezultati);
        System.out.println("rezforma " + rezultatForma);
        int i = 0;
        if (rezultati != null) {
            for (Rezultat rezultat : rezultati) {
                rezultat.setId(new RezultatId(pli.get(i).getPlivacId(), id));
                rezultatService.add(rezultat);
                i++;
            }
        }

        return "redirect:/admin/viewR/" + id;
    }

    @RequestMapping(value = "/editR/{id}", method = RequestMethod.GET)
    public ModelAndView editRezultatGet(@PathVariable("id") Long id) {
        Takmicenje takmicenje = takmicenjeService.findbyId(id);
        List<Prijava> prijave = prijavaService.getAll();
        List<Prijava> pri = new LinkedList<>();

        List<Rezultat> rezultati = new LinkedList<>();

        List<Plivac> plivaci = plivacService.getAll();
        List<Plivac> pli = new LinkedList<>();
        int signal = 0;

        for (Prijava p : prijave) {
            if (p.getTakmicenje().equals(takmicenje)) {
                pri.add(p);
            }
        }
        for (Plivac plivac : plivaci) {

            for (Prijava p : pri) {
                if (p.getPlivac().equals(plivac)) {
                    pli.add(plivac);
                }
            }

        }

        List<Rezultat> rezu = rezultatService.getAll();
        System.out.println("rez: " + rezultati);
        RezultatForma rezultatForma = new RezultatForma();
        rezultatForma.setRezultati(rezu);
        ModelAndView modelAndView = new ModelAndView("admin/rezultatEdit");
        modelAndView.addObject("takmicenje", takmicenje);
        modelAndView.addObject("plivaci", pli);
        modelAndView.addObject("rezultatForma", rezultatForma);

        return modelAndView;
    }

    @RequestMapping(value = "/editR/{id}", method = RequestMethod.POST)
    public String editRezultatPost(@PathVariable("id") Long id, @ModelAttribute("rezultatForma") RezultatForma rezultatForma) throws ParseException {
        Takmicenje takmicenje = takmicenjeService.findbyId(id);
        List<Prijava> prijave = prijavaService.getAll();
        List<Prijava> pri = new LinkedList<>();

        List<Plivac> plivaci = plivacService.getAll();
        List<Plivac> pli = new LinkedList<>();
        int signal = 0;

        for (Prijava p : prijave) {
            if (p.getTakmicenje().equals(takmicenje)) {
                pri.add(p);
            }
        }
        for (Plivac plivac : plivaci) {

            for (Prijava p : pri) {
                if (p.getPlivac().equals(plivac)) {
                    pli.add(plivac);
                }
            }

        }

        List<Rezultat> rezultati = rezultatForma.getRezultati();
        System.out.println("rezultati: " + rezultati);
        System.out.println("rezforma " + rezultatForma);
        int i = 0;
        if (rezultati != null) {
            for (Rezultat rezultat : rezultati) {
                rezultat.setId(new RezultatId(pli.get(i).getPlivacId(), id));
                rezultatService.add(rezultat);
                i++;
            }
        }

        return "redirect:/admin/viewR/" + id;
    }

    @RequestMapping(value = "deleteR/{id}")
    public ModelAndView deleteRezultati(@PathVariable("id") Long id) {

        List<Rezultat> rezultate = rezultatService.getAll();
        Takmicenje t = takmicenjeService.findbyId(id);
        for (Rezultat rezultat : rezultate) {
            if (rezultat.getTakmicenje().equals(t)) {
                rezultatService.delete(rezultat.getId());
            }
        }

        ModelAndView modelAndView = new ModelAndView("admin/rezultatView");
        Takmicenje takmicenje = takmicenjeService.findbyId(id);
        List<Rezultat> rez = rezultatService.getAll();
        List<Rezultat> rezultati = new LinkedList<>();

        for (Rezultat r : rez) {
            if (r.getTakmicenje().equals(takmicenje)) {
                rezultati.add(r);
            }
        }
        modelAndView.addObject("viewTakmicenje", takmicenje);
        modelAndView.addObject("rezultati", rezultati);

        return modelAndView;

    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        List<Plivac> pli = plivacService.getAll();
        List<Plivac> plivaci = new LinkedList<>();
        List<User> users = userService.getAll();
        int signal = 0;
        for (Plivac s : pli) {
            signal = 0;
            for (User user : users) {
                if (user.getPlivacId() == s.getPlivacId()) {
                    signal = 1;
                    break;
                }
            }
            if (signal == 0) {
                plivaci.add(s);
            }

        }
        System.out.println(plivaci);
        plivaci.add(0, new Plivac(0l, "", "", new Date(), "", "", new Zemlja(), ""));
        model.addAttribute("plivaci", plivaci);
        return "/admin/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/admin/registration";
        }

        userService.save(userForm);

//        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
        return "redirect:/admin/welcome";
    }

    @GetMapping("/userAll")
    public ModelAndView getAllUsers() {

        List<User> users = userService.getAll();
        List<Plivac> pli = plivacService.getAll();
        List<Plivac> plivaci = new LinkedList<>();
        for (User u : users) {
            for (Plivac s : pli) {
                if (u.getPlivacId() == s.getPlivacId()) {
                    plivaci.add(s);
                    break;
                }
            }
        }

        ModelAndView modelAndView = new ModelAndView("admin/userAll");
        modelAndView.addObject("users", users);
        modelAndView.addObject("plivaci", plivaci);

        return modelAndView;
    }

}
