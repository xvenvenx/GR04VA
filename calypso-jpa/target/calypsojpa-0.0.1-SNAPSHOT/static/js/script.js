//shows table data
function showEntry(entity) {
	$('#aname').val(entity.aname);
	$('#pw').val(entity.pw);
	$('#fkraft').val(entity.fkraft);
	$('#idView').html((entity.id_anwender && entity.id_anwender !="")? 'id_anwender: ' + entity.id_anwender : "");
}
function showEntry_projekt(entity) {
	$('#pname').val(entity.pname);
	$('#idView_projekt').html((entity.id_projekt && entity.id_projekt !="")? 'id_projekt: ' + entity.id_projekt : "");
}	
function showEntry_projektkonto(entity) {	
	$('#pbez').val(entity.pbez);
	$('#soll_std').val(entity.soll_std);
	$('#buchungszeitraum_dtm_a').val(entity.buchungszeitraum_dtm_a);
	$('#buchungszeitraum_dtm_b').val(entity.buchungszeitraum_dtm_b);
	$('#id_projekt').val(entity.id_projekt);
	$('#idView_projektkonto').html((entity.id_projektkonto && entity.id_projektkonto !="")? 'id_projektkonto: ' + entity.id_projektkonto : "");
}	
function showEntry_buchung(entity) {
	$('#dtm').val(entity.dtm);
	$('#std').val(entity.std);
	$('#id_projektkonto').val(entity.id_projektkonto);
	$('#id_anwender').val(entity.id_anwender);
	$('#idView_buchung').html((entity.id_buchung && entity.id_buchung !="")? 'id_buchung: ' + entity.id_buchung : "");
}
function showEntry_uebersicht(entity) {
	$('#COUNT_STD').val(entity.CountSTD);
	$('#id_projektkonto').val(entity.id_projektkonto);
	$('#SUM_STD').html((entity.SUM_STD && entity.SUM_STD !="")? 'SUM_STD: ' + entity.SUM_STD : "");
}

/* ***************************************** */

// delete entries
function clearEntry() {
	$('#aname').val("");
	$('#pw').val("");
	$('#fkraft').val("");
	$('#idView').html("");	
}

function clearEntry_projekt() {
	$('#pname').val("");
	$('#id_projekt').val("");
	$('#idView_projekt').html("");
}

function clearEntry_projektkonto() {
	$('#pbez').val("");
	$('#soll_std').val("");
	$('#buchungszeitraum_dtm_a').val("");
	$('#buchungszeitraum_dtm_b').val("");
	$('#id_projekt').val("");
	$('#idView_projektkonto').html("");
}

function clearEntry_buchung() {
	$('#dtm').val("");
	$('#std').val("");
	$('#id_projektkonto').val("");
	$('#id_anwender').val("");
	$('#idView_buchung').html("");	
}


/* ************************************** */

