package com.ssd.delivery.controller.account;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.delivery.domain.Account;
import com.ssd.delivery.domain.AccountDTO;
import com.ssd.delivery.domain.AuctionDTO;
import com.ssd.delivery.domain.CoPurchasingDTO;
import com.ssd.delivery.domain.DeliveryDTO;
import com.ssd.delivery.domain.FavoriteUserDTO;
import com.ssd.delivery.domain.Product;
import com.ssd.delivery.service.DeliveryFacade;
import com.ssd.delivery.service.Message;
import com.ssd.delivery.service.PetStoreFacade;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.Model;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/admin/delivery.do")
public class AdminDeliveryController {

	private DeliveryFacade delivery;

	@Autowired
	public void setDelivery(DeliveryFacade delivery) {
		this.delivery = delivery;
	}

	@GetMapping
	public ModelAndView adminDeliveryView(Model model, HttpSession session) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		List<DeliveryDTO> DelList = delivery.getDeliveryList();
		
		
		mav.addObject("DelList", DelList);
		mav.setViewName("adminDelivery");
	
		return mav;
	}
	
}
