document.querySelectorAll(".report-checkbox").forEach(function (checkbox) {
    checkbox.addEventListener("change", function () {
        const reportReason = document.getElementById("report-reason");

        document.querySelectorAll(".report-checkbox").forEach(function(box) {
            box.disabled = checkbox.checked && (checkbox !== box);
        });

        reportReason.disabled = !(checkbox.checked && checkbox.id === "etc");

        if(reportReason.disabled)
        {
            reportReason.value = "";
        }
    });
});

// TODO: (우선순위 낮음) 페이지 뒤로 가기로 신고 페이지에 진입했을 때 모든 checkbox가 enable 상태이고 이전 선택한 기록이 남아있는데, 이를 해결하는 코드를 작성해야 합니다.

document.getElementById("report-reason").addEventListener("input", function () {
    this.style.height = "auto";
    this.style.height = this.scrollHeight + "px";
});

document.getElementById("reportForm").addEventListener("submit", function(event) {
    event.preventDefault();

    const anyChecked = Array.from(document.querySelectorAll(".report-checkbox")).some(function (checkbox)
    {
        return checkbox.checked;
    });

    if(!anyChecked)
    {
        alert("신고 사유를 선택하세요.");
        return;
    }

    const cboxEtc = document.querySelector(".report-checkbox[id='etc']");
    const txtReason = document.getElementById("report-reason");

    if(cboxEtc.checked && !txtReason.value.trim())
    {
        alert("신고 사유를 입력하세요.");
    }
    else
    {
        alert("신고가 등록되었습니다.");
        event.target.submit();
    }
});