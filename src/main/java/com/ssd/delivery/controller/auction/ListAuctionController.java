package com.ssd.delivery.controller.auction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.delivery.controller.UserSession;
import com.ssd.delivery.service.PetStoreFacade;

/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 * @modified by Changsup Park
 */
@Controller
@SessionAttributes("userSession")
public class ListAuctionController {

	private PetStoreFacade petStore;

	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}

	@RequestMapping("/auction/list")
	public ModelAndView handleRequest(
		@ModelAttribute("userSession") UserSession userSession
		) throws Exception {
		String username = userSession.getAccount().getUsername();
		return new ModelAndView("ListOrders", "orderList", 
				petStore.getOrdersByUsername(username));
	}

}
