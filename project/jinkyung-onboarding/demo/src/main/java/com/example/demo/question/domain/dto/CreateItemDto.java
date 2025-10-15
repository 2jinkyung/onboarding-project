package com.example.demo.question.domain.dto;

import com.example.demo.question.domain.Question;
import com.example.demo.question.domain.QuestionType;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateItemDto {

    @NotNull
    private String questionName;

    private String questionDescription;

    private List<QuestionType> itemQuestionList;

    @NotNull
    private boolean isRequired;

    public Question toEntity(){
        return Question.builder()
                .questionName(this.questionName)
                .questionDescription(this.questionDescription)
                .questionType(
                                itemQuestionList.stream()
                                    .map(
                                        QuestionType::toEntity
                                    ).collect(Collectors.toList())

                )
                .isRequired(this.isRequired)
                .build();
    }



}
