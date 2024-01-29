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

const categoryLinks = document.querySelectorAll('#book-categories a');


// Event listener pro každý odkaz na kategorii
categoryLinks.forEach(link => {
  link.addEventListener('click', function(event) {
    event.preventDefault();
    const category = this.getAttribute('data-category');
    openModal(category); // Otevře modální okno s knihami dané kategorie
  });
});


// Funkce pro otevření modálního okna s obsahem kategorie
function openModal(category) {
    const modal = document.getElementById('myModal');
    const modalTitle = document.getElementById('modal-title');
    const modalContentList = document.getElementById('modal-content-list');

  
    // Nastaví titulek modálního okna
    modalTitle.textContent = `Knižní kategorie: ${category}`;

  
    // Zde byste měli načítat obsah knih pro danou kategorii
    // Místo toho použijeme jednoduchý seznam pro příklad
    const books = ['Kniha 1', 'Kniha 2', 'Kniha 3'];

  
    // Naplní seznam v modálním okně
    modalContentList.innerHTML = '';
    books.forEach(book => {
      const listItem = document.createElement('li');
      listItem.textContent = book;
      modalContentList.appendChild(listItem);
    });
  

    // Otevře modální okno
    modal.style.display = 'block';
  }
  
  // Funkce pro zavření modálního okna
  function closeModal() {
    const modal = document.getElementById('myModal');
    modal.style.display = 'none';
  }
  
  // Event listener pro tlačítko zavření
  const closeBtn = document.querySelector('.close');
  closeBtn.addEventListener('click', closeModal);

  
  // Event listener pro modální okno (zavře se při kliknutí mimo obsah)
  window.addEventListener('click', function(event) {
    const modal = document.getElementById('myModal');
    if (event.target === modal) {
      closeModal();
    }
  });



  

