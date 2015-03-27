package com.marketplace.monitor.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author edmundas
 */
@Controller
public class SecureController {
    
    private static final Logger logger = LoggerFactory.getLogger(SecureController.class);
 
    @RequestMapping(value = "/secure", method = RequestMethod.GET)
    public String index(Model model) {
        return "default";
    }

}
