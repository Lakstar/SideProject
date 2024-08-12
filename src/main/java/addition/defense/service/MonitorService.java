package addition.defense.service;

import addition.defense.models.dto.CreateMonitorDTO;
import addition.defense.models.dto.MonitorDTO;
import addition.defense.models.entity.Monitor;

import java.util.List;
import java.util.Optional;

public interface MonitorService {
    MonitorDTO createMonitor(CreateMonitorDTO createMonitorDTO);
    List<MonitorDTO> getAllMonitors();

    void deleteMonitor(long monitorId);

    MonitorDTO getById(Long id);
}
