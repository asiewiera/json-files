package com.asiewiera.jsonfiles.reading;

import com.asiewiera.jsonfiles.dtos.TestDto;

import com.google.gson.Gson;
import com.sun.org.apache.xpath.internal.axes.FilterExprIteratorSimple;
import org.springframework.stereotype.Component;

import java.io.File;
import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Component
public class JsonParsing {
    private static Type listType = new TypeToken<ArrayList<TestDto>>() {
    }.getType();
    private static final String DIRECTORY = "files/";
    private static final String ARCHIVE_DIRECTORY = "files/archive/";

    public static List<TestDto> readJsonFile(String fileName) {
        List<TestDto> testDtoList = new ArrayList<>();
        try (FileReader reader = new FileReader(fileName)) {
            testDtoList = new Gson().fromJson(reader, listType);

  /*          Object object = jsonParser.parse(reader);
            JSONArray jsonArray = (JSONArray) object;
            for (Object o : jsonArray) {
                JSONObject jo = (JSONObject) o;
                TestDto testDto = (TestDto) o;
                testDtoList.add(testDto);
            }*/
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return testDtoList;
    }

    public static List<String> listFilesInDirectory() {
        List<String> result = new ArrayList<>();

        File folder = new File(DIRECTORY);
        result = Stream.of(Objects.requireNonNull(folder.listFiles()))
                .filter(file -> !file.isDirectory())
                .map(File::getPath)
                .filter(file->file.toLowerCase().endsWith("json"))
                .collect(Collectors.toList());
 /*       String[] files = folder.list();
        try (Stream<Path> walk = Files.walk(Paths.get(DIRECTORY))) {

            result = walk.filter(Files::isRegularFile)
                    .map(x -> x.toString()).filter(e->e.toLowerCase().endsWith("json")).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return result;

    }


    public static void moveFilesInDirectoryToArchive(List<String> files) {
        System.out.println("Files size: " + files.size());
        for (String filePath : files
        ) {
            Path sourcePath = Paths.get(filePath);
            String fileName = sourcePath.getFileName().toString();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Path   destPath = Paths.get(ARCHIVE_DIRECTORY + timestamp.toString() + fileName);
            try {
                System.out.println("Call: "+ sourcePath + " : " + destPath);
                Files.move(sourcePath, destPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
