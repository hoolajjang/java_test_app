<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

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
	<div id="divResult">
	</div>
</body>

<script>
(function() {
	var txtUrl, btnGenerate, divResult;
	
	$(function() {
		txtUrl = $("#txtUrl");
		btnGenerate = $("#btnGenerate");
		divResult = $("#divResult");
		
		btnGenerate.bind("click", function() {
			getShortenUrl();
		});
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
				renderResult(result.data);
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
})();
</script>

</html>
