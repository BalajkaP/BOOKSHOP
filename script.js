// script.js
// script.js
console.log('Začátek js');

// Funkce pro změnu barvy pozadí při kliknutí
function changeOptionColor(option) {
    option.style.backgroundColor = getRandomColor();
}

// Funkce pro generování náhodné barvy
function getRandomColor() {
    const letters = '0123456789ABCDEF';
    let color = '#';
    for (let i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}
document.addEventListener("DOMContentLoaded", function() {
    // Event listenery pro odkazy na kategorie
    const categoryLinks = document.querySelectorAll('#book-categories a');
  
    categoryLinks.forEach(link => {
      link.addEventListener('click', function(event) {
        event.preventDefault();
        const category = this.getAttribute('data-category');
        openModal(category); // Otevře modální okno s knihami dané kategorie
      });
    });
  
    // Další váš kód, například funkce changeOptionColor, getRandomColor, fetchData, atd.
    console.log('Začátek js');
  
    // Event listenery pro modální okno a tlačítko zavření
    const closeBtn = document.querySelector('.close');
    closeBtn.addEventListener('click', closeModal);
  
    window.addEventListener('click', function(event) {
      const modal = document.getElementById('myModal');
      if (event.target === modal) {
        closeModal();
      }
    });
  });
  
  // Zbytek vašeho kódu (např. definice funkcí changeOptionColor, getRandomColor, fetchData, atd.)
  
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

// Event listenery pro modální okno a tlačítko zavření
const closeBtn = document.querySelector('.close');
closeBtn.addEventListener('click', closeModal);

window.addEventListener('click', function(event) {
    const modal = document.getElementById('myModal');
    if (event.target === modal) {
        closeModal();
    }
});

