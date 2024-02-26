package zaliczenie.adriangut.projektspring.model;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
public class BlogpostDTO {
    @NonNull
    private String title;

    @NonNull
    private String content;

    @NonNull
    private LocalDateTime created;

    private LocalDateTime updated;
}
