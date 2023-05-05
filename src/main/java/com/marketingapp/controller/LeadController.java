package com.marketingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.dto.LeadDto;
import com.marketingapp.entities.lead;
import com.marketingapp.service.LeadService;
import com.marketingapp.util.EmailService;

@Controller
public class LeadController {
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private EmailService emailService;
	
	//localhost:8080/create
	
    @RequestMapping("/create")   //@WebServlet
	public String viewCreateLeadForm() {
		return "create_lead";  //RequestDispatcher
	}
   
   @RequestMapping("/saveReg")
   public String saveOneLead(@ModelAttribute lead lead , Model model) {
   model.addAttribute("msg" , "Lead Saved");
  	leadService.saveReg(lead);
  	emailService.sendEmail(lead.getEmail(),"Test","Testing Email Services");
   	return "create_lead";
   }
    
   // @RequestMapping("/saveReg")
   // public String saveOneLead(@RequestParam("firstName") String firstName , @RequestParam("lastName") String lastName , @RequestParam("email") String email , @RequestParam("mobile") long mobile , ModelMap model) {
    	
   // 	lead l = new lead();
  //  	l.setFirstName(firstName);
  //  	l.setLastName(lastName);
  //  	l.setEmail(email);
  //  	l.setMobile(mobile);
   // 	
   // 	model.addAttribute("msg" , "Lead Is Saved!!");
   // 	leadService.saveReg(l);
   // 	return "create_lead";
   // }
 //   @RequestMapping("/saveReg")
 //   public String saveOneLead(LeadDto dto, Model model) {
  //  	lead lead = new lead();
  //  	lead.setFirstName(dto.getFirstName());
  //  	lead.setLastName(dto.getLastName());
   // 	lead.setEmail(dto.getEmail());
 //   	lead.setMobile(dto.getMobile());
 //	   model.addAttribute("msg" , "Lead Is Saved");
  //   	leadService.saveReg(lead);
 //   	return "create_lead";
 //   }
    
  //localhost:8080/listall
    @RequestMapping("/listall")
 public String getAllLeads(Model model) { 
    List<lead> leads = leadService.findAllLeads();
    model.addAttribute("leads",leads);
   return "list_leads"; 
}
   //localhost:8080/delete
    @RequestMapping("/delete")
    public String deleteLeadById(@RequestParam("id") long id, Model model) {
    	leadService.deleteLeadById(id);
    	
    	List<lead> leads = leadService.findAllLeads();
        model.addAttribute("leads",leads);
    	return "list_leads";
    }
    @RequestMapping("/update")
    public String updateLead(@RequestParam("id") long id, Model model) {
    lead lead = leadService.findLeadById(id);
    model.addAttribute("lead", lead);
    	return"update_lead";	
    }
    @RequestMapping("/editReg")
    public String editReg(LeadDto dto, Model model) {
    	lead lead = new lead();
    	lead.setId(dto.getId());
    	lead.setFirstName(dto.getFirstName());
    	lead.setLastName(dto.getLastName());
    	lead.setEmail(dto.getEmail());
    	lead.setMobile(dto.getMobile());
    	leadService.saveReg(lead);
    	
    	List<lead> leads = leadService.findAllLeads();
        model.addAttribute("leads",leads);
    	return "list_leads";
    }
}
