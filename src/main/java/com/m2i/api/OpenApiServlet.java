package com.m2i.api;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

/**
 * Cette servlet est déclarée pour déclencher l'initialisation de Swagger Core,
 * mais ne contient pas de configuration manuelle. Swagger détectera automatiquement
 * les ressources REST annotées si les dépendances sont correctement ajoutées.
 */
@WebServlet(name = "OpenApiServlet", urlPatterns = "/api/openapi.json", loadOnStartup = 1)
public class OpenApiServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) {
        // Swagger Core devrait automatiquement gérer la génération de openapi.json
        // si les dépendances sont correctement configurées et les annotations présentes
    }
}
