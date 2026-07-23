package com.dispatch.activeCalls.controller;


import com.dispatch.activeCalls.dto.CallIdRequest;
import com.dispatch.activeCalls.dto.NewEventDto;
import com.dispatch.activeCalls.services.ActiveCallsService;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("CallsController")
@RequestMapping("/calls")
@Setter
public class CallsController {
    private final ActiveCallsService activeCallsService;


    public CallsController(ActiveCallsService activeCallsService) {
        this.activeCallsService = activeCallsService;
    }

    @PostMapping("/add")
    public NewEventDto addNewCall(@RequestBody NewEventDto newEventDto) {
        return activeCallsService.addCall(newEventDto);
    }

    @GetMapping("/active-calls")
    public List<NewEventDto> getActiveCalls() {
        return activeCallsService.getAllActiveCalls();
    }
    @PostMapping("remove-active-call")
    public void removeActiveCall(@RequestBody CallIdRequest callIdRequest) {
        activeCallsService.removeActiveCall(callIdRequest);
    }
}
