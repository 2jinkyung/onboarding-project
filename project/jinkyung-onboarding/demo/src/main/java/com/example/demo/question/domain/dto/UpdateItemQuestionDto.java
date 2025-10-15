package com.example.demo.question.domain.dto;

import com.example.demo.question.domain.Question;
import com.example.demo.utill.InputType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateItemQuestionDto {

    private int questionNo;

    private InputType inputType;

    private Question question;

}