// creates fields of entry and buttons 
function makeForm() {
	function formLine(label, id_anwender) {
		return '<tr>' + 
			'<td>' + label + ':</td><td><input id="' + id_anwender 
				+ '" type="text"/></td>' + 
		'</tr>';
	}
	$('#memberEntry').html(
		'<table><tbody> \
		' + formLine("Anwender ", "aname") + '\
		' + formLine("Passwort" , "pw") + '\
		' + formLine("Führungskraft ? ", "fkraft") + '\
		</tbody></table>'
	)
	.append(
		'<span>' + 
		'<button id="clearButton"' + 'onclick="clearEntry()">Entfernen</button>' + 
		'<button id="submitButton"' + 'onclick="submit()">Bestätigen</button>' + 
		'</span>'
	)			
	.append(
		'<span id="idView"></span> \
		<div class="clearfloat"></div>'
	)
	function formLine(label,id_projekt){
			return '<tr>' + 
				'<td>' + label + ':</td><td><input id="' + id_projekt 
					+ '" type="text"/></td>' + 
			'</tr>';
		}
		$('#projektEntry').html(
			'<table><tbody> \
			' + formLine("Projektname ", "pname") + '\
			</tbody></table>'
		)
		.append(
			'<span>' + 
			'<button id="clearButton"' + 'onclick="clearEntry_projekt()">Entfernen</button>' + 
			'<button id="submitButton"' + 'onclick="submit_projekt()">Bestätigen</button>' + 
			'</span>'
		)			
		.append(
			'<span id="idView_projekt"></span> \
			<div class="clearfloat"></div>'
		)
		function formLine(label,id_projektkonto){
			return '<tr>' + 
				'<td>' + label + ':</td><td><input id="' + id_projektkonto 
					+ '" type="text"/></td>' + 
			'</tr>';
		}
		$('#projektkontoEntry').html(
			'<table><tbody> \
			' + formLine("Projektbez. ", "pbez") + '\
			' + formLine("Sollstunden ", "soll_std") + '\
			' + formLine("Start Buchung (Format: DD.MM.YYYY) ", "buchungszeitraum_dtm_a") + '\
			' + formLine("Ende Buchung (Format: DD.MM.YYYY) ", "buchungszeitraum_dtm_b") + '\
			' + formLine("zugehörige ProjektID ", "id_projekt") + '\
			</tbody></table>'
		)
		.append(
			'<span>' + 
			'<button id="clearButton"' + 'onclick="clearEntry_projektkonto()">Entfernen</button>' + 
			'<button id="submitButton"' + 'onclick="submit_projektkonto()">Bestätigen</button>' + 
			'</span>'
		)			
		.append(
			'<span id="idView_projektkonto"></span> \
			<div class="clearfloat"></div>'
		)
		function formLine(label,id_buchung){
			return '<tr>' + 
				'<td>' + label + ':</td><td><input id="' + id_buchung + '" type="text"/></td>' + 
			'</tr>';
		}
		$('#buchungEntry').html(
			'<table><tbody> \
			' + formLine("Datum (Fomat: DD.MM.YYYY) ", "dtm") + '\
			' + formLine("Stunden" , "std") + '\
			' + formLine("Projektkontonr", "id_projektkonto") + '\
			' + formLine("Anwendernr", "id_anwender") + '\
			</tbody></table>'
		)
		.append(
			'<span>' + 
			'<button id="clearButton"' + 'onclick="clearEntry_buchung()">Entfernen</button>' + 
			'<button id="submitButton"' + 'onclick="submit_buchung()">Bestätigen</button>' + 
			'</span>'
			)			
		.append(
			'<span id="idView_buchung"></span> \
			<div class="clearfloat"></div>'
		);	
	}

/* **************************************** */

// gives out an error if tables could not load successfully 
	function showErr(msg) {
		$('#errMsg').html(msg);
	}
	function showErr_projekt(msg) {
		$('#errMsg_projekt').html(msg);
	}
	function showErr_projektkonto(msg) {
		$('#errMsg_projektkonto').html(msg);
	}
	function showErr_buchung(msg) {
		$('#errMsg_buchung').html(msg);
	}
	function showErr_uebersicht(msg) {
		$('#errMsg_uebersicht').html(msg);
	}

// deletes error if page is reloaded
	function clearErr() {
		$('#errMsg').html("");
	}
	
	function clearErr_projekt() {
		$('#errMsg_projekt').html("");
	}
	
	function clearErr_projektkonto() {
		$('#errMsg_projektkonto').html("");
	}
	function clearErr_buchung() {
		$('#errMsg_buchung').html("");
	}
	function clearErr_uebersicht() {
		$('#errMsg_uebersicht').html("");
	}

// reloads list when page is reloaded
	function clearList() {
		$('#memberList').html("");
	}
	
	function clearList_projekt() {
		$('#projektList').html("");
	}
	
	function clearList_projektkonto() {
		$('#projektkontoList').html("");
	}
	function clearList_buchung() {
		$('#buchungList').html("");
	}	
	function clearList_uebersicht() {
		$('#uebersichtList').html("");
	}

	
