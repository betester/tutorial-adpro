package id.ac.ui.cs.adpro.tutorial3.automata.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.stereotype.Repository;
import org.springframework.test.util.ReflectionTestUtils;

@Repository
public class LoggerRepositoryTest {
    private LoggerRepository loggerRepository;

    @Mock
    private List<String> logs;

    @BeforeEach
    public void setUp(){
        loggerRepository = new LoggerRepositoryImpl();
        logs = new ArrayList<>();
        logs.add("Ganyu: Lifting box with mechanical arms");
    }

    @Test
    public void whenLoggerRepositoryGetLogsReturnAllLogs() {
        ReflectionTestUtils.setField(loggerRepository, "logs", logs);
        List<String> acquiredLogs = loggerRepository.getLogs();
        assertThat(acquiredLogs).isEqualTo(logs);
    }

    @Test
    public void whenLoggerRepositoryAddRecordItShouldSaveRecord() {
        ReflectionTestUtils.setField(loggerRepository, "logs", logs);
        String newLogs = "ZhongLi: Push a rock with his spear";
        loggerRepository.addRecord(newLogs);
        List<String> acquiredLogs = loggerRepository.getLogs();

        assertThat(acquiredLogs).isEqualTo(logs);
        assertThat(logs.get(1)).isEqualTo(newLogs);
    }
}
