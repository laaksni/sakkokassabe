package s24.sakkokassa;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import s24.sakkokassa.domain.Fine;
import s24.sakkokassa.service.FineService;

@SpringBootTest
public class FineServiceTest {
    @Autowired
    private FineService fineService;

    @Test
    public void testGetAllFines() {
        List<Fine> fines = fineService.getAllFines();
        assertNotNull(fines);
    }
}
