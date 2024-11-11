package s24.sakkokassa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import s24.sakkokassa.domain.Fine;
import s24.sakkokassa.domain.FineRepository;

@Service
public class FineService {
    @Autowired
    private FineRepository fineRepository;

    public List<Fine> getAllFines() {
        return fineRepository.findAll();
    }

    public Fine saveFine(Fine fine) {
        return fineRepository.save(fine);
    }

    public List<Fine> getUnpaidFinesByPlayer(Long playerId) {
        return fineRepository.findByPlayerIdAndPaid(playerId, false);
    }
}
