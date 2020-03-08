package com.asiewiera.jsonfiles.reading;

import com.asiewiera.jsonfiles.dtos.TestDto;
import com.asiewiera.jsonfiles.services.TestService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class DataBaseUpdate {

    @Autowired
    private TestService testService;

    @Scheduled(fixedRate = 3600000)
    public synchronized void update() {
        List<String> fileNames = JsonParsing.listFilesInDirectory();
        List<TestDto> testDtoList = new ArrayList<>();
        for (String file : fileNames
        ) {
            testDtoList.addAll(JsonParsing.readJsonFile(file));
        }
        for (TestDto testDto : testDtoList
        ) {
            testService.save(testDto);
        }
        System.out.println("Moving Call");
        JsonParsing.moveFilesInDirectoryToArchive(fileNames);
    }
}
