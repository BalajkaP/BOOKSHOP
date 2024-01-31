// script.js
console.log('Za4iatok js ')
function changeOptionColor(option) {
    // Zmení farbu pozadia pri kliknutí
    option.style.backgroundColor = getRandomColor();
}

function getRandomColor() {
    // Generuje náhodnú farbu
    const letters = '0123456789ABCDEF';
    let color = '#';
    for (let i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}

document.addEventListener("DOMContentLoaded", function() {
    setRandomBannerImage();
});


async function fetchData(endpoint) {
    try {
        const response = await fetch(`http://localhost:3000/${endpoint}`);
        const data = await response.json();
        console.log(data);
    } catch (error) {
        console.error('Chyba pri získavaní údajov:', error);
    }
}

// Volanie funkcie pre každú stránku
fetchData('');
fetchData('books');
fetchData('about');
fetchData('contact');
