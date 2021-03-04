package com.example.demo1.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/v1")
public class DataController {

    private static List<Readings> READINGS = Arrays.asList(
            new Readings("GENESIS", 50),
            new Readings("PSALM", 150)
    );

    @GetMapping
    @PreAuthorize("hasAnyAuthority('management:read')")
    public List<Readings> getAllData() {
        return READINGS;
    }

    @GetMapping(path = "/{book}")
    @PreAuthorize("hasAnyAuthority('management:read')")
    public Readings getTheParticularData(@PathVariable("book") String book) {
        return READINGS.stream().filter(readings -> readings.getBook().equals(book))
                .findAny().orElseThrow(() -> new IllegalStateException("Unknown Books"));
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('management:write')")
    public String postData(@RequestBody Readings readings) {
        return readings.getBook()+ " is posted!";
    }
}
