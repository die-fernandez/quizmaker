package com.trial.controller;

import com.trial.domain.Attempt;
import com.trial.domain.User;
import com.trial.dto.AttemptDto;
import com.trial.service.AttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by diego.fernandez on 12/3/15.
 */
@Controller
@RequestMapping("/attempts")

public class AttemptController {

    @Autowired
    AttemptService service;

    @RequestMapping(value="/start", method={RequestMethod.POST},  headers ="Accept=application/json")
    @ResponseBody
    public Attempt start(@RequestBody AttemptDto attemptDto, @AuthenticationPrincipal  User user){
        if (attemptDto.getExamId() == null){
            throw new RuntimeException("exam id not present, can't start attempt");
        }
       return service.startAttempt(attemptDto, user);
    }
}
