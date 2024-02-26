package zaliczenie.adriangut.projektspring.service;

import org.junit.jupiter.api.Test;
import zaliczenie.adriangut.projektspring.model.Blogpost;
import zaliczenie.adriangut.projektspring.model.BlogpostDTO;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.time.LocalDateTime;

class DAOBlogpostServiceTest {
    @Test
    void testCreateBlogpost() {
        // Arrange
        DAOBlogpostService daoBlogpostService = new DAOBlogpostService();
        BlogpostDTO blogpostDto = new BlogpostDTO();
        blogpostDto.setTitle("Test Title");
        blogpostDto.setContent("Test Content");
        blogpostDto.setCreated(LocalDateTime.now());

        // Act
        Blogpost createdBlogpost = daoBlogpostService.createBlogpost(blogpostDto);

        // Assert
        assertThat(createdBlogpost).isNotNull();
        assertThat(createdBlogpost.getTitle()).isEqualTo("Test Title");
        assertThat(createdBlogpost.getContent()).isEqualTo("Test Content");
        assertThat(createdBlogpost.getCreated()).isNotNull();
    }
    
    @Test
    void testNoTitleBlogpostCreate() {
        // Arrange
        BlogpostDTO blogpostDto = new BlogpostDTO();

        // Act & Assert
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> blogpostDto.setTitle(null))
                .withMessageContaining("title is marked non-null but is null");
    }
    
    @Test
    void testNoContentBlogpostCreate() {
        // Arrange
        BlogpostDTO blogpostDto = new BlogpostDTO();

        // Act & Assert
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> blogpostDto.setContent(null))
                .withMessageContaining("content is marked non-null but is null");
    }
    
    @Test
    void testNoCreatedTimeBlogpostCreate() {
        // Arrange
        BlogpostDTO blogpostDto = new BlogpostDTO();

        // Act & Assert
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> blogpostDto.setCreated(null))
                .withMessageContaining("created is marked non-null but is null");
    }
}