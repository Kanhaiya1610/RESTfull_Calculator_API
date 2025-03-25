function calculate(operation) {
    const value = document.getElementById('inputValue').value;
    fetch(`/api/calculator/${operation}?value=${value}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Invalid input or server error');
            }
            return response.json();
        })
        .then(data => {
            document.getElementById('result').innerText = `Result: ${data}`;
        })
        .catch(error => {
            document.getElementById('result').innerText = `Error: ${error.message}`;
        });
}

function convertUnits() {
    const value = document.getElementById('conversionValue').value;
    const fromUnit = document.getElementById('fromUnit').value;
    const toUnit = document.getElementById('toUnit').value;

    if (isNaN(value) || value.trim() === "") {
        document.getElementById('result').innerText = "Please enter a valid number.";
        return;
    }

    let endpoint = '';
    if (['celsius', 'fahrenheit', 'kelvin'].includes(fromUnit) && ['celsius', 'fahrenheit', 'kelvin'].includes(toUnit)) {
        endpoint = `/api/calculator/convert/temperature?value=${value}&fromUnit=${fromUnit}&toUnit=${toUnit}`;
    } else {
        endpoint = `/api/calculator/convert/${fromUnit}/${toUnit}?value=${value}`;
    }

    fetch(endpoint)
        .then(response => {
            if (!response.ok) {
                throw new Error('Invalid input or server error');
            }
            return response.json();
        })
        .then(data => {
            document.getElementById('result').innerText = `Converted Result: ${data}`;
        })
        .catch(error => {
            document.getElementById('result').innerText = `Error: ${error.message}`;
        });
}
