package myforexhelp.realtime;

import myforexhelp.realtime.controller.PostArticleController;
import myforexhelp.realtime.domain.Article;
import myforexhelp.realtime.domain.UpdatedArticleDTO;
import myforexhelp.realtime.repository.ArticleRepository;
import myforexhelp.realtime.service.SearchingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class PostArticleControllerTest {

    @Mock
    private ArticleRepository articleRepository;

    @Mock
    private SearchingService searchingService;

    @Mock
    private Model model;

    @InjectMocks
    private PostArticleController postArticleController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddArticle() {
        String title = "Test Article";
        String description = "Test Description";
        String content = "Test Content";

        // Create an Article object
        Article article = new Article();
        article.setTitle(title);
        article.setDescription(description);
        article.setContent(content);

        // Mock the articleRepository.save() method to return the created article
        when(articleRepository.save(any())).thenReturn(article);

        // Call the controller method
        String result = postArticleController.addArticle(title, description, content);

        // Verify that the articleRepository.save() method was called once with the correct article
        verify(articleRepository, times(1)).save(any(Article.class));

        // Check if the result of the controller method is correct
        assertEquals("pageForManaging", result);
    }

    @Test
    void testDeleteArticle() {
        Long articleId = 1L;

        // Call the controller method
        String result = postArticleController.deleteArticle(articleId);

        // Verify that the articleRepository.deleteById() method was called once with the correct ID
        verify(articleRepository, times(1)).deleteById(articleId);

        // Check if the result of the controller method is correct
        assertEquals("pageForManaging", result);
    }

    @Test
    void testGetForUpdate() {
        Long articleId = 1L;

        // Create a mock Article object
        Article mockArticle = new Article();
        mockArticle.setId(articleId);
        mockArticle.setTitle("Test Article");
        mockArticle.setDescription("Test Description");
        mockArticle.setContent("Test Content");

        // Create a list of mock Article objects
        List<Object[]> allArticles = new ArrayList<>();
        allArticles.add(new Object[]{mockArticle.getId(), mockArticle.getTitle(), mockArticle.getDescription(), mockArticle.getContent()});

        // Mock the searchingService.articleConverter() method to return the list of mock Article objects
        when(searchingService.getTitleDescriptionAndContentByid()).thenReturn(allArticles);

        // Create a mock Model
        Model mockModel = mock(Model.class);

        // Call the controller method
        String result = postArticleController.getForUpdate(articleId, mockModel);

        // Verify that the searchingService.articleConverter() method was called once
        verify(searchingService, times(1)).getTitleDescriptionAndContentByid();

        // Verify that the model.addAttribute() method was called once with the correct article data
        verify(mockModel, times(1)).addAttribute(eq("articles"), any(UpdatedArticleDTO.class));

        // Check if the result of the controller method is correct
        assertEquals("templateForOneArticle", result);
    }

    @Test
    void testGetForUpdateArticleNotFound() {
        Long articleId = 1L;

        // Create an empty list of articles
        List<Object[]> allArticles = new ArrayList<>();

        // Mock the searchingService.articleConverter() method to return the empty list
        when(searchingService.getTitleDescriptionAndContentByid()).thenReturn(allArticles);

        // Create a mock Model
        Model mockModel = mock(Model.class);

        // Call the controller method
        String result = postArticleController.getForUpdate(articleId, mockModel);

        // Verify that the searchingService.articleConverter() method was called once
        verify(searchingService, times(1)).getTitleDescriptionAndContentByid();

        // Verify that the model.addAttribute() method was not called
        verify(mockModel, never()).addAttribute(anyString(), any());

        // Check if the result of the controller method is correct
        assertEquals("articleDoesNotExists", result);
    }

    @Test
    void testUpdateArticle() {
        Long articleId = 1L;

        // Create a mock Article object
        Article mockArticle = new Article();
        mockArticle.setId(articleId);
        mockArticle.setTitle("Test Article");
        mockArticle.setDescription("Test Description");
        mockArticle.setContent("Test Content");

        // Mock the articleRepository.findById() method to return the mock Article object
        when(articleRepository.findById(articleId)).thenReturn(Optional.of(mockArticle));

        // Mock the articleRepository.save() method to return the updated article
        when(articleRepository.save(any())).thenReturn(mockArticle);

        // Create a mock UpdatedArticleDTO object
        UpdatedArticleDTO updatedArticleDTO = new UpdatedArticleDTO();
        updatedArticleDTO.setTitle("Updated Article");
        updatedArticleDTO.setDescription("Updated Description");
        updatedArticleDTO.setContent("Updated Content");

        // Call the controller method
        String result = postArticleController.updateArticle(articleId, updatedArticleDTO);

        // Verify that the articleRepository.findById() method was called once with the correct ID
        verify(articleRepository, times(1)).findById(articleId);

        // Verify that the articleRepository.save() method was called once with the correct article
        verify(articleRepository, times(1)).save(any(Article.class));

        // Check if the result of the controller method is correct
        assertEquals("pageForManaging", result);
    }

    @Test
    void testUpdateArticleNotFound() {
        Long articleId = 1L;

        // Mock the articleRepository.findById() method to return an empty Optional
        when(articleRepository.findById(articleId)).thenReturn(Optional.empty());

        // Create a mock UpdatedArticleDTO object
        UpdatedArticleDTO updatedArticleDTO = new UpdatedArticleDTO();
        updatedArticleDTO.setTitle("Updated Article");
        updatedArticleDTO.setDescription("Updated Description");
        updatedArticleDTO.setContent("Updated Content");

        // Call the controller method and expect a RuntimeException
        RuntimeException exception = assertThrows(RuntimeException.class, () -> postArticleController.updateArticle(articleId, updatedArticleDTO));

        // Verify that the articleRepository.findById() method was called once with the correct ID
        verify(articleRepository, times(1)).findById(articleId);

        // Verify that the articleRepository.save() method was not called
        verify(articleRepository, never()).save(any(Article.class));

        // Check if the exception message is correct
        assertEquals("Article not found", exception.getMessage());
    }
}

