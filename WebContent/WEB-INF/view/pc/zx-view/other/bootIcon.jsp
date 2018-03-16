<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/deng/include/include.jsp"%>
<%@ include file="/deng/include/includeboot.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>  
<head>  
<meta charset="UTF-8">  
<title>图标大全</title>  
<style type="text/css">
.iconUl {height: 600px;overflow: auto;}
.iconUl li{width: 160px;list-style: none;float: left;padding:5px;}
.iconUl li span{width: 100%;text-align: center;display: block;height: 30px}
</style>
</head>  
<body>
  	<div class="panel panel-default padding-10 no-margin">
		<fieldset>
			<legend style="padding-bottom: 10px">图标大全</legend>
			<ul id="myTab" class="nav nav-tabs">
				<li class="active"><a href="#tab0" data-toggle="tab">操作图标</a></li>
				<li><a href="#tab1" data-toggle="tab">菜单图标</a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane fade in active" id="tab0">
					<ul class="iconUl">
						<li><span class="glyphicon glyphicon-asterisk"></span><span title="glyphicon-asterisk">glyphicon-asterisk</span></li>
						<li><span class="glyphicon glyphicon-plus"></span><span title="glyphicon-plus">glyphicon-plus</span></li>
						<li><span class="glyphicon glyphicon-euro"></span><span title="glyphicon-euro">glyphicon-euro</span></li>
						<li><span class="glyphicon glyphicon-eur"></span><span title="glyphicon-eur">glyphicon-eur</span></li>
						<li><span class="glyphicon glyphicon-minus"></span><span title="glyphicon-minus">glyphicon-minus</span></li>
						<li><span class="glyphicon glyphicon-cloud"></span><span title="glyphicon-cloud">glyphicon-cloud</span></li>
						<li><span class="glyphicon glyphicon-envelope"></span><span title="glyphicon-envelope">glyphicon-envelope</span></li>
						<li><span class="glyphicon glyphicon-pencil"></span><span title="glyphicon-pencil">glyphicon-pencil</span></li>
						<li><span class="glyphicon glyphicon-glass"></span><span title="glyphicon-glass">glyphicon-glass</span></li>
						<li><span class="glyphicon glyphicon-music"></span><span title="glyphicon-music">glyphicon-music</span></li>
						<li><span class="glyphicon glyphicon-search"></span><span title="glyphicon-search">glyphicon-search</span></li>
						<li><span class="glyphicon glyphicon-heart"></span><span title="glyphicon-heart">glyphicon-heart</span></li>
						<li><span class="glyphicon glyphicon-star"></span><span title="glyphicon-star">glyphicon-star</span></li>
						<li><span class="glyphicon glyphicon-star-empty"></span><span title="glyphicon-star-empty">glyphicon-star-empty</span></li>
						<li><span class="glyphicon glyphicon-user"></span><span title="glyphicon-user">glyphicon-user</span></li>
						<li><span class="glyphicon glyphicon-film"></span><span title="glyphicon-film">glyphicon-film</span></li>
						<li><span class="glyphicon glyphicon-th-large"></span><span title="glyphicon-th-large">glyphicon-th-large</span></li>
						<li><span class="glyphicon glyphicon-th"></span><span title="glyphicon-th">glyphicon-th</span></li>
						<li><span class="glyphicon glyphicon-th-list"></span><span title="glyphicon-th-list">glyphicon-th-list</span></li>
						<li><span class="glyphicon glyphicon-ok"></span><span title="glyphicon-ok">glyphicon-ok</span></li>
						<li><span class="glyphicon glyphicon-remove"></span><span title="glyphicon-remove">glyphicon-remove</span></li>
						<li><span class="glyphicon glyphicon-zoom-in"></span><span title="glyphicon-zoom-in">glyphicon-zoom-in</span></li>
						<li><span class="glyphicon glyphicon-zoom-out"></span><span title="glyphicon-zoom-out">glyphicon-zoom-out</span></li>
						<li><span class="glyphicon glyphicon-off"></span><span title="glyphicon-off">glyphicon-off</span></li>
						<li><span class="glyphicon glyphicon-signal"></span><span title="glyphicon-signal">glyphicon-signal</span></li>
						<li><span class="glyphicon glyphicon-cog"></span><span title="glyphicon-cog">glyphicon-cog</span></li>
						<li><span class="glyphicon glyphicon-trash"></span><span title="glyphicon-trash">glyphicon-trash</span></li>
						<li><span class="glyphicon glyphicon-home"></span><span title="glyphicon-home">glyphicon-home</span></li>
						<li><span class="glyphicon glyphicon-file"></span><span title="glyphicon-file">glyphicon-file</span></li>
						<li><span class="glyphicon glyphicon-time"></span><span title="glyphicon-time">glyphicon-time</span></li>
						<li><span class="glyphicon glyphicon-road"></span><span title="glyphicon-road">glyphicon-road</span></li>
						<li><span class="glyphicon glyphicon-download-alt"></span><span title="glyphicon-download-alt">glyphicon-download-alt</span></li>
						<li><span class="glyphicon glyphicon-download"></span><span title="glyphicon-download">glyphicon-download</span></li>
						<li><span class="glyphicon glyphicon-upload"></span><span title="glyphicon-upload">glyphicon-upload</span></li>
						<li><span class="glyphicon glyphicon-inbox"></span><span title="glyphicon-inbox">glyphicon-inbox</span></li>
						<li><span class="glyphicon glyphicon-play-circle"></span><span title="glyphicon-play-circle">glyphicon-play-circle</span></li>
						<li><span class="glyphicon glyphicon-repeat"></span><span title="glyphicon-repeat">glyphicon-repeat</span></li>
						<li><span class="glyphicon glyphicon-refresh"></span><span title="glyphicon-refresh">glyphicon-refresh</span></li>
						<li><span class="glyphicon glyphicon-list-alt"></span><span title="glyphicon-list-alt">glyphicon-list-alt</span></li>
						<li><span class="glyphicon glyphicon-lock"></span><span title="glyphicon-lock">glyphicon-lock</span></li>
						<li><span class="glyphicon glyphicon-flag"></span><span title="glyphicon-flag">glyphicon-flag</span></li>
						<li><span class="glyphicon glyphicon-headphones"></span><span title="glyphicon-headphones">glyphicon-headphones</span></li>
						<li><span class="glyphicon glyphicon-volume-off"></span><span title="glyphicon-volume-off">glyphicon-volume-off</span></li>
						<li><span class="glyphicon glyphicon-volume-down"></span><span title="glyphicon-volume-down">glyphicon-volume-down</span></li>
						<li><span class="glyphicon glyphicon-volume-up"></span><span title="glyphicon-volume-up">glyphicon-volume-up</span></li>
						<li><span class="glyphicon glyphicon-qrcode"></span><span title="glyphicon-qrcode">glyphicon-qrcode</span></li>
						<li><span class="glyphicon glyphicon-barcode"></span><span title="glyphicon-barcode">glyphicon-barcode</span></li>
						<li><span class="glyphicon glyphicon-tag"></span><span title="glyphicon-tag">glyphicon-tag</span></li>
						<li><span class="glyphicon glyphicon-tags"></span><span title="glyphicon-tags">glyphicon-tags</span></li>
						<li><span class="glyphicon glyphicon-book"></span><span title="glyphicon-book">glyphicon-book</span></li>
						<li><span class="glyphicon glyphicon-bookmark"></span><span title="glyphicon-bookmark">glyphicon-bookmark</span></li>
						<li><span class="glyphicon glyphicon-print"></span><span title="glyphicon-print">glyphicon-print</span></li>
						<li><span class="glyphicon glyphicon-camera"></span><span title="glyphicon-camera">glyphicon-camera</span></li>
						<li><span class="glyphicon glyphicon-font"></span><span title="glyphicon-font">glyphicon-font</span></li>
						<li><span class="glyphicon glyphicon-bold"></span><span title="glyphicon-bold">glyphicon-bold</span></li>
						<li><span class="glyphicon glyphicon-italic"></span><span title="glyphicon-italic">glyphicon-italic</span></li>
						<li><span class="glyphicon glyphicon-text-height"></span><span title="glyphicon-text-height">glyphicon-text-height</span></li>
						<li><span class="glyphicon glyphicon-text-width"></span><span title="glyphicon-text-width">glyphicon-text-width</span></li>
						<li><span class="glyphicon glyphicon-align-left"></span><span title="glyphicon-align-left">glyphicon-align-left</span></li>
						<li><span class="glyphicon glyphicon-align-center"></span><span title="glyphicon-align-center">glyphicon-align-center</span></li>
						<li><span class="glyphicon glyphicon-align-right"></span><span title="glyphicon-align-right">glyphicon-align-right</span></li>
						<li><span class="glyphicon glyphicon-align-justify"></span><span title="glyphicon-align-justify">glyphicon-align-justify</span></li>
						<li><span class="glyphicon glyphicon-list"></span><span title="glyphicon-list">glyphicon-list</span></li>
						<li><span class="glyphicon glyphicon-indent-left"></span><span title="glyphicon-indent-left">glyphicon-indent-left</span></li>
						<li><span class="glyphicon glyphicon-indent-right"></span><span title="glyphicon-indent-right">glyphicon-indent-right</span></li>
						<li><span class="glyphicon glyphicon-facetime-video"></span><span title="glyphicon-facetime-video">glyphicon-facetime-video</span></li>
						<li><span class="glyphicon glyphicon-picture"></span><span title="glyphicon-picture">glyphicon-picture</span></li>
						<li><span class="glyphicon glyphicon-map-marker"></span><span title="glyphicon-map-marker">glyphicon-map-marker</span></li>
						<li><span class="glyphicon glyphicon-adjust"></span><span title="glyphicon-adjust">glyphicon-adjust</span></li>
						<li><span class="glyphicon glyphicon-tint"></span><span title="glyphicon-tint">glyphicon-tint</span></li>
						<li><span class="glyphicon glyphicon-edit"></span><span title="glyphicon-edit">glyphicon-edit</span></li>
						<li><span class="glyphicon glyphicon-share"></span><span title="glyphicon-share">glyphicon-share</span></li>
						<li><span class="glyphicon glyphicon-check"></span><span title="glyphicon-check">glyphicon-check</span></li>
						<li><span class="glyphicon glyphicon-move"></span><span title="glyphicon-move">glyphicon-move</span></li>
						<li><span class="glyphicon glyphicon-step-backward"></span><span title="glyphicon-step-backward">glyphicon-step-backward</span></li>
						<li><span class="glyphicon glyphicon-fast-backward"></span><span title="glyphicon-fast-backward">glyphicon-fast-backward</span></li>
						<li><span class="glyphicon glyphicon-backward"></span><span title="glyphicon-backward">glyphicon-backward</span></li>
						<li><span class="glyphicon glyphicon-play"></span><span title="glyphicon-play">glyphicon-play</span></li>
						<li><span class="glyphicon glyphicon-pause"></span><span title="glyphicon-pause">glyphicon-pause</span></li>
						<li><span class="glyphicon glyphicon-stop"></span><span title="glyphicon-stop">glyphicon-stop</span></li>
						<li><span class="glyphicon glyphicon-forward"></span><span title="glyphicon-forward">glyphicon-forward</span></li>
						<li><span class="glyphicon glyphicon-fast-forward"></span><span title="glyphicon-fast-forward">glyphicon-fast-forward</span></li>
						<li><span class="glyphicon glyphicon-step-forward"></span><span title="glyphicon-step-forward">glyphicon-step-forward</span></li>
						<li><span class="glyphicon glyphicon-eject"></span><span title="glyphicon-eject">glyphicon-eject</span></li>
						<li><span class="glyphicon glyphicon-chevron-left"></span><span title="glyphicon-chevron-left">glyphicon-chevron-left</span></li>
						<li><span class="glyphicon glyphicon-chevron-right"></span><span title="glyphicon-chevron-right">glyphicon-chevron-right</span></li>
						<li><span class="glyphicon glyphicon-plus-sign"></span><span title="glyphicon-plus-sign">glyphicon-plus-sign</span></li>
						<li><span class="glyphicon glyphicon-minus-sign"></span><span title="glyphicon-minus-sign">glyphicon-minus-sign</span></li>
						<li><span class="glyphicon glyphicon-remove-sign"></span><span title="glyphicon-remove-sign">glyphicon-remove-sign</span></li>
						<li><span class="glyphicon glyphicon-ok-sign"></span><span title="glyphicon-ok-sign">glyphicon-ok-sign</span></li>
						<li><span class="glyphicon glyphicon-question-sign"></span><span title="glyphicon-question-sign">glyphicon-question-sign</span></li>
						<li><span class="glyphicon glyphicon-info-sign"></span><span title="glyphicon-info-sign">glyphicon-info-sign</span></li>
						<li><span class="glyphicon glyphicon-screenshot"></span><span title="glyphicon-screenshot">glyphicon-screenshot</span></li>
						<li><span class="glyphicon glyphicon-remove-circle"></span><span title="glyphicon-remove-circle">glyphicon-remove-circle</span></li>
						<li><span class="glyphicon glyphicon-ok-circle"></span><span title="glyphicon-ok-circle">glyphicon-ok-circle</span></li>
						<li><span class="glyphicon glyphicon-arrow-left"></span><span title="glyphicon-arrow-left">glyphicon-arrow-left</span></li>
						<li><span class="glyphicon glyphicon-arrow-right"></span><span title="glyphicon-arrow-right">glyphicon-arrow-right</span></li>
						<li><span class="glyphicon glyphicon-arrow-up"></span><span title="glyphicon-arrow-up">glyphicon-arrow-up</span></li>
						<li><span class="glyphicon glyphicon-arrow-down"></span><span title="glyphicon-arrow-down">glyphicon-arrow-down</span></li>
						<li><span class="glyphicon glyphicon-share-alt"></span><span title="glyphicon-share-alt">glyphicon-share-alt</span></li>
						<li><span class="glyphicon glyphicon-resize-full"></span><span title="glyphicon-resize-full">glyphicon-resize-full</span></li>
						<li><span class="glyphicon glyphicon-resize-small"></span><span title="glyphicon-resize-small">glyphicon-resize-small</span></li>
						<li><span class="glyphicon glyphicon-exclamation-sign"></span><span title="glyphicon-exclamation-sign">glyphicon-exclamation-sign</span></li>
						<li><span class="glyphicon glyphicon-gift"></span><span title="glyphicon-gift">glyphicon-gift</span></li>
						<li><span class="glyphicon glyphicon-leaf"></span><span title="glyphicon-leaf">glyphicon-leaf</span></li>
						<li><span class="glyphicon glyphicon-fire"></span><span title="glyphicon-fire">glyphicon-fire</span></li>
						<li><span class="glyphicon glyphicon-eye-open"></span><span title="glyphicon-eye-open">glyphicon-eye-open</span></li>
						<li><span class="glyphicon glyphicon-eye-close"></span><span title="glyphicon-eye-close">glyphicon-eye-close</span></li>
						<li><span class="glyphicon glyphicon-warning-sign"></span><span title="glyphicon-warning-sign">glyphicon-warning-sign</span></li>
						<li><span class="glyphicon glyphicon-plane"></span><span title="glyphicon-plane">glyphicon-plane</span></li>
						<li><span class="glyphicon glyphicon-calendar"></span><span title="glyphicon-calendar">glyphicon-calendar</span></li>
						<li><span class="glyphicon glyphicon-random"></span><span title="glyphicon-random">glyphicon-random</span></li>
						<li><span class="glyphicon glyphicon-comment"></span><span title="glyphicon-comment">glyphicon-comment</span></li>
						<li><span class="glyphicon glyphicon-magnet"></span><span title="glyphicon-magnet">glyphicon-magnet</span></li>
						<li><span class="glyphicon glyphicon-chevron-up"></span><span title="glyphicon-chevron-up">glyphicon-chevron-up</span></li>
						<li><span class="glyphicon glyphicon-chevron-down"></span><span title="glyphicon-chevron-down">glyphicon-chevron-down</span></li>
						<li><span class="glyphicon glyphicon-retweet"></span><span title="glyphicon-retweet">glyphicon-retweet</span></li>
						<li><span class="glyphicon glyphicon-shopping-cart"></span><span title="glyphicon-shopping-cart">glyphicon-shopping-cart</span></li>
						<li><span class="glyphicon glyphicon-folder-close"></span><span title="glyphicon-folder-close">glyphicon-folder-close</span></li>
						<li><span class="glyphicon glyphicon-folder-open"></span><span title="glyphicon-folder-open">glyphicon-folder-open</span></li>
						<li><span class="glyphicon glyphicon-resize-vertical"></span><span title="glyphicon-resize-vertical">glyphicon-resize-vertical</span></li>
						<li><span class="glyphicon glyphicon-resize-horizontal"></span><span title="glyphicon-resize-horizontal">glyphicon-resize-horizontal</span></li>
						<li><span class="glyphicon glyphicon-hdd"></span><span title="glyphicon-hdd">glyphicon-hdd</span></li>
						<li><span class="glyphicon glyphicon-bullhorn"></span><span title="glyphicon-bullhorn">glyphicon-bullhorn</span></li>
						<li><span class="glyphicon glyphicon-bell"></span><span title="glyphicon-bell">glyphicon-bell</span></li>
						<li><span class="glyphicon glyphicon-certificate"></span><span title="glyphicon-certificate">glyphicon-certificate</span></li>
						<li><span class="glyphicon glyphicon-thumbs-up"></span><span title="glyphicon-thumbs-up">glyphicon-thumbs-up</span></li>
						<li><span class="glyphicon glyphicon-thumbs-down"></span><span title="glyphicon-thumbs-down">glyphicon-thumbs-down</span></li>
						<li><span class="glyphicon glyphicon-hand-right"></span><span title="glyphicon-hand-right">glyphicon-hand-right</span></li>
						<li><span class="glyphicon glyphicon-hand-left"></span><span title="glyphicon-hand-left">glyphicon-hand-left</span></li>
						<li><span class="glyphicon glyphicon-hand-up"></span><span title="glyphicon-hand-up">glyphicon-hand-up</span></li>
						<li><span class="glyphicon glyphicon-hand-down"></span><span title="glyphicon-hand-down">glyphicon-hand-down</span></li>
						<li><span class="glyphicon glyphicon-circle-arrow-right"></span><span title="glyphicon-circle-arrow-right">glyphicon-circle-arrow-right</span></li>
						<li><span class="glyphicon glyphicon-circle-arrow-left"></span><span title="glyphicon-circle-arrow-left">glyphicon-circle-arrow-left</span></li>
						<li><span class="glyphicon glyphicon-circle-arrow-up"></span><span title="glyphicon-circle-arrow-up">glyphicon-circle-arrow-up</span></li>
						<li><span class="glyphicon glyphicon-circle-arrow-down"></span><span title="glyphicon-circle-arrow-down">glyphicon-circle-arrow-down</span></li>
						<li><span class="glyphicon glyphicon-globe"></span><span title="glyphicon-globe">glyphicon-globe</span></li>
						<li><span class="glyphicon glyphicon-tasks"></span><span title="glyphicon-tasks">glyphicon-tasks</span></li>
						<li><span class="glyphicon glyphicon-filter"></span><span title="glyphicon-filter">glyphicon-filter</span></li>
						<li><span class="glyphicon glyphicon-briefcase"></span><span title="glyphicon-briefcase">glyphicon-briefcase</span></li>
						<li><span class="glyphicon glyphicon-fullscreen"></span><span title="glyphicon-fullscreen">glyphicon-fullscreen</span></li>
						<li><span class="glyphicon glyphicon-dashboard"></span><span title="glyphicon-dashboard">glyphicon-dashboard</span></li>
						<li><span class="glyphicon glyphicon-paperclip"></span><span title="glyphicon-paperclip">glyphicon-paperclip</span></li>
						<li><span class="glyphicon glyphicon-heart-empty"></span><span title="glyphicon-heart-empty">glyphicon-heart-empty</span></li>
						<li><span class="glyphicon glyphicon-link"></span><span title="glyphicon-link">glyphicon-link</span></li>
						<li><span class="glyphicon glyphicon-phone"></span><span title="glyphicon-phone">glyphicon-phone</span></li>
						<li><span class="glyphicon glyphicon-pushpin"></span><span title="glyphicon-pushpin">glyphicon-pushpin</span></li>
						<li><span class="glyphicon glyphicon-usd"></span><span title="glyphicon-usd">glyphicon-usd</span></li>
						<li><span class="glyphicon glyphicon-gbp"></span><span title="glyphicon-gbp">glyphicon-gbp</span></li>
						<li><span class="glyphicon glyphicon-sort"></span><span title="glyphicon-sort">glyphicon-sort</span></li>
						<li><span class="glyphicon glyphicon-sort-by-alphabet"></span><span title="glyphicon-sort-by-alphabet">glyphicon-sort-by-alphabet</span></li>
						<li><span class="glyphicon glyphicon-sort-by-alphabet-alt"></span><span title="glyphicon-sort-by-alphabet-alt">glyphicon-sort-by-alphabet-alt</span></li>
						<li><span class="glyphicon glyphicon-sort-by-order"></span><span title="glyphicon-sort-by-order">glyphicon-sort-by-order</span></li>
						<li><span class="glyphicon glyphicon-sort-by-order-alt"></span><span title="glyphicon-sort-by-order-alt">glyphicon-sort-by-order-alt</span></li>
						<li><span class="glyphicon glyphicon-sort-by-attributes"></span><span title="glyphicon-sort-by-attributes">glyphicon-sort-by-attributes</span></li>
						<li><span class="glyphicon glyphicon-sort-by-attributes-alt"></span><span title="glyphicon-sort-by-attributes-alt">glyphicon-sort-by-attributes-alt</span></li>
						<li><span class="glyphicon glyphicon-unchecked"></span><span title="glyphicon-unchecked">glyphicon-unchecked</span></li>
						<li><span class="glyphicon glyphicon-expand"></span><span title="glyphicon-expand">glyphicon-expand</span></li>
						<li><span class="glyphicon glyphicon-collapse-down"></span><span title="glyphicon-collapse-down">glyphicon-collapse-down</span></li>
						<li><span class="glyphicon glyphicon-collapse-up"></span><span title="glyphicon-collapse-up">glyphicon-collapse-up</span></li>
						<li><span class="glyphicon glyphicon-log-in"></span><span title="glyphicon-log-in">glyphicon-log-in</span></li>
						<li><span class="glyphicon glyphicon-flash"></span><span title="glyphicon-flash">glyphicon-flash</span></li>
						<li><span class="glyphicon glyphicon-log-out"></span><span title="glyphicon-log-out">glyphicon-log-out</span></li>
						<li><span class="glyphicon glyphicon-new-window"></span><span title="glyphicon-new-window">glyphicon-new-window</span></li>
						<li><span class="glyphicon glyphicon-record"></span><span title="glyphicon-record">glyphicon-record</span></li>
						<li><span class="glyphicon glyphicon-save"></span><span title="glyphicon-save">glyphicon-save</span></li>
						<li><span class="glyphicon glyphicon-open"></span><span title="glyphicon-open">glyphicon-open</span></li>
						<li><span class="glyphicon glyphicon-saved"></span><span title="glyphicon-saved">glyphicon-saved</span></li>
						<li><span class="glyphicon glyphicon-import"></span><span title="glyphicon-import">glyphicon-import</span></li>
						<li><span class="glyphicon glyphicon-export"></span><span title="glyphicon-export">glyphicon-export</span></li>
						<li><span class="glyphicon glyphicon-send"></span><span title="glyphicon-send">glyphicon-send</span></li>
						<li><span class="glyphicon glyphicon-floppy-disk"></span><span title="glyphicon-floppy-disk">glyphicon-floppy-disk</span></li>
						<li><span class="glyphicon glyphicon-floppy-saved"></span><span title="glyphicon-floppy-saved">glyphicon-floppy-saved</span></li>
						<li><span class="glyphicon glyphicon-floppy-remove"></span><span title="glyphicon-floppy-remove">glyphicon-floppy-remove</span></li>
						<li><span class="glyphicon glyphicon-floppy-save"></span><span title="glyphicon-floppy-save">glyphicon-floppy-save</span></li>
						<li><span class="glyphicon glyphicon-floppy-open"></span><span title="glyphicon-floppy-open">glyphicon-floppy-open</span></li>
						<li><span class="glyphicon glyphicon-credit-card"></span><span title="glyphicon-credit-card">glyphicon-credit-card</span></li>
						<li><span class="glyphicon glyphicon-transfer"></span><span title="glyphicon-transfer">glyphicon-transfer</span></li>
						<li><span class="glyphicon glyphicon-cutlery"></span><span title="glyphicon-cutlery">glyphicon-cutlery</span></li>
						<li><span class="glyphicon glyphicon-header"></span><span title="glyphicon-header">glyphicon-header</span></li>
						<li><span class="glyphicon glyphicon-compressed"></span><span title="glyphicon-compressed">glyphicon-compressed</span></li>
						<li><span class="glyphicon glyphicon-earphone"></span><span title="glyphicon-earphone">glyphicon-earphone</span></li>
						<li><span class="glyphicon glyphicon-phone-alt"></span><span title="glyphicon-phone-alt">glyphicon-phone-alt</span></li>
						<li><span class="glyphicon glyphicon-tower"></span><span title="glyphicon-tower">glyphicon-tower</span></li>
						<li><span class="glyphicon glyphicon-stats"></span><span title="glyphicon-stats">glyphicon-stats</span></li>
						<li><span class="glyphicon glyphicon-sd-video"></span><span title="glyphicon-sd-video">glyphicon-sd-video</span></li>
						<li><span class="glyphicon glyphicon-hd-video"></span><span title="glyphicon-hd-video">glyphicon-hd-video</span></li>
						<li><span class="glyphicon glyphicon-subtitles"></span><span title="glyphicon-subtitles">glyphicon-subtitles</span></li>
						<li><span class="glyphicon glyphicon-sound-stereo"></span><span title="glyphicon-sound-stereo">glyphicon-sound-stereo</span></li>
						<li><span class="glyphicon glyphicon-sound-dolby"></span><span title="glyphicon-sound-dolby">glyphicon-sound-dolby</span></li>
						<li><span class="glyphicon glyphicon-sound-5-1"></span><span title="glyphicon-sound-5-1">glyphicon-sound-5-1</span></li>
						<li><span class="glyphicon glyphicon-sound-6-1"></span><span title="glyphicon-sound-6-1">glyphicon-sound-6-1</span></li>
						<li><span class="glyphicon glyphicon-sound-7-1"></span><span title="glyphicon-sound-7-1">glyphicon-sound-7-1</span></li>
						<li><span class="glyphicon glyphicon-copyright-mark"></span><span title="glyphicon-copyright-mark">glyphicon-copyright-mark</span></li>
						<li><span class="glyphicon glyphicon-registration-mark"></span><span title="glyphicon-registration-mark">glyphicon-registration-mark</span></li>
						<li><span class="glyphicon glyphicon-cloud-download"></span><span title="glyphicon-cloud-download">glyphicon-cloud-download</span></li>
						<li><span class="glyphicon glyphicon-cloud-upload"></span><span title="glyphicon-cloud-upload">glyphicon-cloud-upload</span></li>
						<li><span class="glyphicon glyphicon-tree-conifer"></span><span title="glyphicon-tree-conifer">glyphicon-tree-conifer</span></li>
						<li><span class="glyphicon glyphicon-tree-deciduous"></span><span title="glyphicon-tree-deciduous">glyphicon-tree-deciduous</span></li>
						<li><span class="glyphicon glyphicon-cd"></span><span title="glyphicon-cd">glyphicon-cd</span></li>
						<li><span class="glyphicon glyphicon-save-file"></span><span title="glyphicon-save-file">glyphicon-save-file</span></li>
						<li><span class="glyphicon glyphicon-open-file"></span><span title="glyphicon-open-file">glyphicon-open-file</span></li>
						<li><span class="glyphicon glyphicon-level-up"></span><span title="glyphicon-level-up">glyphicon-level-up</span></li>
						<li><span class="glyphicon glyphicon-copy"></span><span title="glyphicon-copy">glyphicon-copy</span></li>
						<li><span class="glyphicon glyphicon-paste"></span><span title="glyphicon-paste">glyphicon-paste</span></li>
						<li><span class="glyphicon glyphicon-alert"></span><span title="glyphicon-alert">glyphicon-alert</span></li>
						<li><span class="glyphicon glyphicon-equalizer"></span><span title="glyphicon-equalizer">glyphicon-equalizer</span></li>
						<li><span class="glyphicon glyphicon-king"></span><span title="glyphicon-king">glyphicon-king</span></li>
						<li><span class="glyphicon glyphicon-queen"></span><span title="glyphicon-queen">glyphicon-queen</span></li>
						<li><span class="glyphicon glyphicon-pawn"></span><span title="glyphicon-pawn">glyphicon-pawn</span></li>
						<li><span class="glyphicon glyphicon-bishop"></span><span title="glyphicon-bishop">glyphicon-bishop</span></li>
						<li><span class="glyphicon glyphicon-knight"></span><span title="glyphicon-knight">glyphicon-knight</span></li>
						<li><span class="glyphicon glyphicon-baby-formula"></span><span title="glyphicon-baby-formula">glyphicon-baby-formula</span></li>
						<li><span class="glyphicon glyphicon-blackboard"></span><span title="glyphicon-blackboard">glyphicon-tent</span></li>
						<li><span class="glyphicon glyphicon-blackboard"></span><span title="glyphicon-blackboard">glyphicon-blackboard</span></li>
						<li><span class="glyphicon glyphicon-bed"></span><span title="glyphicon-bed">glyphicon-bed</span></li>
						<li><span class="glyphicon glyphicon-apple"></span><span title="glyphicon-apple">glyphicon-apple</span></li>
						<li><span class="glyphicon glyphicon-erase"></span><span title="glyphicon-erase">glyphicon-erase</span></li>
						<li><span class="glyphicon glyphicon-hourglass"></span><span title="glyphicon-hourglass">glyphicon-hourglass</span></li>
						<li><span class="glyphicon glyphicon-lamp"></span><span title="glyphicon-lamp">glyphicon-lamp</span></li>
						<li><span class="glyphicon glyphicon-duplicate"></span><span title="glyphicon-duplicate">glyphicon-duplicate</span></li>
						<li><span class="glyphicon glyphicon-piggy-bank"></span><span title="glyphicon-piggy-bank">glyphicon-piggy-bank</span></li>
						<li><span class="glyphicon glyphicon-scissors"></span><span title="glyphicon-scissors">glyphicon-scissors</span></li>
						<li><span class="glyphicon glyphicon-bitcoin"></span><span title="glyphicon-bitcoin">glyphicon-bitcoin</span></li>
						<li><span class="glyphicon glyphicon-btc"></span><span title="glyphicon-btc">glyphicon-btc</span></li>
						<li><span class="glyphicon glyphicon-xbt"></span><span title="glyphicon-xbt">glyphicon-xbt</span></li>
						<li><span class="glyphicon glyphicon-yen"></span><span title="glyphicon-yen">glyphicon-yen</span></li>
						<li><span class="glyphicon glyphicon-jpy"></span><span title="glyphicon-jpy">glyphicon-jpy</span></li>
						<li><span class="glyphicon glyphicon-ruble"></span><span title="glyphicon-ruble">glyphicon-ruble</span></li>
						<li><span class="glyphicon glyphicon-rub"></span><span title="glyphicon-rub">glyphicon-rub</span></li>
						<li><span class="glyphicon glyphicon-scale"></span><span title="glyphicon-scale">glyphicon-scale</span></li>
						<li><span class="glyphicon glyphicon-ice-lolly"></span><span title="glyphicon-ice-lolly">glyphicon-ice-lolly</span></li>
						<li><span class="glyphicon glyphicon-ice-lolly-tasted"></span><span title="glyphicon-ice-lolly-tasted">glyphicon-ice-lolly-tasted</span></li>
						<li><span class="glyphicon glyphicon-education"></span><span title="glyphicon-education">glyphicon-education</span></li>
						<li><span class="glyphicon glyphicon-option-horizontal"></span><span title="glyphicon-option-horizontal">glyphicon-option-horizontal</span></li>
						<li><span class="glyphicon glyphicon-option-vertical"></span><span title="glyphicon-option-vertical">glyphicon-option-vertical</span></li>
						<li><span class="glyphicon glyphicon-menu-hamburger"></span><span title="glyphicon-menu-hamburger">glyphicon-menu-hamburger</span></li>
						<li><span class="glyphicon glyphicon-modal-window"></span><span title="glyphicon-modal-window">glyphicon-modal-window</span></li>
						<li><span class="glyphicon glyphicon-oil"></span><span title="glyphicon-oil">glyphicon-oil</span></li>
						<li><span class="glyphicon glyphicon-grain"></span><span title="glyphicon-grain">glyphicon-grain</span></li>
						<li><span class="glyphicon glyphicon-sunglasses"></span><span title="glyphicon-sunglasses">glyphicon-sunglasses</span></li>
						<li><span class="glyphicon glyphicon-text-size"></span><span title="glyphicon-text-size">glyphicon-text-size</span></li>
						<li><span class="glyphicon glyphicon-text-color"></span><span title="glyphicon-text-color">glyphicon-text-color</span></li>
						<li><span class="glyphicon glyphicon-text-background"></span><span title="glyphicon-text-background">glyphicon-text-background</span></li>
						<li><span class="glyphicon glyphicon-object-align-top"></span><span title="glyphicon-object-align-top">glyphicon-object-align-top</span></li>
						<li><span class="glyphicon glyphicon-object-align-bottom"></span><span title="glyphicon-object-align-bottom">glyphicon-object-align-bottom</span></li>
						<li><span class="glyphicon glyphicon-object-align-horizontal"></span><span title="glyphicon-object-align-horizontal">glyphicon-object-align-horizontal</span></li>
						<li><span class="glyphicon glyphicon-object-align-left"></span><span title="glyphicon-object-align-left">glyphicon-object-align-left</span></li>
						<li><span class="glyphicon glyphicon-object-align-vertical"></span><span title="glyphicon-object-align-vertical">glyphicon-object-align-vertical</span></li>
						<li><span class="glyphicon glyphicon-object-align-right"></span><span title="glyphicon-object-align-right">glyphicon-object-align-right</span></li>
						<li><span class="glyphicon glyphicon-triangle-right"></span><span title="glyphicon-triangle-right">glyphicon-triangle-right</span></li>
						<li><span class="glyphicon glyphicon-triangle-left"></span><span title="glyphicon-triangle-left">glyphicon-triangle-left</span></li>
						<li><span class="glyphicon glyphicon-triangle-bottom"></span><span title="glyphicon-triangle-bottom">glyphicon-triangle-bottom</span></li>
						<li><span class="glyphicon glyphicon-triangle-top"></span><span title="glyphicon-triangle-top">glyphicon-triangle-top</span></li>
						<li><span class="glyphicon glyphicon-console"></span><span title="glyphicon-console">glyphicon-console</span></li>
						<li><span class="glyphicon glyphicon-superscript"></span><span title="glyphicon-superscript">glyphicon-superscript</span></li>
						<li><span class="glyphicon glyphicon-subscript"></span><span title="glyphicon-subscript">glyphicon-subscript</span></li>
						<li><span class="glyphicon glyphicon-menu-left"></span><span title="glyphicon-menu-left">glyphicon-menu-left</span></li>
						<li><span class="glyphicon glyphicon-menu-right"></span><span title="glyphicon-menu-right">glyphicon-menu-right</span></li>
						<li><span class="glyphicon glyphicon-menu-down"></span><span title="glyphicon-menu-down">glyphicon-menu-down</span></li>
						<li><span class="glyphicon glyphicon-menu-up"></span><span title="glyphicon-menu-up">glyphicon-menu-up</span></li>
					</ul>
				</div>
				<div class="tab-pane fade" id="tab1">
					<ul class="iconUl">
						<li><span class="icon-user-female"></span><span title="icon-user-female">icon-user-female</span></li>
						<li><span class="icon-user-follow"></span><span title="icon-user-follow">icon-user-follow</span></li>
						<li><span class="icon-user-following"></span><span title="icon-user-following">icon-user-following</span></li>
						<li><span class="icon-user-unfollow"></span><span title="icon-user-unfollow">icon-user-unfollow</span></li>
						<li><span class="icon-trophy"></span><span title="icon-trophy">icon-trophy</span></li>
						<li><span class="icon-screen-smartphone"></span><span title="icon-screen-smartphone">icon-screen-smartphone</span></li>
						<li><span class="icon-screen-desktop"></span><span title="icon-screen-desktop">icon-screen-desktop</span></li>
						<li><span class="icon-plane"></span><span title="icon-plane">icon-plane</span></li>
						<li><span class="icon-notebook"></span><span title="icon-notebook">icon-notebook</span></li>
						<li><span class="icon-moustache"></span><span title="icon-moustache">icon-moustache</span></li>
						<li><span class="icon-mouse"></span><span title="icon-mouse">icon-mouse</span></li>
						<li><span class="icon-magnet"></span><span title="icon-magnet">icon-magnet</span></li>
						<li><span class="icon-energy"></span><span title="icon-energy">icon-energy</span></li>
						<li><span class="icon-emoticon-smile"></span><span title="icon-emoticon-smile">icon-emoticon-smile</span></li>
						<li><span class="icon-disc"></span><span title="icon-disc">icon-disc</span></li>
						<li><span class="icon-crop"></span><span title="icon-crop">icon-crop</span></li>
						<li><span class="icon-credit-card"></span><span title="icon-credit-card">icon-credit-card</span></li>
						<li><span class="icon-chemistry"></span><span title="icon-chemistry">icon-chemistry</span></li>
						<li><span class="icon-user"></span><span title="icon-user">icon-user</span></li>
						<li><span class="icon-social-youtube"></span><span title="icon-social-youtube">icon-social-youtube</span></li>
						<li><span class="icon-social-twitter"></span><span title="icon-social-twitter">icon-social-twitter</span></li>
						<li><span class="icon-social-tumblr"></span><span title="icon-social-tumblr">icon-social-tumblr</span></li>
						<li><span class="icon-social-facebook"></span><span title="icon-social-facebook">icon-social-facebook</span></li>
						<li><span class="icon-social-dropbox"></span><span title="icon-social-dropbox">icon-social-dropbox</span></li>
						<li><span class="icon-shield"></span><span title="icon-shield">icon-shield</span></li>
						<li><span class="icon-screen-tablet"></span><span title="icon-screen-tablet">icon-screen-tablet</span></li>
						<li><span class="icon-magic-wand"></span><span title="icon-magic-wand">icon-magic-wand</span></li>
						<li><span class="icon-hourglass"></span><span title="icon-hourglass">icon-hourglass</span></li>
						<li><span class="icon-graduation"></span><span title="icon-graduation">icon-graduation</span></li>
						<li><span class="icon-ghost"></span><span title="icon-ghost">icon-ghost</span></li>
						<li><span class="icon-game-controller"></span><span title="icon-game-controller">icon-game-controller</span></li>
						<li><span class="icon-fire"></span><span title="icon-fire">icon-fire</span></li>
						<li><span class="icon-eyeglasses"></span><span title="icon-eyeglasses">icon-eyeglasses</span></li>
						<li><span class="icon-envelope-open"></span><span title="icon-envelope-open">icon-envelope-open</span></li>
						<li><span class="icon-envelope-letter"></span><span title="icon-envelope-letter">icon-envelope-letter</span></li>
						<li><span class="icon-bell"></span><span title="icon-bell">icon-bell</span></li>
						<li><span class="icon-badge"></span><span title="icon-badge">icon-badge</span></li>
						<li><span class="icon-anchor"></span><span title="icon-anchor">icon-anchor</span></li>
						<li><span class="icon-wallet"></span><span title="icon-wallet">icon-wallet</span></li>
						<li><span class="icon-vector"></span><span title="icon-vector">icon-vector</span></li>
						<li><span class="icon-speech"></span><span title="icon-speech">icon-speech</span></li>
						<li><span class="icon-puzzle"></span><span title="icon-puzzle">icon-puzzle</span></li>
						<li><span class="icon-printer"></span><span title="icon-printer">icon-printer</span></li>
						<li><span class="icon-present"></span><span title="icon-present">icon-present</span></li>
						<li><span class="icon-playlist"></span><span title="icon-playlist">icon-playlist</span></li>
						<li><span class="icon-pin"></span><span title="icon-pin">icon-pin</span></li>
						<li><span class="icon-picture"></span><span title="icon-picture">icon-picture</span></li>
						<li><span class="icon-map"></span><span title="icon-map">icon-map</span></li>
						<li><span class="icon-layers"></span><span title="icon-layers">icon-layers</span></li>
						<li><span class="icon-handbag"></span><span title="icon-handbag">icon-handbag</span></li>
						<li><span class="icon-globe-alt"></span><span title="icon-globe-alt">icon-globe-alt</span></li>
						<li><span class="icon-globe"></span><span title="icon-globe">icon-globe</span></li>
						<li><span class="icon-frame"></span><span title="icon-frame">icon-frame</span></li>
						<li><span class="icon-folder-alt"></span><span title="icon-folder-alt">icon-folder-alt</span></li>
						<li><span class="icon-film"></span><span title="icon-film">icon-film</span></li>
						<li><span class="icon-feed"></span><span title="icon-feed">icon-feed</span></li>
						<li><span class="icon-earphones-alt"></span><span title="icon-earphones-alt">icon-earphones-alt</span></li>
						<li><span class="icon-earphones"></span><span title="icon-earphones">icon-earphones</span></li>
						<li><span class="icon-drop"></span><span title="icon-drop">icon-drop</span></li>
						<li><span class="icon-drawer"></span><span title="icon-drawer">icon-drawer</span></li>
						<li><span class="icon-docs"></span><span title="icon-docs">icon-docs</span></li>
						<li><span class="icon-directions"></span><span title="icon-directions">icon-directions</span></li>
						<li><span class="icon-direction"></span><span title="icon-direction">icon-direction</span></li>
						<li><span class="icon-diamond"></span><span title="icon-diamond">icon-diamond</span></li>
						<li><span class="icon-cup"></span><span title="icon-cup">icon-cup</span></li>
						<li><span class="icon-compass"></span><span title="icon-compass">icon-compass</span></li>
						<li><span class="icon-call-out"></span><span title="icon-call-out">icon-call-out</span></li>
						<li><span class="icon-call-in"></span><span title="icon-call-in">icon-call-in</span></li>
						<li><span class="icon-call-end"></span><span title="icon-call-end">icon-call-end</span></li>
						<li><span class="icon-calculator"></span><span title="icon-calculator">icon-calculator</span></li>
						<li><span class="icon-bubbles"></span><span title="icon-bubbles">icon-bubbles</span></li>
						<li><span class="icon-briefcase"></span><span title="icon-briefcase">icon-briefcase</span></li>
						<li><span class="icon-book-open"></span><span title="icon-book-open">icon-book-open</span></li>
						<li><span class="icon-basket-loaded"></span><span title="icon-basket-loaded">icon-basket-loaded</span></li>
						<li><span class="icon-basket"></span><span title="icon-basket">icon-basket</span></li>
						<li><span class="icon-bag"></span><span title="icon-bag">icon-bag</span></li>
						<li><span class="icon-action-undo"></span><span title="icon-action-undo">icon-action-undo</span></li>
						<li><span class="icon-action-redo"></span><span title="icon-action-redo">icon-action-redo</span></li>
						<li><span class="icon-wrench"></span><span title="icon-wrench">icon-wrench</span></li>
						<li><span class="icon-umbrella"></span><span title="icon-umbrella">icon-umbrella</span></li>
						<li><span class="icon-trash"></span><span title="icon-trash">icon-trash</span></li>
						<li><span class="icon-tag"></span><span title="icon-tag">icon-tag</span></li>
						<li><span class="icon-support"></span><span title="icon-support">icon-support</span></li>
						<li><span class="icon-size-fullscreen"></span><span title="icon-size-fullscreen">icon-size-fullscreen</span></li>
						<li><span class="icon-size-actual"></span><span title="icon-size-actual">icon-size-actual</span></li>
						<li><span class="icon-shuffle"></span><span title="icon-shuffle">icon-shuffle</span></li>
						<li><span class="icon-share-alt"></span><span title="icon-share-alt">icon-share-alt</span></li>
						<li><span class="icon-share"></span><span title="icon-share">icon-share</span></li>
						<li><span class="icon-rocket"></span><span title="icon-rocket">icon-rocket</span></li>
						<li><span class="icon-question"></span><span title="icon-question">icon-question</span></li>
						<li><span class="icon-pie-chart"></span><span title="icon-pie-chart">icon-pie-chart</span></li>
						<li><span class="icon-pencil"></span><span title="icon-pencil">icon-pencil</span></li>
						<li><span class="icon-note"></span><span title="icon-note">icon-note</span></li>
						<li><span class="icon-music-tone-alt"></span><span title="icon-music-tone-alt">icon-music-tone-alt</span></li>
						<li><span class="icon-music-tone"></span><span title="icon-music-tone">icon-music-tone</span></li>
						<li><span class="icon-microphone"></span><span title="icon-microphone">icon-microphone</span></li>
						<li><span class="icon-loop"></span><span title="icon-loop">icon-loop</span></li>
						<li><span class="icon-logout"></span><span title="icon-logout">icon-logout</span></li>
						<li><span class="icon-login"></span><span title="icon-login">icon-login</span></li>
						<li><span class="icon-list"></span><span title="icon-list">icon-list</span></li>
						<li><span class="icon-like"></span><span title="icon-like">icon-like</span></li>
						<li><span class="icon-home"></span><span title="icon-home">icon-home</span></li>
						<li><span class="icon-grid"></span><span title="icon-grid">icon-grid</span></li>
						<li><span class="icon-graph"></span><span title="icon-graph">icon-graph</span></li>
						<li><span class="icon-equalizer"></span><span title="icon-equalizer">icon-equalizer</span></li>
						<li><span class="icon-dislike"></span><span title="icon-dislike">icon-dislike</span></li>
						<li><span class="icon-cursor"></span><span title="icon-cursor">icon-cursor</span></li>
						<li><span class="icon-control-start"></span><span title="icon-control-start">icon-control-start</span></li>
						<li><span class="icon-control-rewind"></span><span title="icon-control-rewind">icon-control-rewind</span></li>
						<li><span class="icon-control-play"></span><span title="icon-control-play">icon-control-play</span></li>
						<li><span class="icon-control-pause"></span><span title="icon-control-pause">icon-control-pause</span></li>
						<li><span class="icon-control-forward"></span><span title="icon-control-forward">icon-control-forward</span></li>
						<li><span class="icon-control-end"></span><span title="icon-control-end">icon-control-end</span></li>
						<li><span class="icon-calendar"></span><span title="icon-calendar">icon-calendar</span></li>
						<li><span class="icon-bulb"></span><span title="icon-bulb">icon-bulb</span></li>
						<li><span class="icon-bar-chart"></span><span title="icon-bar-chart">icon-bar-chart</span></li>
						<li><span class="icon-arrow-up"></span><span title="icon-arrow-up">icon-arrow-up</span></li>
						<li><span class="icon-arrow-right"></span><span title="icon-arrow-right">icon-arrow-right</span></li>
						<li><span class="icon-arrow-left"></span><span title="icon-arrow-left">icon-arrow-left</span></li>
						<li><span class="icon-arrow-down"></span><span title="icon-arrow-down">icon-arrow-down</span></li>
						<li><span class="icon-ban"></span><span title="icon-ban">icon-ban</span></li>
						<li><span class="icon-bubble"></span><span title="icon-bubble">icon-bubble</span></li>
						<li><span class="icon-camcorder"></span><span title="icon-camcorder">icon-camcorder</span></li>
						<li><span class="icon-camera"></span><span title="icon-camera">icon-camera</span></li>
						<li><span class="icon-check"></span><span title="icon-check">icon-check</span></li>
						<li><span class="icon-clock"></span><span title="icon-clock">icon-clock</span></li>
						<li><span class="icon-close"></span><span title="icon-close">icon-close</span></li>
						<li><span class="icon-cloud-download"></span><span title="icon-cloud-download">icon-cloud-download</span></li>
						<li><span class="icon-cloud-upload"></span><span title="icon-cloud-upload">icon-cloud-upload</span></li>
						<li><span class="icon-doc"></span><span title="icon-doc">icon-doc</span></li>
						<li><span class="icon-envelope"></span><span title="icon-envelope">icon-envelope</span></li>
						<li><span class="icon-eye"></span><span title="icon-eye">icon-eye</span></li>
						<li><span class="icon-flag"></span><span title="icon-flag">icon-flag</span></li>
						<li><span class="icon-folder"></span><span title="icon-folder">icon-folder</span></li>
						<li><span class="icon-heart"></span><span title="icon-heart">icon-heart</span></li>
						<li><span class="icon-info"></span><span title="icon-info">icon-info</span></li>
						<li><span class="icon-key"></span><span title="icon-key">icon-key</span></li>
						<li><span class="icon-link"></span><span title="icon-link">icon-link</span></li>
						<li><span class="icon-lock"></span><span title="icon-lock">icon-lock</span></li>
						<li><span class="icon-lock-open"></span><span title="icon-lock-open">icon-lock-open</span></li>
						<li><span class="icon-magnifier"></span><span title="icon-magnifier">icon-magnifier</span></li>
						<li><span class="icon-magnifier-add"></span><span title="icon-magnifier-add">icon-magnifier-add</span></li>
						<li><span class="icon-magnifier-remove"></span><span title="icon-magnifier-remove">icon-magnifier-remove</span></li>
						<li><span class="icon-paper-clip"></span><span title="icon-paper-clip">icon-paper-clip</span></li>
						<li><span class="icon-paper-plane"></span><span title="icon-paper-plane">icon-paper-plane</span></li>
						<li><span class="icon-pointer"></span><span title="icon-pointer">icon-pointer</span></li>
						<li><span class="icon-power"></span><span title="icon-power">icon-power</span></li>
						<li><span class="icon-refresh"></span><span title="icon-refresh">icon-refresh</span></li>
						<li><span class="icon-reload"></span><span title="icon-reload">icon-reload</span></li>
						<li><span class="icon-settings"></span><span title="icon-settings">icon-settings</span></li>
						<li><span class="icon-star"></span><span title="icon-star">icon-star</span></li>
						<li><span class="icon-symbol-female"></span><span title="icon-symbol-female">icon-symbol-female</span></li>
						<li><span class="icon-symbol-male"></span><span title="icon-symbol-male">icon-symbol-male</span></li>
						<li><span class="icon-target"></span><span title="icon-target">icon-target</span></li>
						<li><span class="icon-volume-1"></span><span title="icon-volume-1">icon-volume-1</span></li>
						<li><span class="icon-volume-2"></span><span title="icon-volume-2">icon-volume-2</span></li>
						<li><span class="icon-volume-off"></span><span title="icon-volume-off">icon-volume-off</span></li>
						<li><span class="icon-users"></span><span title="icon-users">icon-users</span></li>
					</ul>
				</div>
			</div>
		</fieldset>
	</div>
</body>  
</html> 