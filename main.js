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

// Nastavenie náhodného obrázka pri načítaní stránky
document.addEventListener("DOMContentLoaded", function() {
    setRandomBannerImage();
});

function setRandomBannerImage() {
    const banner = document.getElementById('book-banner');
    const images = ['image1.jpg', 'image2.jpg', 'image3.jpg'];
    const randomImage = images[Math.floor(Math.random() * images.length)];
    const imagePath = 'cesta/k/' + randomImage; // Uveďte správnu cestu k obrázku
    banner.style.backgroundImage = 'url("' + imagePath + '")';
}
