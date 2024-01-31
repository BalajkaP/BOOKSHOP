// booksScript.js
console.log('Začiatok booksScript.js ');

document.addEventListener("DOMContentLoaded", function() {
    setRandomBannerImage();
    fetchData('books'); // Získanie údajov o knihách pri načítaní stránky
});

async function fetchData(endpoint) {
    try {
        const response = await fetch(`http://localhost:3000/${endpoint}`);
        const data = await response.json();
        console.log(data);

        // Ak endpoint je 'books', zavolaj funkciu pre zobrazenie kníh
        if (endpoint === 'books') {
            displayBooks(data);
        }
    } catch (error) {
        console.error('Chyba pri získavaní údajov:', error);
    }
}

function displayBooks(books) {
    const bookGrid = document.getElementById('book-grid');

    if (bookGrid) {
        // Vyčistenie obsahu mriežky kníh pred vložením nových údajov
        bookGrid.innerHTML = '';

        // Iterácia cez každú knihu a vytvorenie prvkov v mriežke
        books.forEach(book => {
            const bookItem = document.createElement('div');
            bookItem.classList.add('book-item');

            // Vytvorenie obrázka knihy
            const bookImage = document.createElement('img');
            bookImage.src = book.image;
            bookImage.alt = book.title;
            bookItem.appendChild(bookImage);

            // Vytvorenie názvu knihy
            const bookTitle = document.createElement('h3');
            bookTitle.textContent = book.title;
            bookItem.appendChild(bookTitle);

            // Vytvorenie autora knihy
            const bookAuthor = document.createElement('p');
            bookAuthor.textContent = 'Author: ' + book.author;
            bookItem.appendChild(bookAuthor);

            // Ďalšie informácie a prvky môžete pridávať podľa potreby

            // Pridanie knihy do mriežky
            bookGrid.appendChild(bookItem);
        });
    } else {
        console.error("Element with id 'book-grid' not found.");
    }
}

// Funkcie pre náhodnú farbu a zmenu farby pozadia (zostáva nezmenené)
function changeOptionColor(option) {
    option.style.backgroundColor = getRandomColor();
}

function getRandomColor() {
    const letters = '0123456789ABCDEF';
    let color = '#';
    for (let i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}

// Funkcia pre náhodné nastavenie banner obrázka (zostáva nezmenená)
function setRandomBannerImage() {
    // prípadne implementujte podľa vašich potrieb
}

// booksScript.js


// ... (predchádzajúci kód)

function displayBooks(books, categoryFilter) {
    const bookGrid = document.getElementById('book-grid');

    if (bookGrid) {
        // Vyčistenie obsahu mriežky kníh pred vložením nových údajov
        bookGrid.innerHTML = '';

        // Filtrácia kníh podľa kategórie
        const filteredBooks = categoryFilter ? books.filter(book => book.category === categoryFilter) : books;

        // Iterácia cez každú knihu a vytvorenie prvkov v mriežke
        filteredBooks.forEach(book => {
            const bookItem = document.createElement('div');
            bookItem.classList.add('book-item');

            // Vytvorenie obrázka knihy
            const bookImage = document.createElement('img');
            bookImage.src = book.image;
            bookImage.alt = book.title;
            bookItem.appendChild(bookImage);

            // Vytvorenie názvu knihy
            const bookTitle = document.createElement('h3');
            bookTitle.textContent = book.title;
            bookItem.appendChild(bookTitle);

            // Vytvorenie autora knihy
            const bookAuthor = document.createElement('p');
            bookAuthor.textContent = 'Author: ' + book.author;
            bookItem.appendChild(bookAuthor);

            // Ďalšie informácie a prvky môžete pridávať podľa potreby

            // Pridanie knihy do mriežky
            bookGrid.appendChild(bookItem);
        });
    } else {
        console.error("Element with id 'book-grid' not found.");
    }
}

// ... (zostávajúci kód)
