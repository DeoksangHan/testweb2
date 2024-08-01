// 목록화면으로 이동 기능

const listButton = document.getElementById('list-btn');

if (listButton) {
    listButton.addEventListener('click', event => {
       location.replace('/articles');
    });
};

// 삭제 기능
const deleteButton = document.getElementById('delete-btn');

if (deleteButton) {
    deleteButton.addEventListener('click', event => {
        let id = document.getElementById('article-id').value;
        fetch(`/articles/${id}`, {
            method: 'DELETE'
        })
            .then(() => {
                alert('삭제가 완료되었습니다.');
                location.replace('/articles');
            });
    });
};

// 수정 기능
const modifyButton = document.getElementById('modify-btn');

if (modifyButton) {
	//클릭 이벤트가 감지되면 수정 API 요청
    modifyButton.addEventListener('click', event => {
		// <-- location :  ..../new-article?id=10
        let params = new URLSearchParams(location.search);  
        let id = params.get('id');

        fetch(`/articles/${id}`, {
            method: 'PUT',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title').value,
                content: document.getElementById('content').value
            })
        })
            .then(() => {
                alert('수정이 완료되었습니다.');
                location.replace(`/articles/${id}`);
            });
    });
}

// 생성 기능
const createButton = document.getElementById('create-btn');

if (createButton) {
    createButton.addEventListener('click', event => {
        fetch('/new-article', {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title').value,
                content: document.getElementById('content').value
            })
        })
            .then(() => {
                alert('등록 완료되었습니다.');
                location.replace('/articles');
            });
    });
}