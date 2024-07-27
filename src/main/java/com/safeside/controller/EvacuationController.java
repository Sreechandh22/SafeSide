package com.safeside.controller;

import com.safeside.model.Route;
import com.safeside.service.EvacuationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EvacuationController {

    @Autowired
    private EvacuationService evacuationService;

    @GetMapping("/route")
    public ResponseEntity<Route> getEvacuationRoute(@RequestParam String userId) {
        Route route = evacuationService.calculateRoute(userId);
        return ResponseEntity.ok(route);
    }
}