/* ************************************** */	

// creates table
	function makeList(data) {
		clearList();
		function tableRow(aname, pw, fkraft, id_anwender) {
			return '<tr id="tab-'+id_anwender+'"data="'+id_anwender+'">  \
				<td>#</td><td><td>'+id_anwender+'</td> \
				<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \
				<td>&nbsp</td> \<td>&nbsp</td> \<td>'+aname+'</td> \
				<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \
				<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \
				<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>'+pw+'</td> \
				<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \
				<td>'+fkraft+'</td> \
				<td>&nbsp</td> \<td>&nbsp</td> \<td><button onclick="edit('+id_anwender+')">Bearbeiten</button></td> \
				<td>&nbsp</td> \<td>&nbsp</td> \<td><button onclick="del('+id_anwender+')">Löschen</button></td> \
			</tr>';
		}
		var tab = $('<table class="listTable"></table>');
		tab.html('<tbody>');
		$.each(data, function(id_anwender, val) {
			tab.append(tableRow(val.aname, val.pw, val.fkraft, val.id_anwender));
		});
		tab.append('</tbody>');
		$('#memberList').append(tab);
	}
	
	function makeList_projekt(data) {
		clearList_projekt();
		function tableRow(pname,id_projekt) {
			return '<tr id="tab-'+id_projekt+'"data="'+id_projekt+'">  \
				<td>#</td><td>'+id_projekt+'</td> \
				<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \
				<td>&nbsp</td> \<td>&nbsp</td> \<td>'+pname+'</td> \
				<td>&nbsp</td> \<td>&nbsp</td> \<td><button onclick="edit_projekt('+id_projekt+')">Bearbeiten</button></td> \
				<td>&nbsp</td> \<td>&nbsp</td> \<td><button onclick="del_projekt('+id_projekt+')">Löschen</button></td> \
			</tr>';
		}
		var tab = $('<table class="listTable"></table>');
		tab.html('<tbody>');
		$.each(data, function(id_projekt, val) {
			tab.append(tableRow(val.pname, val.id_projekt));
		});
		tab.append('</tbody>');
		$('#projektList').append(tab);
	}
	
	function makeList_projektkonto(data) {
		clearList_projektkonto();
		function tableRow(pbez,soll_std,buchungszeitraum_dtm_a,buchungszeitraum_dtm_b,id_projekt,id_projektkonto) {
			return '<tr id="tab-'+id_projektkonto+'"data="'+id_projektkonto+'">  \
				<td>#</td><td>'+id_projektkonto+'</td> \
				<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \
				<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>'+pbez+'</td> \
				<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>'+soll_std+'</td><td>STD</td> \
				<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \
				<td>&nbsp</td> \<td>&nbsp</td> \<td>'+buchungszeitraum_dtm_a+'</td> \
				<td>&nbsp</td> \<td>&nbsp</td> \<td>'+buchungszeitraum_dtm_b+'</td> \
				<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>#</td><td>'+id_projekt+'</td> \
				<td>&nbsp</td> \<td>&nbsp</td> \<td><button onclick="edit_projektkonto('+id_projektkonto+')">Bearbeiten</button></td> \
				<td>&nbsp</td> \<td>&nbsp</td> \<td><button onclick="del_projektkonto('+id_projektkonto+')">Löschen</button></td> \
			</tr>';
		}
		var tab = $('<table class="listTable"></table>');
		tab.html('<tbody>');
		$.each(data, function(id_projektkonto, val) {
			tab.append(tableRow(val.pbez,val.soll_std,val.buchungszeitraum_dtm_a,val.buchungszeitraum_dtm_b, val.id_projekt,val.id_projektkonto));
		});
		tab.append('</tbody>');
		$('#projektkontoList').append(tab);
	}
	
	function makeList_buchung(data) {
		clearList_buchung();
		function tableRow(dtm,std,id_projektkonto,id_anwender,id_buchung) {
			return '<tr id="tab-'+id_buchung+'"data="'+id_buchung+'">  \
				<td>#</td><td>'+id_buchung+'</td> \ <td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td><td>&nbsp</td> \<td>&nbsp</td> \ <td>&nbsp</td> \
				<td>&nbsp</td> \<td>&nbsp</td> \<td>'+std+'</td><td>STD</td> \ <td>&nbsp</td> \
				<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>#</td><td>'+id_projektkonto+'</td> \ <td>&nbsp</td> \
				<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \
				<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>#</td><td>'+id_anwender+'</td> \
				<td>&nbsp</td> \<td>&nbsp</td> \<td><button onclick="edit_buchung('+id_buchung+')">Bearbeiten</button></td> \
				<td>&nbsp</td> \<td>&nbsp</td> \<td><button onclick="del_buchung('+id_buchung+')">Löschen</button></td> \
			</tr>';
		}
		var tab = $('<table class="listTable"></table>');
		tab.html('<tbody>');
		$.each(data, function(id_buchung, val) {
			tab.append(tableRow(val.dtm,val.std,val.id_projektkonto,val.id_anwender,val.id_buchung));
		});
		tab.append('</tbody>');
		$('#buchungList').append(tab);
	}
	function makeList_uebersicht(data) {
		clearList();
		function tableRow(SUM_STD,COUNT_STD,id_projektkonto) {
			return '<tr id="tab-'+SUM_STD+'"data="'+SUM_STD+'">  \
				<td>'+SUM_STD+'</td><td>STD</td> \ <td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \
				<td>&nbsp</td> \<td>&nbsp</td> \<td>'+COUNT_STD+'</td><td>STK</td> \ <td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \
				<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>&nbsp</td> \<td>#</td><td>'+id_projektkonto+'</td> \
			</tr>';
		}
		var tab = $('<table class="listTable"></table>');
		tab.html('<tbody>');
		$.each(data, function(SUM_STD, val) {
			tab.append(tableRow(val.SUM_STD, val.COUNT_STD, val.id_projektkonto));
		});
		tab.append('</tbody>');
		$('#uebersichtList').append(tab);
	}
	
