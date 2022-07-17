package kr.momjobgo.eyou.web.controller;

import kr.momjobgo.eyou.web.service.TimeTakenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/time-taken")
public class TimeTakenController {
    private final TimeTakenService timeTakenService;

    public TimeTakenController(TimeTakenService timeTakenService) { this.timeTakenService = timeTakenService; }

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body( timeTakenService.getAll() );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) { return ResponseEntity.ok().body( timeTakenService.getById(id) ); }

}
