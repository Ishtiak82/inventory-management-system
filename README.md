# Inventory Management System (Java Swing)

A simple **Java Swing desktop application** for managing inventory items with user login, admin management and basic product filtering.  
Users can log in, add admins, add products to the inventory, and quickly see which items are still under warranty.

---

## ✨ Features

- 🔐 **Login system**
  - Only registered users can access the system.
  - (You can add new admins/users from inside the app.)

- 👤 **Admin / User management**
  - Add new admin accounts from the UI.
  - Basic user/admin management for a small desktop app.

- 📦 **Inventory management**
  For each product you can store:
  - Product name  
  - Serial number  
  - Price  
  - Condition (e.g. New, Used, Damaged)  
  - Warranty availability (Yes / No)
  - Availability status

- ✅ **Warranty filter**
  - View **only products that are under warranty** in a separate view/filter.
  - Helpful for quickly checking which items are still covered.

---

## 🛠️ Tech Stack

- **Language:** Java  
- **GUI:** Java Swing  
- **IDE:** Eclipse  
- **Database:** SQL database (see `.sql` file in this repo)

---

## 📁 Project Structure (basic idea)

> The exact structure may vary, but the project roughly contains:

- `src/` – Java source files  
  - Login / authentication classes  
  - Admin / user handling  
  - Inventory / product classes  
  - Database connection/helper classes  
- `db/` or root `.sql` file – SQL script to create the database and tables

---

## 🚀 Getting Started

### 1. Prerequisites

- **Java JDK** 8 or later  
- **Eclipse IDE** (or any Java IDE)
- A SQL database (e.g. MySQL / MariaDB / PostgreSQL – depends how you configure it)

### 2. Clone the repository

```bash
git clone https://github.com/Ishtiak82/inventory-management-system.git
