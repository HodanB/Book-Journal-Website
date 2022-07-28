const readingList = document.getElementById('readingList');
const searchBar = document.getElementById('searchBar');
let Books = [];

searchBar.addEventListener('keyup', (e) => {
    const searchString = e.target.value.toLowerCase();

    const filteredBooks = Books.filter((book) => {
        return (
            book.title.toLowerCase().includes(searchString) ||
            book.author.toLowerCase().includes(searchString) ||
            book.genre.toLowerCase().includes(searchString ) ||
            book.releaseYear.toLowerCase().includes(searchString )

            
        );
    });
    displayBooks(filteredBooks);
});
const loadBooks = async () => {
    try {
        const res = await fetch('http://localhost:8080/getBooks');
        Books = await res.json();
        displayBooks(Books);
    } catch (err) {
        console.error(err);
    }
};
const displayBooks = (books) => {
    const htmlString = books
        .map((book) => {
            return `
            <li class="book">
                <h2>${book.title}</h2>
                <p> Author: ${book.author} (Genre: ${book.genre},  Pages: ${book.pages},  ReleaseYear: ${book.releaseYear})</p>
            </li>
        `;
        })
        .join('');
    readingList.innerHTML = htmlString;
};
loadBooks();