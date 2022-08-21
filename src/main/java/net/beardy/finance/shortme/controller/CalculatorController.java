package net.beardy.finance.shortme.controller;

import lombok.RequiredArgsConstructor;
import net.beardy.finance.shortme.controller.request.ShortSuggestionRequest;
import net.beardy.finance.shortme.controller.response.CalculatorResponse;
import net.beardy.finance.shortme.mapper.GenericCreateMapper;
import net.beardy.finance.shortme.service.SuggestionService;
import net.beardy.finance.shortme.service.dto.suggestion.AutomatedSuggestions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
@RequiredArgsConstructor
public class CalculatorController {

    private final SuggestionService suggestionService;

    private final GenericCreateMapper genericCreateMapper;

    @PostMapping("/suggestions")
    public CalculatorResponse suggestions(@Validated @RequestBody ShortSuggestionRequest request) {
        final AutomatedSuggestions suggestions =
            suggestionService.getSuggestions(request.getPrice(), request.getAmount(), request.getFee());
        return genericCreateMapper.map(suggestions, CalculatorResponse.class);
    }

}
