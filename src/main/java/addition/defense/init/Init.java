package addition.defense.init;

import addition.defense.models.entity.Monitor;
import addition.defense.repository.MonitorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Init implements CommandLineRunner {
    private final MonitorRepository monitorRepository;

    public Init(MonitorRepository monitorRepository) {
        this.monitorRepository = monitorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
