# Library REST API

## This repository contains extra exercise from Kodilla course. 


## Description:
This is REST API for book rental service from the library. It uses standard HTTP methods like: GET, PUT and POST.


**REST API services allow administrator to the followings actions:**
- creating new reader,
- creating new book,
- creating new item,
- changing status of item,
- checking number of items from indicated book,
- renting book,
- returning book.


**Application contains four modeled entities:**
- READERS with columns:
  - reader ID,
  - name,
  - lastname,
  - account created date.
- BOOKS with columns:
  - book ID,
  - title,
  - author,
  - release date.
- ITEMS with columns:
  - item ID,
  - book ID,
  - status (e.g. available).
- BORROWINGS with columns:
  - item ID,
  - reader ID,
  - borrowing date,
  - return date.


## Explanation:
For example, if there are five "Catcher in the Rye" books in the library resources, then in database tables there will be one item in table called BOOKS and five items
in table called ITEMS. Thanks to this, each piece is identifiable in database without duplication infromation such as the title or author.
