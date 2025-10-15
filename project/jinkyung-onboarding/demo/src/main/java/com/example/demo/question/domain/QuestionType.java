package com.example.demo.question.domain;

import com.example.demo.question.domain.dto.UpdateItemQuestionDto;
import com.example.demo.utill.InputType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "QuestionType") //항목 입력형태
public class QuestionType{

    @Id
    @Column(name = "questionType_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionTypeId;


    //타입 추후 수정하기
    @Column(name = "inputType")
    private InputType inputType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;


    public static QuestionType toEntity(QuestionType itemOption) {
        return QuestionType.builder()
                .question(
                        ObjectUtils.isEmpty(itemOption)
                                ? null
                                : itemOption.getQuestion()
                )
                .inputType(itemOption.getInputType())
                .build();
    }

    public void updateItemQuestion(UpdateItemQuestionDto questionDto) {
            if (this.questionTypeId == questionDto.getQuestionNo()) {
                this.question = questionDto.getQuestion();
            }
    }
}



