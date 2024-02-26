package zaliczenie.adriangut.projektspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogpostDTO {
    @NonNull
    private String title;

    @NonNull
    private String content;

    @NonNull
    private LocalDateTime created;

    private LocalDateTime updated;

}
