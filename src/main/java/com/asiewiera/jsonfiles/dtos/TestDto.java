package com.asiewiera.jsonfiles.dtos;

import com.asiewiera.jsonfiles.entities.Answer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestDto {


    private String category;
    private String subCategory;
    private Boolean multiSelect;
    private String text;
    private List<Answer> answers;
    private String explanation;


    @Override
    public String toString() {
        return "TestDto{" +
                "category='" + category + '\'' +
                ", subCategory='" + subCategory + '\'' +
                ", multiSelect=" + multiSelect +
                ", text='" + text + '\'' +
                ", answers=" + answers +
                ", explanation='" + explanation + '\'' +
                '}' + "\n=========================================================================================================================================\n";
    }
}
