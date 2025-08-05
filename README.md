#  FileViewer - JSP Servlet-Based Vulnerable Web App

A deliberately vulnerable Java web application demonstrating **Path Traversal** and **Stack Trace Information Disclosure** vulnerabilities, using Java Servlets and basic file I/O operations.

---
```plaintext
##  Project Structure
FileViewer/
│
├── Web Pages/
│ │
│ ├── config/
│ │ └── conf.env # Sensitive config file (can be targeted)
│ │
│ ├── reports/
│ │ ├── 22BCON1552 # Valid student report files
│ │ ├── 22BCON1553
│ │ └── 22BCON1554
│ │
│ ├── secret/
│ │ └── admin.txt #  Sensitive file simulating a secret
│ │
│ └── index.jsp # Optional welcome page
│
├── Source Packages/
│ ├── com.fileviewer.servlet/
│ │ ├── VulnerableFileViewer.java # Vulnerable Servlet (Path Traversal)
│ │ └── ReportViewerServlet.java # Patched File
│ │
│ └── com.fileviewer.util/

---


## ⚙️ Technology Stack

- **Frontend**: HTML (via JSP)
- **Backend**: Java Servlets (Tomcat)
- **Server**: Apache Tomcat 11
- **Language**: Java 8+
- **IDE**: Apache NetBeans

---

##  Features & Vulnerabilities

### `VulnerableFileViewer.java`
- Reads `id` parameter from query string:  
  `?id=../../../config/conf.env`
- Uses `FileReader` to load file contents
- No path sanitization
- Allows **Path Traversal**
- Exposes **Stack Trace** on error

### `ReportViewerServlet.java`
- Accepts `id` parameter
-  Uses canonical path validation
-  Restricts access to `/reports` directory
-  Catches and hides exceptions with user-friendly errors

---

##  Example Exploits

### 1. **Path Traversal**
http://localhost:8080/FileViewer/VulnerableFileViewer?id=../../../secret/admin.txt


### 2. **Stack Trace Disclosure**
If the file doesn't exist or can't be accessed:
http://localhost:8080/FileViewer/VulnerableFileViewer?id=../../does_not_exist.txt


### 3. **Safe Access**
http://localhost:8080/FileViewer/ReportViewerServlet?id=22BCON1552



---

## How It Works

- JSP & Servlet code is compiled into Java `.class` files
- `VulnerableFileViewer` directly reads any file from user-supplied input
- `ReportViewerServlet` ensures all requests stay within a safe directory

---

##  How to Run This Project

### Clone from GitHub
git clone https://github.com/sumedha037/FileViewer.git

Import in NetBeans
Open Apache NetBeans

Go to File > Open Project

Select the FileViewer folder

Configure Server
Ensure Apache Tomcat 11 is added in NetBeans

Right-click the project > Properties > Run

Set Context Path: /FileViewer

Select Server: Apache Tomcat

Run the Project
Right-click the project > Run

App will open at:

arduino
Copy
Edit
http://localhost:8080/FileViewer/
Test vulnerable endpoint:

bash
Copy
Edit
http://localhost:8080/FileViewer/VulnerableFileViewer?id=../../../secret/admin.txt
Test patched endpoint:

bash
Copy
Edit
http://localhost:8080/FileViewer/ReportViewerServlet?id=22BCON1553

### Security Note
Never store sensitive files like conf.env, admin.txt inside web-accessible folders in production.

Always sanitize input and handle errors gracefully in real applications.

Disclaimer
This project is for educational and training purposes only.
Do not deploy it in real-world environments.



