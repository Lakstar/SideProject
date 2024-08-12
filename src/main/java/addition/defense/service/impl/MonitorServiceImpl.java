package addition.defense.service.impl;

import addition.defense.models.dto.CreateMonitorDTO;
import addition.defense.models.dto.MonitorDTO;
import addition.defense.models.entity.Monitor;
import addition.defense.repository.MonitorRepository;
import addition.defense.service.MonitorService;
import addition.defense.service.exception.MonitorNotFoundException;
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
    public MonitorDTO createMonitor(CreateMonitorDTO createMonitorDTO) {
        Monitor monitor = new Monitor();
        monitor.setName(createMonitorDTO.getName());
        monitor.setInches(createMonitorDTO.getInches());
        monitor.setDescription(createMonitorDTO.getDescription());

        Monitor savedMonitor = monitorRepository.save(monitor);
        return map(savedMonitor);
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
        if (!monitorRepository.existsById(monitorId)) {
            throw new MonitorNotFoundException("Monitor with ID " + monitorId + " not found.");
        }
        monitorRepository.deleteById(monitorId);
    }

    @Override
    public MonitorDTO getById(Long id) {
        return monitorRepository.findById(id)
                .map(MonitorServiceImpl::map)
                .orElseThrow(() -> new MonitorNotFoundException("Not found!"));

    }

    private static MonitorDTO map(Monitor monitor){
        return new MonitorDTO(
                monitor.getId(),
                monitor.getName(),
                monitor.getInches(),
                monitor.getDescription());
    }

    @Override
    public MonitorDTO updateMonitor(Long id, CreateMonitorDTO updateMonitorDTO) {
        Monitor existingMonitor = monitorRepository.findById(id)
                .orElseThrow(() -> new MonitorNotFoundException("Monitor with ID " + id + " not found."));

        existingMonitor.setName(updateMonitorDTO.getName());
        existingMonitor.setInches(updateMonitorDTO.getInches());
        existingMonitor.setDescription(updateMonitorDTO.getDescription());

        Monitor updatedMonitor = monitorRepository.save(existingMonitor);
        return map(updatedMonitor);
    }

}
