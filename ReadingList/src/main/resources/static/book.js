"use strict";

document.querySelector("form").addEventListener("submit", function (event) {
    event.preventDefault(); // turns off the page refresh/redirect

    console.log("THIS:", this);


const form = event.target;
//const data
const  book = {
title: form.title.value,
author: form.author.value,
genre: form.genre.value,
pages: form.pages.value,
releaseYear: form.releaseYear.value,
}



axios.post("http://localhost:8080/createBook", book)
.then(res => {
    console.log("RESPONSE: ", res);
    form.title.focus();
    form.reset();
    console.log("success");
    renderBooks();
})
.catch(err => console.error(err));
console.log("Book: ", book);

});

function renderBooks() {
    axios.get("http://localhost:8080/getBooks")
        .then(res => {
        console.log("books: ", res.data);
        output.innerHTML = "";
        for (let book of res.data) {
            const bookCol = document.createElement("div");
                bookCol.className = "col";
    
            const bookCard = document.createElement("div");
                bookCard.className = "card";
                bookCol.appendChild(bookCard);
      
            const bookDiv = document.createElement("div");
                bookDiv.className = "card-body";
                bookCard.appendChild(bookDiv);
      
            const bookTitle = document.createElement("h2");
                bookTitle.innerText = book.title;
                bookDiv.appendChild(bookTitle);
    
            const bookAuthor = document.createElement("p");
                bookAuthor.innerText = book.author;
                bookDiv.appendChild(bookAuthor);

            const bookGenre = document.createElement("p");
                bookGenre.innerText = book.genre;
                bookDiv.appendChild(bookGenre);
        
            const bookPages = document.createElement("p");
                bookPages.innerText = book.pages + " pages.";
                bookDiv.appendChild(bookPages);

            const bookreleaseYear = document.createElement("p");
                 bookreleaseYear.innerText = book.releaseYear;
                bookDiv.appendChild(bookreleaseYear);
            
            const bookUpdate = document.createElement("button");
                bookUpdate.innerText = "Update";
                bookUpdate.className = "btn btn-outline-success";
                bookUpdate.addEventListener("click", () => {
                    console.log();
                    updateBook(book.id);
                    
                });
                bookDiv.appendChild(bookUpdate);
                output.appendChild(bookCol);

                          

                
            const bookDelete = document.createElement("button");
                bookDelete.innerText = " Remove ";
                bookDelete.className = "btn btn-outline-danger";
                bookDelete.addEventListener("click", function () {
                deleteBook(book.id);
        
            });     
        
            bookDiv.appendChild(bookDelete);
        
            output.appendChild(bookCol);
        }
    })

    .catch(err => console.error(err));

}
function deleteBook(id) {
    axios.delete("http://localhost:8080/removeBook/" + id)
        .then(res => {
                console.log(res);
                 renderBooks();
    
            })
            .catch(err => console.error(err));
        }
const updateBook= (id) => {
    console.log("title"+ this.title.value);
    axios.patch("http://localhost:8080/updateBook/" + id + "?title=" + this.title.value + "&author=" + this.author.value + "&genre=" + this.genre.value
        + "&pages=" + this.pages.value + "&releaseYear=" + this.releaseYear.value )
            .then(res => {
                console.log("Update successful");
                renderBooks();
            })
            .catch(err => console.log(err));
            }
    
    renderBooks();

