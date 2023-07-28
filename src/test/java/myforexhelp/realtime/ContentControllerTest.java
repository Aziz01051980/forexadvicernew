package myforexhelp.realtime;

import myforexhelp.realtime.controller.ContentController;
import myforexhelp.realtime.domain.NameAndEmail;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import myforexhelp.realtime.domain.Article;
import myforexhelp.realtime.domain.ArticleDTO;
import myforexhelp.realtime.repository.ArticleRepository;
import myforexhelp.realtime.repository.NameAndEmailRepository;
import myforexhelp.realtime.service.SearchingService;
import myforexhelp.realtime.service.SendingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ContentControllerTest {

    @Mock
    private ArticleRepository articleRepository;

    @Mock
    private NameAndEmailRepository nameAndEmailRepository;

    @Mock
    private SendingService sendingService;

    @Mock
    private SearchingService searchingService;

    @InjectMocks
    private ContentController contentController;

    public ContentControllerTest() {
    }

    public void setContentController(ContentController contentController) {
        this.contentController = contentController;
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        contentController.setNameAndEmailRepository(nameAndEmailRepository);
        contentController.setSendingService(sendingService);
    }


    @Test
    void testGetAllArticles() {
        // Mocking the data to be returned by the searchingService.articleConverter() method
        List<Object[]> mockArticleDataList = new ArrayList<>();
        Object[] mockArticleData = new Object[]{1L, "Title", "Description"};
        mockArticleDataList.add(mockArticleData);
        when(searchingService.articleConverter()).thenReturn(mockArticleDataList);

        // Mock the conversion from articleData to ArticleDTO
        List<ArticleDTO> mockArticleDTOList = new ArrayList<>();
        mockArticleDTOList.add(new ArticleDTO(1L, "Title", "Description"));

        // Create a mock Model
        Model model = mock(Model.class);

        // Test the controller method
        String viewName = contentController.getAllArticles(model);

        // Verify that the necessary methods were called and the model was populated correctly
        verify(searchingService, times(1)).articleConverter();
        verify(model, times(1)).addAttribute(eq("articles"), eq(mockArticleDTOList));
        assertEquals("allArticles", viewName);
    }

    @Test
    void testGetSelectedArticle() {
        // Mock the data to be returned by the searchingService.getContentOfArticleById() method
        Article mockArticle = new Article();
        mockArticle.setId(1L);
        mockArticle.setTitle("Title");
        mockArticle.setDescription("Description");

        // Use thenReturn() to directly return the Article object in an array of Object[]
        doReturn(new Object[]{mockArticle}).when(searchingService).getContentOfArticleById(1L);

        // Create a mock Model
        Model model = mock(Model.class);

        // Test the controller method
        String viewName = contentController.getSelectedArticle(1L, model);

        // Verify that the necessary methods were called and the model was populated correctly
        verify(searchingService, times(1)).getContentOfArticleById(1L);

        // Pass the Object[] directly to addAttribute method without an extra array (correct implementation)
        verify(model, times(1)).addAttribute(eq("article"), eq(new Object[]{mockArticle}));
        assertEquals("selectedArticle", viewName);
    }

    @Test
    void testGetFormForClientMessage() {
        // Create a mock Model
        Model model = mock(Model.class);

        // Test the controller method
        String viewName = contentController.getFormForClientMessage(model);

        // Verify that the necessary methods were called and the model was populated correctly
        verify(model, times(1)).addAttribute(eq("article"), any(Article.class));
        assertEquals("mailFromClient", viewName);
    }

    @Test
    void testSendingClientMail() {
        // Mock the request parameters
        String mail = "client@example.com";
        String subject = "Test Subject";
        String textOfTheMail = "Test mail content";

        // Create a mock NameAndEmailRepository
        NameAndEmailRepository mockNameAndEmailRepository = mock(NameAndEmailRepository.class);

        // Set the mockNameAndEmailRepository in the contentController
        contentController.setNameAndEmailRepository(mockNameAndEmailRepository);

        // Create a mock SendingService
        SendingService mockSendingService = mock(SendingService.class);

        // Set the mockSendingService in the contentController
        contentController.setSendingService(mockSendingService);

        // Test the controller method
        String viewName = contentController.sendingClienMail(mail, subject, textOfTheMail);

        // Verify that the necessary methods were called and the repository was updated
        verify(mockNameAndEmailRepository, times(1)).save(any(NameAndEmail.class));
        verify(mockSendingService, times(1)).gettingMailFromClient(mail, subject, textOfTheMail);
        assertEquals("homepage", viewName);
    }
}





