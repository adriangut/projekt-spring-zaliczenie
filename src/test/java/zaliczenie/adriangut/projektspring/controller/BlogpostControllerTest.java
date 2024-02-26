package zaliczenie.adriangut.projektspring.controller;

import zaliczenie.adriangut.projektspring.model.Blogpost;
import zaliczenie.adriangut.projektspring.service.H2BlogpostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BlogpostControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private H2BlogpostService service;

    @Test
    public void getAllBlogposts() throws Exception {
        // given
        given(service.getAllBlogposts()).willReturn(List.of(new Blogpost()));

        // when + then
        mvc.perform(get("/api/blogposts")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}