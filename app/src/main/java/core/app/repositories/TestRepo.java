package core.app.repositories;

import core.app.models.*;
import org.springframework.data.jpa.repository.*;

public interface TestRepo
        extends JpaRepository<TestEntity, Long> {

}
