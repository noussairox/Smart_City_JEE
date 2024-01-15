<!-- header.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ville Intelligent</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="font-sans bg-gray-100">

<!-- Navbar -->
<nav class="bg-purple-400 p-3">
    <div class="container mx-auto flex items-center justify-between">
        <a class="text-white font-mono" href="./">Ville Intelligent</a>
        <div class="flex-grow text-center">
            <a class="text-white ml-4" href="<%= request.getContextPath() %>/">Accueil</a>
            <a class="text-white ml-4" href="<%= request.getContextPath() %>/terrains-disponibles">Terrain</a>
            <a class="text-white ml-4" href="<%= request.getContextPath() %>/Signalement">Reclamation</a>
            <a class="text-white ml-4" href="<%= request.getContextPath() %>/SuiviDechets">Suivi des déchets</a>
            <a class="text-white ml-4" href="<%= request.getContextPath() %>/PlacesTouristiques">Lieux touristiques</a>
            <a class="text-white ml-4" href="<%= request.getContextPath() %>/visualisation-patrimoine">Patrimoine</a>
        </div>
        <div class="flex-shrink">
            <a class="text-white ml-4 border rounded-md p-1 px-4 hover:bg-white hover:text-purple-400" href="<%= request.getContextPath() %>/Login">Login</a>
        </div>
    </div>
</nav>


<!-- Content -->
<div class="container mt-4 mx-auto">