const stars = document.querySelectorAll('.star');
const ratingInput = document.getElementById('rating_input');

stars.forEach((star, index) => {
    star.addEventListener('click', () => {
        if (star.classList.contains('selected')) {
            stars.forEach((s, i) => {
                if (i >= index) {
                    s.classList.remove('selected');
                    s.innerHTML = '&#9734;'; // Unicode for empty star
                }
            });

            ratingInput.value = index;
        } else {
            stars.forEach((s, i) => {
                if (i <= index) {
                    s.classList.add('selected');
                    s.innerHTML = '&#9733;'; // Unicode for filled star
                }
            });

            ratingInput.value = index + 1;
        }
    });
});

document.getElementById('photo').addEventListener('change', function() {
    const file = this.files[0];
    const preview = document.getElementById('photo-preview');
    const uploadBtn = document.getElementById('upload-btn');

    const reader = new FileReader();
    reader.onload = function(e) {
        const img = document.createElement('img');
        img.src = e.target.result;
        preview.innerHTML = '';
        preview.appendChild(img);

        const deleteBtn = document.createElement('button');
        deleteBtn.textContent = '삭제';
        deleteBtn.classList.add('delete-btn');
        preview.appendChild(deleteBtn);

        deleteBtn.addEventListener('click', function() {
            preview.innerHTML = '';
            uploadBtn.style.display = 'block';
        });

        uploadBtn.style.display = 'none';
    }
    reader.readAsDataURL(file);
});

const reviewText = document.getElementById('review');
reviewText.addEventListener('input', function() {
    this.style.height = 'auto';
    this.style.height = (this.scrollHeight) + 'px';
});
/*
document.querySelector('.submit-btn').addEventListener('click', function() {
    if (reviewText.value.length < 15) {
        alert('리뷰는 최소 15자 이상 작성해주세요.');
    } else {
        alert('리뷰가 등록되었습니다!');
    }
});
*/
document.getElementById("reviewForm").addEventListener("submit", function(event) {
    event.preventDefault();

    if(ratingInput.value < 1 || ratingInput > 5)
    {
        alert("별점을 1~5 사이의 값으로 매겨주세요.");
    }
    else if(!reviewText.value.trim() || reviewText.value.length < 15)
    {
        alert("리뷰는 최소 15자 이상 작성해주세요.");
    }
    else
    {
        alert("리뷰가 등록되었습니다!");
        event.target.submit();
    }
});