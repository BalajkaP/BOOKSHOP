// script.js
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
