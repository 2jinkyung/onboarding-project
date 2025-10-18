package com.example.demo;

import com.example.demo.answer.service.AnswerService;
import com.example.demo.question.domain.QuestionType;
import com.example.demo.question.domain.dto.CreateItemDto;
import com.example.demo.survey.domain.Survey;
import com.example.demo.survey.domain.dto.CreateSurveyDTO;
import com.example.demo.survey.domain.dto.SurveyDto;
import com.example.demo.survey.service.SurveyService;
import com.example.demo.utill.InputType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
class DemoApplicationTests {

	@Autowired
	private SurveyService surveyService;

	@Autowired
	private AnswerService answerService;

	@Test
	@DisplayName("설문조사 생성 테스트")
	void createSurvey() {
		CreateSurveyDTO dto = new CreateSurveyDTO();
		List<CreateItemDto> itemList = new ArrayList<CreateItemDto>();
		dto.setName("사람들이 선호하는 여행지 설문조사");
		dto.setDescription("사람들의 선호/비선호 여행지를 조사한다.");

		//항목1 입력
		CreateItemDto createItemDto1 = new CreateItemDto();
		createItemDto1.setQuestionName("산과 바다중 선호하는 여행지는?");
		createItemDto1.setQuestionDescription("단답형으로 입력해주세요");

		QuestionType questionType1 = new QuestionType();
		questionType1.setInputType(InputType.ShortAnswerType);

		createItemDto1.setItemQuestionList(List.of(questionType1));
		
		itemList.add(createItemDto1);
		dto.setItems(itemList);
		Long result = surveyService.create(dto);

		Survey survey= surveyService.findSurvey(result);
		Assertions.assertThat(result).isEqualTo(survey.getSurveyId());

	}


//	@Test
//	void createAnswer() {
//		CreateAnswerDto dto = new CreateAnswerDto();
//		dto.setName("이진경");
//		List<CreateItemAnswerDto> itemAnswerDtoList = new ArrayList<>();
//		CreateItemAnswerDto itemAnswerDto1 = new CreateItemAnswerDto(1, "바다", false);
//		CreateItemAnswerDto itemAnswerDto2 = new CreateItemAnswerDto(2, "산", false);
//		itemAnswerDtoList.add(itemAnswerDto1);
//		itemAnswerDtoList.add(itemAnswerDto2);
//
//		dto.setItgit emAnswers(itemAnswerDtoList);
//		Survey survey= surveyService.findSurvey(1L);
//		answerService.createAnswer(survey,dto);
//	}
}
