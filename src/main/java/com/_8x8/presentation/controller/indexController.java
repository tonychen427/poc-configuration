package com._8x8.presentation.controller;


import com._8x8.logic.service.IUserPhoneLogProvider;
import com._8x8.logic.service.IUserPhoneLogService;
import com._8x8.logic.service.IUserService;
import com._8x8.presentation.model.User;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class indexController {

    @Autowired
    IUserService _userSerice;

    @Autowired
    IUserPhoneLogService _userPhoneLogService;

    @Autowired
    IUserPhoneLogProvider _userPhoneLogProvider;

    @RequestMapping(value = "/{name:.+}", method = RequestMethod.GET)
    public String spaIndex(@PathVariable("name")String name, ModelMap model) {
      //  User mUser = _userSerice.GetUserById(0);
        model.addAttribute("application", name);
        return "index";
    }

    @RequestMapping(value = "/zpay/", method = RequestMethod.GET)
    public ModelAndView zpayIndex() {
        
        List<User> mUser = _userSerice.GetUsers();
        
        ModelAndView model = new ModelAndView();
        model.setViewName("zpayIndex");        
        model.addObject("users", mUser);
        return model;
    }
}
