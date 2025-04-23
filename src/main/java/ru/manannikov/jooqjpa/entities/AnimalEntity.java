package ru.manannikov.jooqjpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
@ToString
// Индекс для первичного ключа создается автоматически
@Table(
    name = "animals"
)
public class AnimalEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id")
    private Integer id;

    @Column(name = "animal_russian_name", length = 32, nullable = false, unique = true)
    private String russianName;
    @Column(name = "animal_latin_name", length = 64, nullable = false, unique = true)
    private String latinName;

    @Column(name = "animal_class", length = 24, nullable = false)
    private String animalClass;
    @Column(name = "animal_order", length = 24, nullable = false)
    private String animalOrder;
    @Column(name = "animal_family", length = 36, nullable = false)
    private String animalFamily;
    @Column(name = "animal_genus", length = 24, nullable = false)
    private String animalGenus;
    @Column(name = "animal_species", length = 128)
    private String animalSpecies;

    @Column(name = "animal_natural_habitat", length = 2048)
    private String naturalHabitat;

    @Column(name = "animal_image_uri", length = 128)
    private String imageUri;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;

        AnimalEntity that = (AnimalEntity) o;
        return getId() != null
            && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
            ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode()
            : getClass().hashCode();
    }
}
