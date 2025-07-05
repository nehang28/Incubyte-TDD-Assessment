# String Calculator

This is a simple Java Maven project that implements the **String Calculator Kata** using TDD and JUnit 5.

---

## ✅ Features

- Returns 0 for an empty string  
- Returns number itself for a single number  
- Returns sum for two or more numbers separated by commas or new lines  
- Supports custom delimiters (e.g., `//;\n1;2`)  
- Throws exception for negative numbers (e.g., `-1` → throws `"negative number not allowed [-1]"`)  
- Ignores numbers greater than 1000  
- Supports delimiters of any length (e.g., `//[***]\n1***2***3` → returns `6`)  
- Supports multiple delimiters (e.g., `//[*][%]\n1*2%3` → returns `6`)  
- Supports multiple delimiters with length longer than one char (e.g., `//[;;][%%]\n1;;2%%3` → returns `6`)  

---

## 📥 Clone the Repository

```bash
git clone https://github.com/nehang28/Incubyte-TDD-Assessment
