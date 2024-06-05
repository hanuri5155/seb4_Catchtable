function updatePrice() {
    const numPeople = document.getElementById('numPeople').value;
    const pricePerPerson = 5000;
    const totalPrice = numPeople * pricePerPerson;
    document.getElementById('paymentButton').innerText = `결제 (${totalPrice}원)`;
}

function setDateConstraints() {
    const today = new Date();
    const yyyy = today.getFullYear();
    const mm = String(today.getMonth() + 1).padStart(2, '0');
    const dd = String(today.getDate()).padStart(2, '0');

    const minDate = `${yyyy}-${mm}-${dd}`;
    const maxDate = new Date();
    maxDate.setDate(today.getDate() + 14);
    const maxYyyy = maxDate.getFullYear();
    const maxMm = String(maxDate.getMonth() + 1).padStart(2, '0');
    const maxDd = String(maxDate.getDate()).padStart(2, '0');
    const maxDateStr = `${maxYyyy}-${maxMm}-${maxDd}`;

    document.getElementById('reservationDate').setAttribute('min', minDate);
    document.getElementById('reservationDate').setAttribute('max', maxDateStr);
}

// Initialize the date constraints and price on page load
document.addEventListener('DOMContentLoaded', (event) => {
    setDateConstraints();
    updatePrice();
});