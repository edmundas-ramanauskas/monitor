package com.marketplace.app.web.controllers;

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
public class PublicController {
    
    private static final Logger logger = LoggerFactory.getLogger(PublicController.class);
 
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        return "default";
    }
 
    @RequestMapping(value = "/forbidden", method = RequestMethod.GET)
    public String forbidden(Model model) {
        return "forbidden";
    }
}