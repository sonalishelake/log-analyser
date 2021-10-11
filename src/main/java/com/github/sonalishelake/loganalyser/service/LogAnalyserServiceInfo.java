package com.github.sonalishelake.loganalyser.service;

import com.github.sonalishelake.loganalyser.conf.ApplicationDetails;
import com.github.sonalishelake.loganalyser.manager.LogAnalyserManagerDetails;
import com.github.sonalishelake.loganalyser.model.ContextLogFile;
import com.github.sonalishelake.loganalyser.validator.LogAnalyserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogAnalyserServiceInfo {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogAnalyserServiceInfo.class);

    @Autowired
    private LogAnalyserValidator validator;

    @Autowired
    private LogAnalyserManagerDetails manager;

    @Autowired
    private ApplicationDetails applicationDetails;

    public void execute(String... args) {
        ContextLogFile context = ContextLogFile.getInstance();
        validator.validateInput(context, args);
        manager.parseAndPersistEvents(context);
    }

}
