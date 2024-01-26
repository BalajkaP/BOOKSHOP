document.addEventListener("DOMContentLoaded", function() {
    createCatalogsAndBrochures();
});

function createCatalogsAndBrochures() {
    const container = document.getElementById('catalogsAndBrochures');

    const rows = 3;
    const columns = 3;

    const catalogsAndBrochuresData = [
        { title: 'Katalóg 1', year: '2022', content: 'Obsah katalógu 1' },
        { title: 'Katalóg 2', year: '2021', content: 'Obsah katalógu 2' },
        { title: 'Brožúra 1', year: '2020', content: 'Obsah brožúry 1' },
        // Ďalšie údaje o katalógoch a brožúrach
    ];

    for (let i = 0; i < rows; i++) {
        for (let j = 0; j < columns; j++) {
            const catalogItem = document.createElement('div');
            catalogItem.classList.add('catalog-item');
            catalogItem.setAttribute('data-title', catalogsAndBrochuresData[i * columns + j].title);
            catalogItem.setAttribute('data-year', catalogsAndBrochuresData[i * columns + j].year);
            catalogItem.setAttribute('data-content', catalogsAndBrochuresData[i * columns + j].content);

            container.appendChild(catalogItem);
        }
    }

    const catalogItems = document.querySelectorAll('.catalog-item');
    catalogItems.forEach(function(item) {
        item.addEventListener('click', function() {
            showCatalogOrBrochureDetails(item);
        });
    });
}

function showCatalogOrBrochureDetails(catalogItem) {
    const detailsContainer = document.getElementById('catalogAndBrochureDetails');
    const catalogTitle = catalogItem.getAttribute('data-title');
    const catalogYear = catalogItem.getAttribute('data-year');
    const catalogContent = catalogItem.getAttribute('data-content');

    detailsContainer.innerHTML = `
        <h2>${catalogTitle}</h2>
        <p><strong>Rok vydania:</strong> ${catalogYear}</p>
        <p>${catalogContent}</p>
    `;

    detailsContainer.style.display = 'block';
}
