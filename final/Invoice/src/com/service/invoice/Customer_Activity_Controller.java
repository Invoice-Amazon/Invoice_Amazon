package com.service.invoice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

@Controller
public class Customer_Activity_Controller {

   @RequestMapping(value = "/customeractivity", method = RequestMethod.GET)
   public ModelAndView student() {
      return new ModelAndView("customeractivity", "command", new Customer_Activity());
   }
   
   
   
   @RequestMapping(value = "/addCustomeractivity", method = RequestMethod.POST)
   public String addCustomerinput(@ModelAttribute("SpringWeb")Customer_Activity customer, 
   ModelMap model) {
      model.addAttribute("emailid", customer.getEmailid());
      model.addAttribute("secs", customer.getSecs());
      int rslt = DB_conn.add_customer_details(customer.getSecs(), customer.getEmailid());
      int rslt2 = DB_conn.add_transaction_details(customer.getEmailid());
      
      return "result";
   }
}