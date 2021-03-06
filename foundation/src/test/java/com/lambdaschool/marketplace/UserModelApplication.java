package com.lambdaschool.marketplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Main class to start the application.
 */
//@EnableJpaAuditing
@SpringBootApplication
public class UserModelApplication {
  /**
   * Connect to the system environment where environment variables live.
   */
  private final Environment env;

  /**
   * If an environment variable is not found, set this to true
   */
  private static boolean stop = false;

  public UserModelApplication(Environment env) {
    this.env = env;
  }

  /**
   * If an application relies on an environment variable, check to make sure that environment variable is available!
   * If the environment variable is not available, you could set a default value, or as is done here, stop execution of the program
   *
   * @param envvar The system environment where environment variable live
   */
  private static void checkEnvironmentVariable(String envvar) {
    if (System.getenv(envvar) == null) {
      stop = true;
    }
  }

  /**
   * Main method to start the application.
   *
   * @param args Not used in this application.
   */
  public static void main(String[] args) {
    // Check to see if the environment variables exists. If they do not, stop execution of application.
    checkEnvironmentVariable("CLIENT_ID");
    checkEnvironmentVariable("CLIENT_SECRET");

    if (!stop) {
      SpringApplication.run(UserModelApplication.class, args);
    }
  }
}