/* **************************************** */

// enables delete single entries at a time 
	function removeEntry(id_anwender) {
		$('#tab-' + id_anwender).remove();
	}
	
	function removeEntry_projekt(id_projekt) {
		$('#tab-' + id_projekt).remove();
	}
	function removeEntry_projektkonto(id_projektkonto) {
		$('#tab-' + id_projektkonto).remove();
	}
	
	function removeEntry_buchung(id_buchung) {
		$('#tab-' + id_buchung).remove();
	}	
	
/* ***************************************** */

// enables sending single data entry at a time
	function submit() {
		var id_anwender = $('#idView').html();
		if(id_anwender.length > 13) id_anwender = id_anwender.substring(13);
		var aname = $('#aname').val();
		var pw = $('#pw').val();
		var fkraft = $('#fkraft').val();
		console.log(id_anwender);
		var url = (id_anwender == "")? 
			"../webapi/anwender" : "../webapi/anwender/" + id_anwender;
		console.log(id_anwender);
		var meth = (id_anwender == "")? 
			"POST" : "PUT";
	
		$.ajax({
			method: meth, 
			url: url, 
			data: { aname:aname, 
					pw:pw, 
					fkraft:fkraft }
		})
		.done(function(msg) {
			clearErr();
			loadList();
		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			showErr("AJAX: " + errorThrown);
		});
	}
	
	function submit_projekt() {
		var id_projekt = $('#idView_projekt').html();
		if(id_projekt.length > 12) id_projekt = id_projekt.substring(12);
		var pname = $('#pname').val();
		var url = (id_projekt == "")? 
			"../webapi/projekt" : "../webapi/projekt/" + id_projekt;
		console.log(id_projekt);
		var meth = (id_projekt == "")? 
			"POST" : "PUT";
	
		$.ajax({
			method: meth, 
			url: url, 
			data: { pname:pname }
		})
		.done(function(msg) {
			clearErr_projekt();
			loadList_projekt();
		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			showErr_projekt("AJAX: " + errorThrown);
		});
	}
	
	function submit_projektkonto() {
		var id_projektkonto = $('#idView_projektkonto').html();
		if(id_projektkonto.length > 17) id_projektkonto = id_projektkonto.substring(17);
		var pbez = $('#pbez').val();
		var soll_std = $('#soll_std').val();
		var buchungszeitraum_dtm_a = $('#buchungszeitraum_dtm_a').val();
		var buchungszeitraum_dtm_b = $('#buchungszeitraum_dtm_b').val();
		var id_projekt = $('#id_projekt').val();
		var url = (id_projektkonto == "")? 
			"../webapi/projektkonto" : "../webapi/projektkonto/" + id_projektkonto;
		var meth = (id_projektkonto == "")? 
			"POST" : "PUT";
	
		$.ajax({
			method: meth, 
			url: url, 
			data: { pbez:pbez,
					soll_std:soll_std,
					buchungszeitraum_dtm_a:buchungszeitraum_dtm_a,
					buchungszeitraum_dtm_b:buchungszeitraum_dtm_b,
					id_projekt:id_projekt}
		})
		.done(function(msg) {
			clearErr_projektkonto();
			loadList_projektkonto();
		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			showErr_projektkonto("AJAX: " + errorThrown);
		});
	}
	

	function submit_buchung() {
		var id_buchung = $('#idView_buchung').html();
		if(id_buchung.length > 12) id_buchung = id_buchung.substring(12);
		var dtm = $('#dtm').val();
		var std = $('#std').val();
		var id_projektkonto = $('#id_projektkonto').val();
		var id_anwender = $('#id_anwender').val();
		var url = (id_buchung == "")? 
			"../webapi/buchung" : "../webapi/buchung/" + id_buchung;
		var meth = (id_buchung == "")? 
			"POST" : "PUT";
	
		$.ajax({
			method: meth, 
			url: url, 
			data: { dtm:dtm, 
					std:std, 
					id_projektkonto:id_projektkonto,
					id_anwender:id_anwender }
		})
		.done(function(msg) {
			clearErr_buchung();
			loadList_buchung();
		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			showErr_buchung("AJAX: " + errorThrown);
		});
	}
	
	
