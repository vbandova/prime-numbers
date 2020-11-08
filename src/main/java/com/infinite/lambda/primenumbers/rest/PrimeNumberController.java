package com.infinite.lambda.primenumbers.rest;

import com.infinite.lambda.primenumbers.service.PrimeNumberService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/vi/primes")
public class PrimeNumberController {

    private static final Logger logger = LoggerFactory.getLogger(PrimeNumberController.class);
    private final PrimeNumberService primeNumberService;

    public PrimeNumberController(PrimeNumberService numberService) {
        this.primeNumberService = numberService;
    }

    @ApiOperation(value = "Checks if given number is prime. Works with max value = 9223372036854775807", response = Boolean.class)
    @PostMapping("/check")
    public ResponseEntity<Boolean> checkPrime(@RequestParam long number) {
        logger.info("Checking if number {} is prime", number);
        boolean prime = primeNumberService.isPrime(number);
        return ResponseEntity.ok(prime);
    }

    @ApiOperation(value = "Finds next prime after number (including number). If not found we return -1. Works with max value = 9223372036854775807", response = Long.class)
    @GetMapping("/next")
    public ResponseEntity<Long> getNextPrime(@RequestParam long number) {
        logger.info("Finding next prime for number {}", number);
        long nextPrime = primeNumberService.getNextPrime(number);
        return ResponseEntity.ok(nextPrime);
    }


}
