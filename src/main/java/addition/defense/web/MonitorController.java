package addition.defense.web;

import addition.defense.models.dto.CreateMonitorDTO;
import addition.defense.models.dto.MonitorDTO;
import addition.defense.models.entity.Monitor;
import addition.defense.repository.MonitorRepository;
import addition.defense.service.MonitorService;
import addition.defense.service.impl.MonitorServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pcs")
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
    public ResponseEntity<MonitorDTO> createPc(@RequestBody CreateMonitorDTO createMonitorDTO){
        return ResponseEntity.ok().build();
    }
}
