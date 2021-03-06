package com.exampl.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Properties を読み込むクラス
 */
@Controller
public class HomeController {
    private static final Logger logger =
            LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private Properties applicationProperties;

    /**
     * application.properties を読み込むメソッドです。
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {

        String message = 
                applicationProperties.getProperty("app.test");
        logger.info("message : " + message);

        model.addAttribute("message", message );
        return "home";
    }
    
}
