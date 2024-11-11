package s24.sakkokassa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import s24.sakkokassa.domain.Fine;
import s24.sakkokassa.service.FineService;
import s24.sakkokassa.service.PlayerService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/fines")
public class FineController {
    @Autowired
    private FineService fineService;

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public String getFines(Model model) {
        model.addAttribute("fines", fineService.getAllFines());
        return "fines";
    }

    @GetMapping("/new")
    public String createFineForm(Model model) {
        model.addAttribute("fine", new Fine());
        model.addAttribute("players", playerService.getAllPlayers());
        return "fine_form";
    }

    @PostMapping
    public String saveFine(@Valid Fine fine, BindingResult result) {
        if (result.hasErrors()) {
            return "fine_form";
        }
        fineService.saveFine(fine);
        return "redirect:/fines";
    }
}

