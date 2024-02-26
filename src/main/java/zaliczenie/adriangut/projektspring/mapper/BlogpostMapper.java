package zaliczenie.adriangut.projektspring.mapper;

import org.mapstruct.Mapper;
import zaliczenie.adriangut.projektspring.model.Blogpost;
import zaliczenie.adriangut.projektspring.model.BlogpostDTO;

@Mapper(componentModel = "spring")
public interface BlogpostMapper {
    BlogpostDTO toDto(Blogpost blogpost);
    Blogpost toEntity(BlogpostDTO blogpostDTO);
}