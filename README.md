# API Training Workshop #1 - Rest
The current workshop exercise implements a header checker middleware making usage of the validator pattern.
# Quickstart
### Install
Required Technologies:
*  JAVA 1.8
*  Spring Framework - Spring Boot 1.4

### Usage

* **Success Case:**  Call Rest method `Get` method on `http://localhost:8080/header/list` with `platform` header having the values **iOS** or **Android**
* **Fail Case:** Remove `platform` header