/* ************************************** */

// enables loading list with new entry
	function loadList() {
		var url = "../webapi/anwender";
		$.ajax({
			method: "GET", 
			url: url
		})
		.done(function(msg) {
			clearErr();
			makeList(msg);
		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			showErr("AJAX: " + errorThrown);		
		});
	}
	
	function loadList_projekt() {
		var url = "../webapi/projekt";
		$.ajax({
			method: "GET", 
			url: url
		})
		.done(function(msg) {
			clearErr_projekt();
			makeList_projekt(msg);
		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			showErr_projekt("AJAX: " + errorThrown);		
		});
	}
	
	function loadList_projektkonto() {
		var url = "../webapi/projektkonto";
		$.ajax({
			method: "GET", 
			url: url
		})
		.done(function(msg) {
			clearErr_projektkonto();
			makeList_projektkonto(msg);
		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			showErr_projektkonto("AJAX: " + errorThrown);		
		});
	}
	
	function loadList_buchung() {
		var url = "../webapi/buchung";
		$.ajax({
			method: "GET", 
			url: url
		})
		.done(function(msg) {
			clearErr_buchung();
			makeList_buchung(msg);
		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			showErr_buchung("AJAX: " + errorThrown);		
		});
	}
	function loadList_uebersicht() {
		var url = "../webapi/buchungProjektUebersicht/uebersicht";
		$.ajax({
			method: "GET", 
			url: url
		})
		.done(function(msg) {
			clearErr_uebersicht();
			makeList_uebersicht(msg);
		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			showErr_uebersicht("AJAX: " + errorThrown);		
		});
	}
	
	
