package id.ac.ui.cs.adpro.tutorial3.automata.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class LoggerRepositoryImpl implements LoggerRepository {

    private List<String> logs = new ArrayList<>();

    @Override
    public List<String> getLogs() {
        return logs;
    }

    @Override
    public void addRecord(String record) {
        logs.add(record);
    }
}
