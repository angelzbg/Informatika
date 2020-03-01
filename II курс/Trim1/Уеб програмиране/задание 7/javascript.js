function changeText()
{
	var text = document.getElementById('div1');
	var text1 = text.textContent,
	text2 = 'Имам два лева ';
	var n = text1.localeCompare(text2);
	if(n == 0)
	document.getElementById('otgovor').innerHTML = '<font color="green">верен!</font>';
	else document.getElementById('otgovor').innerHTML = '<font color="red">грешен!</font>';
}
function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    ev.dataTransfer.setData('text', ev.target.id);
}

function drop(ev) {
    ev.preventDefault();
    var data = ev.dataTransfer.getData('text');
    ev.target.appendChild(document.getElementById(data));
}
function changeText2()
{
	var word1 = document.getElementById('divWord1'), word2 = document.getElementById('divWord2');
	var text1 = word1.textContent, text2 = word2.textContent,
	duma1 = 'елементи', duma2 = 'тагове';
	var check1 = text1.localeCompare(duma1), check2 = text2.localeCompare(duma2);
	if(check1 == 0 && check2 == 0)
	document.getElementById('otgovor2').innerHTML = '<font color="green">верен!</font>';
	else document.getElementById('otgovor2').innerHTML = '<font color="red">грешен!</font>';
}
function changeText4()
{
	var numb = document.getElementById('numb').value;
	var checkNumb = 20;
	if(numb == checkNumb)
	document.getElementById('otgovor4').innerHTML = '<font color="green">верен!</font>';
	else document.getElementById('otgovor4').innerHTML = '<font color="red">грешен!</font>';
}
function changeText5()
{
	if(document.getElementById('qko').checked)
	document.getElementById('otgovor5').innerHTML = '<font color="green">верен!</font>';
	else document.getElementById('otgovor5').innerHTML = '<font color="red">грешен!</font>';
}
function changeText6()
{
	if(document.getElementById('box3').checked && 
		document.getElementById('box5').checked && 
			document.getElementById('box6').checked && 
				(!document.getElementById('box1').checked && 
					!document.getElementById('box2').checked &&
						!document.getElementById('box4').checked))
	document.getElementById('otgovor6').innerHTML = '<font color="green">верен!</font>';
	else document.getElementById('otgovor6').innerHTML = '<font color="red">грешен!</font>';
}

var enabledImg = { 
	bananas:false, books:false, burger:false, 
	flower:false, monitor:false, pizza:false,
	rock:false, spaghetti:false, tree:false
};

function imageClick(name) {
	enabledImg[name] = !enabledImg[name];
	var elem = document.getElementById(name);
	if(enabledImg[name] == true) {
		elem.style.border = "2px solid orange";
	}		
	else {
		elem.style.border = "1px solid black";
	}
}

function imageCheck() {
	if(enabledImg['bananas'] == true && !enabledImg['books'] && enabledImg['burger'] 
		&& !enabledImg['flower'] && !enabledImg['monitor'] && enabledImg['pizza']
		&& !enabledImg['rock'] && enabledImg['spaghetti'] && !enabledImg['tree']) {
		document.getElementById('otgovor3').innerHTML = '<font color="green">верен!</font>';
	}
	else {
		document.getElementById('otgovor3').innerHTML = '<font color="red">грешен!</font>';
	}
}