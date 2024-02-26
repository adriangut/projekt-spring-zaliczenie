package zaliczenie.adriangut.projektspring.controller;

import zaliczenie.adriangut.projektspring.model.Blogpost;
import zaliczenie.adriangut.projektspring.model.BlogpostDTO;
import zaliczenie.adriangut.projektspring.service.H2BlogpostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogposts")
public class BlogpostController {
    private final H2BlogpostService blogpostService;

    @Autowired
    public BlogpostController(H2BlogpostService blogpostService) {
        this.blogpostService = blogpostService;
    }

    @GetMapping
    public List<Blogpost> getAllBlogposts() {
        return blogpostService.getAllBlogposts();
    }

    @GetMapping("/{id}")
    public Blogpost getBlogpostById(@PathVariable Long id) {
        return blogpostService.getBlogpostById(id);
    }

    @PostMapping
    public Blogpost createBlogpost(@RequestBody BlogpostDTO blogpost) {
        return blogpostService.createBlogpost(blogpost);
    }

    @PatchMapping("/{id}")
    public Blogpost updateBook(@PathVariable Long id, @RequestBody BlogpostDTO blogpost) {
        return blogpostService.updateBlogpost(id, blogpost);
    }

    @DeleteMapping("/{id}")
    public void deleteBlogpost(@PathVariable Long id) {
        blogpostService.deleteBlogpost(id);
    }
}