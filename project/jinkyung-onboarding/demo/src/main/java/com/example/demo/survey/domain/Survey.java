package com.example.demo.survey.domain;

import com.example.demo.answer.domain.Answer;
import com.example.demo.question.domain.Question;
import com.example.demo.survey.domain.dto.UpdateSurveyDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "survey")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_id")
    @Comment("설문조사 ID")
    private Long surveyId;

    @Column(name = "name")
    @Comment("설문조사 이름")
    private String name;

    @Column(name = "description")
    @Comment("설문조사 설명")
    private String description;

    @OneToMany(mappedBy = "survey",fetch = FetchType.LAZY)
    @Comment("설문받을 항목")
    private List<Question> questions = new ArrayList<>();

    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "create_at")
    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    public void updateSurvey(UpdateSurveyDTO updateSurveyDTO) {
        if(updateSurveyDTO.getName() != null) this.name = updateSurveyDTO.getName();
        if(updateSurveyDTO.getDescription() != null) this.description = updateSurveyDTO.getDescription();
//        updateSurveyDTO.getQuestions().forEach(itemDto -> {
//            Question question = questions.stream()
//                    .filter(i -> i.getItemNo() == (itemDto.getItemNo()))
//                    .findFirst()
//                    .orElseThrow(() -> new IllegalArgumentException("Question not found"));
//            question.updateItem(itemDto);
//        });


        this.createAt = LocalDateTime.now();
    }

}
