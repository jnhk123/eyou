package kr.momjobgo.eyou.web.controller;

import kr.momjobgo.eyou.web.common.FileService;
import kr.momjobgo.eyou.web.jpa.entity.FileEntity;
import kr.momjobgo.eyou.web.jpa.repository.FileRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@RestController
@RequestMapping("/file")
public class FileController {

    private final FileService fileService;
    private final FileRepository fileRepository;

    public FileController(FileService fileService, FileRepository fileRepository) {
        this.fileService = fileService;
        this.fileRepository = fileRepository;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> upload(HttpServletRequest req, @RequestParam Long contentsId) {

        fileService.upload(req).forEach( file -> {
            System.out.println(file);
            file.setContentsId(contentsId);
            fileRepository.save(file);
        });

        return ResponseEntity.ok().body("FILE UPLOAD SUCCESS");
    }


    @GetMapping("/download")
    public void download(
            HttpServletRequest request, HttpServletResponse response, @RequestParam Long fileId
    ) throws IOException {
        Optional<FileEntity> optional = fileRepository.findById(fileId);
        if(optional.isPresent()){
            fileService.download(request, response, optional.get());
        } else {
            PrintWriter pw = response.getWriter();
            pw.println("FILE IS NOT EXIST");
        }
    }
}
