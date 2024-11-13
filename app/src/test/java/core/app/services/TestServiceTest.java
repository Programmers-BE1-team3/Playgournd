package core.app.services;

import static org.assertj.core.api.Assertions.*;

import core.app.models.*;
import jakarta.transaction.*;
import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.*;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class TestServiceTest {

    @Autowired
    TestService service;

    private static final int TEST_SIZE = 10;

    @Test
    @DisplayName("엔티티 저장")
    void save() {
        TestEntity testEntity = new TestEntity().changeName("TESTING");

        TestEntity result = service.save(testEntity);

        assertThat(result).satisfies(
                r -> assertThat(r).isNotNull(),
                r -> assertThat(r.getId()).isNotNull(),
                r -> assertThat(r.getName()).isNotNull(),
                r -> assertThat(r).isEqualTo(testEntity)
        );
    }

    @Test
    @DisplayName("여러 엔티티 조회")
    void get() {
        List<TestEntity> test = IntStream.range(0, TEST_SIZE)
                .mapToObj(i -> new TestEntity().changeName(String.valueOf(i)))
                .map(service::save)
                .toList();

        List<TestEntity> result1 = test.stream()
                .map(t -> service.findById(t.getId()).orElseThrow())
                .toList();

        assertThat(test).containsAll(result1);
    }

    @Test
    @DisplayName("엔티티 삭제")
    void delete() {
        TestEntity test = service.save(new TestEntity().changeName("TESTING"));

        Long id = test.getId();
        service.deleteById(id);

        assertThat(service.findById(id)).isEmpty();
    }

    @Test
    @DisplayName("Hello World")
    void echo() {
        service.helloWorld();
    }

    @Test
    @DisplayName("일부로 테스트 실패하기")
    void failOnPurpose() {
        assertThat(service.getFalse()).isTrue();
    }
}