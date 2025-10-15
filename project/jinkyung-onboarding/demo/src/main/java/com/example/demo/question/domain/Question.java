package com.example.demo.question.domain;

import com.example.demo.question.domain.dto.UpdateItemDto;
import com.example.demo.survey.domain.Survey;
import com.example.demo.utill.InputType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "question")
public class Question {

    @Id
    @Column(name = "question_id")
    @Comment("아이디")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

//    @Column(name = "question_no")
//    @Comment("항목 번호")
//    private int questionNo;

    @Column(name = "question_name")
    @Comment("항목 이름")
    private String questionName;

    @Column(name = "question_description")
    @Comment("항목 설명")
    private String questionDescription;

    @Column(name = "is_required")
    private boolean isRequired;

    @OneToMany(mappedBy = "question",fetch = FetchType.LAZY)
    private List<QuestionType> questionType;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;

    @CreationTimestamp
    @Column(name = "create_at")
    private LocalDateTime createAt;

    private LocalDateTime updateAt;



    public class QuestionTypeDto{
        private InputType inputType;
    }

    public void updateItem(UpdateItemDto updateItemDto) {
        if(updateItemDto.getItemName() != null ) this.questionName = updateItemDto.getItemName();
        if(updateItemDto.getItemDescription() != null ) this.questionDescription = updateItemDto.getItemDescription();
        this.isRequired = updateItemDto.isRequired();

//        if(updateItemDto.getItemQuestionList() != null) {
//           QuestionType question = questionType.stream()
//                   .filter(itemQuestion1 -> itemQuestion1.getQuestionNo() == updateItemDto.getItemNo())
//                   .findFirst()
//                   .orElseThrow(() -> new IllegalArgumentException("QuestionType not found for itemNo: " + updateItemDto.getItemNo()));
////            question.updateItemQuestion(updateItemDto.getItemQuestionList());
//
//        }
        this.updateAt = LocalDateTime.now();
    }
}



