package myforexhelp.realtime;

import myforexhelp.realtime.controller.ArticleController;
import myforexhelp.realtime.domain.Article;
import myforexhelp.realtime.repository.ArticleRepository;
import myforexhelp.realtime.service.SendingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ArticleControllerTest {

    @Mock
    private ArticleRepository articleRepository;

    @Mock
    private SendingService sendingService;

    @Mock
    private Model model;

    @InjectMocks
    private ArticleController articleController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
//        homePageController.setNameAndEmailRepository(nameAndEmailRepository);
//        nameAndEmailRepository.deleteAll();
    }

    @Test
    void testGetAdminPanel() {
        // Call the controller method
        String result = articleController.getAdminPanel(model);

        // Verify that the model.addAttribute() method was called once with a new Article object
        verify(model, times(1)).addAttribute(eq("article"), any(Article.class));

        // Check if the result of the controller method is correct
        assertEquals("adminPanel", result);
    }

    @Test
    void testAddNameAndEmail() {
        String subject = "Test Subject";
        String textOfTheMail = "Test Text";

        // Call the controller method
        String result = articleController.addNameAndEmail(subject, textOfTheMail);

        // Verify that the sendingService.sendMailToRecipient() method was called once with the correct subject and text
        verify(sendingService, times(1)).sendMailToRecipient(subject, textOfTheMail);

        // Check if the result of the controller method is correct
        assertEquals("allArticles", result);
    }

    @Test
    void testCreateArticleForSend() {
        // Call the controller method
        String result = articleController.createArticleForSend();

        // Check if the result of the controller method is correct
        assertEquals("createArticleForSend", result);
    }
}

