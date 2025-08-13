# OneKonnect_Partner_Portal
## 📌 Overview
This project automates the OneKonnect partner portal user flow using Selenium WebDriver with Java, following the Page Object Model (POM) design pattern and a data-driven testing approach with JSON files.
The test scenario is based on the requirements.

It includes:
- Login with valid credentials
- Navigating to the EDI form
- Filling only mandatory fields using data-driven input from JSON
- Submitting the order and verifying in the Orders page
- ExtentReports for detailed HTML report (Plus)

---

## 🧰 Tech Stack

- **Language**: Java 23  
- **Automation**: Selenium WebDriver  
- **Test Framework**: TestNG
- **Reporting**: ExtentReports (HTML format)
- **Test Data**: JSON-simple (for reading test data)
- **Build Tool**: Maven  
  
---

## 📂 Project Structure

```
project-root/
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── Pages
│   │   │   │   ├── DashboardPage.java
│   │   │   │   ├── EDIFormPage.java
│   │   │   │   ├── LoginPage.java
│   │   │   │   └── OrdersPage.java
│   │   │   └── utils
│   │   │       └── DataReader.java
│   │   └── resources
│   │       └── jsonfiles
│   │           ├── ediformdata.json
│   │           └── loginData.json
│   │
│   └── test
│       └── java
│           ├── DataProvider
│           │   ├── EDIFormDataProvider.java
│           │   └── LoginDataProvider.java
│           ├── Setup
│           │   └── Setup.java
│           ├── Tests
│           │   └── OneKonnectEndToEndTest.java
│           └── utils.reports
│               └── UI_test_report.html
```
---
## 🏃 How to Run the Test
1- Clone the Repository
```bash
git clone https://github.com/your-username/OneKonnect.git
cd OneKonnect
```
2- Open the Project in IntelliJ IDEA
- Go to File → Open and select the OneKonnect folder.
- Ensure Maven is enabled so dependencies download automatically.

3- Run the Test from IntelliJ
- Navigate to:
```
src/test/java/Tests/OneKonnectEndToEndTest.java
```
- Right-click → Run 'OneKonnectEndToEndTest'.

4- Run the Test from Command Line
```bash
mvn clean test -Dtest=OneKonnectEndToEndTest
```

5- View the Test Report
- After execution, open:
```
utils.reports/UI_test_report.html
```
- Open in a browser to view the detailed ExtentReports report.

## 📄 Test Data
All input values (login credentials, form field values) are stored in JSON files under
```
src/main/resources/jsonfiles/
```
---

## 📊 Test Reports

After test execution, a detailed HTML report is generated.

📁 Location:  
```
src/test/java/utils/reports/UI_test_report.html
```

📖 To view:
- Open the file in your browser manually.

---
