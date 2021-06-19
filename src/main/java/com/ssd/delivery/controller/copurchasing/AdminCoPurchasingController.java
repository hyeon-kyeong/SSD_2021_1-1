package com.ssd.delivery.controller.copurchasing;

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
@RequestMapping({"/delivery/adminCoPurchasing.do", "/admin/coPurchasing.do"})
public class AdminCoPurchasingController {

	private DeliveryFacade delivery;

	@Autowired
	public void setDelivery(DeliveryFacade delivery) {
		this.delivery = delivery;
	}

	@GetMapping
	public ModelAndView adminCPView(Model model, HttpSession session) throws Exception {
		List<DeliveryDTO> del = delivery.isExistingCP();
		
		ModelAndView mav = new ModelAndView();
		
		List<CoPurchasingDTO> CPList = delivery.getCPList();
		
	
		for (int i = 0; i < del.size(); i++) {
			for (int j = 0; j < CPList.size(); j++) {
				if (del.get(i).getDeliveryId() == CPList.get(j).getDelivery()) {
					CPList.get(j).setFlag(1);
				}
			}
		}
		
		mav.addObject("CPList", CPList);
		mav.setViewName("adminCoPurchasing");
	
		return mav;
	}
	
}
