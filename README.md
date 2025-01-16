# QuanLyThuChi (Income and Expense Management System)

## Overview
QuanLyThuChi is a Java-based desktop application designed to manage income and expenses for individuals or organizations. The system allows users to track financial transactions, including income and expenses, while providing features to manage related data such as students, instructors, and transaction details.

## Features
### 1. **User Authentication**
   - Login interface to ensure secure access to the system.
   - Navigation to the main interface after successful authentication.

### 2. **Income Management**
   - Manage income data related to students and instructors.
   - Add, update, delete, and view details of income transactions.
   - Fields include:
     - Instructor details
     - Student details
     - Date of transaction
     - Amount received
     - Payment status

### 3. **Expense Management**
   - Manage expense data, including payments to instructors or other costs.
   - Add, update, delete, and view details of expense transactions.
   - Fields include:
     - Instructor details
     - Date of expense
     - Amount paid
     - Related course or activity

### 4. **Data Management**
   - Manage information about:
     - **Students (HocVien):** Name, gender, date of birth, phone number, and address.
     - **Instructors (GiangVien):** Name, gender, date of birth, phone number, and address.
   - Relational data management with foreign keys linking student or instructor to transactions.

### 5. **Database Integration**
   - The application uses a relational database to store all information securely.
   - SQL queries are used for CRUD operations on tables such as:
     - Income transactions (`thong_tin_thu`)
     - Expense transactions (`thong_tin_chi`)
     - Related entities like students (`HocVien`) and instructors (`GiangVien`).

### 6. **Graphical User Interface**
   - Intuitive GUI for ease of use.
   - Separate forms for login (`FrmDangNhap`), main dashboard (`FrmManHinhChinh`), and financial management.

---

## Project Structure

```plaintext
QuanLyThuChi/
├── src/
│   ├── controller/
│   │   └── Main.java                # Entry point of the application
│   ├── dao/
│   │   ├── ConectDatabase.java      # Database connection management
│   │   ├── ThongTinCaNhanDAO.java   # Data access for personal information
│   │   ├── ThongTinChiDAO.java      # Data access for expense transactions
│   │   └── ThongTinThuDAO.java      # Data access for income transactions
│   ├── gui/
│   │   ├── FrmDangNhap.java         # Login form
│   │   └── FrmManHinhChinh.java     # Main dashboard form
│   ├── model/
│   │   ├── HocVien.java             # Model for students
│   │   ├── GiangVien.java           # Model for instructors
│   │   └── DiaChi.java              # Model for addresses
│   └── util/
│       └── Util.java                # Utility class for date formatting, etc.
├── README.md                        # Project documentation
└── resources/                       # (Optional) Resource files (e.g., SQL scripts, images)
```

---

## Key Classes and Their Responsibilities

### 1. **Controller**
   - `Main.java`: The main entry point of the application. It initializes the database connection and launches the login form.

### 2. **DAO (Data Access Objects)**
   - `ThongTinCaNhanDAO.java`: Handles queries and operations related to personal information management.
   - `ThongTinChiDAO.java`: Manages CRUD operations for expense transactions.
   - `ThongTinThuDAO.java`: Manages CRUD operations for income transactions.

### 3. **Model**
   - `HocVien.java`: Represents a student with attributes like name, gender, date of birth, and contact details.
   - `GiangVien.java`: Represents an instructor with similar attributes.
   - `DiaChi.java`: Represents address details, which are linked to students and instructors.

### 4. **GUI**
   - `FrmDangNhap.java`: Login form for user authentication.
   - `FrmManHinhChinh.java`: Main form that serves as the dashboard for managing income and expenses.

---

## How to Run

### Prerequisites
1. **Java Development Kit (JDK):** Ensure JDK 8 or higher is installed.
2. **Database:** A relational database (e.g., MySQL) is required. Make sure the database is set up and configured correctly.
3. **IDE:** Use an IDE like Eclipse or IntelliJ IDEA for running the project.

### Steps to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/username/QuanLyThuChi.git
   ```
2. Open the project in your IDE.
3. Set up the database:
   - Import the SQL schema provided in the `resources/` folder.
   - Update database credentials in `ConectDatabase.java`.
4. Run the `Main.java` class to start the application.

---

## Database Tables

### Example Tables
1. **`thong_tin_thu` (Income Information):**
   - `id` (Primary Key)
   - `giangVienThu` (Instructor Name)
   - `tenHocVien` (Student Name)
   - `gioiTinh` (Gender)
   - `ngaySinh` (Date of Birth)
   - `monHoc` (Subject)
   - `ngayThu` (Transaction Date)
   - `diaChi` (Address)
   - `soTien` (Amount)
   - `soDienThoai` (Phone)
   - `trangThai` (Status)

2. **`thong_tin_chi` (Expense Information):**
   - `id` (Primary Key)
   - `giangVien` (Instructor Name)
   - `nhanVienChi` (Staff Name)
   - `gioiTinh` (Gender)
   - `soTien` (Amount)
   - `monGiangDay` (Subject)
   - `ngayChi` (Transaction Date)
   - `soDienThoai` (Phone)

3. Additional tables for students (`HocVien`), instructors (`GiangVien`), and addresses (`DiaChi`).

---

## Future Enhancements
1. Add reporting features for better financial insights.
2. Implement role-based user authentication.
3. Enhance the GUI for a more modern look.
4. Migrate to a web-based architecture for scalability.
5. Add localization support for multiple languages.

---

## Authors
This project was developed by a dedicated team of software engineers. Contributions are welcome!

---

## License
This project is licensed under the MIT License. Feel free to use, modify, and distribute it.
