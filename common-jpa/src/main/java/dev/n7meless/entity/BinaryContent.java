package dev.n7meless.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@EqualsAndHashCode(exclude = "id")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "binary_content")
public class BinaryContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private byte[] fileAsArrayOfBytes;
}
