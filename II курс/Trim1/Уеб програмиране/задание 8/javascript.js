function makemefade() { document.getElementById('calc').style.opacity="0.8"; }
function makemevisible() { document.getElementById('calc').style.opacity="1.0"; }

var counter = 1;

function displayTax() {
	var tax = calcTax();
	var text = "Данък: " + tax.toFixed(2) + " лв";
	document.getElementById('tax').innerHTML = text;
}

function calcTax() {
	var sum = calcSum();
	return (sum * 0.20);
}

function displayProfit() {
	displayTax();

	var profit = calcProfit();
	var text = "Печалба: " + profit.toFixed(2) + " лв";
	document.getElementById('profit').innerHTML = text;
}

function calcProfit() {
	var sum = calcSum();
	var tax = calcTax();
	return (sum - tax);
}

function calcSum() {
	var sum = 0;
	for(var i = 1; i <= counter; i++)
	{
		var profitBoxId = "prihod" + i;
		var expenseBoxId = "razhod" + i;
		
		var income = document.getElementById(profitBoxId).value;
		var expense = document.getElementById(expenseBoxId).value;

		sum += (income - expense);
	}
	return sum;
}

function addMonth(){
	if(counter == 12) {
		return;
	}

	counter++;
	var monthHtml = generateHtmlForMonth(counter);
	document.getElementById('data').insertAdjacentHTML('beforeend', monthHtml);
}

function generateHtmlForMonth(index) {
		var name = "mesec" + index;
		var incomeId = "prihod" + index;
		var expenseId = "razhod" + index;
		
		var fullString = "<div id= 'month" + index + "' class = 'month'>";
		fullString += "Месец " + index + " ";
		fullString += "<input id='" + incomeId + "' type='number' onKeyUp = 'validateInput(this.id)' step='0.01' min='0' placeholder='0' class='numberBox'>";
		fullString += "<input id='" + expenseId + "' type='number' onKeyUp = 'validateInput(this.id)' step='0.01' min='0' placeholder='0' class='numberBox'>";
		fullString += "<input type='button' onclick='removeMonth(" + index + ")' value='X'/>";
		fullString += "</div>";
		
		return fullString;
}

function removeMonth(index) {
	if(counter == 1) {
		return;
	}
	
	deleteMonthElement(index);
	
	for(var i = index + 1; i <= counter; i++) {
		var incomeVal = document.getElementById("prihod" + i).value;
		var expenseVal = document.getElementById("razhod" + i).value;
		
		deleteMonthElement(i);
		
		var monthHtml = generateHtmlForMonth(i - 1);
		document.getElementById('data').insertAdjacentHTML('beforeend', monthHtml);
		document.getElementById("prihod" + (i - 1)).value = incomeVal;
		document.getElementById("razhod" + (i - 1)).value = expenseVal;
	}
	
	counter--;
}

function deleteMonthElement(index) {
	var monthToErase = document.getElementById("month" + index);
	monthToErase.outerHTML = "";
	delete monthToErase;
}

function validateInput(id) {
	var element = document.getElementById(id);
	if(element.value < 0) {
		element.value = 0;
	}
}

function showCredits()
{
	document.getElementById('credits').setAttribute("id", "show");
	document.getElementById('butcr').setAttribute("id", "hide");
}