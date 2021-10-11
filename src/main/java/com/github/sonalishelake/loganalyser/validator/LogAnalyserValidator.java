package com.github.sonalishelake.loganalyser.validator;

import com.github.sonalishelake.loganalyser.model.ContextLogFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Component
public class LogAnalyserValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogAnalyserValidator.class);

    public void validateInput(ContextLogFile context, String... args) {
        LOGGER.info("Validating the input...");

        validateArguments(args);
        validateFilePath(context, args[0]);
    }

    private void validateFilePath(ContextLogFile context, String logFilePath) {
        LOGGER.info("Log file specified for LogAnalyserService: {}", logFilePath);
        context.setLogFilePath(logFilePath);

        try {
            File file = new ClassPathResource("inputfile/" + logFilePath).getFile();
            if (!file.exists()) {
                file = new ClassPathResource(logFilePath).getFile();
                if (!file.exists()) {
                    file = new File(logFilePath);
                }
            }

            if (!file.exists())
                throw new FileNotFoundException("Unable to open the file " + logFilePath);
        } catch (IOException e) {
            LOGGER.error("!!! Unable to find the specified file '{}'", logFilePath);
        }
    }

    private void validateArguments(String[] args) {
        LOGGER.debug("Validating the program arguments...");
        if (args.length < 1) {
            throw new IllegalArgumentException("!!! Please specify the filepath to analyse.");
        }
    }
}
