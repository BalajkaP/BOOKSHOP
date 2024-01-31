function showCatalogOrBrochureDetails(catalogItem) {
    const detailsContainer = document.getElementById('catalogAndBrochureDetails');
    const catalogTitle = catalogItem.getAttribute('data-title');
    const catalogYear = catalogItem.getAttribute('data-year');
    const catalogContent = catalogItem.getAttribute('data-content');

    const detailsWindow = document.getElementById('details-window');
    detailsWindow.innerHTML = `
        <h2>${catalogTitle}</h2>
        <p><strong>Rok vydání:</strong> ${catalogYear}</p>
        <p>${catalogContent}</p>
    `;

    detailsContainer.style.display = 'block';
    detailsWindow.style.display = 'block';

    detailsContainer.innerHTML = `
        <h2>${catalogTitle}</h2>
        <p><strong>Rok vydania:</strong> ${catalogYear}</p>
        <p>${catalogContent}</p>
    `;

    detailsContainer.style.display = 'block';
}

function openDetailsWindow(title, year, content, imageUrl) {
    const detailsWindow = document.getElementById('details-window');
    detailsWindow.innerHTML = `
        <h2>${title}</h2>
        <p><strong>Rok vydania:</strong> ${year}</p>
        <p class="details">${content}</p>
        <img src="${imageUrl}" alt="${title}">
    `;

    detailsWindow.style.display = 'block';
}

document.addEventListener("DOMContentLoaded", function() {
    createCatalogsAndBrochures();
});

function createCatalogsAndBrochures() {
    // Kód pro vytvoření katalogů a brožur...
    // ...
}
