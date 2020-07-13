package by.ipps.client.controller;

import by.ipps.client.entity.ElectronicAppeal;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/electronicAppeal")
@Log4j2
@CrossOrigin
public class ElectronicAppealController {
    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity send(
            @ModelAttribute ElectronicAppeal electronicAppeal){
        log.info(electronicAppeal.toString());
        try{
            log.info(electronicAppeal.getFile()[0].getOriginalFilename());
        }catch (NullPointerException ignore){
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
