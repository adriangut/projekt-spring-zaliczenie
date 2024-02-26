package zaliczenie.adriangut.projektspring.service;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import zaliczenie.adriangut.projektspring.mapper.BlogpostMapper;
import zaliczenie.adriangut.projektspring.model.Blogpost;
import zaliczenie.adriangut.projektspring.model.BlogpostDTO;
import zaliczenie.adriangut.projektspring.repository.BlogpostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Profile("h2")
@AllArgsConstructor
public class H2BlogpostService implements BlogpostService {
    private final BlogpostRepository blogpostRepository;
    private final BlogpostMapper blogpostMapper;

    @Override
    public List<Blogpost> getAllBlogposts() {
        return blogpostRepository.findAll();
    }

    @Override
    public Blogpost getBlogpostById(Long id) {
        return blogpostRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Blogpost createBlogpost(BlogpostDTO blogpost){
        if (blogpost == null) {
            throw new NullPointerException("Blogpost must be provided");
        }
        return blogpostRepository.save(blogpostMapper.toEntity(blogpost));
    }

    @Override
    public Blogpost updateBlogpost(Long id, BlogpostDTO blogpost) {
        if (blogpostRepository.findById(id).isPresent()) {
            return blogpostRepository.save(blogpostMapper.toEntity(blogpost));
        } else {
            throw new NoSuchElementException("Blogpost not found");
        }
    }

    @Override
    public void deleteBlogpost(Long id){
        blogpostRepository.deleteById(id);
    }
}