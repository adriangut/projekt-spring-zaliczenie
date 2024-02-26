package zaliczenie.adriangut.projektspring.controller;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/property")
@AllArgsConstructor
public class PropertyController {
    private final Environment env;

    @GetMapping
    public ResponseEntity<String> getProperty(@RequestParam String propertyName) {
        String propertyValue = env.getProperty(propertyName);

        if (propertyValue != null) {
            return ResponseEntity.ok().body(propertyValue);
        }

        return ResponseEntity.notFound().build();
    }
}