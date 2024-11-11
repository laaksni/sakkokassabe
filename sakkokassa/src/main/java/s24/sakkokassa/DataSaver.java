package s24.sakkokassa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import s24.sakkokassa.domain.Fine;
import s24.sakkokassa.domain.Player;
import s24.sakkokassa.service.FineService;
import s24.sakkokassa.service.PlayerService;

import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
public class DataSaver {

    @Bean
    CommandLineRunner initData(PlayerService playerService, FineService fineService) {
        return args -> {
            Player player1 = new Player();
            player1.setName("Keijo Kiekkoilija");
            player1 = playerService.savePlayer(player1);

            Player player2 = new Player();
            player2.setName("Matti Maalivahti");
            player2 = playerService.savePlayer(player2);

            Fine fine = new Fine();
            fine.setDescription("Myöhästyminen");
            fine.setAmount(new BigDecimal("10.00"));
            fine.setPaid(false);
            fine.setDate(LocalDate.of(2024, 1, 1));
            fine.setPlayer(player1);
            fineService.saveFine(fine);
        };
    }
}

