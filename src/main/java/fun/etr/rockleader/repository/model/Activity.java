package fun.etr.rockleader.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Activity name is mandatory")
    private String name;

    private String description;

    @NotNull(message = "Activity Type is mandatory")
    @Enumerated(EnumType.STRING)
    private ActivityType type;

    private int difficulty;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="account_id")
    private Account account;

    @ElementCollection
    private Set<String> tags;

}
