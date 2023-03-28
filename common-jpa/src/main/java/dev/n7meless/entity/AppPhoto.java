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
@Table(name = "app_photo")
public class AppPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String telegramFileId;
    @OneToOne
    private BinaryContent binaryContent;
    private Integer fileSize;
}
