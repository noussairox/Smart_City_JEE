<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/header.jsp" %>

<div class="container mx-auto flex mt-8">
    <div class="w-1/2 pr-8">
        <h1 class="text-4xl text-purple-700 font-bold mb-4">Bienvenue sur SmartCity!</h1>
        <p class="text-lg font-light">
            SmartCity offre une approche innovante pour rendre la vie urbaine plus pratique et connectée.
            Explorez nos services pour réserver des terrains publics, signaler des problèmes, suivre la gestion des déchets
            et découvrir des lieux touristiques exceptionnels.
        </p>
    </div>
    <div class="w-1/2">
        <img src="https://static.latribune.fr/858597/casablanca.jpg" alt="Casablanca" class="rounded-lg shadow-lg">
    </div>
</div>

<div class="container mx-auto mt-8">
    <h2 class="text-2xl text-purple-700 font-bold mb-4">Nos Services</h2>

    <!-- Service 1 : Réservation des terrains publics -->
<div class="flex mb-8">
    <div class="w-1/3 pr-4">
        <img src="https://frmf.ma/wp-content/uploads/2024/01/15324C51-D274-4BAB-A168-DB7AB1D8A635-scaled.jpeg" alt="Image Service 1" class="rounded-lg shadow-lg mb-4">
    </div>
    <div class="w-2/3">
        <h3 class="text-xl font-bold mb-2">Réservation des Terrains Publics</h3>
        <p class="text-gray-700">
            Réservez facilement les terrains publics pour vos activités sportives ou événements spéciaux.
        </p>
        <button class="bg-blue-500 text-white px-4 py-2 rounded-full mt-2" onclick="window.location.href='./Reservation'">Réserver</button>
    </div>
</div>

<!-- Service 2 : Signalement des problèmes -->
<div class="flex mb-8">
    <div class="w-1/3 pr-4">
        <img src="https://www.merci-app.com/app/uploads/2023/07/643960ac1999ef0f2b66b178_62dfb171bd353b3faaedffff_recalamation-client-blog-cover.png" alt="Image Service 2" class="rounded-lg shadow-lg mb-4">
    </div>
    <div class="w-2/3">
        <h3 class="text-xl font-bold mb-2">Signalement des Problèmes</h3>
        <p class="text-gray-700">
            Signalez rapidement les problèmes de la ville pour une résolution efficace et une meilleure qualité de vie.
        </p>
        <button class="bg-blue-500 text-white px-4 py-2 rounded-full mt-2" onclick="window.location.href='./Signalement'">Signaler</button>
    </div>
</div>

<!-- Service 3 : Suivi des Déchets -->
<div class="flex mb-8">
    <div class="w-1/3 pr-4">
        <img src="https://blog.chimirec.fr/img/articles_a/1579164329.blog.chimirec.bsd.140120.ok.jpg" alt="Image Service 3" class="rounded-lg shadow-lg mb-4">
    </div>
    <div class="w-2/3">
        <h3 class="text-xl font-bold mb-2">Suivi des Déchets</h3>
        <p class="text-gray-700">
            Contribuez à un environnement propre en suivant la gestion des déchets de votre ville.
        </p>
        <button class="bg-blue-500 text-white px-4 py-2 rounded-full mt-2" onclick="window.location.href='./SuiviDechets'">Suivre</button>
    </div>
</div>

<!-- Service 4 : Visualisation des Lieux Touristiques -->
<div class="flex mb-8">
    <div class="w-1/3 pr-4">
        <img src="https://passporterapp.com/fr/blog/wp-content/uploads/2023/09/que-faire-a-Essaouira.webp" alt="Image Service 4" class="rounded-lg shadow-lg mb-4">
    </div>
    <div class="w-2/3">
        <h3 class="text-xl font-bold mb-2">Visualisation des Lieux Touristiques</h3>
        <p class="text-gray-700">
            Explorez et découvrez les endroits touristiques fascinants de votre ville avec notre guide interactif.
        </p>
        <button class="bg-blue-500 text-white px-4 py-2 rounded-full mt-2" onclick="window.location.href='./PlacesTouristiques'">Explorer</button>
    </div>
</div>
  <!-- Section À propos de SmartCity -->
<div class="container mx-auto mt-8 border border-purple-400 p-6 rounded-lg shadow-lg my-8 p-10 px-20">
    <h2 class="text-2xl text-purple-700 font-bold mb-4 py-2 border-b-8">À propos de SmartCity</h2>
    <p class="text-lg font-light">
        SmartCity est une application innovante qui vise à rendre la vie urbaine plus pratique, connectée et agréable.
        Notre plateforme offre une gamme de services conçus pour améliorer la qualité de vie des citoyens.
        Découvrez comment nous facilitons la réservation des terrains publics, la gestion des problèmes de la ville, le suivi des déchets,
        et l'exploration des lieux touristiques. Rejoignez-nous pour contribuer à construire une ville plus intelligente et durable.
    </p>
</div>

  
</div>

<%@ include file="/WEB-INF/footer.jsp" %>
