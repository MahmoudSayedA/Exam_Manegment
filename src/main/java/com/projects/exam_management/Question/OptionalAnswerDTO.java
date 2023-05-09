package Question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OptionalAnswerDTO {
    private String option;
    private Question qestion;
    private Long id;

    public static OptionalAnswerDTO toDTO(OptionalAnswer optionalAnswer){
        return builder().id(optionalAnswer.getId()).option(optionalAnswer.getOption()).qestion(optionalAnswer.getQestion()).build();
    }
}
