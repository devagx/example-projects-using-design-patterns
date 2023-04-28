package oem.importer.controllers;

import oem.importer.domain.File;
import oem.importer.services.OemServiceImpl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class OemController {
    private final OemServiceImpl oemServiceImpl;

    public OemController(OemServiceImpl oemServiceImpl) {
        this.oemServiceImpl = oemServiceImpl;
    }

    @PostMapping("/import")
    ResponseEntity<String> importFile(@RequestBody File file) {
        String result = oemServiceImpl.parse(file);

        if (result.equalsIgnoreCase("INVALID PARSER")) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.created(URI.create("/import/")).body(result);
    }
}
