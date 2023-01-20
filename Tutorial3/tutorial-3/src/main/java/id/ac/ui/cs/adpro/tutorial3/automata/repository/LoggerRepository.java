package id.ac.ui.cs.adpro.tutorial3.automata.repository;

import java.util.List;

public interface LoggerRepository {

    List<String> getLogs();

    void addRecord(String record);
}
