package core.app.models;

import jakarta.persistence.*;
import java.util.*;
import lombok.*;

@Entity
@Getter
public class TestEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = true)
    private String name;

    public TestEntity changeName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TestEntity that = (TestEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(name);
        return result;
    }
}
