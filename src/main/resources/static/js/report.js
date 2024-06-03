document.querySelectorAll(".report-checkbox").forEach(function (checkbox) {
    checkbox.addEventListener("change", function () {
        const reportReason = document.getElementById("report-reason");

        if (checkbox.checked) {
            document.querySelectorAll(".report-checkbox").forEach(function (box) {
                if (box !== checkbox) {
                    box.disabled = true;
                }
            });
            if (checkbox.value === "기타") {
                reportReason.disabled = false;
            } else {
                reportReason.disabled = true;
            }
        } else {
            document.querySelectorAll(".report-checkbox").forEach(function (box) {
                box.disabled = false;
            });
            reportReason.disabled = true;
            if (checkbox.value === "기타") {
                reportReason.value = ""; // Clear the text box if "기타" is deselected
            }
        }
    });
});

document.getElementById("report-reason").addEventListener("input", function () {
    this.style.height = "auto";
    this.style.height = this.scrollHeight + "px";
});

document
    .getElementById("reportForm")
    .addEventListener("submit", function (event) {
        event.preventDefault();
        const anyChecked = Array.from(
            document.querySelectorAll(".report-checkbox")
        ).some(function (checkbox) {
            return checkbox.checked;
        });

        if (!anyChecked) {
            alert("신고 사유를 선택해주세요.");
            return;
        }

        const otherCheckbox = document.querySelector('.report-checkbox[value="기타"]');
        const reportReason = document.getElementById("report-reason");

        if (otherCheckbox.checked && !reportReason.value.trim()) {
            alert("신고 사유를 입력해주세요.");
            return;
        }

        alert("신고가 등록되었습니다.");
    });