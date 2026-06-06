<!-- BANNER -->
<div align="center">

```
╔══════════════════════════════════════════════════════════════════════════════════╗
║                                                                                  ║
║    ███████╗ █████╗     ██╗  ██╗ ██████╗ ████████╗███████╗██╗                   ║
║    ██╔════╝██╔══██╗    ██║  ██║██╔═══██╗╚══██╔══╝██╔════╝██║                   ║
║    ███████╗███████║    ███████║██║   ██║   ██║   █████╗  ██║                   ║
║    ╚════██║██╔══██║    ██╔══██║██║   ██║   ██║   ██╔══╝  ██║                   ║
║    ███████║██║  ██║    ██║  ██║╚██████╔╝   ██║   ███████╗███████╗              ║
║    ╚══════╝╚═╝  ╚═╝    ╚═╝  ╚═╝ ╚═════╝    ╚═╝   ╚══════╝╚══════╝              ║
║                                                                                  ║
║           █████╗ ██████╗ ██████╗ ██╗██╗   ██╗███╗   ███╗                        ║
║         ██╔══██╗██╔══██╗██╔══██╗██║██║   ██║████╗ ████║                        ║
║         ███████║██████╔╝██████╔╝██║██║   ██║██╔████╔██║                        ║
║         ██╔══██║██╔═══╝ ██╔═══╝ ██║██║   ██║██║╚██╔╝██║                        ║
║         ██║  ██║██║     ██║     ██║╚██████╔╝██║ ╚═╝ ██║                        ║
║         ╚═╝  ╚═╝╚═╝     ╚═╝     ╚═╝ ╚═════╝ ╚═╝     ╚═╝                        ║
║                                                                                  ║
║     ── Java · Appium · TestNG · Allure · Jenkins · Android ──                  ║
║                                                                                  ║
║            Production-Grade Mobile Automation Framework                          ║
║                      Built by  Raxit Sharma                                     ║
║                                                                                  ║
╚══════════════════════════════════════════════════════════════════════════════════╝
```

<br/>

