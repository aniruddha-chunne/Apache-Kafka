package com.deliveryboy.deliveryboyapp.config.controller;

import com.deliveryboy.deliveryboyapp.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationController
{

    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/update")
    public ResponseEntity<?> update()
    {
        this.kafkaService.updateLocation("(" + Math.round(Math.random()*100) + "," + Math.round(Math.random()*100) + ")");
        System.out.println("LocationUpdated");
        String a = new ResponseEntity<>(Map.of("message" , "Location Updated"), HttpStatus.OK).toString();
        System.out.println(a);
        return new ResponseEntity<>(Map.of("message" , "Location Updated"), HttpStatus.OK);

    }

}
