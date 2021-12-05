package fun.etr.rockleader.persistence.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.springframework.data.rest.core.annotation.RestResource;

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

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name="account_id", nullable=false)
    private Account account;

    private String description;

    @NotNull(message = "Activity Type is mandatory")
    @Enumerated(EnumType.STRING)
    private ActivityType type;

    private int difficulty;

    @ElementCollection
    private Set<String> tags;

}
