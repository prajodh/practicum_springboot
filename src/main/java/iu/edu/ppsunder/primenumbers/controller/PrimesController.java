package iu.edu.ppsunder.primenumbers.controller;

import iu.edu.ppsunder.primenumbers.service.IPrimesService;
import iu.edu.ppsunder.primenumbers.service.PrimesService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/primes")
public class PrimesController {
    IPrimesService primesService;
    public PrimesController(IPrimesService primesService){

        this.primesService = primesService;

    }

    @GetMapping("/{n}")
    public boolean isPrime(@PathVariable int n){
        return primesService.isPrime(n);
    }
}
