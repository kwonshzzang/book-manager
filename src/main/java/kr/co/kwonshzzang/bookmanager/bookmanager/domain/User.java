package kr.co.kwonshzzang.bookmanager.bookmanager.domain;

import lombok.*;

import java.time.LocalDateTime;

//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class User {
    @NonNull
    private String name;
    @NonNull
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
