# 🧪 Intervue.io Login Automation Test (Selenium Java)

This project automates the login functionality for [https://www.intervue.io](https://www.intervue.io) using **Selenium WebDriver in Java**.

If the login attempt fails, a **screenshot is automatically captured** and saved locally.

---

## 📹 Video Demonstration


---

## 🚀 Tech Stack

- Java
- Selenium WebDriver
- ChromeDriver (managed by WebDriverManager)
- Maven (optional but recommended for dependencies)

---

## ✅ Test Flow

1. Open the website `https://www.intervue.io`
2. Click the **Login** button
3. Switch to the new tab
4. Click on the **Login** button again
5. Enter credentials:
   - **Email**: `neha@intervue.io`
   - **Password**: `Ps@neha@123`
6. Click Login
7. Based on the result:
   - ✅ **Login Success** → print a message
   - ❌ **Login Failed** → take a screenshot and save it

---

Script 



## 🛠️ Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/intervue-login-test.git
cd intervue-login-test
