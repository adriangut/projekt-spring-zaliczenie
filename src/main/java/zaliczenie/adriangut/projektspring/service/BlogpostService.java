package zaliczenie.adriangut.projektspring.service;

import zaliczenie.adriangut.projektspring.model.Blogpost;
import zaliczenie.adriangut.projektspring.model.BlogpostDTO;

import java.util.List;

public interface BlogpostService {
    List<Blogpost> getAllBlogposts();
    Blogpost getBlogpostById(Long id);
    public Blogpost createBlogpost(BlogpostDTO blogpost);
    public Blogpost updateBlogpost(Long id, BlogpostDTO blogpost);
    public void deleteBlogpost(Long id);
}