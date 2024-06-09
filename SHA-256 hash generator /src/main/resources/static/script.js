function generateHash() {
    const inputText = document.getElementById('inputText').value;
    fetch('/api/generateHash', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(inputText)
    })
    .then(response => response.text())
    .then(hash => {
        document.getElementById('outputHash').innerText = "SHA-256 Hash: " + hash;
    })
    .catch(error => {
        console.error('Error:', error);
    });
}