[![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://adoptium.net/)
[![Appium](https://img.shields.io/badge/Appium-UiAutomator2-662D91?style=for-the-badge&logo=appium&logoColor=white)](https://appium.io/)
[![TestNG](https://img.shields.io/badge/TestNG-7.x-FF6B35?style=for-the-badge&logo=testng&logoColor=white)](https://testng.org/)
[![Maven](https://img.shields.io/badge/Maven-3.8+-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)](https://maven.apache.org/)
[![Allure](https://img.shields.io/badge/Allure-Reports-brightgreen?style=for-the-badge&logo=qase&logoColor=white)](https://allurereport.org/)
[![Jenkins](https://img.shields.io/badge/Jenkins-CI%2FCD-D24939?style=for-the-badge&logo=jenkins&logoColor=white)](https://www.jenkins.io/)
[![Android](https://img.shields.io/badge/Android-Emulator%20%7C%20Device-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://developer.android.com/)
[![License](https://img.shields.io/badge/License-Proprietary-red?style=for-the-badge&logo=opensourceinitiative&logoColor=white)](#license)

<br/>

> *A battle-hardened mobile automation framework that solves flaky locators, parallel session collisions,*
> *state leakage, and brittle CI — built on a real hotel booking app, not a toy demo.*

<br/>

</div>

---

## 📖 Table of Contents

- [✨ Why This Framework?](#-why-this-framework)
- [📌 Project Story](#-project-story)
- [🚀 Key Features](#-key-features)
- [🧱 Tech Stack](#-tech-stack)
- [🗂️ Repository Structure](#️-repository-structure)
- [⚙️ Setup & Installation](#️-setup--installation)
- [▶️ How to Run](#️-how-to-run)
- [🧩 Page Object Factory](#-page-object-factory)
- [🧪 Data-Driven Testing (CSV)](#-data-driven-testing-csv)
- [🔁 Reset Policy per Test](#-reset-policy-per-test)
- [📊 Reporting & Artifacts](#-reporting--artifacts)
- [🧰 Jenkins CI Integration](#-jenkins-ci-integration)
- [🩺 Troubleshooting](#-troubleshooting)
- [🗺️ Roadmap](#️-roadmap)
- [🙌 Contributing](#-contributing)
- [📜 License](#-license)

---

## ✨ Why This Framework?

This is **not** a tutorial project. Every design decision exists to solve a real problem encountered in production mobile automation.

| Challenge | Solution |
|---|---|
| No accessibility IDs on early devices | Constrained XPath + targeted `UiSelector` |
| Parallel test session collisions | Dynamic port allocation + per-thread isolated drivers |
| Flaky test state between runs | `@ResetPolicy` annotation with granular per-test control |
| CI reports that lie | JUnit XML gating + Allure with preserved trend history |
| Brittle element waits | Intent-based explicit waits (presence, visibility, clickability) |
| Data explosion requiring code changes | CSV-driven `@DataProvider` for zero-code test scaling |

---

## 📌 Project Story

This framework was built through **weeks of real-world iteration** — not designed on paper and shipped clean.

The first devices used in testing (a Google tablet and a Pixel 2 emulator) did not expose accessibility IDs. That forced a hardened locator strategy early: short, anchored XPath expressions, `UiSelector` where text or ID was stable, and intent-based waits replacing every blind `Thread.sleep()`.

After stabilising on a **Pixel 2 + Pixel 9 Pro XL** matrix, the focus shifted to making parallel execution genuinely safe — unique `systemPort` per session, clean per-thread driver lifecycles, and namespaced artifacts so no run ever clobbers another.

The result is a framework where **on any failure**, a human or a CI agent sees the same truth: a screenshot, a short video clip, device logs, and a JUnit XML report.

---

## 🚀 Key Features

### 🏨 Test Coverage
- **Authentication** — Sign in and sign up flows (positive + negative)
- **Hotel Search** — Full search with filter combinations
- **Profile Management** — Profile update flows
- **Hotel Booking** — End-to-end booking with positive and negative validations

### 🏗️ Architecture
- **Page Object Factory** with `@AndroidFindBy` and `AppiumFieldDecorator` for lazy, resilient element resolution
- **CSV-driven DataProviders** for signup, search, and booking scenarios — add rows, not code
- **`@ResetPolicy` annotation** — per-test control over `NO_RESET`, `RESET_DATA`, `FAST_RESET`, `FULL_RESET`, or `INHERIT`

### ⚡ Parallel Execution
- Device-level independence via `testng.xml` parameters
- Dynamic system port allocation — zero collision guarantee
- Isolated artifact directories per session
- No shared mutable state across threads

### 📸 Failure Artifacts
- **Screenshot** captured at point of failure
- **Short video clip** of the test run
- **Device / console logs**
- **JUnit XML** consumed by Jenkins for accurate build gating

### 📈 Reporting
- **Allure Reports** with steps, parameters, and attachments
- **History preservation** between runs — Trends tab tells real stories
- Listener-injected history ensures accumulation across CI builds

---

## 🧱 Tech Stack

<div align="center">

| Layer | Technology |
|:---|:---|
| **Language** | Java 17+ |
| **Test Runner** | TestNG |
| **Mobile Driver** | Appium 2.x (UiAutomator2) |
| **Design Pattern** | Page Object Factory |
| **Test Data** | CSV DataProviders |
| **Reporting** | Allure Reports + JUnit XML |
| **CI/CD** | Jenkins Pipeline |
| **Target Platform** | Android (Emulators & Real Devices) |
| **Default Devices** | Pixel 2 · Pixel 9 Pro XL |
| **Build Tool** | Apache Maven 3.8+ |

</div>

---

## 🗂️ Repository Structure

```
SA_HOTEL_APPIUM_JAVA_TESTNG_FRAMEWORK/
│
├── src/
│   ├── main/
│   │   └── java/                         # (Reserved for shared utilities/models)
│   │
│   └── test/
│       ├── java/
│       │   ├── base/                     # DriverFactory, BaseTest, ResetPolicy handling
│       │   ├── listeners/                # AllureListener, media capture, history injection
│       │   ├── pages/                    # Page Object Factory classes (one per screen)
│       │   ├── tests/                    # Test classes — positive and negative suites
│       │   └── utils/                   # CsvUtils, MediaManager, EnvWriter, helpers
│       │
│       └── resources/
│           └── data/                     # CSV test data files
│               ├── signup.csv
│               ├── search.csv
│               └── booking.csv
│
├── allure-results/                       # Raw results produced by test runs
├── allure-report/                        # Published HTML report (CI-generated)
├── history/                              # Preserved Allure trend history between runs
├── testng.xml                            # Suite definition — devices, parallelism, parameters
└── pom.xml                               # Maven dependencies and plugin configuration
```

---

## ⚙️ Setup & Installation

### Prerequisites

Ensure the following are installed and configured before cloning:

```
✔  Java 17 or later         → https://adoptium.net/
✔  Maven 3.8+               → https://maven.apache.org/
✔  Node.js + Appium 2.x     → npm install -g appium
✔  Android SDK              → https://developer.android.com/studio
✔  ADB & Emulators/Devices  → adb devices (to verify connectivity)
```

### Clone the Repository

```bash
git clone https://github.com/raxit00701/SA_HOTEL_APPIUM_JAVA_TESTNG_FRAMEWORK.git
cd SA_HOTEL_APPIUM_JAVA_TESTNG_FRAMEWORK
```

### Install Dependencies

```bash
mvn -q -DskipTests clean install
```

### Start Appium Server

```bash
appium --port 4723
```

> The framework includes a service builder. You can also point it at your own running instance.
> Verify your devices are visible first:

```bash
adb devices
```

---

## ▶️ How to Run

### Run a Single Test (Quick Debug)

```bash
mvn -Dtest=tests.Test4 test
```

### Run the Full Suite

```bash
mvn -DsuiteXmlFile=testng.xml test
```

### Run in Parallel Across Devices

Configure your `testng.xml` and let the framework handle the rest — ports, drivers, and artifacts are all isolated automatically.

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Android Suite" parallel="tests" thread-count="2">

  <test name="Pixel_2_Run">
    <parameter name="deviceName" value="Pixel_2"/>
    <parameter name="udid"       value="emulator-5554"/>
    <parameter name="systemPort" value="8201"/>
    <classes>
      <class name="tests.Test1"/>
      <class name="tests.Test4"/>
    </classes>
  </test>

  <test name="Pixel_9_Pro_XL_Run">
    <parameter name="deviceName" value="Pixel_9_Pro_XL"/>
    <parameter name="udid"       value="emulator-5556"/>
    <parameter name="systemPort" value="8203"/>
    <classes>
      <class name="tests.Test1"/>
      <class name="tests.Test4"/>
    </classes>
  </test>

</suite>
```

> **Swap devices without touching a single line of Java.** Change `deviceName` and `udid` here and the framework adapts entirely.

---

## 🧩 Page Object Factory

Every screen in the app has a dedicated Page Object class. Elements are declared with `@AndroidFindBy` and resolved lazily via `AppiumFieldDecorator` — no stale element references, no early resolution failures.

```java
public class HomePage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='More']")
    private WebElement moreButton;

    @AndroidFindBy(id = "com.myhotels.sa:id/citySearchLayout")
    private WebElement citySearchLayout;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Start Search\")")
    private WebElement startSearchButton;

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(
            new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this
        );
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void tapMore() {
        wait.until(ExpectedConditions.elementToBeClickable(moreButton)).click();
    }
}
```

**Locator strategy principles:**
- Prefer short, anchored XPath — avoid long chains that break on layout changes
- Use `UiSelector` where element text or resource ID is stable
- Fall back to `content-desc` for labelled interactive components

---

## 🧪 Data-Driven Testing (CSV)

Test data lives in CSV files under `src/test/resources/data/`. Adding new scenarios requires **zero code changes** — just add rows.

```java
@DataProvider(name = "SignupData", parallel = false)
public Object[][] getSignupData() {
    return CsvUtils.readCsv("src/test/resources/data/signup.csv");
}
```

**Example `signup.csv`:**

```csv
firstName,lastName,email,password,searchText,mobile
Rohit,Sharma,rohit.sharma+001@testmail.com,Passw0rd!,India,9876543210
Priya,Mehta,priya.mehta+002@testmail.com,SecureP@ss1,Mumbai,9123456780
```

> The same pattern applies to `search.csv` and `booking.csv`. Scale test coverage by editing spreadsheets, not source files.

---

## 🔁 Reset Policy Per Test

The `@ResetPolicy` annotation lets each test class declare its own state requirements. The base class reads the mode and configures Appium capabilities and post-test cleanup accordingly.

```java
@ResetPolicy(ResetPolicy.Mode.RESET_DATA)
public class Test4 extends MastodonBase {
    // This test always starts with a clean app state
}
```

### Available Modes

| Mode | Behaviour |
|:---|:---|
| `INHERIT` | Inherits the setting from the parent suite configuration |
| `NO_RESET` | App state is preserved between tests — fastest execution |
| `RESET_DATA` | Clears app data before the test — reliable state, moderate speed |
| `FAST_RESET` | Terminates and relaunches the app without clearing data |
| `FULL_RESET` | Uninstalls and reinstalls the app — cleanest, slowest |

> Use `NO_RESET` for read-only flows and `RESET_DATA` for any test that writes data (sign up, booking, profile update).

---

## 📊 Reporting & Artifacts

### On Every Failure

The framework automatically captures and attaches:

```
📸  Screenshot     — exact screen state at point of failure
🎬  Video Clip     — short recording of the test run
📋  Device Logs    — ADB logcat or console output
📄  JUnit XML      — machine-readable result for CI gating
```

### Allure Reports

```bash
# Generate and open the report locally
allure serve allure-results/
```

Reports include:
- **Steps** — granular action-level breakdown
- **Parameters** — data-driven test inputs visible per run
- **Attachments** — screenshots and videos embedded inline
- **Trends** — pass/fail/broken rates over time

### Allure History Retention

The Allure listener injects history from the `history/` directory into each new run, so the **Trends tab accumulates real data** across builds.

```
# Before generating the report in CI:
cp -r history/ allure-results/history/
allure generate allure-results/ -o allure-report/ --clean

# After the run, preserve updated history:
cp -r allure-report/history/ history/
```

---

## 🧰 Jenkins CI Integration

### Recommended Pipeline Steps

```groovy
pipeline {
    agent any
    stages {
        stage('Restore History') {
            steps {
                // Copy preserved history into allure-results before the run
                sh 'cp -r history/ allure-results/history/ || true'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn clean test -DsuiteXmlFile=testng.xml'
            }
        }
        stage('Report') {
            steps {
                allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'allure-results']]
                ])
            }
        }
    }
    post {
        always {
            // Archive everything CI needs
            archiveArtifacts artifacts: 'allure-results/**, allure-report/**, junit-reports/**, screenshots/**, videos/**'
            junit 'junit-reports/**/*.xml'
            // Preserve history for the next build
            sh 'cp -r allure-report/history/ history/'
        }
    }
}
```

**Key CI principles:**
- Build pass/fail is **gated by JUnit XML** — not Allure, not console output
- Allure history directory is preserved between builds as an artifact
- All media (screenshots, videos) is archived so failed runs are fully reproducible
- Suite parameters in `testng.xml` mean no code changes are needed for device swaps in CI

---

## 🩺 Troubleshooting

<details>
<summary><strong>🔍 No accessibility IDs found on device</strong></summary>

Use short, anchored XPath or `UiSelector` with stable text or resource IDs. Avoid deep chains like `//LinearLayout/RelativeLayout/TextView[3]` — these break on the smallest layout change.

```java
// ✅ Preferred
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Start Search\")")

// ✅ Also good — anchored and shallow
@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='More']")

// ❌ Avoid — brittle positional chain
@AndroidFindBy(xpath = "//LinearLayout/RelativeLayout/FrameLayout[2]/TextView")
```
</details>

<details>
<summary><strong>⚡ Parallel tests colliding or failing intermittently</strong></summary>

- Verify each `<test>` block in `testng.xml` has a **unique `systemPort`**
- Confirm each device has a **unique `udid`** — `adb devices` to check
- Ensure artifact directories are namespaced per device/thread
- Never use static mutable fields in page or base classes
</details>

<details>
<summary><strong>📜 Overscroll missing the target element</strong></summary>

Use `UiScrollable` with the correct container and stop as soon as the target appears. Scrolling past the target causes flakiness on element interaction.

```java
new UiScrollable(new UiSelector().scrollable(true))
    .scrollIntoView(new UiSelector().text("Book Now"));
```
</details>

<details>
<summary><strong>🔁 State leaking between tests</strong></summary>

Set `@ResetPolicy` explicitly on every test class that writes data. Using `INHERIT` on flows that create accounts or bookings means prior run state can affect results.
</details>

<details>
<summary><strong>📊 Allure Trends tab is flat / history not showing</strong></summary>

The `history/` directory must be copied into `allure-results/` **before** `allure generate` runs. If CI starts a fresh workspace each build, restore `history/` from the previous build's artifacts before the test stage.

```bash
cp -r history/ allure-results/history/
```
</details>

---

## 🗺️ Roadmap

- [ ] **Extended negative cases** — more booking edge scenarios and error state validation
- [ ] **Expanded device matrix** — additional emulator API levels and real device profiles
- [ ] **Network conditioning** — throttle, offline, and high-latency test modes
- [ ] **Retry logic** — configurable retry on known flaky network endpoints
- [ ] **Contract checks** — lightweight API contract validation for critical app endpoints
- [ ] **iOS support** — XCUITest driver parity for cross-platform coverage

---

## 🙌 Contributing

Contributions are welcome — especially bug reports with full reproduction steps.

When opening an issue or pull request, please include:

- **Logs** — ADB logcat or Appium server output
- **Failing step** — which test, which step, what was expected vs actual
- **Environment details** — OS, Java version, Appium version, device/emulator

For larger changes, open an issue first to discuss the approach before investing time in a PR.

---

## 📜 License

<div align="center">

```
╔══════════════════════════════════════════════════════════╗
║                                                          ║
║              PROPRIETARY SOFTWARE LICENSE                ║
║                                                          ║
║          All Rights Reserved © 2026 Raxit Sharma         ║
║                                                          ║
╚══════════════════════════════════════════════════════════╝
```

</div>

This project is **proprietary and protected by copyright**.

**All Rights Reserved © 2026 Raxit Sharma**

No permission is granted to use, copy, modify, distribute, or create derivative works from this code without explicit written permission from the author.

Unauthorized use, reproduction, or distribution of this software, in whole or in part, may result in severe civil and criminal penalties and will be prosecuted to the maximum extent possible under the law.

For licensing inquiries, contact the author directly.

---

<div align="center">

```
─────────────────────────────────────────────────────────
  Built with precision. Tested with purpose.
  SA Hotel Appium Java TestNG Framework
  © 2026 Raxit Sharma — All Rights Reserved
─────────────────────────────────────────────────────────
```

⭐ **If this framework helped you, consider starring the repository.**

</div>
