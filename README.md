# Testing Automation Project

This project is an automated testing framework built using Java, Gradle, JUnit, Serenity/Selenium, and Cucumber. It follows the Page Object Model and Screenplay patterns for structuring the test code.

## Project Structure

```
testing-automation-project
├── src
│   ├── main
│   │   └── java
│   │       └── pages
│   │           └── BasePage.java
|   |           └── TrianglePage.java
│   └── test
│       ├── java
│       │   ├── runners
│       │   │   └── TestRunner.java
│       │   ├── steps
│       │   │   └── StepDefinitions.java
│       │   └── screenplay
│       │       └── Tasks.java
│       └── resources
│       │   ├── features
│       │   │   └── SampleFeature.feature
│           └── serenity.conf
├── build.gradle
├── gradle.properties
├── settings.gradle
└── README.md
```

## Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/testing-automation-project.git
   cd testing-automation-project
   ```

2. **Install Dependencies**
   Ensure you have Gradle installed. Run the following command to install the necessary dependencies:
   ```bash
   ./gradlew build
   ```

## 3. Configure WebDriver

This project uses Selenium WebDriver with Google Chrome.  
You must [download ChromeDriver](https://chromedriver.chromium.org/downloads) that matches your installed version of Chrome.

- Download the appropriate ChromeDriver for your OS and Chrome version.
- Unzip the file and place the `chromedriver.exe` (Windows) or `chromedriver` (Mac/Linux) in a known directory, for example: `C:/drivers/chromedriver-win64/chromedriver.exe`.
- Update the path in the code or set the environment variable if needed:
  - The path is set in the code as:
    ```java
    System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver-win64/chromedriver.exe");
    ```
  - You can also set the environment variable `webdriver.chrome.driver` to point to your driver location.

**Note:**  
If you use a different browser, download and configure the corresponding driver (e.g., [GeckoDriver for Firefox](https://github.com/mozilla/geckodriver/releases)).


4. **Run Tests**
   You can run the tests using JUnit or through Jenkins. To run the tests locally with JUnit, use:
   ```bash
   ./gradlew test
   ```

## Usage

The project includes a sample feature file located at `src/test/java/features/SampleFeature.feature`, which describes the user story for validating triangle types based on three input values. The corresponding step definitions can be found in `src/test/java/steps/StepDefinitions.java`.

## Reporting

After running the tests, Serenity will generate reports that can be found in the `/target/site/serenity/index.html` directory.

## Contributing

Feel free to fork the repository and submit pull requests for any improvements or bug fixes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.