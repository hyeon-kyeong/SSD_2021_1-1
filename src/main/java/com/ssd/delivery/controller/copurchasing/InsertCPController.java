package com.ssd.delivery.controller.copurchasing;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.delivery.domain.*;
import com.ssd.delivery.service.DeliveryFacade;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/delivery/coPurchasingInsert.do")
public class InsertCPController {
	@Autowired
	private DeliveryFacade delivery;

	@GetMapping
	public ModelAndView insert2(@RequestParam("deliveryId") int deliveryId) throws Exception {

		DeliveryDTO delItem = delivery.getDeliveryById(deliveryId);
		
		ModelAndView mav = new ModelAndView();

		mav.addObject("delivery", delItem);
		mav.setViewName("copurchasingForm2");

		return mav;
	}

	@PostMapping
	public ModelAndView inserCP(Model model, HttpSession session, @ModelAttribute("CoPurchasingForm")  CoPurchasingDTO CP, @RequestParam("deliveryId") int deliveryId) throws Exception {
		AccountDTO account = (AccountDTO)session.getAttribute("userSession");
		
		CP.setDelivery(deliveryId);
		delivery.insertCP(CP);
		System.out.println(CP.getCoPurchasingId());
		
		delivery.insertCPLineItem2(new CoPurchasingLineItemDTO(CP.getUsername() ));
	
		ModelAndView mav = new ModelAndView();
		
		DeliveryDTO del = delivery.getDeliveryById(deliveryId);

		mav.addObject("cp", CP);
		mav.addObject("del", del);
		mav.addObject("userSession", account);
		mav.setViewName("coPurchasingDetail");
				
		return mav;
	
	}
}
