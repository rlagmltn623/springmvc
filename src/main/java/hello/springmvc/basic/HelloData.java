package hello.springmvc.basic;

import lombok.Data;

@Data
//롬복 @Data
//@Getter , @Setter , @ToString , @EqualsAndHashCode , @RequiredArgsConstructor 자동적용        자동으로 적용해준다.
public class HelloData {

    private String username;
    private int age;


}
