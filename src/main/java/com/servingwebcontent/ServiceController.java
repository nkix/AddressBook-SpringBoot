package com.servingwebcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ServiceController {
    private AddressBookRepository repository;

    public ServiceController(AddressBookRepository repository){
        this.repository = repository;
    }

    @RequestMapping(path="/addressbook/{id}", method=RequestMethod.GET)
    public String addressbookForm(@PathVariable long id, Model model){
        AddressBook ab = this.repository.findById(id);
        if(id==1&&ab==null){
            ab = new AddressBook();
            repository.save(ab);
            model.addAttribute("validId", true);
        }
        else model.addAttribute("validId", !(ab==null));
        model.addAttribute("addressbook", ab);

        return "addressbook";
    }

    @RequestMapping(path="/addBuddy/{id}", method = RequestMethod.GET)
    public String buddyInfoForm(@PathVariable long id, Model model) {
        AddressBook ab = this.repository.findById(id);
        System.out.println("id:" + id);
        if (ab == null){
            return null;
        }

        model.addAttribute("validId", true);
        model.addAttribute("id", id);

        return "addBuddy";
    }

    @RequestMapping(path="/addBuddy/{id}", method = RequestMethod.POST)
    public String addBuddyInfo(@PathVariable long id, BuddyInfo buddy) {
        AddressBook ab = this.repository.findById(id);
        System.out.println("id:" + id);
        if (ab == null){
            return null;
        }

        ab.addBuddy(buddy);
        this.repository.save(ab);

        return "redirect:/addressbook/" + id;
    }


    @DeleteMapping("/deleteBuddy/{id}")
    public String removeBuddyInfo(@PathVariable long id,
                                       @RequestBody BuddyInfo buddy) {
        AddressBook ab = this.repository.findById(id);
        if (ab == null){
            return null;
        }
        ab.deleteBuddy(buddy);
        this.repository.save(ab);
        return "addressbook";
    }

    @GetMapping("/main")
    public String getAddressBook(Model model){
        model.addAttribute("addr_list", repository.findAll());
        return "main";
    }

    @PostMapping("/main")
    public String createAddressBook(Model model){
        AddressBook addr = new AddressBook();
        repository.save(addr);
        model.addAttribute("addr_list", repository.findAll());
        return "main";
    }

}
