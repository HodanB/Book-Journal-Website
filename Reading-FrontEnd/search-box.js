const readingList = document.getElementById('readingList');
const searchBar = document.getElementById('searchBar');
let hpBooks = [];

searchBar.addEventListener('keyup', (e) => {
    const searchString = e.target.value.toLowerCase();

    const filteredBooks = hpBooks.filter((book) => {
        return (
            book.title.toLowerCase().includes(searchString) ||
            book.author.toLowerCase().includes(searchString)
        );
    });
    displayBooks(filteredBooks);
});
const loadBooks = async () => {
    try {
        const res = await fetch('http://localhost:8080/getBooks');
        hpBooks = await res.json();
        displayBooks(hpBooks);
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
                <p>Author: ${book.author}</p>
            </li>
        `;
        })
        .join('');
    readingList.innerHTML = htmlString;
};
loadBooks();