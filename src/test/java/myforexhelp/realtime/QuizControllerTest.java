package myforexhelp.realtime;

import myforexhelp.realtime.controller.QuizController;
import myforexhelp.realtime.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Collections;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ActiveProfiles("test")
@WebMvcTest(QuizController.class)
@ContextConfiguration(classes = TestJpaConfig.class)
@ExtendWith(MockitoExtension.class)
public class QuizControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArticleRepository articleRepository;

    @InjectMocks
    private QuizController quizController;

    @Test
    public void testGetMainQuiz() throws Exception {
        when(articleRepository.findAll()).thenReturn(Collections.emptyList());

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(quizController).build();
        mockMvc.perform(get("/quiz/mainquiz"))
                .andExpect(status().isOk())
                .andExpect(view().name("mainquiz"))
                .andExpect(model().attributeExists("articles"));

        verify(articleRepository, times(1)).findAll();
        verifyNoMoreInteractions(articleRepository);
    }

    @Test
    public void testGetCandlestickQuiz() throws Exception {
//        when(articleRepository.findAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/quiz/candlestick"))
                .andExpect(status().isOk())
                .andExpect(view().name("candlestick"));
//                .andExpect(model().attributeExists("articles"));

//        verify(articleRepository, times(1)).findAll();
//        verifyNoMoreInteractions(articleRepository);
    }



    @Test
    public void testGetElliotWaveQuiz() throws Exception {
        when(articleRepository.findAll()).thenReturn(Collections.emptyList());

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(quizController).build();
        mockMvc.perform(get("/quiz/elliotwaves"))
                .andExpect(status().isOk())
                .andExpect(view().name("elliotwaves"))
                .andExpect(model().attributeExists("articles"));

        verify(articleRepository, times(1)).findAll();
        verifyNoMoreInteractions(articleRepository);
    }



    @Test
    public void testGetMoneyManagementQuiz() throws Exception {
        when(articleRepository.findAll()).thenReturn(Collections.emptyList());

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(quizController).build();
        mockMvc.perform(get("/quiz/moneymanagement"))
                .andExpect(status().isOk())
                .andExpect(view().name("moneymanagement"))
                .andExpect(model().attributeExists("articles"));

        verify(articleRepository, times(1)).findAll();
        verifyNoMoreInteractions(articleRepository);
    }

    @Test
    public void testGetCalculator() throws Exception {
        mockMvc.perform(get("/calculator"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"));
    }

}

