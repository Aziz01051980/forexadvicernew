package myforexhelp.realtime;

import myforexhelp.realtime.controller.HomePageController;
import myforexhelp.realtime.domain.NameAndEmail;
import myforexhelp.realtime.repository.NameAndEmailRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class HomePageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private NameAndEmailRepository nameAndEmailRepository;

    @InjectMocks
    private HomePageController homePageController;

    public void setMockMvc(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    public void setHomePageController(HomePageController homePageController) {
        this.homePageController = homePageController;
    }

    public void setNameAndEmailRepository(NameAndEmailRepository nameAndEmailRepository) {
        this.nameAndEmailRepository = nameAndEmailRepository;
    }

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        homePageController.setNameAndEmailRepository(nameAndEmailRepository);
        nameAndEmailRepository.deleteAll();
    }


    @Transactional
    @Rollback(value = true)
    @Test
    public void testGetHomePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("homepage"));
    }

    @Transactional
    @Rollback(value = true)
    @Test
    public void testGetAboutPage() throws Exception {
        mockMvc.perform(get("/about"))
                .andExpect(status().isOk())
                .andExpect(view().name("about"));
    }

    @Transactional
//    @Rollback(value = false)
    @Test
    public void testAddNameAndEmail() throws Exception {
        String email = "test@example.com";

        mockMvc.perform(post("/addNameandEmail")
                        .param("email", email))
                .andExpect(status().isOk())
                .andExpect(view().name("homepage"));

        // Verify that the data is saved to the repository
        List<String> savedNameAndEmails = nameAndEmailRepository.findAllMails();
        assertNotNull(savedNameAndEmails);

        System.out.println("Saved emails: " + savedNameAndEmails);

        assertTrue(savedNameAndEmails.contains(email));
    }
}
