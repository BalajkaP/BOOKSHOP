// script.js
console.log('Začátek js');

document.addEventListener("DOMContentLoaded", function() {
    // Event listener pre odkaz "Katalógy a brožúry"
    const catalogsAndBrochuresLink = document.querySelector('.menu-link[href="catalogsAndBrochures.html"]');
    catalogsAndBrochuresLink.addEventListener('click', function(event) {
        event.preventDefault();
        openCatalogsAndBrochuresWindow();
    });

    // Event listener pre modálne okno a tlačidlo zavretia
    const closeModalBtn = document.querySelector('.close');
    closeModalBtn.addEventListener('click', closeModal);

    window.addEventListener('click', function(event) {
        const modal = document.getElementById('myModal');
        if (event.target === modal) {
            closeModal();
        }
    });
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

function openCatalogsAndBrochuresWindow() {
    const catalogsAndBrochuresWindow = window.open('catalogsAndBrochures.html', '_blank');
}

function showCatalogOrBrochureDetails(catalogItem) {
    const detailsContainer = document.getElementById('catalogAndBrochureDetails');
    const catalogTitle = catalogItem.getAttribute('data-title');
    const catalogYear = catalogItem.getAttribute('data-year');
    const catalogContent = catalogItem.getAttribute('data-content');
    
    // Tu môžete pridať ďalšie detaily, ak sú potrebné

    detailsContainer.innerHTML = `
        <h2>${catalogTitle}</h2>
        <p><strong>Rok vydania:</strong> ${catalogYear}</p>
        <p>${catalogContent}</p>
    `;

    detailsContainer.style.display = 'block';
}

