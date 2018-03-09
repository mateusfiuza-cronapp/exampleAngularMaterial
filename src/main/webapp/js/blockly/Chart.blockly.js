window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Chart = window.blockly.js.blockly.Chart || {};

var item, data, data1, labelList;

function mathRandomInt(a, b) {
	if (a > b) {
		// Swap a and b to ensure a is smaller.
		var c = a;
		a = b;
		b = c;
	}
	return Math.floor(Math.random() * (b - a + 1) + a);
}

/**
 * Chart
 */
window.blockly.js.blockly.Chart.createUserChart = function() {
	labelList = ['Janerio', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho',
			'Julho', 'Agosto'];
	data = [mathRandomInt(1, 100), mathRandomInt(1, 100),
			mathRandomInt(1, 100), mathRandomInt(1, 100),
			mathRandomInt(1, 100), mathRandomInt(1, 100),
			mathRandomInt(1, 100), mathRandomInt(1, 100)];
	data1 = [mathRandomInt(1, 100), mathRandomInt(1, 100),
			mathRandomInt(1, 100), mathRandomInt(1, 100),
			mathRandomInt(1, 100), mathRandomInt(1, 100),
			mathRandomInt(1, 100), mathRandomInt(1, 100)];
	this.cronapi.chart.createChart("chart5115", 'line', labelList, null,
			this.cronapi.chart.createDataset('Dataset 1', data, null),
			this.cronapi.chart.createDataset('Dataset 2', data1, null));
}
