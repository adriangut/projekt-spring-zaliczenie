package zaliczenie.adriangut.projektspring.service;

import org.springframework.context.annotation.Profile;
import zaliczenie.adriangut.projektspring.model.Blogpost;
import org.springframework.stereotype.Service;
import zaliczenie.adriangut.projektspring.model.BlogpostDTO;

import java.util.*;

@Service
@Profile("dao")
public class DAOBlogpostService implements BlogpostService {
    private int idValue = 0;
    private final List<Blogpost> blogposts = new ArrayList<>();

    @Override
    public List<Blogpost> getAllBlogposts() {
        return blogposts;
    }

    @Override
    public Blogpost getBlogpostById(Long id) {
        return blogposts.stream()
                .filter(blogpost -> blogpost.getId().equals(id))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Blogpost createBlogpost(BlogpostDTO blogpost) {
        // this is an in memory database and will not have collisions
        // caused by a predictable sequence of integers
        idValue += 1;
        int storedIdValue = idValue;

        Blogpost newBlogpost = Blogpost.builder()
                .id(Long.getLong(Integer.toString(storedIdValue)))
                .title(blogpost.getTitle())
                .content(blogpost.getContent())
                .created(blogpost.getCreated())
                .updated(blogpost.getUpdated())
                .build();

        blogposts.add(newBlogpost);

        return newBlogpost;
    }

    @Override
    public Blogpost updateBlogpost(Long id, BlogpostDTO blogpost) {
        Blogpost blogpostToUpdate = getBlogpostById(id);

        blogpostToUpdate.setTitle(blogpost.getTitle());
        blogpostToUpdate.setContent(blogpost.getContent());
        blogpostToUpdate.setUpdated(blogpost.getUpdated());

        return blogpostToUpdate;
    }

    @Override
    public void deleteBlogpost(Long id) {
        blogposts.remove(getBlogpostById(id));
    }

}