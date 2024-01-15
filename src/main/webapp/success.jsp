<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/headerAdmin.jsp" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Page d'Administration</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>

<div class="container mx-auto mt-8">
    <h1 class="text-4xl font-bold mb-4 font-mono text-center text-green-500">Bienvenue à la page d'administration</h1>

    <div class="flex flex-wrap mx-4">
        <div class="w-full md:w-1/2 lg:w-1/2 xl:w-1/2 px-4 mb-8">
            <section class="border-t-4 border-r-4">
                <h2 class="text-2xl font-bold mb-4">Gestion des Réclamations</h2>
                <p class="mb-4">Gérez les réclamations des utilisateurs.</p>
                <img src="https://quirecherche.info/wp-content/uploads/2012/03/Fotolia_28422345_L2.jpg" alt="Gestion des Réclamations" class="w-full h-64 object-fill rounded-md mb-4 mx-auto">
                <a href="/gestiondesreclamations" class="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded block mx-auto">Gérer</a>
            </section>
        </div>

        <div class="w-full md:w-1/2 lg:w-1/2 xl:w-1/2 px-4 mb-8">
            <section class="border-t-4 border-r-4">
                <h2 class="text-2xl font-bold mb-4">Gestion des Lieux Touristiques</h2>
                <p class="mb-4">Gérez les places touristiques disponibles.</p>
                <img src="https://exploreessaouira.com/wp-content/uploads/2023/10/Essaouira-nighlife.jpg.webp" class="w-full h-64 object-fill rounded-md mb-4 mx-auto">
                <a href="/gestiondesplacestouristiques" class="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded block mx-auto">Gérer</a>
            </section>
        </div>

		<div class="w-full md:w-1/2 lg:w-1/2 xl:w-1/2 px-4 mb-8">
            <section class="border-t-4 border-r-4">
                <h2 class="text-2xl font-bold mb-4">Gestion des reservation des terrain publique</h2>
                <p class="mb-4">Gérez les reservation des terrain publique</p>
                <img src="https://t1.uc.ltmcdn.com/fr/posts/8/4/8/quelle_est_la_taille_d_un_terrain_de_football_12848_orig.jpg" class="w-full h-64 object-fill rounded-md mb-4 mx-auto">
                <a href="/gestiondesplacestouristiques" class="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded block mx-auto">Gérer</a>
            </section>
        </div>
        
        <div class="w-full md:w-1/2 lg:w-1/2 xl:w-1/2 px-4 mb-8">
            <section class="border-t-4 border-r-4">
                <h2 class="text-2xl font-bold mb-4">Gestion des patrimoine</h2>
                <p class="mb-4">Gérez les des patrimoine disponibles.</p>
                <img src="https://www.1jour1actu.com/wp-content/uploads/2015/09/patrimoine.jpg" class="w-full h-64 object-fill rounded-md mb-4 mx-auto">
                <a href="/gestiondesplacestouristiques" class="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded block mx-auto">Gérer</a>
            </section>
        </div>
        <div class="w-full md:w-1/2 lg:w-1/2 xl:w-1/2 px-4 mb-8">
            <section class="border-t-4 border-r-4">
                <h2 class="text-2xl font-bold mb-4">Gestion des dechets</h2>
                <p class="mb-4">Gérez les dechets disponibles.</p>
                <img src="https://cdn.catf.us/wp-content/uploads/2022/09/03152954/GettyImages-1300144187-1-1400x934.jpg" class="w-full h-64 object-fill rounded-md mb-4 mx-auto">
                <a href="/gestiondesplacestouristiques" class="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded block mx-auto">Gérer</a>
            </section>
        </div>
        <div class="w-full md:w-1/2 lg:w-1/2 xl:w-1/2 px-4 mb-8">
            <section class="border-t-4 border-r-4">
                <h2 class="text-2xl font-bold mb-4">Gestion des Terains</h2>
                <p class="mb-4">Gérez les Terains disponibles.</p>
                <img src="https://www.clubparadise.ma/assets/base/img/content/stock/pleinciel-paradise-club63.jpg" class="w-full h-64 object-fill rounded-md mb-4 mx-auto">
                <a href="/gestiondesplacestouristiques" class="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded block mx-auto">Gérer</a>
            </section>
        </div>
    </div>
</div>

</body>
</html>

<%@ include file="/WEB-INF/footerAdmin.jsp" %>
