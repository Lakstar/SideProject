package addition.defense.controller;

import addition.defense.models.dto.CreateMonitorDTO;
import addition.defense.models.dto.MonitorDTO;
import addition.defense.service.impl.MonitorServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitors")
public class MonitorController {
    private final MonitorServiceImpl monitorService;

    public MonitorController(MonitorServiceImpl monitorService) {
        this.monitorService = monitorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonitorDTO> getMonitorById(@PathVariable("id") Long id){

        return ResponseEntity.ok(monitorService.getById(id));
    }
    @GetMapping
    public ResponseEntity<List<MonitorDTO>> getAllMonitors(){
        return ResponseEntity.ok(
                monitorService.getAllMonitors()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MonitorDTO> deleteMonitorById(@PathVariable("id") Long id){
        monitorService.deleteMonitor(id);
        return ResponseEntity.ok().build();
    }


    @PostMapping
    public ResponseEntity<MonitorDTO> createMonitor(@Valid @RequestBody CreateMonitorDTO createMonitorDTO) {
        MonitorDTO createdMonitor = monitorService.createMonitor(createMonitorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMonitor);
    }
}
