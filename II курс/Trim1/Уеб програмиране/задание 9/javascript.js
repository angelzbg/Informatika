window.onload = function() {
  restartGame();
};

var lastPickId;

var winCond = [
	[ "1", "2", "3", "4" ],
	[ "12", "13", "14", "5" ],
	[ "11", "", "15", "6" ],
	[ "10", "9", "8", "7" ],
];


function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    ev.dataTransfer.setData("text", ev.target.innerHTML);
	lastPick = ev.target;
	lastPickId = ev.target.id;
}

function drop(ev) {
    ev.preventDefault();
	if(ev.target.innerHTML == "" && areNeighbours(lastPickId, ev.target.id)){
		var data = ev.dataTransfer.getData("text");
		ev.target.innerHTML = data;
		document.getElementById(lastPickId).innerHTML = "";
		
		var audio = new Audio('click.mp3');
		audio.play();
		
		checkForVictory();
	}
}

function areNeighbours(id1, id2) {
	var x1 = parseInt(id1[0]);
	var y1 = parseInt(id1[1]);
	
	var x2 = parseInt(id2[0]);
	var y2 = parseInt(id2[1]);
	
	return (Math.abs(x1 - x2) + Math.abs(y1 - y2) <= 1);
}

function checkForVictory() {
	for(var x = 0; x < 4; x++) {
		for(var y = 0; y < 4; y++) {
			var elementNum = document.getElementById(String(x) + String(y)).innerHTML;

			if(elementNum != winCond[y][x]) {
				return;
			}
		}
	}
	window.alert("Спечелихте!");
}

function restartGame() {
	var numbers = [ "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "" ];

	for(var x = 0; x < 4; x++) {
		for(var y = 0; y < 4; y++) {
			var elIndex = getRandom(numbers.length);
			
			document.getElementById(String(x) + String(y)).innerHTML = numbers[elIndex];
			numbers.splice(elIndex, 1);
		}
	}

}

function getRandom(max) {
	return Math.floor(Math.random() * max);
}
