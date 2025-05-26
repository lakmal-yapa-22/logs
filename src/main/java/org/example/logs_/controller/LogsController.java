package org.example.logs_.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogsController {

  // Logger object එක initialize කරනවා – මේකෙන් logs generate කරන්න පුළුවන්
  private static final Logger logger = LoggerFactory.getLogger(LogsController.class);

  // "/log" කියන endpoint එක call කළාම මෙය ක්‍රියාත්මක වෙනවා
  @GetMapping("/log")
  public String logMessage() {

    // Logging levels යොදාගෙන message log කරනවා
    logger.info("logMessage is called info");   // සාමාන්‍ය තොරතුරු
    logger.warn("logMessage is called warn");   // අවවාද (warnings)
    logger.error("logMessage is called error"); // දෝෂ (errors)
    logger.debug("logMessage is called debug"); // development එකට උපයෝගී debug info

    // 🔍 Logging භාවිතා කරන ප්‍රධාන අරමුණු:
    // - Log management tools: ELK stack, Logstash, Kibana
    // - Error tracking
    // - System monitoring
    // - Security checking

    // Exception handling එකක් (runtime error simulate කරනවා)
    try {
      String notNumberStr = "hello"; // මේක integer එකක් නෙමෙයි
      int notNumber = Integer.parseInt(notNumberStr); // Error එක throw වෙනවා
    } catch (NumberFormatException e) {
      // Exception එක log කරනවා error level එකෙන්
      logger.error("logMessage is called error: {}", e.getMessage());
    }

    return "this is sample end point for test log manager";
  }
}
