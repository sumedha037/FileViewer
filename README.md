
# 🛡️ FileViewer - JSP Vulnerable Web App

A deliberately vulnerable Java web application that demonstrates **Path Traversal** and **Stack Trace Information Disclosure** vulnerabilities using JSP and Java I/O.

---

## 📁 Project Structure

```
FileViewer/
│
├── Web Pages/
│   │
│   ├── WEB-INF/
│   │   └── web.xml
│   │
│   ├── config/
│   │   └── conf.env              # 🟡 Sensitive config file (can be targeted)
│   │
│   ├── reports/
│   │   ├── 22BCON1552              # ✅ Valid student report files
│   │   ├── 22BCON1553
│   │   └── 22BCON1554
│   │
│   ├── secret/
│   │   └── admin.txt               # 🔐 Secret file to simulate sensitive data
│   │
│   ├── view.jsp                    # ❌ Vulnerable file (Path Traversal)
│   ├── PatchedView.jsp            # ✅ Patched version with input validation
│   └── index.jsp                  # Home page (optional)
│
└─
```

## ⚙️ Technology Stack

- **Frontend**: HTML (via JSP)
- **Backend**: JSP (Java Server Pages)
- **Server**: Apache Tomcat 11
- **Language**: Java 8+
- **IDE**: NetBeans (Apache or Oracle)

---

## 🛠️ Features & Vulnerabilities Demonstrated

### 🔴 Vulnerable File: `view.jsp`
- Accepts `id` parameter from the URL (e.g., `?id=../../../config/conf.env`)
- Uses `FileReader` to read any file on the server
- Lacks proper input validation
- ❗ Allows **Path Traversal** and may leak stack traces if file access fails

### ✅ Patched File: `PatchedView.jsp`
- Blocks dangerous characters (`../`, `/`, `\`)
- Ensures canonical path stays inside `/reports`
- Returns clean error messages instead of stack traces

---

## 🧪 Example Exploits

### 1. **Path Traversal**
```
http://localhost:8080/FileViewer/view.jsp?id=../../../secret/admin.txt
```

### 2. **Stack Trace Disclosure**
If a file is missing or access fails, the unhandled exception in `view.jsp` may reveal stack trace like:
```
java.io.FileNotFoundException: ...
	at ...
```

---

## 🧩 How It Works Behind the Scenes

- JSP pages are compiled into Java Servlets by the container (Tomcat).
- All logic ends up inside the `_jspService()` method.
- When you run `view.jsp`, it becomes a Java servlet class under the hood and handles the request.
- Use `Tomcat/work/Catalina/localhost/FileViewer/org/apache/jsp` to inspect compiled `.java` versions of JSPs (optional).

---

## 🚫 Disclaimer

> This app is built only for **educational** and **demonstration** purposes.
> Do **not** deploy it in a production environment.

---

## ✅ To Run the App

1. Open in **Apache NetBeans**
2. Start **Apache Tomcat 11** server
3. Right-click project > Run
4. Visit: `http://localhost:8080/FileViewer/view.jsp?id=22BCON1552`

---

## 📌 Note

- Keep your sensitive files like `conf.env`, `admin.txt` outside web-accessible folders in real apps.
- Always sanitize user input and handle errors gracefully.

---
