package kr.co.kwonshzzang.bookmanager.bookmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookNameAndCategory {
    private String name;
    private String category;
}
