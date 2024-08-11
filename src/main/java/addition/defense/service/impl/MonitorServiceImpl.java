package addition.defense.service.impl;

import addition.defense.models.dto.CreateMonitorDTO;
import addition.defense.models.dto.MonitorDTO;
import addition.defense.models.entity.Monitor;
import addition.defense.repository.MonitorRepository;
import addition.defense.service.MonitorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonitorServiceImpl implements MonitorService {

    private final MonitorRepository monitorRepository;

    public MonitorServiceImpl(MonitorRepository monitorRepository) {
        this.monitorRepository = monitorRepository;
    }

    @Override
    public void createMonitor(CreateMonitorDTO createMonitorDTO) {

    }

    @Override
    public List<MonitorDTO> getAllMonitors() {
        return monitorRepository
                .findAll().stream()
                .map(MonitorServiceImpl::map)
                .toList();
    }

    @Override
    public void deleteMonitor(long monitorId) {
        monitorRepository.deleteById(monitorId);
    }

    @Override
    public MonitorDTO getById(Long id) {
        return monitorRepository.findById(id)
                .map(MonitorServiceImpl::map)
                .orElseThrow(() -> new IllegalArgumentException("Not found!"));

    }

    private static MonitorDTO map(Monitor monitor){
        return new MonitorDTO(
                monitor.getId(),
                monitor.getName(),
                monitor.getInches(),
                monitor.getDescription());
    }

}
