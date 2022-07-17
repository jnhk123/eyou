package kr.momjobgo.eyou.web.controller;


import kr.momjobgo.eyou.web.service.ContentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contents")
public class ContentsController {
    private final ContentsService contentsService;

    public ContentsController(ContentsService contentsService) { this.contentsService = contentsService; }

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body( contentsService.getAll() );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) { return ResponseEntity.ok().body( contentsService.getById(id) ); }

    @GetMapping("/writer={writer}")
    public ResponseEntity<?> getByWriter(@PathVariable Long writer) { return ResponseEntity.ok().body( contentsService.getByWriter(writer) ); }

}
