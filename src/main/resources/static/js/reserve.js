calendarDate = document.getElementById('reservationDate');
cboxTime = document.getElementById('usageTime');
cboxCountPerson = document.getElementById('numPeople');
btnPurchase = document.getElementById('paymentButton');
reservationForm = document.getElementById('reservationForm');

function isInvalidDate(dateString)
{
    if(!dateString)
        return true;

    const datePattern = /^\d{4}-\d{2}-\d{2}$/;
    if(!datePattern.test(dateString))
        return true;

    const date = new Date(dateString);
    if(isNaN(date.getTime()))
        return true;

    const [year, month, day] = dateString.split('-').map(Number);
    if (date.getUTCFullYear() !== year || (date.getUTCMonth() + 1) !== month || date.getUTCDate() !== day)
        return true;

    return false;
}

function updatePrice()
{
    const parsedNumPeople = parseInt(cboxCountPerson.value);

    if(Number.isNaN(parsedNumPeople))
    {
        // TODO: 숫자를 제대로 받아올 수 없을 때 로직을 이 곳에서 처리합니다.
    }
    else
    {
        const pricePerPerson = 5000;
        const totalPrice = parsedNumPeople * pricePerPerson;
        btnPurchase.innerText = `결제 (${totalPrice}원)`;
    }
}

function setDateConstraints()
{
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

function ClearDate()
{
    calendarDate.value = '';
}

function ClearTime()
{
    let timeOptions = cboxTime.options;

    for(let i = 0; i < timeOptions.length; ++i)
        timeOptions[i].selected = (timeOptions[i].id === 'sel-0-00');
}

function ClearCountPerson()
{
    let cntOptions = cboxCountPerson.options;

    for(let i = 0; cntOptions.length; ++i)
        cntOptions[i].selected = (cntOptions[i].id === 'sel-1-00');
}

function OnSelectDate()
{
    ClearTime();
    ClearCountPerson();

    cboxTime.enabled = true;
    cboxCountPerson.enabled = false;
    btnPurchase.enabled = false;
}

function OnSelectTime()
{
    ClearCountPerson();

    cboxCountPerson.enabled = true;
    btnPurchase.enabled = false;
}

function OnSelectCountPerson()
{
    updatePrice();

    btnPurchase.enabled = true;
}

calendarDate.addEventListener('onselect', OnSelectDate);
cboxTime.addEventListener('onchange', OnSelectTime);
cboxCountPerson.addEventListener('onchange', OnSelectCountPerson);

// Initialize the date constraints and price on page load
document.addEventListener('DOMContentLoaded', (event) =>
{
    setDateConstraints();
    updatePrice();

    ClearDate();
    ClearTime();
    // ClearCountPerson();

    calendarDate.enabled = true;
    cboxTime.enabled = false;
    cboxCountPerson.enabled = false;
    btnPurchase.enabled = false;
});

window.addEventListener('pageshow', (event) =>
{
    setDateConstraints();
    updatePrice();

    ClearDate();
    ClearTime();
    // ClearCountPerson();

    calendarDate.enabled = true;
    cboxTime.enabled = false;
    cboxCountPerson.enabled = false;
    btnPurchase.enabled = false;
});

reservationForm.addEventListener('submit', function(event)
{
    event.preventDefault();

    const canPurchase = /*[[${canPurchase}]]*/"canPurchase";
    const canReserve = /*[[${canReserve}]]*/"canReserve";
    console.log(canPurchase);
    console.log(canReserve);

    if(!canPurchase)
    {
        alert("결제에 실패했습니다.");
    }
    else if(!canReserve)
    {
        alert("예약에 실패했습니다.");
    }
    else
    {
        // alert("예약에 성공했습니다.");
        event.target.submit();
    }
});
