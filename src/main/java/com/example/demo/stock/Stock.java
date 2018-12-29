package com.example.demo.stock;


import com.example.demo.utils.StockUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class Stock {


    @RequestMapping(value = "stock" ,method = RequestMethod.GET)
    public String hello(String stockColds,Integer min){
        StockUtils main = new StockUtils();
        main.stockNum = stockColds;
        main.min = min;
        HashMap<String,Float> res= main.batchRun();
        String result = main.getMin500(res);

        return result;
    }
}
