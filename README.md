# 📝 NoteMaker App (Java)

A simple **terminal-based note-taking application** written in Java. This program allows you to create, append, view, search, and delete notes from a plain text file (`Notes.txt`). It's designed to help you manage quick notes from the command line.

---

## 📦 Features

- ✅ Add a new note (overwrites existing notes)
- ➕ Append additional notes
- 👀 View all stored notes
- 🔍 Search notes by keyword
- ❌ Delete a specific note by number
- 🧹 Clear all notes
- 📄 File-based (no database needed)

---

## 🛠️ Technologies Used

- Java (Standard Edition)
- File I/O (`FileWriter`, `FileReader`, `BufferedReader`)
- Terminal/Command Line Interface
- No external libraries

---

## 🚀 How to Run

### 1. Clone the Repository
    git clone https://github.com/YourUsername/NoteMakerApp.git
    cd NoteMakerApp
2. Compile the Program
    javac NoteMaker.java
3. Run the Program
    java NoteMaker
📂 File Structure

  NoteMakerApp/
  │
  ├── NoteMaker.java      # Main Java program
  ├── Notes.txt           # Notes storage file (auto-created)
  └── README.md           # This file
  💡 Example Usage
  
------WELCOME TO NOTES APP------
1. Add a new note
2. Append a new note
3. View all notes
4. Search a note
5. Delete a note
6. Delete all notes
7. Menu
8. Exit

Enter your choice-

🔐 Notes
Notes are stored in a simple text format with headings like --- NOTE 1 ---.

Searching is case-insensitive.

When deleting a note, enter its number (e.g., 1, 2, 3...).

🙋 Author
Made with ❤️ by Pratheek Gaba
