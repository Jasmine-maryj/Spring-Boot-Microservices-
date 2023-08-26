package com.dev.orderservice.controller;

import com.dev.orderservice.dto.OrderDto;
import com.dev.orderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/orders")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder")
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    public ResponseEntity<Map<String, String>> placeOrder(@RequestBody OrderDto orderDto){
        Map<String, String> result = orderService.placeOrder(orderDto);
        log.info("in order controller");
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    public ResponseEntity<Map<String, String>> fallbackMethod(@RequestBody OrderDto orderDto, RuntimeException exception){
        Map<String, String> map = new HashMap<>();
        map.put("message", "Something went wrong, Try again later!");
        return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @GetMapping("/{name}")
//    public Mono<ResponseEntity<String>> checkInventoryAndPlaceOrder(@PathVariable String name) {
//        return orderService.checkInventoryAndPlaceOrder(name)
//                .map(response -> new ResponseEntity<>(response, HttpStatus.OK))
//                .defaultIfEmpty(new ResponseEntity<>("Inventory not available", HttpStatus.BAD_REQUEST));
//    }
}
