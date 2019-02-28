package project;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileHandler {

    private Map<String, ObservableList<Entry>> tempMap = new HashMap<>();

    public FileHandler() {
        tempMap.put("IncomeList",EntryRepository.getIncomeList());
        tempMap.put("ExpensesList", EntryRepository.getExpenseList());
    }

    public void saveToDirectory(File directory) throws IOException {
        File selectedDirectory = new File(directory.getPath() + "/budget.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(selectedDirectory, tempMap);
    }

    public HashMap<String, List<Entry>> readFile(File file) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(file, new TypeReference<HashMap<String, List<Entry>>>(){});
    }
}
