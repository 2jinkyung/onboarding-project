package com.example.demo.question.domain.dto;

import com.example.demo.utill.InputType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateItemDto {

    private int itemNo;

    private String itemName;

    private String itemDescription;


    private InputType inputType;

    private List<UpdateItemQuestionDto> itemQuestionList;

    private boolean isRequired;

}
