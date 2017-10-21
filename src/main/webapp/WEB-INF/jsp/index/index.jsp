<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" session="false" %>

<html>
<head>
	<title>Java Test Application</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
	<div>
		URL : <input id="txtUrl" type="text" />
		<button id="btnGenerate">변환</button>
	</div>
	
	<p>Short URL</p>
	<div id="divResult">
	</div>
	
	<p>데이터 리스트</p>
	<div id="divList">
	</div>
</body>

<script>
(function() {
	var txtUrl, btnGenerate, divResult;
	
	$(function() {
		txtUrl = $("#txtUrl");
		btnGenerate = $("#btnGenerate");
		divResult = $("#divResult");
		divList = $("#divList");
		
		btnGenerate.bind("click", function() {
			getShortenUrl();
		});
		
		reflashList();
	});
	
	function getShortenUrl() {
		var originUrl = txtUrl.val();
		
		$.ajax({
			url: "/ajax/getShortUrl?url=" + originUrl,
			processData: false,
			contentType: false,
			type: "GET",
			success: function(result) {
				console.log(result);
				
				if (result.code < 0) {
					alert("URL 형식이 잘못되었습니다.");
				}
				else {
					renderResult(result.data);
					reflashList();
				}
			}
		});
	}
	
	function renderResult(surl) {
		var aLink = $("<a />").attr({
			href: surl,
			target: "_blank"
		})
		.text(surl);
		
		divResult.empty().append(aLink);
	}
	
	function reflashList() {
		$.ajax({
			url: "/ajax/getList",
			processData: false,
			contentType: false,
			type: "GET",
			success: function(result) {
				console.log(result);
				
				if (result.code < 0) {
					alert("오류입니다.");
				}
				else {
					renderDataList(result.data);
				}
			}
		});
	}
	
	function renderDataList(data) {
		var list = $("<ul />");
		
		for (var d in data) {
			list.append("<li>" + d + " - " + data[d] + "</li>");
		}
		
		divList.empty().append(list);
	}
})();
</script>

</html>