/* ************************************ */

// enables editing single entry at a time
	function edit(id_anwender) {
		var url = "../webapi/anwender/" + id_anwender;
		$.ajax({
			method: "GET",
			url:url
		})
		.done(function(msg) {
			clearErr();
			showEntry(msg);
		})
		.fail(function(jqXHR, textStatus, errorThrown){
			showErr("AJAX: " + errorThrown);
		});
	}
	
	function edit_projekt(id_projekt) {
		var url = "../webapi/projekt/" + id_projekt;
		$.ajax({
			method: "GET",
			url:url
		})
		.done(function(msg) {
			clearErr_projekt();
			showEntry_projekt(msg);
		})
		.fail(function(jqXHR, textStatus, errorThrown){
			showErr_projekt("AJAX: " + errorThrown);
		});
	}
	
	function edit_projektkonto(id_projektkonto) {
		var url = "../webapi/projektkonto/" + id_projektkonto;
		$.ajax({
			method: "GET",
			url:url
		})
		.done(function(msg) {
			clearErr_projektkonto();
			showEntry_projektkonto(msg);
		})
		.fail(function(jqXHR, textStatus, errorThrown){
			showErr_projektkonto("AJAX: " + errorThrown);
		});
	}
	
	function edit_buchung(id_buchung) {
		var url = "../webapi/buchung/" + id_buchung;
		$.ajax({
			method: "GET",
			url:url
		})
		.done(function(msg) {
			clearErr_buchung();
			showEntry_buchung(msg);
		})
		.fail(function(jqXHR, textStatus, errorThrown){
			showErr_buchung("AJAX: " + errorThrown);
		});
	}	
	
/* *************************************** */	

// enables delete single entry at a time
	function del(id_anwender) {
		clearEntry();
		var url = "../webapi/anwender/" + id_anwender;
		$.ajax({
			method: "DELETE", 
			url:url
		})
		.done(function(msg) {
			clearErr();
			removeEntry(id_anwender);
		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			showErr("AJAX: " + errorThrown);
		});
	}
	
	function del_projekt(id_projekt) {
		clearEntry_projekt();
		var url = "../webapi/projekt/" + id_projekt;
		$.ajax({
			method: "DELETE", 
			url:url
		})
		.done(function(msg) {
			clearErr_projekt();
			removeEntry_projekt(id_projekt);
		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			showErr_projekt("AJAX: " + errorThrown);
		});
	}
	
	function del_projektkonto(id_projektkonto) {
		clearEntry_projektkonto();
		var url = "../webapi/projektkonto/" + id_projektkonto;
		$.ajax({
			method: "DELETE", 
			url:url
		})
		.done(function(msg) {
			clearErr_projektkonto();
			removeEntry_projektkonto(id_projektkonto);
		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			showErr_projektkonto("AJAX: " + errorThrown);
		});
	}
	
	function del_buchung(id_buchung) {
		clearEntry_buchung();
		var url = "../webapi/buchung/" + id_buchung;
		$.ajax({
			method: "DELETE", 
			url:url
		})
		.done(function(msg) {
			clearErr_buchung();
			removeEntry_buchung(id_buchung);
		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			showErr_buchung("AJAX: " + errorThrown);
		});
	}
	
	
	
/* *************************************** */	

// enables loading data as a form - mainfunction from script
	$(function() {
	makeForm();
	loadList();
	loadList_projekt();
	loadList_projektkonto();
	loadList_buchung();
	loadList_uebersicht();
})








